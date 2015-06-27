/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package org.springside.examples.showcase.repository.mybatis;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.wdl.foo.entity.Team;
import com.wdl.foo.repository.mybatis.TeamDao;

@DirtiesContext
@ActiveProfiles("test")
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class TeamDaoTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private TeamDao teamDao;

	@Test
	public void getTeamWithDetail() throws Exception {
		Team team = teamDao.getWithDetail(1L);
		System.out.println(team.getName());
	}
}
