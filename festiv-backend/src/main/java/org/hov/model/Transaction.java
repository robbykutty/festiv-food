package org.hov.model;

import java.security.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="Transactions")
public class Transaction 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int transactionId;
	
	@Column
	private String transactionType;
	private Timestamp transactionDate;
	private String transactionStatus;
	private String transactionInfo;
	
	public int getTransactionId() 
	{
		return transactionId;
	}
	
	public void setTransactionId(int transactionId) 
	{
		this.transactionId = transactionId;
	}
	
	public String getTransactionType() 
	{
		return transactionType;
	}
	
	public void setTransactionType(String transactionType) 
	{
		this.transactionType = transactionType;
	}
	
	public Timestamp getTransactionDate() 
	{
		return transactionDate;
	}
	
	public void setTransactionDate(Timestamp transactionDate) 
	{
		this.transactionDate = transactionDate;
	}
	
	public String getTransactionStatus() 
	{
		return transactionStatus;
	}
	
	public void setTransactionStatus(String transactionStatus) 
	{
		this.transactionStatus = transactionStatus;
	}
	
	public String getTransactionInfo() 
	{
		return transactionInfo;
	}
	
	public void setTransactionInfo(String transactionInfo) 
	{
		this.transactionInfo = transactionInfo;
	}
}
