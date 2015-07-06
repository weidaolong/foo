package com.wdl.foo.modules.shiro.service;

import java.util.Iterator;
import java.util.Map.Entry;

import org.apache.shiro.config.Ini;
import org.apache.shiro.config.Ini.Section;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;

public class ChainFilterBuff implements FactoryBean<Ini.Section> {
	
	private static Logger logger = LoggerFactory
			.getLogger(ChainFilterBuff.class);
	private String filterChainDefinitions;
	@Override
	public Section getObject() throws Exception {
		Ini ini = new Ini();
	    ini.load(filterChainDefinitions);   //先载入XML中定义好的chain
	    Ini.Section section = ini.getSection(Ini.DEFAULT_SECTION_NAME);
	    
	    
//	    section.put("/**", "authc, roles[admin,user], perms[file:edit]");
	    logger.info("资源权限加载完成");
	    Iterator<Entry<String, String>> entries=section.entrySet().iterator();
        while(entries.hasNext()){  
            Entry<String, String> me = entries.next();  
            String key = me.getKey();  
            String value = me.getValue();  
            logger.info(key+"="+value);       
        } 
		return section;
	}

	@Override
	public Class<?> getObjectType() {
		return this.getClass();
	}

	@Override
	public boolean isSingleton() {
		return false;
	}

	public void setFilterChainDefinitions(String filterChainDefinitions) {
		this.filterChainDefinitions = filterChainDefinitions;
	}

	public String getFilterChainDefinitions() {
		return filterChainDefinitions;
	}

}
