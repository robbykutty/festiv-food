package org.hov.serviceimpl;

import java.util.List;
import java.util.UUID;

import org.hov.dao.OrderDAO;
import org.hov.model.Order;
import org.hov.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService
{
	@Autowired
	OrderDAO orderDAO;

	@Override
	public UUID addOrder(Order order) 
	{
		return orderDAO.addOrder(order);
	}

	@Override
	public boolean updateOrder(Order order) 
	{
		return orderDAO.updateOrder(order);
	}

	@Override
	public List<Order> getAllOrder() 
	{
		return orderDAO.getAllOrder();
	}

	@Override
	public List<Order> getOrderByUser(int userId) 
	{
		return orderDAO.getOrderByUser(userId);
	}

	@Override
	public List<Order> getOrderByTeam(int teamId) 
	{
		return orderDAO.getOrderByTeam(teamId);
	}

	@Override
	public Order getOrderById(int orderId) 
	{
		return orderDAO.getOrderById(orderId);
	}
}
