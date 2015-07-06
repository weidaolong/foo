package com.wdl.foo.service.sys;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wdl.foo.repository.mybatis.sys.ResourcesDao;

@Service
@Transactional
public class ResourcesService {
	@Autowired
	private ResourcesDao resourcesDao;
	
	public Map findAllResources(){
		return resourcesDao.findAllResources();
	}
}
