package com.videostore.logic;

import com.videostore.bean.User;

public class UserLogic {
	
	/**
	 * user is authenticated or not
	 * @param allUsers
	 * @param id
	 * @param password
	 * @return
	 */
	public static boolean isUserAuthenticated(User[] allUsers, String id, String password) {
		
		boolean result = false;
		
		if(null == id || null == password)
			return false;
		
		for(User user : allUsers) {
			if(id.equals(user.getId()) && password.equals(user.getPassword())) {
				result = true;
				break;
			}
		}
		return result;
	}
	
	public static String getUserNameById(User[] allUsers, String userId) {
		String name = "";
		for(User user : allUsers) {
			if(userId.equals(user.getId())) {
				name = user.getUserName();
				break;
			}
		}
		return name;
	}
}
