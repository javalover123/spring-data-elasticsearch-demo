package org.letek.estest.service;

import java.util.List;

import org.letek.estest.model.Feedback;
import org.letek.estest.model.User;
import org.letek.estest.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service("feedbackService")
public class FeedbackService {

	@Autowired
	private FeedbackRepository feedbackRepository;

	public Feedback save(Feedback entity) {
		return feedbackRepository.save(entity);
	}

	public List<Feedback> findByContent(String content, Pageable pageable) {
		return feedbackRepository.findByContent(content, pageable);
	}

	public List<Feedback> findByContentAndIp(String content, String ip) {
		return feedbackRepository.findByContentAndIpLike(content, ip);
	}

	public List<Feedback> findByUser(User user) {
		return feedbackRepository.findByUser(user);
	}

	public List<Feedback> findByUserId(Long userId) {
		return feedbackRepository.findByUserId(userId);
	}

	public Feedback findOne(long id) {
		return feedbackRepository.findOne(id);
	}

	public Iterable<Feedback> findAll(Iterable<Long> ids) {
		return feedbackRepository.findAll(ids);
	}

	public long count() {
		return feedbackRepository.count();
	}

	public void delete(Long id) {
		feedbackRepository.delete(id);
	}

	public void delete(Feedback entity) {
		feedbackRepository.delete(entity);
	}

}
