package org.letek.estest.model;

import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldIndex;
import org.springframework.data.elasticsearch.annotations.FieldType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Document(indexName = "feedback", type = "feedback")
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
	@Field(index = FieldIndex.analyzed, type = FieldType.String)
	private String ip;

	/** 不序列化到_source */
	@JsonIgnore
	private String area;

	@JsonIgnore
	private String isp;

	@Field(type = FieldType.Integer)
	private String plat;

	@Field(type = FieldType.String)
	private String content;

	@Field(type = FieldType.Object)
	private User user;

	public Feedback() {
		super();
	}

	public Feedback(Long id, String time, String uid, String ip, String plat,
			String content, User user) {
		super();
		this.id = id;
		this.time = time;
		this.uid = uid;
		this.ip = ip;
		this.plat = plat;
		this.content = content;
		this.user = user;
	}

	@Override
	public String toString() {
		return "Feedback [id=" + id + ", time=" + time + ", uid=" + uid
				+ ", ip=" + ip + ", area=" + area + ", isp=" + isp + ", plat="
				+ plat + ", content=" + content + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getIsp() {
		return isp;
	}

	public void setIsp(String isp) {
		this.isp = isp;
	}

	public String getPlat() {
		return plat;
	}

	public void setPlat(String plat) {
		this.plat = plat;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
