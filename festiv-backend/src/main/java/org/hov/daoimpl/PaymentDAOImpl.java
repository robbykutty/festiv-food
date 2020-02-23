package org.hov.daoimpl;

import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hov.dao.PaymentDAO;
import org.hov.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("paymentDAO")
@Transactional
public class PaymentDAOImpl implements PaymentDAO
{
	@Autowired
	SessionFactory sessionFactory;
	
	public int createPaymentTransaction(Payment payment)
	{
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try
		{
			tx = session.beginTransaction();
			session.save(payment);
			tx.commit();
			return payment.getPaymentId();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			tx.rollback();
			return 0;
		}
		finally
		{
		session.close();	
		}
	}
	
	public List<Payment> getPayementTransactionByOrderId(int orderId) 
	{
		try
		{
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from org.hov.model.Payment where orderId = :id");
			query.setParameter("id", orderId);
			return query.getResultList();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public Payment getPaymentTransactionById(int paymentId) 
	{
		try
		{
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from org.hov.model.Payment where paymentId = :id");
			query.setParameter("id", paymentId);
			return (Payment)query.getResultList().get(0);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}	
	
	public long getPaymentTransactionExpirySeconds(int paymentId) 
	{	
		long remainingSeconds = 0;
		long expirySeconds = 0;
		long currentTimeSeconds = 0;
		try
		{
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from org.hov.model.Payment where paymentId = :id and paymentStatus = :status");
			query.setParameter("id", paymentId);
			query.setParameter("status", "INITIATED");
			Payment paym = (Payment)query.getResultList().get(0);
	
			expirySeconds = Long.valueOf(String.valueOf(paym.getPaymentExpiry()));				//Expiring Time In Seconds
			currentTimeSeconds = Long.valueOf(String.valueOf(System.currentTimeMillis()/1000));	//Current Time in Seconds
			
			if(paym != null && (expirySeconds - currentTimeSeconds) > 0)
			{
				remainingSeconds = expirySeconds - currentTimeSeconds;
			}
			return remainingSeconds;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return 0;
		}
	}
}
