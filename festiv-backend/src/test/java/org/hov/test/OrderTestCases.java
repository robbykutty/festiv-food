package org.hov.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.hov.config.AppConfig;
import org.hov.model.Order;
import org.hov.service.OrderService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringJUnitConfig(classes=AppConfig.class)
public class OrderTestCases 
{
	@Autowired
	OrderService orderService;
	
	/*  CREATION TEST CASES  */
	
	@Test
	@Ignore
	public void addOrder()
	{
		Order order = new Order();
	
		order.setUserId(3);
		order.setTeamId(2);
		order.setPaymentId(3);
		order.setOrderQuantity(1);
		order.setOrderStatus("DELIVERED");
		
		assertNotEquals(0, orderService.addOrder(order));
	}
	
	/*  UPDATION TEST CASES  */
	
	@Test
	@Ignore
	public void updateOrder()
	{
		Order order = orderService.getOrderById(5);
		order.setOrderStatus("PAID");
		order.setUserId(2);
		order.setTeamId(2);
		
		assertEquals(true, orderService.updateOrder(order));
	}
	
	/*  RETRIEVE TEST CASES  */
	
	@Test
	@Ignore
	public void displayOrder()
	{
		List<Order> orderList = orderService.getAllOrder();
		
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
		assertNotEquals(null, orderList);
	}
	
	@Test
	@Ignore
	public void displayOrderByUser()
	{
		List<Order> orderList = orderService.getOrderByUser(3);
		
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
		assertNotEquals(null, orderList);
	}
	
	@Test
	@Ignore
	public void displayOrderByTeam()
	{
		List<Order> orderList = orderService.getOrderByTeam(2);
		
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
		assertNotEquals(null, orderList);
	}

	@Test
	@Ignore
	public void displayOrderById()
	{
		Order odr = orderService.getOrderById(5);
		if (odr != null)
		{
			System.out.println("-------------------------");
			System.out.println("Order Id: " + odr.getOrderId());
			System.out.println("User Id: " + odr.getUserId());
			System.out.println("Team Id: " + odr.getTeamId());
			System.out.println("Order Status: " + odr.getOrderStatus());
			System.out.println("Order Quantity: " + odr.getOrderQuantity());
			System.out.println("Payment Id: " + odr.getPaymentId());
		}
		assertNotEquals(null, odr);
	}
}
