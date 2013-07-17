package com.videostore.bean;

public class User {
	
	private String id;
	private String password;
	private String userName;
	private String Address;
	
	@Override
	public boolean equals(Object user){
		if (!(user instanceof User))
			return false;
		User tempuser = (User)user;
		if (tempuser.id.equals(this.id) && tempuser.password.equals(this.password)
				&& tempuser.userName.equals(this.userName) && tempuser.Address.equals(this.Address))
			return true;
		return false;
	}
	@Override
	public int hashCode() {
		StringBuilder sb = new StringBuilder();
		sb.append(id+"~~");
		sb.append(password+"~~");
		sb.append(userName+"~~");
		sb.append(Address);
		return sb.toString().hashCode();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", userName="
				+ userName + ", Address=" + Address + "]";
	}

}
