package org.hov.daoimpl;

import java.util.List;
import java.util.UUID;

import javax.persistence.Query;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hov.dao.UserDAO;
import org.hov.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO
{
	@Autowired
	SessionFactory sessionFactory;
	
	public boolean addUser(User user) 
	{	
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try
		{
			tx=session.beginTransaction();
			session.save(user);
			tx.commit();
			return true;
		}
		catch (Exception e) 
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

	public boolean updateUser(User user) 
	{
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try
		{
			tx = session.beginTransaction();
			session.update(user);
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
	
	public List<User> getAllUsers() 
	{
		try
		{
			Session session = sessionFactory.getCurrentSession();
			return session.createQuery("from org.hov.model.User").list();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
			
		}
	}

	public User getUserById(UUID userId) 
	{
		try
		{
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from org.hov.model.User where userId = :id");
			query.setParameter("id", userId);
			return (User)query.getResultList().get(0);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public User getUserByEmail(String userEmail) 
	{
		try
		{
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from org.hov.model.User where userEmail = :email");
			query.setParameter("email", userEmail);
			query.setMaxResults(1);
			return (User)query.getResultList().get(0);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public boolean blockUserById(UUID userId) 
	{
		try
		{
			User user = getUserById(userId);
			user.setBlocked(true);
			if(updateUser(user))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	public boolean unblockUserById(UUID userId) 
	{
		try
		{
			User user = getUserById(userId);
			user.setBlocked(false);
			if(updateUser(user))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	public boolean suspendUserById(UUID userId) 
	{
		try
		{
			User user = getUserById(userId);
			user.setSuspended(true);
			if(updateUser(user))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
}
