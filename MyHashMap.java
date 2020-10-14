package com.capgemini.assignment.hashtable;

import com.capgemini.assignment.linkedlist.MyLinkedList;

public class MyHashMap<K, V> {
	private MyLinkedList myLinkedList;
	public MyHashMap() {
		myLinkedList  = new MyLinkedList();
	}

	public V get(K key) {
		MyMapNode<K,V> myMapNode = (MyMapNode<K, V>) myLinkedList.search(key);
		if(myMapNode==null)
		return null;
		else
			return myMapNode.getValue();
	}

	public void add(K key, V value) {
		MyMapNode<K,V> myMapNode = (MyMapNode<K, V>) myLinkedList.search(key);
		if(myMapNode==null) {
		myMapNode = new MyMapNode(key, value);
			myLinkedList.append(myMapNode);
		}
		else 
			myMapNode.setValue(value);
	}
	@Override
	public String toString() {
		return " " + myLinkedList + " ";
	}

}
