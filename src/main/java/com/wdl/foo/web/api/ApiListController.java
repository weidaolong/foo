/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.wdl.foo.web.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wdl.foo.entity.Team;
import com.wdl.foo.service.AccountEffectiveService;

@Controller
@RequestMapping(value = "/api")
public class ApiListController {
	@Autowired
	private AccountEffectiveService service; 
	
	@ResponseBody 
	@RequestMapping(method = RequestMethod.GET)
	public List<Team> list() {
		List<Team> team=service.getTeamWithDetail(1L);
		return team;
	}
}
