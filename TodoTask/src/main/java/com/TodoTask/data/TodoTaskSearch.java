package com.TodoTask.data;
import java.sql.Timestamp;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;
@Component
public class TodoTaskSearch {
	@JsonFormat(pattern="yyyy-MM-dd'T' HH:mm:ss.SSSX", shape = JsonFormat.Shape.STRING)
	private Timestamp fromDate;
	@JsonFormat(pattern="yyyy-MM-dd'T' HH:mm:ss.SSSX", shape = JsonFormat.Shape.STRING)
	private Timestamp toDate;

	public TodoTaskSearch() {}

	public TodoTaskSearch(Timestamp fromDate, Timestamp toDate) {
		super();
		this.fromDate = fromDate;
		this.toDate = toDate;
	}

	public Timestamp getFromDate() {
		return fromDate;
	}

	public void setFromDate(Timestamp fromDate) {
		this.fromDate = fromDate;
	}

	public Timestamp getToDate() {
		return toDate;
	}

	public void setToDate(Timestamp toDate) {
		this.toDate = toDate;
	}

	@Override
	public String toString() {
		return "TaskSearch [fromDate=" + fromDate + ", toDate=" + toDate + "]";
	}
	

}
