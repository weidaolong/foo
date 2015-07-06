package com.wdl.foo.repository.mybatis.sys;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wdl.foo.entity.sys.SysResources;
import com.wdl.foo.repository.mybatis.MyBatisRepository;
@MyBatisRepository
public interface ResourcesDao {
	public List<SysResources> findAllResources(@Param("resourcesType") String resourcesType,@Param("parentId") String parentId);
}
