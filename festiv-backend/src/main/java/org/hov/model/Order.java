package org.hov.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

@Entity
@Table (name="Orders")
public class Order 
{
	@Id
	@GeneratedValue
	private UUID orderId;
	
	@Column
	@NotBlank
	private String orderStatus; // Convert to ENUM, Constants -> INITATED, PREPARED, DELIVERED, RETURNED
	
	@Column
	@NotNull
	@Range(min = 1, message = "Order Quantity can be less than 1.")
	@Range(max = 3, message = "Order Quantity can be more than 3.")
	private int orderQuantity;
	
	@Column
	@NotNull
	private int userId;
	
	@Column
	@NotNull
	private int teamId;
	
	@Column
	@NotNull
	private int paymentId;
	
	public UUID getOrderId() 
	{
		return orderId;
	}

	public void setOrderId(UUID orderId) 
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
