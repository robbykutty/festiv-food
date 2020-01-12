package org.hov.dao;

import java.util.List;

import org.hov.model.Order;

public interface OrderDAO 
{
	public int addOrder(Order order);
	public List<Order> getAllOrder();
	public List<Order> getOrderByUser(int userid);
	public List<Order> getOrderByTeam(int teamid);
	public Order getOrderById(int orderId);
	public boolean updateOrderById(int OrderId);
	public boolean expireOrderById(int orderId);
}
