package com.capgemini.assignment.hashtable;

import org.junit.Test;

import junit.framework.Assert;

public class MyLinkedHashMapTest {
	java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MyLinkedHashMap.class.getName());

	@Test
	public void givenASentenceWhenWordsAreAddedToListShouldReturnWordsFrequency() {
		String sentence = "Paranoids are not paranoid because they are paranoid but"
				        + " because they keep putting themselves deliberately "
				        + "into paranoid avoidable situations";
		MyLinkedHashMap<String, Integer> myLinkedHashMap = new MyLinkedHashMap();
		String[] words = sentence.toLowerCase().split(" ");
		for (String word : words) {
			Integer value = myLinkedHashMap.get(word);
			if (value == null)
				value = 1;
			else
				value = value + 1;
			myLinkedHashMap.add(word, value);
		}
		int frequency = myLinkedHashMap.get("paranoid");
		logger.info("All MapNodes : "+myLinkedHashMap);
		Assert.assertEquals(3, frequency);
	}
	@Test
	public void givenASentenceWhenWordsAreDeletedFromList() {
		String sentence = "Paranoids are not paranoid because they are paranoid but "
				+ "because they keep putting themselves deliberately " + "into paranoid avoidable situations";
		MyLinkedHashMap<String, Integer> myLinkedHashMap = new MyLinkedHashMap();
		boolean empty = myLinkedHashMap.isEmpty();
		Assert.assertTrue(empty);
		String[] words = sentence.toLowerCase().split(" ");
		for (String word : words) {
			Integer value = myLinkedHashMap.get(word);
			if (value == null)
				value = 1;
			else
				value = value + 1;
			myLinkedHashMap.add(word, value);
		}
		int sizeBefore = myLinkedHashMap.size();
		Assert.assertEquals(14, sizeBefore);
		MyMapNode<String, Integer> delete = myLinkedHashMap.remove("avoidable");
		int sizeAfter = myLinkedHashMap.size();
		logger.info("MapNodes after removing: "+myLinkedHashMap);
		Assert.assertEquals("avoidable", delete.getKey());
		Assert.assertEquals(13, sizeAfter);
	}
}
