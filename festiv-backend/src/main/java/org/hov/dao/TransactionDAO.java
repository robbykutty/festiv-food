package org.hov.dao;

import org.hov.model.Transaction;

public interface TransactionDAO 
{
	public int createPaymentTransaction(Transaction transaction);
	public String getPaymentTransactionStatusById(int transactionId);
	public boolean expirePaymentTransactionById(int transactionId);
}
