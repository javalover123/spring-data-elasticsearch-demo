package org.letek.estest.repository;

import java.util.List;

import org.letek.estest.model.Feedback;
import org.letek.estest.model.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends ElasticsearchCrudRepository<Feedback, Long> {

	@Query("{\"bool\" : {\"must\" : {\"term\" : {\"content\" : \"?0\"}}}}")
	List<Feedback> findByContent(String content, Pageable pageable);

	List<Feedback> findByContentAndIpLike(String content, String ip);

	List<Feedback> findByUser(User user);

	List<Feedback> findByUserId(Long userId);

}
