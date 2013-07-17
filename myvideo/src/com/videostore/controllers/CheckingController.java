package com.videostore.controllers;


import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.videostore.bean.Copy;
import com.videostore.bean.Movie;
import com.videostore.bean.User;
import com.videostore.dao.VideoStoreDAO;
import com.videostore.dao.VideoStoreDAOImpl;
import com.videostore.logic.CopyLogic;
import com.videostore.logic.MovieLogic;
import com.videostore.logic.UserLogic;

@Controller
public class CheckingController extends AbstractController {
	
	private VideoStoreDAO videoStoreDAO = new VideoStoreDAOImpl();
	
   	@RequestMapping("/checking")
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response){
   		String amount_str = request.getParameter("amount");
   		//amount_str = "5.98";
   		System.out.println("amount_str::: "+amount_str);
   		HttpSession session = request.getSession();
    	ArrayList copyList = (ArrayList) session.getAttribute("copyList");
    	// 33% discount
		Calendar date = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		int weekday = date.get(Calendar.DAY_OF_WEEK);
		BigDecimal bd = null;
		String msg = "";
    	if(copyList.size() > 2 && weekday != 1 && weekday != 7) {
    		bd = new BigDecimal(amount_str);
    		bd = bd.multiply(new BigDecimal("0.67"));
    		msg = "Thank you for the order! You just got 33% off.(See our discount <a class=\"policy\" href=\"#\">policy</a> here.)";
    	} else if ( weekday != 1 && weekday != 7) {
    		bd = new BigDecimal(amount_str);
    		bd = bd.multiply(new BigDecimal("0.9"));
    		msg = "Thank you for the order! You just got 10% off.(See our discount <a class=\"policy\" href=\"#\">policy</a> here.)";
    	} else {
    		bd = new BigDecimal(amount_str);
    	}
    	int transId = videoStoreDAO.getMaxTransId()+1;
		String dateTime = format.format(date.getTime());
		String amount = bd.toString();
		String userId = (String) session.getAttribute("userId");
		videoStoreDAO.insertTransaction(transId, dateTime, amount, userId);
		videoStoreDAO.insertCopy(copyList, String.valueOf(transId));
   		System.out.println("msg::: "+msg);
    	return new ModelAndView("confirm", "msg", msg);
	
    }
}