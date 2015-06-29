/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.wdl.foo.moudle.test.greenmail;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.icegreen.greenmail.util.GreenMail;
import com.wdl.foo.SpringContextTestCase;

@ContextConfiguration(locations = { "/greenmail/applicationContext-mail.xml" })
public class MailServerSimulatorTest extends SpringContextTestCase {

	@Autowired
	private GreenMail greenMail;

	@Test
	public void greenMail() {
		assertThat(greenMail.getSmtp().getPort()).isEqualTo(3025);
	}
}
