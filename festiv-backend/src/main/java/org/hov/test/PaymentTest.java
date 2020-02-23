package org.hov.test;

import org.hov.daoimpl.PaymentDAOImpl;
import org.hov.model.Payment;

public class PaymentTest 
{
	public static void addPayment()
	{
		PaymentDAOImpl pdi = new PaymentDAOImpl();
		Payment payment = new Payment();
		payment.setOrderId(1);
		payment.setPaymentInfo("LOGIN");
		payment.setPaymentPass("PASS");
		payment.setPaymentStatus("INITIATED");
	}
	
	public static void getPaymentById()
	{
		
	}
	
	public static void getPaymentByOrder()
	{
		
	}
	
	
	public static void getPaymentExpiryTime()
	{
		
	}
	
	public static void main(String[] args)
	{
		
	}
}
