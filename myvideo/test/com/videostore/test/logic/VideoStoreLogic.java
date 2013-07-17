package com.videostore.test.logic;

import java.util.ArrayList;

import com.videostore.bean.Copy;
import com.videostore.bean.User;
import com.videostore.dao.VideoStoreDAO;
import com.videostore.dao.VideoStoreDAOImpl;
import com.videostore.logic.CopyLogic;
import com.videostore.logic.UserLogic;

public class VideoStoreLogic {
//	private static UserLogi;
	public static void testUserLogin() {
		User user = new User();
		user.setId("123");
		user.setPassword("321");
		
		User[] users = new User[]{ user };
		
		assert(UserLogic.isUserAuthenticated(users, null, null) == false);
		assert(UserLogic.isUserAuthenticated(users, "123", null) == false);
		assert(UserLogic.isUserAuthenticated(users, null, "321") == false);
		assert(UserLogic.isUserAuthenticated(users, "112", null) == false);
		assert(UserLogic.isUserAuthenticated(users, null, "111") == false);
		assert(UserLogic.isUserAuthenticated(users, "123", "321") == true);
		System.out.println("pass");
	}
	
	public static void testGetAmount() {

		VideoStoreDAO videoStoreDAO = new VideoStoreDAOImpl();
    	String copyNo = "50";
    	String objectId = "1001";
    	Copy copy = videoStoreDAO.getCopyById(objectId, copyNo);

    	ArrayList copyList = new ArrayList();
    	copyList.add(copy);
    	String amount = CopyLogic.getAmount(copyList);
    	System.out.println(amount);
	}
}
