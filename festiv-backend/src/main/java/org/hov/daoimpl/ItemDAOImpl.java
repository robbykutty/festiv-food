package org.hov.daoimpl;

import java.util.List;
import java.util.UUID;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hov.dao.ItemDAO;
import org.hov.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("itemDAO")
@Transactional
public class ItemDAOImpl implements ItemDAO 
{
	@Autowired
	SessionFactory sessionFactory;
	
	public UUID addItem(Item item) 
	{
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try
		{
			tx = session.beginTransaction();
			session.save(item);
			tx.commit();
			return item.getItemId();
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

	public boolean updateItem(Item item) 
	{
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try
		{
			tx = session.beginTransaction();
			session.update(item);
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
	
	public List<Item> getAllItems() 
	{
		try
		{
			Session session = sessionFactory.getCurrentSession();
			return session.createQuery("from org.hov.model.Item").list();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Item> getActiveItems() 
	{
		try
		{
			Session session = sessionFactory.getCurrentSession();
			return session.createQuery("from org.hov.model.Item where blocked = false and expired = false").list();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public List<Item> getItemByTeam(int teamId) 
	{
		try
		{
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from org.hov.model.Item where teamId = :team");
			query.setParameter("team", teamId);
			return query.getResultList();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public Item getItemById(int itemId)
	{
		try
		{
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from org.hov.model.Item where itemId = :id");
			query.setParameter("id", itemId);
			return (Item)query.getResultList().get(0);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public boolean blockItemById(int itemId) 
	{
		Item item = getItemById(itemId);
		item.setBlocked(true);
		if(updateItem(item))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public boolean unblockItemById(int itemId) 
	{
		Item item = getItemById(itemId);
		item.setBlocked(false);
		if(updateItem(item))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public boolean expireItemById(int itemId) 
	{
		Item item = getItemById(itemId);
		item.setExpired(true);
		if(updateItem(item))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
