package com.wdl.foo.repository.mybatis.sys;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.wdl.foo.entity.sys.SysUser;
import com.wdl.foo.repository.mybatis.MybatisContextTestCase;
import com.wdl.foo.service.sys.SysUserService;

public class SysUserDaoTest extends MybatisContextTestCase{
	@Autowired
	private SysUserService service;
	
	@Test
	public void findByLoginName(){
		SysUser user=service.findByLoginName("zhangsan");
		System.out.println(user.getPassword());
	}
}
