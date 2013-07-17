package com.videostore.factory;

import java.sql.Connection;

import com.videostore.utils.SimplePool;

public class DBPool extends SimplePool<Connection>{
	
	public DBPool() {
		init();
	}
	
	
	public void init() {
		for(int i=0; i<super.MAX_IDLE; i++) {
			objectList.add(DBConnectionFactory.getConnection(""));
		}
		System.out.println("Pool Initilized");
	}

}
