/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.wdl.foo.jms;

import static org.assertj.core.api.Assertions.assertThat;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;

import com.wdl.foo.SpringContextTestCase;
import com.wdl.foo.entity.User;
import com.wdl.foo.jms.advanced.AdvancedNotifyMessageListener;
import com.wdl.foo.jms.advanced.AdvancedNotifyMessageProducer;
import com.wdl.foo.modules.utils.Threads;
import com.wdl.foo.modules.utils.log.LogbackListAppender;

@DirtiesContext
@ContextConfiguration(locations = { "/applicationContext.xml", "/jms/applicationContext-jms-advanced.xml" })
public class JmsAdvancedTest extends SpringContextTestCase {

	@Autowired
	private AdvancedNotifyMessageProducer notifyMessageProducer;

	@Resource
	private JmsTemplate advancedJmsTemplate;

	@Resource
	private Destination advancedNotifyTopic;

	@Test
	public void queueMessage() {
		Threads.sleep(1000);
		LogbackListAppender appender = new LogbackListAppender();
		appender.addToLogger(AdvancedNotifyMessageListener.class);

		User user = new User();
		user.setName("calvin");

		notifyMessageProducer.sendQueue(user);
		Threads.sleep(1000);
		assertThat(appender.getFirstMessage()).isEqualTo(
				"UserName:calvin, ObjectType:user");
	}

	@Test
	public void topicMessage() {
		Threads.sleep(1000);
		LogbackListAppender appender = new LogbackListAppender();
		appender.addToLogger(AdvancedNotifyMessageListener.class);

		User user = new User();
		user.setName("calvin");

		notifyMessageProducer.sendTopic(user);
		Threads.sleep(1000);
		assertThat(appender.getFirstMessage()).isEqualTo(
				"UserName:calvin, ObjectType:user");
	}

	@Test
	public void topicMessageWithWrongType() {
		Threads.sleep(1000);
		LogbackListAppender appender = new LogbackListAppender();
		appender.addToLogger(AdvancedNotifyMessageListener.class);

		advancedJmsTemplate.send(advancedNotifyTopic, new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {

				MapMessage message = session.createMapMessage();
				message.setStringProperty("objectType", "role");
				return message;
			}
		});

		Threads.sleep(1000);
		assertThat(appender.isEmpty()).isTrue();
	}
}
