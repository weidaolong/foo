package com.wdl.foo.modules.redis;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import net.sourceforge.groboutils.junit.v1.MultiThreadedTestRunner;
import net.sourceforge.groboutils.junit.v1.TestRunnable;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

public class RedisKeyTest extends RedisTestCase {

	@Test
	public void testKey() {
		Jedis jedis = getJedis();
		String key = "name";
		String value = "魏道龙";
		jedis.set(key, value);
		assertThat(jedis.get(key)).isEqualTo(value);
		returnResource(jedis, false);
	}

	@Test
	public void test2Trans() {
		Jedis jedis = getJedis();
		long start = System.currentTimeMillis();
		Transaction tx = jedis.multi();
		for (int i = 1000000; i < 2000000; i++) {
			tx.set("t" + i, "t" + i);
		}
		List<Object> results = tx.exec();
		long end = System.currentTimeMillis();
		System.out.println("Transaction SET: " + ((end - start) / 1000.0)
				+ " seconds");
		returnResource(jedis, false);
	}

	@Test
	public void testGetTrans() {
		System.out.print(Thread.currentThread().getName());
		Jedis jedis = getJedis();
		long start = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			System.out.println(jedis.get("t" + i));
		}
		long end = System.currentTimeMillis();
		System.out.println("Transaction SET: " + ((end - start) / 1000.0)
				+ " seconds");
		returnResource(jedis, false);
	}

	@Test
	public void testThreadInsert() throws Throwable {
		TestRunnable[] tcs = new TestRunnable[5] ;
		for (int i = 0; i < 5; i++) {
			TestRunnable r = new TestRunnable() {

				@Override
				public void runTest() throws Throwable {
					String threadName=Thread.currentThread().getName();
					Jedis jedis = getJedis();
					long start = System.currentTimeMillis();
					Transaction tx = jedis.multi();
					for (int j = 0; j < 100; j++) {
						tx.set("t "+ threadName+ "="+j, "t" + j);
					}
					List<Object> results = tx.exec();
					long end = System.currentTimeMillis();
					System.out.println("Transaction SET: "
							+ ((end - start) / 1000.0) + " seconds");
					returnResource(jedis, false);
				}

			};

			tcs[i] = r;

		}
		MultiThreadedTestRunner mttr = new MultiThreadedTestRunner(tcs);
		mttr.runTestRunnables(20 * 60 * 1000);
	}
	
	@Test
	public void testThreadDel() throws Throwable {
		TestRunnable[] tcs = new TestRunnable[5] ;
		for (int i = 0; i < 5; i++) {
			TestRunnable r = new TestRunnable() {

				@Override
				public void runTest() throws Throwable {
					String threadName=Thread.currentThread().getName();
					Jedis jedis = getJedis();
					long start = System.currentTimeMillis();
					Transaction tx = jedis.multi();
					for (int j = 1; j < 100; j++) {
						tx.del("t "+ threadName+ j);
					}
					List<Object> results = tx.exec();
					long end = System.currentTimeMillis();
					System.out.println("Transaction SET: "
							+ ((end - start) / 1000.0) + " seconds");
					returnResource(jedis, false);
				}

			};

			tcs[i] = r;

		}
		MultiThreadedTestRunner mttr = new MultiThreadedTestRunner(tcs);
		mttr.runTestRunnables(20 * 60 * 1000);
	}
}
