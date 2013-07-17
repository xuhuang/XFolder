package com.videostore.utils;

public interface Poolable <T>{
	
	public T getObject();
	public void returnObject(T obj);

}
