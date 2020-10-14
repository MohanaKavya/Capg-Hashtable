package com.capgemini.assignment.hashtable;
import java.util.ArrayList;

import com.capgemini.assignment.linkedlist.MyLinkedList;

import junit.framework.Assert;

public class MyLinkedHashMap<K, V> {
	private int bucketNumber;
	private ArrayList<MyLinkedList> bucketArray;
	
	public MyLinkedHashMap() {
		this.bucketNumber = 10;
		bucketArray = new ArrayList<>();
		for(int i=0; i<bucketNumber; i++)
			this.bucketArray.add(null);
	}

	 private int getBucketIndex(K key) {
		int hashCode = Math.abs(key.hashCode());
		int index = hashCode % bucketNumber;
		 return index;
	}
	
	public V get(K key) {
		int index = getBucketIndex(key);
		MyLinkedList myLinkedList = bucketArray.get(index);
		if(myLinkedList==null)
			return null;
		else {
			MyMapNode<K, V> myMapNode = (MyMapNode<K, V>) myLinkedList.search(key);
			if(myMapNode==null)
				return null;
			else
				return myMapNode.getValue();
		}		
	}


	void add(K key, V value) {
		int index = getBucketIndex(key);
		MyLinkedList myLinkedList = bucketArray.get(index);
		if(myLinkedList==null) {
			myLinkedList = new MyLinkedList();
			bucketArray.set(index, myLinkedList);
		}
			MyMapNode<K, V> myMapNode = (MyMapNode<K, V>) myLinkedList.search(key);
			if(myMapNode==null) {
				myMapNode = new MyMapNode<>(key, value);
				myLinkedList.append(myMapNode);
			}
			else
				myMapNode.setValue(value);		
	}
	public boolean isEmpty() {
		return size() == 0 ? true : false;
	}

	public int size() {
		int size = 0;
		for(int i=0; i<bucketNumber; i++) {
			MyLinkedList myLinkedList = bucketArray.get(i);
			if(myLinkedList!=null)
				size+=myLinkedList.size();
		}
		return size;
	}

	public MyMapNode<K, V> remove(K key) {
		int index = getBucketIndex(key);
		MyLinkedList myLinkedList = bucketArray.get(index);
		if(myLinkedList==null) 
			return null;
			MyMapNode<K, V> myMapNode = (MyMapNode<K, V>) myLinkedList.search(key);
			if(myMapNode==null)  
				return null;
			else { 
				MyMapNode<K, V> deleteNode = null;
				if(myMapNode==myLinkedList.head) 	
					deleteNode = (MyMapNode) myLinkedList.pop();
				else if(myMapNode==myLinkedList.tail)
					deleteNode = (MyMapNode) myLinkedList.popLast();
				else 
				deleteNode = (MyMapNode) myLinkedList.deleteAtPosition(myMapNode);
		return deleteNode;
			}
	}

	@Override
	public String toString() {
		return " " + bucketArray + " ";
	}
}
