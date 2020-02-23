package org.hov.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="Orders")
public class Order 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int orderId;
	
	@Column
	private String orderStatus; // Convert to ENUM, Constants -> INITATED, PREPARED, DELIVERED, RETURNED
	private int orderQuantity;
	private int userId;
	private int teamId;
	private int paymentId;
	
	public int getOrderId() 
	{
		return orderId;
	}
	
	public void setOrderId(int orderId) 
	{
		this.orderId = orderId;
	}
	
	public int getUserId() 
	{
		return userId;
	}
	
	public void setUserId(int userId) 
	{
		this.userId = userId;
	}
	
	public int getTeamId() 
	{
		return teamId;
	}
	
	public void setTeamId(int teamId) 
	{
		this.teamId = teamId;
	}
	
	public String getOrderStatus() 
	{
		return orderStatus;
	}
	
	public void setOrderStatus(String orderStatus) 
	{
		this.orderStatus = orderStatus;
	}

	public int getOrderQuantity() 
	{
		return orderQuantity;
	}

	public void setOrderQuantity(int orderQuantity) 
	{
		this.orderQuantity = orderQuantity;
	}

	public int getPaymentId() 
	{
		return paymentId;
	}

	public void setPaymentId(int paymentId) 
	{
		this.paymentId = paymentId;
	}
}
