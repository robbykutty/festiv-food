package org.hov.model;

import java.security.Timestamp;
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
	private String orderStatus;
	private int orderQuantity;
	private Timestamp orderConfirmedTime;
	private int userId;
	private int teamId;
	private String transactionId;
	private boolean orderExpired;
	
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
	
	public String getTransactionId() 
	{
		return transactionId;
	}
	
	public void setTransactionId(String transactionId) 
	{
		this.transactionId = transactionId;
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

	public Timestamp getOrderConfirmedTime() 
	{
		return orderConfirmedTime;
	}

	public void setOrderConfirmedTime(Timestamp orderConfirmedTime) 
	{
		this.orderConfirmedTime = orderConfirmedTime;
	}		
	
	public boolean isOrderExpired() 
	{
		return orderExpired;
	}

	public void setOrderExpired(boolean orderExpired) 
	{
		this.orderExpired = orderExpired;
	}
}
