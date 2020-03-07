package org.hov.serviceimpl;

import java.util.UUID;

import org.hov.dao.TeamDAO;
import org.hov.model.Team;
import org.hov.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamServiceImpl implements TeamService
{
	@Autowired
	TeamDAO teamDAO;	//TeamDAOImpl Wired
	
	@Override
	public UUID addTeam(Team team) 
	{
		return teamDAO.addTeam(team);
	}

	@Override
	public boolean updateTeam(Team team) 
	{
		return teamDAO.updateTeam(team);
	}

	@Override
	public Team getTeamById(int teamId) 
	{
		return teamDAO.getTeamById(teamId);
	}

	@Override
	public boolean activateTeamById(int teamId) 
	{
		return teamDAO.activateTeamById(teamId);
	}

	@Override
	public boolean deactivateTeamById(int teamId) 
	{
		return teamDAO.deactivateTeamById(teamId);
	}
}
