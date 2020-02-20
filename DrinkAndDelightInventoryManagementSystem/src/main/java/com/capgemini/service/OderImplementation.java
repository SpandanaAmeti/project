package com.capgemini.service;

import java.util.HashMap;

import com.capgemini.dao.OrderDAO;
import com.capgemini.dto.OrderBean;

public class OderImplementation {
	public  HashMap<Integer,OrderBean> addData( OrderBean p) {
		
		//System.out.println(p);
		OrderDAO o=new OrderDAO();
		o.storeValue(p);
		return null;
		
		
	}
}
