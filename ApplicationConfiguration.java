package com.sample.demo;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {
	
	static class JersyConfig extends ResourceConfig {
		public JersyConfig() {
			this.packages("com.example.demo");
		}
		
	}

}
