package com.videostore.test;

import java.util.Calendar;

import com.videostore.test.connection.ConnectionTest;
import com.videostore.test.dao.VideoStoreDAOTest;
import com.videostore.test.logic.VideoStoreLogic;

public class AllTest {
	
	public static void main(String[] args) throws Exception{
//		ConnectionTest.test();
//		VideoStoreDAOTest.test();
//		VideoStoreLogic.testUserLogin();
		VideoStoreDAOTest.testMovie();
//		VideoStoreLogic.testGetAmount();
//		VideoStoreDAOTest.testMaxxx();
	}

}
