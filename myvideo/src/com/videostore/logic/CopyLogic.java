package com.videostore.logic;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.videostore.bean.Copy;

public class CopyLogic {
	public static String getAmount(ArrayList copies) {
		String result = null;
		BigDecimal bd = new BigDecimal("0");
		System.out.println("copies.size()::"+copies.size());
		for(int i=0;i<copies.size();i++) {

			Copy copy = (Copy)copies.get(i);
			System.out.println("copy.getCharge()::"+copy.getCharge());
			BigDecimal charge = new BigDecimal(copy.getCharge());
			bd = bd.add(charge);
		}
		result = bd.toString();
		return result;
	}
	public static List convertCopyList(ArrayList copies) {
		ArrayList<Map<String, String>> list = new ArrayList<Map<String, String>>();
		for(int i=0;i<copies.size();i++) {
			Map currCopy = new HashMap<String, String>();
			Copy copy = (Copy) copies.get(i);
			currCopy.put("Title", copy.getTitle());
			currCopy.put("Charge", copy.getCharge());
			currCopy.put("CopyNo", copy.getCopyNo());
			currCopy.put("Poster", copy.getPoster());
			list.add(currCopy);
		}
		return list;
	}
}
