# The betest demo for spring-data-elasticsearch, it shows save, find by page, find by tow parameters using like and @Query.

import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends
		ElasticsearchCrudRepository<Feedback, Long> {

	@Query("{\"bool\" : {\"must\" : {\"term\" : {\"content\" : \"?0\"}}}}")
	List<Feedback> findByContent(String content, Pageable pageable);

	List<Feedback> findByContentAndIpLike(String content, String ip);

}

# And custom date fomat, ip seaching, and ignore fields save to _source.
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldIndex;
import org.springframework.data.elasticsearch.annotations.FieldType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Document(indexName = "feedback1", type = "feedback")
public class Feedback extends Searchable {

	@Field(type = FieldType.Long)
	private Long id;

	@Field(
			type = FieldType.Date, 
			format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss"
	)
	private String time;

	@Field(type = FieldType.Long)
	private String uid;

	/** 没有使用FieldType.ip，是因为这种类型不能模糊搜索 */
	/** Not using FieldType.ip，because this type can't support fuzzy search. */
	@Field(index = FieldIndex.analyzed, type = FieldType.String)
	private String ip;

	/** 不序列化到_source */
	/** Ignore this field when save to _source */
	@JsonIgnore
	private String area;
}
