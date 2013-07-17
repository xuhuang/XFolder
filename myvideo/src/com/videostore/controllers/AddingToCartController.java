package com.videostore.controllers;


import java.io.Serializable;
import java.math.BigDecimal;
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

import com.videostore.bean.Copy;
import com.videostore.bean.Movie;
import com.videostore.bean.User;
import com.videostore.dao.VideoStoreDAO;
import com.videostore.dao.VideoStoreDAOImpl;
import com.videostore.logic.CopyLogic;
import com.videostore.logic.MovieLogic;
import com.videostore.logic.UserLogic;

@Controller
public class AddingToCartController extends AbstractController {
	
	private VideoStoreDAO videoStoreDAO = new VideoStoreDAOImpl();
	
   	@RequestMapping("/addingtocart")
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response){
   		
   		HttpSession session = request.getSession();
    	String copyNo = request.getParameter("copy");
    	String objectId = request.getParameter("objectId");
    	System.out.println("copyno:"+copyNo+", objectId:"+objectId);
    	Copy copy = videoStoreDAO.getCopyById(objectId, copyNo);
    	System.out.println("111 ::"+copy.getCharge());

    	ArrayList copyList = (ArrayList) session.getAttribute("copyList");
    	if(copyList == null) {
    		copyList = new ArrayList();
    		copyList.add(copy);
    	} else {
    		copyList.add(copy);
    	}

    	String amount = CopyLogic.getAmount(copyList);
    	ArrayList copies = (ArrayList) CopyLogic.convertCopyList(copyList);
    	
    	Map cartInfo = new HashMap();
    	cartInfo.put("copies", copies);
    	cartInfo.put("amount", amount);
    	
    	session.setAttribute("copyList", copyList);
    	
    	return new ModelAndView("shoppingcart", "cartInfo", cartInfo);
	
    }
}