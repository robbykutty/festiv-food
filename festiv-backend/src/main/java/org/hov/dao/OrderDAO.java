package org.hov.dao;

import java.util.List;
import java.util.UUID;

import org.hov.model.Order;

public interface OrderDAO 
{
	public UUID addOrder(Order order);
	public boolean updateOrder(Order order);
	public List<Order> getAllOrder();
	public List<Order> getOrderByUser(int userId);
	public List<Order> getOrderByTeam(int teamId);
	public Order getOrderById(int orderId);
}
