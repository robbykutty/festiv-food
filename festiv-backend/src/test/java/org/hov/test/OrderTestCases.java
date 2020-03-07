package org.hov.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.List;
import java.util.UUID;

import org.hov.config.AppConfig;
import org.hov.enumerators.OrderStatus;
import org.hov.model.Order;
import org.hov.service.OrderService;
import org.junit.Before;
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
	
	Order targetOrder;
	
	UUID targetUUID;
	
	/*  CREATION TEST CASES  */
	
	@Before
	public void getTargetOrder()
	{
		targetUUID = UUID.randomUUID();
		targetOrder = orderService.getAllOrder().get(0);
	}
	
	@Test
	@Ignore
	public void addOrder()
	{
		Order order = new Order();
	
		order.setUserId(targetUUID);
		order.setTeamId(targetUUID);
		order.setPaymentId(targetUUID);
		order.setOrderQuantity(4);
		order.setOrderStatus(OrderStatus.INITATED);
		
		assertNotEquals(0, orderService.addOrder(order));
	}
	
	/*  UPDATION TEST CASES  */
	
	@Test
	@Ignore
	public void updateOrder()
	{
		Order order = targetOrder;
		order.setOrderStatus(OrderStatus.DELIVERED);
		order.setUserId(targetUUID);
		order.setTeamId(targetUUID);
		
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
		List<Order> orderList = orderService.getOrderByUser(targetUUID);
		
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
		List<Order> orderList = orderService.getOrderByTeam(targetUUID);
		
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
		Order odr = orderService.getOrderById(targetOrder.getOrderId());
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
