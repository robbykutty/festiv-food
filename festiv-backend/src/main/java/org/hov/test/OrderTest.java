package org.hov.test;

import java.util.List;

import org.hov.daoimpl.OrderDAOImpl;
import org.hov.model.Order;

public class OrderTest 
{
	public static void addOrder()
	{
		OrderDAOImpl odi = new OrderDAOImpl();
		Order order = new Order();
	
		order.setUserId(3);
		order.setTeamId(2);
		order.setPaymentId(3);
		order.setOrderQuantity(1);
		order.setOrderStatus("DELIVERED");
		
		System.out.println("Added Order Id =>" + odi.addOrder(order));
	}
	
	public static void updateOrder()
	{
		OrderDAOImpl odi = new OrderDAOImpl();
		Order order = odi.getOrderById(1);
		
		//order.setOrderStatus("PAID");
		order.setUserId(2);
		order.setTeamId(2);
		
		System.out.println("Updated Order=>" + odi.updateOrder(order));
	}
	public static void displayOrder()
	{
		OrderDAOImpl odi = new OrderDAOImpl();
		List<Order> orderList = odi.getAllOrder();
		
		for(Order odr: orderList)
		{
			System.out.println("-------------------------");
			System.out.println("Order Id: " + odr.getOrderId());
			System.out.println("User Id: " + odr.getUserId());
			System.out.println("Team Id: " + odr.getTeamId());
			System.out.println("Order Status: " + odr.getOrderStatus());
			System.out.println("Order Quantity: " + odr.getOrderQuantity());
			System.out.println("Payment Id: " + odr.getPaymentId());
		}
	}
	
	public static void displayOrderByUser()
	{
		OrderDAOImpl odi = new OrderDAOImpl();
		List<Order> orderList = odi.getOrderByUser(3);
		
		for(Order odr: orderList)
		{
			System.out.println("-------------------------");
			System.out.println("Order Id: " + odr.getOrderId());
			System.out.println("User Id: " + odr.getUserId());
			System.out.println("Team Id: " + odr.getTeamId());
			System.out.println("Order Status: " + odr.getOrderStatus());
			System.out.println("Order Quantity: " + odr.getOrderQuantity());
			System.out.println("Payment Id: " + odr.getPaymentId());
		}
	}
	
	public static void displayOrderByTeam()
	{
		OrderDAOImpl odi = new OrderDAOImpl();
		List<Order> orderList = odi.getOrderByTeam(2);
		
		for(Order odr: orderList)
		{
			System.out.println("-------------------------");
			System.out.println("Order Id: " + odr.getOrderId());
			System.out.println("User Id: " + odr.getUserId());
			System.out.println("Team Id: " + odr.getTeamId());
			System.out.println("Order Status: " + odr.getOrderStatus());
			System.out.println("Order Quantity: " + odr.getOrderQuantity());
			System.out.println("Payment Id: " + odr.getPaymentId());
		}
	}
	
	public static void displayOrderById()
	{
		OrderDAOImpl odi = new OrderDAOImpl();
		Order odr = odi.getOrderById(2);

		System.out.println("-------------------------");
		System.out.println("Order Id: " + odr.getOrderId());
		System.out.println("User Id: " + odr.getUserId());
		System.out.println("Team Id: " + odr.getTeamId());
		System.out.println("Order Status: " + odr.getOrderStatus());
		System.out.println("Order Quantity: " + odr.getOrderQuantity());
		System.out.println("Payment Id: " + odr.getPaymentId());
	}
	
	public static void main(String[] args)
	{
		//addOrder();
		//updateOrder();
		//displayOrder();
		//displayOrderByUser();
		//displayOrderByTeam();
		//displayOrderById();
	}
}
