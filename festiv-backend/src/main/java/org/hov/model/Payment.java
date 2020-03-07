package org.hov.model;

import java.security.Timestamp;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table (name="Payments")
public class Payment 
{
	@Id
	@GeneratedValue
	private UUID paymentId;
	
	@Column
	@NotNull
	private int orderId;
	
	@Column
	@NotBlank
	private String paymentStatus; //To be changed to Enumeration, Constants-> INITIATED, PAID, REFUNDED, EXPIRED
	
	@Column
	private String paymentInfo;
	
	@Column
	private String paymentPass;

	@Column
	@NotNull
	private Timestamp paymentExpiry;

	@Column
	@NotNull
	private Timestamp paymentDate;
	
	public UUID getPaymentId() 
	{
		return paymentId;
	}

	public void setPaymentId(UUID paymentId) 
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
