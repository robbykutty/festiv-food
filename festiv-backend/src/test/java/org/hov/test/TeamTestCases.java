package org.hov.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.UUID;

import org.hov.config.AppConfig;
import org.hov.model.Team;
import org.hov.service.TeamService;
import org.junit.Before;
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
	
	Team targetTeam;
	
	@Before
	public void getTargetTeam()
	{
		targetTeam = teamService.getTeamById(UUID.fromString("822987d6-9c2c-4856-9686-d963cdec76e1"));
	}
	
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
		targetTeam.setTeamDescription("Updated Team Description");
		assertEquals(true, teamService.updateTeam(targetTeam));
	}

	@Test
	@Ignore
	public void displayTeamById()
	{
		Team tm = targetTeam;
		
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
		teamService.activateTeamById(targetTeam.getTeamId());
	}

	@Test
	@Ignore
	public void deactivateTeam()
	{
		teamService.deactivateTeamById(targetTeam.getTeamId());
	}
}
