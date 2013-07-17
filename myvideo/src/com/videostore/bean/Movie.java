package com.videostore.bean;

public class Movie {

	private String ObjectId;
	private String Title;
	private String Category;
	private String Director;
	private String Producer;
	private String Actor1;
	private String Actor2;
	private String Charge;
	private String Poster;
	
	public String getObjectId() {
		return ObjectId;
	}
	public void setObjectId(String objectId) {
		ObjectId = objectId;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	public String getDirector() {
		return Director;
	}
	public void setDirector(String director) {
		Director = director;
	}
	public String getProducer() {
		return Producer;
	}
	public void setProducer(String producer) {
		Producer = producer;
	}
	public String getActor1() {
		return Actor1;
	}
	public void setActor1(String actor1) {
		Actor1 = actor1;
	}
	public String getActor2() {
		return Actor2;
	}
	public void setActor2(String actor2) {
		Actor2 = actor2;
	}
	public String getCharge() {
		return Charge;
	}
	public void setCharge(String charge) {
		Charge = charge;
	}
	public String getPoster() {
		return Poster;
	}
	public void setPoster(String poster) {
		Poster = poster;
	}
	
	@Override
	public String toString() {
		return "Movie [ObjectId=" + ObjectId + ", Title=" + Title
				+ ", Category=" + Category + ", Director=" + Director
				+ ", Producer=" + Producer + ", Actor1=" + Actor1 + ", Actor2="
				+ Actor2 + ", Charge=" + Charge + "]";
	}
	
}
