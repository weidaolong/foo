package com.wdl.foo.repository.mybatis;

import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.wdl.foo.SpringContextTestCase;

@DirtiesContext
@ContextConfiguration(locations = { "/applicationContext.xml" })
@TransactionConfiguration(transactionManager="transactionManager",defaultRollback=false)
public class MybatisContextTestCase extends SpringContextTestCase{

}
