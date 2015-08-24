package org.letek.estest.model;

import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

public class User {

	@Field(type = FieldType.Long)
	private Long id;

	@Field(type = FieldType.String)
	private String name;

	public User() {
		super();
	}

	public User(Long id) {
		super();
		this.id = id;
	}

	@Override
	public String toString() {
		return id.toString();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
