package org.letek.estest.service;

import org.junit.Test;
import org.letek.estest.BaseTest;
import org.letek.estest.model.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

public class FeedbackServiceTest extends BaseTest {

	@Autowired
	private FeedbackService feedbackService;

	// @Test
	public void save() {
		Feedback entity = new Feedback(1L, "2015-08-22 20:21:22", "11",
				"192.168.0.1", "3", "测试一个feedback");
		feedbackService.save(entity);
	}

	@Test
	public void findByContentAndIp() {
		System.out.println(feedbackService.findByContent("feedback",
				new PageRequest(0, 2)));
		System.out.println("===============");
		System.out.println(feedbackService.findByContentAndIp("测试一个",
				"192.168.0.1"));
		System.out.println(feedbackService.findByContentAndIp("feed",
				"192.168.0.1"));
		System.out.println(feedbackService.findByContentAndIp("feedback",
				"192.168.0.1"));
		System.out.println(feedbackService.findByContentAndIp("测试一个",
				"192.168.0"));
	}

}
