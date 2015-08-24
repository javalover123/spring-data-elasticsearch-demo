package org.letek.estest.service;

import org.junit.Test;
import org.letek.estest.BaseTest;
import org.letek.estest.model.Feedback;
import org.letek.estest.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

public class FeedbackServiceTest extends BaseTest {

	@Autowired
	private FeedbackService feedbackService;

	// @Test
	public void save() {
		Feedback entity = new Feedback(1L, "2015-08-22 20:21:22", "11", "192.168.0.1", "3", "测试一个feedback",
				new User(1L));
		feedbackService.save(entity);
	}

	@Test
	public void findByContentAndIp() {
		logger.info(feedbackService.findByUserId(1L));
		logger.info(feedbackService.findByUserId(2L));
		logger.info("===============");
		logger.info(feedbackService.findByUser(new User(1L)));
		logger.info(feedbackService.findByUser(new User(2L)));
		logger.info("===============");
		logger.info(feedbackService.findByContent("feedback", new PageRequest(0, 2)));
		logger.info("===============");
		logger.info(feedbackService.findByContentAndIp("测试一个", "192.168.0.1"));
		logger.info(feedbackService.findByContentAndIp("feed", "192.168.0.1"));
		logger.info(feedbackService.findByContentAndIp("feedback", "192.168.0.1"));
		logger.info(feedbackService.findByContentAndIp("测试一个", "192.168.0"));
	}

}
