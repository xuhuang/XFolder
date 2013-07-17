package com.videostore.controllers;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.videostore.bean.Movie;
import com.videostore.bean.User;
import com.videostore.dao.VideoStoreDAO;
import com.videostore.dao.VideoStoreDAOImpl;
import com.videostore.logic.MovieLogic;
import com.videostore.logic.UserLogic;

@Controller
public class ProductBrowseController extends AbstractController {
	
	private VideoStoreDAO videoStoreDAO = new VideoStoreDAOImpl();
	
   	@RequestMapping("/home")
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response){
//   		HttpSession session = request.getSession();
    	String category = request.getParameter("category");
   		String errMsg = "The result is empty!";
   		Movie[] movies = null;
    	if(category != null) {
    		if("movie".equals(category)) {
    			movies = videoStoreDAO.getAllMovies();
    		} else if("vcr".equals(category)) {
    			
    		} else if("store".equals(category)) {
    			
    		} else {
        		movies = videoStoreDAO.getMoviesByCategory(category);
    		}
    		if(movies.length > 0) {
        		ArrayList list = (ArrayList) MovieLogic.getMovieList(movies);
        		return new ModelAndView("home", "movies", list);
    		}
    	}
    	return new ModelAndView("failed","errMsg", errMsg);
    }
}