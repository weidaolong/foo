package com.wdl.foo.repository.mybatis.sys;

import java.util.Map;
import com.wdl.foo.repository.mybatis.MyBatisRepository;
@MyBatisRepository
public interface ResourcesDao {
	public Map findAllResources();
}
