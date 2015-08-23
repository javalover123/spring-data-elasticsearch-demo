package org.letek.estest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Searchable {

	@JsonIgnore
	protected String startDate;

	@JsonIgnore
	protected String endDate;

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

}
