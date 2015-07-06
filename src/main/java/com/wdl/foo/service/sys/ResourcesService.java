package com.wdl.foo.service.sys;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wdl.foo.entity.sys.SysResources;
import com.wdl.foo.repository.mybatis.sys.ResourcesDao;

@Service
@Transactional
public class ResourcesService {
	@Autowired
	private ResourcesDao resourcesDao;
	
	public List<SysResources> findAllResources(String resourcesType,String parentId){
		return resourcesDao.findAllResources(resourcesType, parentId);
	}
}
