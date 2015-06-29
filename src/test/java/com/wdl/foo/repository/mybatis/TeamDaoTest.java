/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.wdl.foo.repository.mybatis;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.github.pagehelper.Page;
import com.wdl.foo.SpringContextTestCase;
import com.wdl.foo.entity.Team;
import com.wdl.foo.service.AccountEffectiveService;


/**
 * @TransactionConfiguration(transactionManager="transactionManager",defaultRollback=false)
 * 设置事务默认提交
 * @author wdl
 *
 */



@DirtiesContext
@ContextConfiguration(locations = { "/applicationContext.xml" })
@TransactionConfiguration(transactionManager="transactionManager",defaultRollback=false)
public class TeamDaoTest extends SpringContextTestCase {

	@Autowired
	private AccountEffectiveService teamDao;

	@Test
	public void getTeamWithDetail() throws Exception {
		Page<Team> page=teamDao.get(1L);
		for(Team e:page.getResult()){
			System.out.println(e.getName());
		}
		
	}
	
}
