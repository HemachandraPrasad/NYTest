package com.sample.demo;

import javax.sql.DataSource;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
@EnableBatchProcessing
public class SampleBatchConfig {	     
	    @Autowired
	    private StepBuilderFactory stepBuilderFactory;	 
	    /*@Bean
	    public Job readCSVFilesJob() {
	    return jobBuilderFactory.get("readCSVFilesJob").incrementer(new RunIdIncrementer()).start(step1()).build();
	    }	*/ 
	   /* @Bean
	    public Step step1() {
	        return stepBuilderFactory.get("step1").<Users, Users>chunk(5).reader(reader())
	                .build();
	    }*/
	    @Bean
	    public Step step1(JdbcBatchItemWriter<Users> writer) {
	        return stepBuilderFactory.get("step1")
	            .<Users, Users> chunk(10)
	            .reader(reader()).build();
	    }
	 
	   /* @Bean
	    public FlatFileItemReader <Users> reader() {
	        FlatFileItemReader<Users> reader = new FlatFileItemReader<Users>();	         
	        reader.setResource(new FileSystemResource("input/inputData.csv"));          
	        reader.setLinesToSkip(1);          
	        reader.setLineMapper(new DefaultLineMapper() {
	            {	               
	                setLineTokenizer(new DelimitedLineTokenizer() {
	                    {
	                     setNames(new String[] { "user_Id", "ﬁrst_name", "last_name","username","status" });
	                    }
	                });	                
	                setFieldSetMapper(new BeanWrapperFieldSetMapper<Users>() {
	                    {
	                        setTargetType(Users.class);
	                    }
	                });
	            }
	        });
	        return reader;
	    }	*/
	    
	    @Bean
	    public FlatFileItemReader<Users> reader() {
	        return new FlatFileItemReaderBuilder<Users>()
	            .name("personItemReader")
	            .resource(new ClassPathResource("sample-data.csv"))
	            .delimited()
	            .names(new String[]{"user_Id", "ﬁrst_name", "last_name","username","status"})
	            .fieldSetMapper(new BeanWrapperFieldSetMapper<Users>() {{
	                setTargetType(Users.class);
	            }})
	            .build();
	    }
	    @Bean
	    public JdbcBatchItemWriter<Users> writer(DataSource dataSource) {
	        return new JdbcBatchItemWriterBuilder<Users>()
	            .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
	            .sql("UPDATE USERS SET (status)  (:status)")
	            .dataSource(dataSource)
	            .build();
	    }
}
