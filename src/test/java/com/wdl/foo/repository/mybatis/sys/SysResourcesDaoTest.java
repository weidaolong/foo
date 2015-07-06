package com.wdl.foo.repository.mybatis.sys;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.wdl.foo.entity.sys.SysResources;
import com.wdl.foo.repository.mybatis.MybatisContextTestCase;
import com.wdl.foo.service.sys.ResourcesService;

public class SysResourcesDaoTest extends MybatisContextTestCase{
	@Autowired
	private ResourcesService service;
	
	@Test
	public void findByLoginName(){
		List<SysResources> user=service.findAllResources("M","root");
		System.out.println(user.size());
	}
}
