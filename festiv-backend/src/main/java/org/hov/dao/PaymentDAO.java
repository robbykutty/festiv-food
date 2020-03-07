package org.hov.dao;

import java.util.List;
import java.util.UUID;

import org.hov.model.Payment;

public interface PaymentDAO
{
	public UUID createPaymentTransaction(Payment payment);
	public Payment getPaymentTransactionById(int paymentId);
	public List<Payment> getPayementTransactionByOrderId(int orderId);
	public long getPaymentTransactionExpirySeconds(int paymentId);
}
