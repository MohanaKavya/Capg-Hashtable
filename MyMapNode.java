package com.capgemini.assignment.hashtable;

import com.capgemini.assignment.linkedlist.INode;

public class MyMapNode<K, V> implements INode<K>{
	private K key;
	private V value;
	private MyMapNode<K, V> next;
	
	public MyMapNode(K key, V value) {
		this.key = key;
		this.value = value;
		this.next = null;
	}

	@Override
	public void setNext(INode myNode) {
		this.next = (MyMapNode<K, V>) myNode;
	}

	@Override
	public INode getNext() {
		return this.next;
	}

	@Override
	public K getKey() {
		return this.key;
	}

	@Override
	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}
	@Override
	public String toString() {
		StringBuffer myMapNodes = new StringBuffer();
		myMapNodes.append("(Key : "+key+", Value : "+value+")");
		if(this.next!=null)
			myMapNodes.append(" -> ").append(next);
		return myMapNodes.toString();
	}

}
