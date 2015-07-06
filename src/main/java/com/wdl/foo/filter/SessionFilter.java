package com.wdl.foo.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;

import com.wdl.foo.entity.sys.SysResources;
import com.wdl.foo.modules.SpringContextUtil;
import com.wdl.foo.modules.shiro.service.ShiroDbRealm.ShiroUser;
import com.wdl.foo.service.sys.ResourcesService;


public class SessionFilter extends OncePerRequestFilter {
	private static Logger logger = LoggerFactory.getLogger(SessionFilter.class);

	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		if (subject.isAuthenticated()) {
			@SuppressWarnings("unchecked")
			List<SysResources> categorys =(List<SysResources>) session.getAttribute("categorys");
			if (categorys == null) {
				ShiroUser shiroUser =(ShiroUser) subject.getPrincipal();
				logger.info(shiroUser.getName()+"认证成功，更新session");
				categorys=findAllResources("M");
				session.setAttribute("categorys", categorys);
			}
		}

		filterChain.doFilter(request, response);
	}
	
	
	private List<SysResources> findAllResources(String resourcesType){
		ResourcesService resourcesService = (ResourcesService) SpringContextUtil
				.getBean("resourcesService");
		List<SysResources> list= resourcesService.findAllResources(resourcesType,"root");
		for(SysResources e:list){
			List<SysResources> childResources=resourcesService.findAllResources(resourcesType, e.getId());
			e.setResList(childResources);
		}
		return list;
	}
}
