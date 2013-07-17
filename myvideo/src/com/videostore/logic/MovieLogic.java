package com.videostore.logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.videostore.bean.Movie;
import com.videostore.dao.VideoStoreDAO;
import com.videostore.dao.VideoStoreDAOImpl;

public class MovieLogic {
	private static VideoStoreDAO videoStoreDAO = new VideoStoreDAOImpl();
	
	public static List getMovieList(Movie[] movies) {
		ArrayList<Map<String, String>> list = new ArrayList<Map<String, String>>();
		
		for(Movie movie : movies) {
			Integer[] copies = videoStoreDAO.getMovieCopies(movie.getObjectId());
			Map currMovie = new HashMap<String, String>();
			currMovie.put("ObjectId", movie.getObjectId());
			currMovie.put("Title", movie.getTitle());
			currMovie.put("id", movie.getObjectId());
			currMovie.put("Category", movie.getCategory());
			currMovie.put("Charge", movie.getCharge());
			currMovie.put("Director", movie.getDirector());
			currMovie.put("Producer", movie.getProducer());
			currMovie.put("Poster", movie.getPoster());
			currMovie.put("Actor", movie.getActor1()+" ,"+movie.getActor2());
			currMovie.put("Copy", copies);
			list.add(currMovie);
		}
		return list;
	}
}
