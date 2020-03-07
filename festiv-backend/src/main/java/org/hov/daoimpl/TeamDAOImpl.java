package org.hov.daoimpl;

import java.util.UUID;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hov.dao.TeamDAO;
import org.hov.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("teamDAO")
@Transactional
public class TeamDAOImpl implements TeamDAO
{
	@Autowired
	SessionFactory sessionFactory;
	
	public UUID addTeam(Team team) 
	{
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try
		{
			tx = session.beginTransaction();
			session.save(team);
			tx.commit();
			return team.getTeamId();
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
	
	public boolean updateTeam(Team team) 
	{
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try
		{
			tx = session.beginTransaction();
			session.update(team);
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
	
	public Team getTeamById(int teamId) 
	{
		try
		{
			Session session = sessionFactory.openSession();
			Query query = session.createQuery("from org.hov.model.Team where teamId = :id");
			query.setParameter("id", teamId);
			return (Team)query.getResultList().get(0);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public boolean activateTeamById(int teamId) 
	{
		try
		{
			Team team = getTeamById(teamId);
			team.setActive(true);
			return updateTeam(team);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean deactivateTeamById(int teamId) 
	{
		try
		{
			Team team = getTeamById(teamId);
			team.setActive(false);
			return updateTeam(team);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
}
