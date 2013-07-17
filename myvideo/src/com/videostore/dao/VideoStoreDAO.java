package com.videostore.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.videostore.bean.Copy;
import com.videostore.bean.Movie;
import com.videostore.bean.User;

public interface VideoStoreDAO {
	
	public User[] getAllUsers();
	
	public Movie[] getAllMovies();
	
	public Movie[] getMoviesByCategory(String category);
	
	public Integer[] getMovieCopies(String movieId);
	
	public Movie[] getMoviesByTitle(String title);
	
	public ResultSet getReport(String sql);
	
	public Copy getCopyById(String ObjectId, String CopyNo);
	
	public Movie getMovieById(String id);
	
	public int getMaxTransId();
	
	public void insertTransaction(int tranId, String date, String amount, String memberId);
	
	public void insertCopy(ArrayList copyList, String transId);
}
