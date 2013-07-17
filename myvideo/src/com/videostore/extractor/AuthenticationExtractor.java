package com.videostore.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.videostore.bean.Movie;
import com.videostore.bean.User;

public class AuthenticationExtractor {
	
	public static User[] extract(ResultSet rs) throws Exception {
		List <User> authList = new ArrayList<User>();
		while(rs.next()){
			User auth = new User();
			auth.setUserName(rs.getString("MName"));
			auth.setPassword(rs.getString("Password"));
			auth.setAddress(rs.getString("Address"));
			auth.setId(rs.getString("MemberId"));
			authList.add(auth);
		}
		
		return authList.toArray(new User[] {});
	}
	
	public static Movie[] extractMovie(ResultSet rs) throws Exception {
		List <Movie> movieList = new ArrayList<Movie>();
		while(rs.next()){
			Movie movie = new Movie();
			movie.setObjectId(rs.getString("ObjectId"));
			movie.setTitle(rs.getString("Title"));
			movie.setCategory(rs.getString("Category"));
			movie.setDirector(rs.getString("Director"));
			movie.setProducer(rs.getString("Producer"));
			movie.setActor1(rs.getString("Actor1"));
			movie.setActor2(rs.getString("Actor2"));
			movie.setCharge(rs.getString("Charge"));
			movie.setPoster(rs.getString("Poster"));
			movieList.add(movie);
		}
		
		return movieList.toArray(new Movie[] {});
	}
	
	public static Integer[] extractCopy(ResultSet rs) throws Exception {
		List <Integer> copies = new ArrayList();
		while(rs.next()) {
			copies.add(rs.getInt("CopyNo"));
		}
		return copies.toArray(new Integer[] {});
	}
}
