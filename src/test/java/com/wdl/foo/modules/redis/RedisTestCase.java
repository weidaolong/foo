package com.wdl.foo.modules.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.exceptions.JedisConnectionException;

import com.wdl.foo.SpringContextTestCase;

@DirtiesContext
@ContextConfiguration(locations = { "/applicationContext.xml", "/redis/applicationContext-redis.xml" })
public class RedisTestCase extends SpringContextTestCase{
	@Autowired
	protected JedisPool jedisPool;
	
    public Jedis getJedis() {
        Jedis jedis = null;
        try {
            jedis = getJedisPool().getResource();
        } catch (Exception e) {
            throw new JedisConnectionException(e);
        }
        return jedis;
    }
    public void returnResource(Jedis jedis, boolean isBroken) {
        if (jedis == null)
            return;
        if (isBroken)
            getJedisPool().returnBrokenResource(jedis);
        else
            getJedisPool().returnResource(jedis);
    }
    
    public JedisPool getJedisPool() {
        return jedisPool;
    }

    public void setJedisPool(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }
}
