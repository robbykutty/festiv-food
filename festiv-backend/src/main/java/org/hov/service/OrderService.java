package org.hov.service;

import java.util.List;
import java.util.UUID;

import org.hov.model.Order;

public interface OrderService 
{
	public UUID addOrder(Order order);
	public boolean updateOrder(Order order);
	public List<Order> getAllOrder();
	public List<Order> getOrderByUser(UUID userId);
	public List<Order> getOrderByTeam(UUID teamId);
	public Order getOrderById(UUID orderId);
}
