package org.hov.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.hov.config.AppConfig;
import org.hov.model.Payment;
import org.hov.service.PaymentService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringJUnitConfig(classes = AppConfig.class)
public class PaymentTestCases 
{
	@Autowired
	PaymentService paymentService;
	
	@Test
	@Ignore
	public void addPayment()
	{
		Payment payment = new Payment();
		payment.setOrderId(1);
		payment.setPaymentInfo("LOGIN");
		payment.setPaymentPass("PASS");
		payment.setPaymentStatus("INITIATED");
		
		assertEquals(true, paymentService.createPaymentTransaction(payment));
	}

	@Test
	@Ignore
	public void getPaymentById()
	{
		assertNotNull(paymentService.getPaymentTransactionById(2));
	}

	@Test
	@Ignore
	public void getPaymentByOrder()
	{
		assertNotNull(paymentService.getPayementTransactionByOrderId(3));
	}

	@Test
	@Ignore
	public void getPaymentExpiryTime()
	{
		long seconds = paymentService.getPaymentTransactionExpirySeconds(2);
		assertNotEquals(0, seconds);
	}
}
