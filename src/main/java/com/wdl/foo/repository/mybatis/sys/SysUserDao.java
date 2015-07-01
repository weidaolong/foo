package com.wdl.foo.repository.mybatis.sys;

import com.wdl.foo.entity.sys.SysUser;
import com.wdl.foo.repository.mybatis.MyBatisRepository;
@MyBatisRepository
public interface SysUserDao{
	public SysUser findByLoginName(String loginName);
	
	public void insert(SysUser sysUser);
}
