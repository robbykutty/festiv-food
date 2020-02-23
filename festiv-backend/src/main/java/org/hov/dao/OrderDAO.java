package org.hov.dao;

import java.util.List;

import org.hov.model.Order;

public interface OrderDAO 
{
	public int addOrder(Order order);
	public boolean updateOrder(Order order);
	public List<Order> getAllOrder();
	public List<Order> getOrderByUser(int userId);
	public List<Order> getOrderByTeam(int teamId);
	public Order getOrderById(int orderId);
}
