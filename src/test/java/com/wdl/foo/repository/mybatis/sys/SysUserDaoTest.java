package com.wdl.foo.repository.mybatis.sys;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.wdl.foo.entity.sys.SysUser;
import com.wdl.foo.repository.mybatis.MybatisContextTestCase;
import com.wdl.foo.service.sys.AccountService;

public class SysUserDaoTest extends MybatisContextTestCase{
	@Autowired
	private AccountService service;
	
	@Test
	public void findByLoginName(){
		SysUser user=service.findByLoginName("zhangsan");
		System.out.println(user.getPassword());
	}
	@Test
	public void registerUser(){
		SysUser user=new SysUser();
		user.setName("zhangsan");
		user.setPlainPassword("zhangsan");
		user.setLoginName("zhangsan");
		user.setRegisterDate(new Date());
		service.registerUser(user);
		
	}
}
