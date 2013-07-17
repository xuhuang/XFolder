package com.videostore.utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;

public abstract class SimplePool <T> implements Poolable<T>{
	
	protected static final int MAX_IDLE = 10;
	protected ArrayList<T> objectList;
	
	private BlockingQueue request;
	
	public SimplePool() {
		objectList = new ArrayList<T>();
	}
	
	@Override
	public synchronized T getObject() {
		T returnValue = null;
		for(int i=0; i<objectList.size(); i++) {
			if(objectList.get(i)!=null) {
				returnValue = objectList.get(i);
				objectList.set(i, null);
				return returnValue;
			}
		}
		
		System.out.println("Pool being comsumed out.");
		return null;
	}
	@Override
	public synchronized void returnObject(T obj) {
		for(int i=0; i<objectList.size(); i++) {
			if(objectList.get(i) == null) {
				objectList.set(i, obj);
			}
		}
		
	}
	
	

}
