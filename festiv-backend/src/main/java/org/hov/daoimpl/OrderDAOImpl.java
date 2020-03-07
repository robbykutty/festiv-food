package org.hov.daoimpl;

import java.util.List;
import java.util.UUID;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hov.dao.OrderDAO;
import org.hov.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("orderDAO")
@Transactional
public class OrderDAOImpl implements OrderDAO
{
	@Autowired
	SessionFactory sessionFactory;
	public UUID addOrder(Order order) 
	{
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try
		{
			tx = session.beginTransaction();
			session.save(order);
			tx.commit();
			return order.getOrderId();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
			tx.rollback();
			return null;
		}
		finally
		{
			session.close();
		}
	}

	public boolean updateOrder(Order order) 
	{
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try
		{
			tx = session.beginTransaction();
			session.update(order);
			tx.commit();
			return true;
		}
		catch(Exception e) 
		{
			e.printStackTrace();
			tx.rollback();
			return false;
		}
		finally
		{
			session.close();
		}
	}
	
	public List<Order> getAllOrder() 
	{
		try
		{
			Session session = sessionFactory.getCurrentSession();
			return session.createQuery("from org.hov.model.Order").list();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public List<Order> getOrderByUser(UUID userId) 
	{
		try
		{
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from org.hov.model.Order where userId = :id");
			query.setParameter("id", userId);
			return query.getResultList();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public List<Order> getOrderByTeam(UUID teamId) 
	{
		try
		{
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from org.hov.model.Order where userId = :id");
			query.setParameter("id", teamId);
			return query.getResultList();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public Order getOrderById(UUID orderId) 
	{
		try
		{
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from org.hov.model.Order where orderId = :id");
			query.setParameter("id", orderId);
			return (Order)query.getResultList().get(0);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
}
