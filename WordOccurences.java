package com.nyt.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author hemachandra
 *  
 */
public class WordOccurences {
	
	String words[] = { "Findow", "Balloons", "Elephants", "Boom Bands",
			"findow", "Hakken-Kraks", "Hakken-Kraks", "dog",
			"Hakken-Kraks", "Elephants" };
	    Integer wordKey =1;
	
	/**
	 * @param string
	 * @return
	 */
	public HashMap<Integer, String>wordCount(String string[]){		   
		   Map< Integer, String> wordMap =  new HashMap<>();		   
		   Set<String> set = duplicateCount();
		   for (String string2 : set) {	  
			    wordMap.put(wordKey,string2);
			    wordKey++;
		      }
		      System.out.println("size of the map/word count" + wordMap.size());
			return null;
	}
	
	/**
	 * @return
	 */
	public Set<String> duplicateCount(){
		boolean found = false;
		int duplicateWord = 0;
		Set<String> set = new HashSet<String>();
		for(int i=0;i<words.length;i++){
		//for (String string : set) {
			if (!set.add(words[i])) {
				duplicateWord++;
				System.out.println("" +words[i]);
			}
			else{
				set.add(words[i]);
			}
			//System.out.println("word count of duplicates:" + duplicateWord);
		//}
		}
		return set;
	}

	public static void main(String[] args) {		
	 WordOccurences occurences = new WordOccurences();
	 occurences.duplicateCount();

	}

}
