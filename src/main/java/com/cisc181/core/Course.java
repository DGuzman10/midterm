package com.cisc181.core;

import java.util.UUID;

public class Course {
	
	private UUID CourseID;
	private String CourseName;
	private int GradePoints;
	private String Major;
	public UUID getCourseID() {
		return CourseID;
	}
	public Course (UUID CourseID, String CourseName, int GradePoints) {
		super();
		this.CourseID = CourseID;
		this.CourseName = CourseName;
		this.GradePoints = GradePoints;
	}
	public void setCourseID(UUID courseID) {
		CourseID = courseID;
	}
	public String getCourseName() {
		return CourseName;
	}
	public void setCourseName(String courseName) {
		CourseName = courseName;
	}
	public int getGradePoints() {
		return GradePoints;
	}
	public void setGradePoints(int gradePoints) {
		GradePoints = gradePoints;
	}
	public String getMajor() {
		return Major;
	}
	public void setMajor(String major) {
		Major = major;
	}
}