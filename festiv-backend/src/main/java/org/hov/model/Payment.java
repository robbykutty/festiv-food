package org.hov.model;

import java.security.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="Payments")
public class Payment 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int paymentId;
	
	@Column
	private int orderId;
	private String paymentStatus; //To be changed to Enumeration, Constants-> INITIATED, PAID, REFUNDED, EXPIRED
	private String paymentInfo;
	private String paymentPass;
	private Timestamp paymentExpiry;
	private Timestamp paymentDate;
	
	public int getPaymentId() 
	{
		return paymentId;
	}
	
	public void setPaymentId(int paymentId) 
	{
		this.paymentId = paymentId;
	}
	
	public int getOrderId() 
	{
		return orderId;
	}

	public void setOrderId(int orderId) 
	{
		this.orderId = orderId;
	}

	public String getPaymentStatus() 
	{
		return paymentStatus;
	}
	
	public void setPaymentStatus(String paymentStatus) 
	{
		this.paymentStatus = paymentStatus;
	}
	
	public String getPaymentInfo() 
	{
		return paymentInfo;
	}
	
	public void setPaymentInfo(String paymentInfo) 
	{
		this.paymentInfo = paymentInfo;
	}
	
	public String getPaymentPass() 
	{
		return paymentPass;
	}
	
	public void setPaymentPass(String paymentPass) 
	{
		this.paymentPass = paymentPass;
	}
	
	public Timestamp getPaymentDate() 
	{
		return paymentDate;
	}
	
	public void setPaymentDate(Timestamp paymentDate) 
	{
		this.paymentDate = paymentDate;
	}
	
	public Timestamp getPaymentExpiry() 
	{
		
		return paymentExpiry;
	}
	
	public void setPaymentExpiry(Timestamp paymentExpiry) 
	{
		this.paymentExpiry = paymentExpiry;
	}
}
