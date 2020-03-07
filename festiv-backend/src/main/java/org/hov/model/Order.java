package org.hov.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Range;
import org.hov.enumerators.OrderStatus;

@Entity
@Table (name="Orders")
public class Order 
{
	@Id
	@GeneratedValue
	@Type(type = "uuid-char")
	private UUID orderId;
	
	@Column
	@NotBlank
	@Enumerated(EnumType.STRING)
	private OrderStatus orderStatus;
	
	@Column
	@NotNull
	@Range(min = 1, message = "Order Quantity can be less than 1.")
	@Range(max = 3, message = "Order Quantity can be more than 3.")
	private int orderQuantity;
	
	@Column
	//@NotNull
	private UUID userId;
	
	@Column
	//@NotNull
	private UUID teamId;
	
	@Column
	//@NotNull
	private UUID paymentId;
	
	public UUID getOrderId() 
	{
		return orderId;
	}

	public void setOrderId(UUID orderId) 
	{
		this.orderId = orderId;
	}

	public UUID getUserId() 
	{
		return userId;
	}
	
	public void setUserId(UUID userId) 
	{
		this.userId = userId;
	}
	
	public UUID getTeamId() 
	{
		return teamId;
	}
	
	public void setTeamId(UUID teamId) 
	{
		this.teamId = teamId;
	}
	
	public OrderStatus getOrderStatus() 
	{
		return orderStatus;
	}
	
	public void setOrderStatus(OrderStatus orderStatus) 
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

	public UUID getPaymentId() 
	{
		return paymentId;
	}

	public void setPaymentId(UUID paymentId) 
	{
		this.paymentId = paymentId;
	}
}
