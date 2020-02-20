package com.capgemini.dao;

import java.util.HashMap;

import com.capgemini.dto.OrderBean;

public class OrderDAO {

	private static final Integer SupplierId = null;

	public HashMap<Integer,OrderBean> storeValue(OrderBean a) {
		//HashMap<Integer,DDbean>
		OrderBean dd=new OrderBean();
	HashMap<Integer,OrderBean> p=new HashMap<Integer,OrderBean>();
	p.put(SupplierId,a);
	//p.put(SupplierId,dd);
System.out.println(OrderBean.getName());
System.out.println(OrderBean.getPrice_per_unit());
System.out.println(OrderBean.getQuanityunit());
System.out.println(OrderBean.getQuantityValue());
System.out.println("Your order is placed sucessfully ");
	
	return null;
	
	
	
	
		
	}
}
