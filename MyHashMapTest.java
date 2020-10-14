package com.capgemini.assignment.hashtable;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import junit.framework.Assert;

public class MyHashMapTest {
	@Test
	public void givenASentenceWhenWordsAreAddedToListShouldReturnWordFrequency() {
		java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MyHashMap.class.getName());
		String sentence = "To be or not to be";
		MyHashMap<String, Integer> myHashMap = new MyHashMap();
		String[] words = sentence.toLowerCase().split(" ");
		for (String word : words) {
			Integer value = myHashMap.get(word);
			if (value == null)
				value = 1;
			else
				value = value + 1;
			myHashMap.add(word, value);
		}
		int frequency = myHashMap.get("to");
		
		logger.info("MapNodes : "+myHashMap);
		Assert.assertEquals(2, frequency);
	}
}
