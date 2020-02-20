package com.capgemini.ui;

import java.util.Date;
import java.util.Scanner;

import com.capgemini.dto.OrderBean;
import com.capgemini.service.OderImplementation;

public class OrderMain {

	static String name;
	static double price_per_unit;
	static double quantityValue;
	static double quanityunit;
	double price;
	static String warehouseID;
	static String deliveryDate;

	Date ManufacturingDate;
	Date ExpiryDate;
	String QualityCheck;
	Date processDate;
	static int SupplierId;
	enum module1 {P,R};

	public static void main(String[] args) {
	
		String module = null;
		
Scanner sc=new Scanner(System.in);
OrderBean p=new OrderBean();


//System.out.println("Place an order");
OderImplementation sr=new  OderImplementation();


System.out.println("Place an order");

System.out.println( "Raw Material" );
System.out.println(" Product Stock");
System.out.println("Enter Material (R,P) : ");

module=sc.nextLine();
System.out.println("You entered module is  : " );   
switch(module1.valueOf(module))
{


case R:
	System.out.println("Enter the Raw Material Name");
	name=sc.nextLine();
	p.setName(name);

	
	System.out.println("Enter the Supplier ID");
	SupplierId=sc.nextInt();
	p.setSupplierId(SupplierId);
	
	System.out.println("Enter the Warehouse ID");
	warehouseID=sc.next();
	p.setWarehouseID(warehouseID);
	
	System.out.println("Enter Quantity value and unit");
	quantityValue=sc.nextDouble();
	p.setQuantityValue(quantityValue);
	 quanityunit=sc.nextDouble();
	p.setQuanityunit(quanityunit);
	System.out.println("Enter Price per Unit");
	price_per_unit=sc.nextDouble();
	p.setPrice_per_unit(price_per_unit);
	sr.addData(p);
		/*
		 * System.out.println("Enter Expected Date of delivery");
		 * deliveryDate=sc.nextLine();
		 */
	//System.out.println(p.getName());
	 break;
case P:
	System.out.println("Enter the Product Name");
	name=sc.nextLine();
	p.setName(name);
	
	System.out.println("Enter the Supplier ID");
	SupplierId=sc.nextInt();
	p.setSupplierId(SupplierId);
	
	System.out.println("Enter the Warehouse ID");
	warehouseID=sc.next();
	p.setWarehouseID(warehouseID);
	
	System.out.println("Enter Quantity value and unit");
	quantityValue=sc.nextDouble();
	p.setQuantityValue(quantityValue);
	 quanityunit=sc.nextDouble();
	 p.setQuanityunit(quanityunit);
	
	System.out.println("Enter Price per Unit");
	price_per_unit=sc.nextDouble();
	p.setPrice_per_unit(price_per_unit);
	
	sr.addData(p);
	break;
	
	

}



}
}

