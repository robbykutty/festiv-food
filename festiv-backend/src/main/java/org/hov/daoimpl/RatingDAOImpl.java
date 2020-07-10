package org.hov.daoimpl;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hov.dao.RatingDAO;
import org.hov.model.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("RatingDAO")
@Transactional
public class RatingDAOImpl implements RatingDAO
{
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean addOrUpdateRating(Rating rating) 
	{
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try
		{
			tx = session.beginTransaction();
			session.saveOrUpdate(rating);
			tx.commit();
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		finally
		{
			session.close();
		}
	}
	
	@Override
	public int getAverageRatingForItem(int itemId) 
	{
		try 
		{
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery(
						"select avg(org.hov.model.Rating.ratingValue) " +
						"from org.hov.model.Rating " +
						"where itemId = :itemid");
			query.setParameter("itemid", itemId);
			return (int) query.getResultList().get(0);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public Rating getRatingByItemAndUser(int itemId, int userId) 
	{
		try 
		{
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from org.hov.model.Rating " +
											  "where itemId = :itemid and " +
											  "where userId = :userid ");
			query.setParameter("itemid", itemId);
			query.setParameter("userid", userId);
			return (Rating)query.getResultList().get(0);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
}
