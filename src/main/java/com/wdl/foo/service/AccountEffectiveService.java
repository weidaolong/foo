/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.wdl.foo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.wdl.foo.entity.Team;
import com.wdl.foo.repository.mybatis.TeamDao;

@Component
@Transactional
public class AccountEffectiveService {
	@Autowired
	private TeamDao teamDao;

	/**
	 * 分页
	 * @param id
	 * @return
	 */
	public List<Team> getTeamWithDetail(Long id) {
		PageHelper.startPage(0, 10);
		return teamDao.getWithDetail(id);
	}

}
