package org.hov.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.hov.config.AppConfig;
import org.hov.daoimpl.TeamDAOImpl;
import org.hov.model.Team;
import org.hov.service.TeamService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringJUnitConfig(classes = AppConfig.class)
public class TeamTestCases 
{
	@Autowired
	TeamService teamService;
	
	@Test
	@Ignore
	public void addTeam()
	{
		Team team = new Team();
		
		team.setTeamName("Team Name 1");
		team.setTeamDescription("Team Description 1");
		team.setActive(true);
		
		assertNotEquals(0, teamService.addTeam(team));
	}

	@Test
	@Ignore
	public void updateTeam()
	{
		Team team = teamService.getTeamById(2);
		team.setTeamDescription("Updated Team Description");
		assertEquals(true, teamService.updateTeam(team));
	}

	@Test
	@Ignore
	public void displayTeamById()
	{
		Team tm = teamService.getTeamById(2);
		
		System.out.println("------------------------------------");
		System.out.println("Team Id: " + tm.getTeamId());
		System.out.println("Team Name: " + tm.getTeamName());
		System.out.println("Team Description: " + tm.getTeamDescription());
		System.out.println("Team Active: " + tm.isActive());
	}

	@Test
	@Ignore
	public void activateTeam()
	{
		teamService.activateTeamById(2);
	}

	@Test
	@Ignore
	public void deactivateTeam()
	{
		teamService.deactivateTeamById(2);
	}
}
