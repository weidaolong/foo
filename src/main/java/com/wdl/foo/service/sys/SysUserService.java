package com.wdl.foo.service.sys;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wdl.foo.entity.sys.SysUser;
import com.wdl.foo.modules.security.utils.Digests;
import com.wdl.foo.modules.utils.Encodes;
import com.wdl.foo.repository.mybatis.sys.SysUserDao;

@Component
public class SysUserService{
	
	@Autowired
	private SysUserDao dao;
	public static final String HASH_ALGORITHM = "SHA-1";
	public static final int HASH_INTERATIONS = 1024;
	private static final int SALT_SIZE = 8;
	
	public SysUser findByLoginName(String loginName){
		return dao.findByLoginName(loginName);
	}
	
	
	/**
	 * 设定安全的密码，生成随机的salt并经过1024次 sha-1 hash
	 */
	private void entryptPassword(SysUser user) {
		byte[] salt = Digests.generateSalt(SALT_SIZE);
		user.setSalt(Encodes.encodeHex(salt));

		byte[] hashPassword = Digests.sha1(user.getPlainPassword().getBytes(), salt, HASH_INTERATIONS);
		user.setPassword(Encodes.encodeHex(hashPassword));
	}
	
	public void updateUser(SysUser user) {
		if (StringUtils.isNotBlank(user.getPlainPassword())) {
			entryptPassword(user);
		}
	}
}
