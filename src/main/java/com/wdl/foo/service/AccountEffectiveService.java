/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.wdl.foo.service;

import java.util.HashMap;

import org.springframework.stereotype.Component;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wdl.foo.entity.Team;
import com.wdl.foo.repository.mybatis.TeamDao;

@Component
public class AccountEffectiveService extends CrudService<TeamDao, Team> {
	/**
	 * 分页
	 * @param id
	 * @return
	 */
	public Page<Team> get(Long id) {
		PageHelper.startPage(0, 10);
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("id", id);
		return dao.findPage(map);
	}

}
