package com.cisc181.core;

import java.util.Date;
import java.util.UUID;

public class Semester {
	
	private UUID SemesterID;
	private Date StartDate;
	private Date EndDate;
	public UUID getSemesterID() {
		return SemesterID;
	}
	
	public Semester(UUID semesterID, Date startDate, Date endDate) {
		super();
		this.SemesterID = semesterID;
		this.StartDate = startDate;
		this.EndDate = endDate;
	}
	
	public void setSemesterID(UUID semesterID) {
		SemesterID = semesterID;
	}
	public Date getStartDate() {
		return StartDate;
	}
	public void setStartDate(Date startDate) {
		StartDate = startDate;
	}
	public Date getEndDate() {
		return EndDate;
	}
	public void setEndDate(Date endDate) {
		EndDate = endDate;
	}
	
	
}
