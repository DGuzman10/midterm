package com.cisc181.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.Exception.PersonException;
import com.cisc181.eNums.eMajor;

public class Student_Test {
	static ArrayList<Course> courses = new ArrayList<Course>();
	static ArrayList<Semester> semesters = new ArrayList<Semester>();
	static ArrayList<Section> sections = new ArrayList<Section>();
	
	static Course CISC181 = new Course(UUID.randomUUID(), "Intro to Computer Science II", 3);
	static Course MUSC107 = new Course(UUID.randomUUID(), "History of Rock", 3);
	static Course SPAN201 = new Course(UUID.randomUUID(), "Spanish Compositon & Grammar", 3);
	
	static Semester Fall = new Semester(UUID.randomUUID(), new Date(116, 9, 1), new Date(116, 12, 15));
	static Semester Spring = new Semester(UUID.randomUUID(), new Date(117, 2, 6), new Date(117, 5, 30));
	
	static Section CompSci1 = new Section(CISC181.getCourseID(), Fall.getSemesterID(), UUID.randomUUID(), 117);
	static Section CompSci2 = new Section(CISC181.getCourseID(), Spring.getSemesterID(), UUID.randomUUID(), 205);
	static Section Musc1 = new Section(MUSC107.getCourseID(), Fall.getSemesterID(), UUID.randomUUID(), 323);
	static Section Span1 = new Section(SPAN201.getCourseID(), Spring.getSemesterID(), UUID.randomUUID(), 323);
	

	@BeforeClass
	public static void setup() {
		
		courses.add(CISC181);
		courses.add(MUSC107);
		courses.add(SPAN201);
		
		semesters.add(Fall);
		semesters.add(Spring);
		
		sections.add(CompSci1);
		sections.add(CompSci2);
		sections.add(Musc1);
		sections.add(Span1);
	}

	@Test
	public void TestGPA() throws PersonException {
		Student Bean = new Student(eMajor.BUSINESS);
		Student Ricky = new Student(eMajor.PHYSICS);
		Student Lance = new Student(eMajor.CHEM);
		Student Terry = new Student(eMajor.COMPSI);
		Student Mike = new Student(eMajor.NURSING);
		Student Kate = new Student(eMajor.PHYSICS);
		Student Alondra = new Student(eMajor.COMPSI);
		Student Light = new Student(eMajor.PHYSICS);
		Student Mikasa = new Student(eMajor.BUSINESS);
		Student Levi = new Student(eMajor.NURSING);
		
ArrayList<Student> students = new ArrayList<Student>();
		
		students.add(Bean);
		students.add(Ricky);
		students.add(Lance);
		students.add(Terry);
		students.add(Mike);
		students.add(Kate);
		students.add(Alondra);
		students.add(Light);
		students.add(Mikasa);
		students.add(Levi);
		
		ArrayList<Enrollment> enrollments = new ArrayList<Enrollment>();
		for (Section x : sections) {
			for (Student y : students) {
				enrollments.add(new Enrollment(x.getSectionID(), y.getStudentID()));
			}
		}
		
		for (Enrollment e : enrollments) {
			if(e.getStudentID() == Bean.getStudentID()) {
				e.setGrade(4.0);
			}
			else if (e.getStudentID() == Ricky.getStudentID()) {
				e.setGrade(3.9);
			}
			else if (e.getStudentID() == Lance.getStudentID()) {
				e.setGrade(3.8);
			}
			else if (e.getStudentID() == Terry.getStudentID()) {
				e.setGrade(3.7);
			}
			else if (e.getStudentID() == Mike.getStudentID()) {
				e.setGrade(3.6);
			}
			else if (e.getStudentID() == Kate.getStudentID()) {
				e.setGrade(3.5);
			}
			else if (e.getStudentID() == Alondra.getStudentID()) {
				e.setGrade(3.4);
			}
			else if (e.getStudentID() == Light.getStudentID()) {
				e.setGrade(3.3);
			}
			else if (e.getStudentID() == Mikasa.getStudentID()) {
				e.setGrade(3.2);
			}
			else if (e.getStudentID() == Levi.getStudentID()) {
				e.setGrade(3.1);
			}
		}
		
		int TotalCred = 0;
		for (Section section : sections) {
			if (section.getCourseID() == CISC181.getCourseID()) {
				TotalCred += CISC181.getGradePoints();
			}
			else if (section.getCourseID() == MUSC107.getCourseID()) {
				TotalCred += MUSC107.getGradePoints();
			}
			else {
				TotalCred += SPAN201.getGradePoints();
			}
}
		
		double BeanGPA = 0;
		for (Enrollment e : enrollments) {
			if (e.getStudentID() == Bean.getStudentID()) {
				if (e.getSectionID() == CompSci1.getSectionID() || 
						e.getSectionID() == CompSci2.getSectionID()) {
					BeanGPA += CISC181.getGradePoints()*e.getGrade();
				}
				else if (e.getSectionID() == Musc1.getSectionID()) { 
					BeanGPA += MUSC107.getGradePoints()*e.getGrade();
				}
				else {
					BeanGPA += SPAN201.getGradePoints()*e.getGrade();
				}
			}
		}
		BeanGPA /= TotalCred;
		assertEquals(BeanGPA, 0, 0.1);
		
		double RickyGPA = 0;
		for (Enrollment e : enrollments) {
			if (e.getStudentID() == Ricky.getStudentID()) {
				if (e.getSectionID() == CompSci1.getSectionID() || 
						e.getSectionID() == CompSci2.getSectionID()) {
					RickyGPA += e.getGrade()*CISC181.getGradePoints();
				}
				else if (e.getSectionID() == Musc1.getSectionID()) { 
						
					RickyGPA += e.getGrade()*MUSC107.getGradePoints();
				}
				else {
					RickyGPA += e.getGrade()*SPAN201.getGradePoints();
				}
			}
		}
		RickyGPA /= TotalCred;
		assertEquals(RickyGPA, 0, 0.1);
		
		double LanceGPA = 0;
		for (Enrollment e : enrollments) {
			if (e.getStudentID() == Lance.getStudentID()) {
				if (e.getSectionID() == CompSci1.getSectionID() || 
						e.getSectionID() == CompSci2.getSectionID()) {
					LanceGPA += e.getGrade()*CISC181.getGradePoints();
				}
				else if (e.getSectionID() == Musc1.getSectionID()) {
					LanceGPA += e.getGrade()*MUSC107.getGradePoints();
				}
				else {
					LanceGPA += e.getGrade()*SPAN201.getGradePoints();
				}
			}
		}
		LanceGPA /= TotalCred;
		assertEquals(LanceGPA, 0, 0.1);
		
		double TerryGPA = 0;
		for (Enrollment e : enrollments) {
			if (e.getStudentID() == Terry.getStudentID()) {
				if (e.getSectionID() == CompSci1.getSectionID() || 
						e.getSectionID() == CompSci2.getSectionID()) {
					TerryGPA += e.getGrade()*CISC181.getGradePoints();
				}
				else if (e.getSectionID() == Musc1.getSectionID()) { 
					
					TerryGPA += e.getGrade()*MUSC107.getGradePoints();
				}
				else {
					TerryGPA += e.getGrade()*SPAN201.getGradePoints();
				}
			}
		}
		TerryGPA /= TotalCred;
		assertEquals(TerryGPA, 0, 0.1);
		
		double MikeGPA = 0;
		for (Enrollment e : enrollments) {
			if (e.getStudentID() == Mike.getStudentID()) {
				if (e.getSectionID() == CompSci1.getSectionID() || 
						e.getSectionID() == CompSci2.getSectionID()) {
					MikeGPA += e.getGrade()*CISC181.getGradePoints();
				}
				else if (e.getSectionID() == Musc1.getSectionID()) { 
						
					MikeGPA += e.getGrade()*MUSC107.getGradePoints();
				}
				else {
					MikeGPA += e.getGrade()*SPAN201.getGradePoints();
				}
			}
		}
		MikeGPA /= TotalCred;
		assertEquals(MikeGPA, 0, 0.1);
		
		double KateGPA = 0;
		for (Enrollment e : enrollments) {
			if (e.getStudentID() == Kate.getStudentID()) {
				if (e.getSectionID() == CompSci1.getSectionID() || 
						e.getSectionID() == CompSci2.getSectionID()) {
					KateGPA += e.getGrade()*CISC181.getGradePoints();
				}
				else if (e.getSectionID() == Musc1.getSectionID()) {
					KateGPA += e.getGrade()*MUSC107.getGradePoints();
				}
				else {
					KateGPA += e.getGrade()*SPAN201.getGradePoints();
				}
			}
		}
		KateGPA /= TotalCred;
		assertEquals(KateGPA, 0, 0.1);
		
		double AlondraGPA = 0;
		for (Enrollment e : enrollments) {
			if (e.getStudentID() == Alondra.getStudentID()) {
				if (e.getSectionID() == CompSci1.getSectionID() || 
						e.getSectionID() == CompSci2.getSectionID()) {
					AlondraGPA += e.getGrade()*CISC181.getGradePoints();
				}
				else if (e.getSectionID() == Musc1.getSectionID()) {
					AlondraGPA += e.getGrade()*MUSC107.getGradePoints();
				}
				else {
					AlondraGPA += e.getGrade()*SPAN201.getGradePoints();
				}
			}
		}
		AlondraGPA /= TotalCred;
		assertEquals(KateGPA, 0, 0.1);
		
		double LightGPA = 0;
		for (Enrollment e : enrollments) {
			if (e.getStudentID() == Light.getStudentID()) {
				if (e.getSectionID() == CompSci1.getSectionID() || 
						e.getSectionID() == CompSci2.getSectionID()) {
					LightGPA += e.getGrade()*CISC181.getGradePoints();
				}
				else if (e.getSectionID() == Musc1.getSectionID()) { 
					LightGPA += e.getGrade()*MUSC107.getGradePoints();
				}
				else {
					LightGPA += e.getGrade()*SPAN201.getGradePoints();
				}
			}
		}
		LightGPA /= TotalCred;
		assertEquals(LightGPA, 0, 0.1);
		
		double MikasaGPA = 0;
		for (Enrollment e : enrollments) {
			if (e.getStudentID() == Mikasa.getStudentID()) {
				if (e.getSectionID() == CompSci1.getSectionID() || 
						e.getSectionID() == CompSci2.getSectionID()) {
					MikasaGPA += e.getGrade()*CISC181.getGradePoints();
				}
				else if (e.getSectionID() == Musc1.getSectionID()) {
						
					MikasaGPA += e.getGrade()*MUSC107.getGradePoints();
				}
				else {
					MikasaGPA += e.getGrade()*SPAN201.getGradePoints();
				}
			}
		}
		MikasaGPA /= TotalCred;
		assertEquals(MikasaGPA, 0, 0.1);
		
		double LeviGPA = 0;
		for (Enrollment e : enrollments) {
			if (e.getStudentID() == Levi.getStudentID()) {
				if (e.getSectionID() == CompSci1.getSectionID() || 
						e.getSectionID() == CompSci2.getSectionID()) {
					LeviGPA += e.getGrade()*CISC181.getGradePoints();
				}
				else if (e.getSectionID() == Musc1.getSectionID()) {
						
					LeviGPA += e.getGrade()*MUSC107.getGradePoints();
				}
				else {
					LeviGPA += e.getGrade()*SPAN201.getGradePoints();
				}
			}
		}
		LeviGPA /= TotalCred;
		assertEquals(LeviGPA, 0, 0.1);
		
		
		double CISCAvg = 0; 
		double MUSCAvg = 0;
		double SPANAvg = 0;
		for(Enrollment e : enrollments){
			if(e.getSectionID() == CompSci1.getSectionID() || 
					e.getSectionID() == CompSci2.getSectionID()){
				CISCAvg += e.getGrade();
			}
			else if(e.getSectionID() == Musc1.getSectionID()) {
				MUSCAvg += e.getGrade();
			}
			else{
				SPANAvg += e.getGrade();
			}
		}
	
	CISCAvg /= (enrollments.size()/3);
	MUSCAvg /= (enrollments.size()/3);
	SPANAvg /= (enrollments.size()/3);
	
	assertEquals(CISCAvg, 0, 0.01);
	assertEquals(MUSCAvg, 0, 0.01);
	assertEquals(SPANAvg, 0,0.01);
	
	Student John = new Student(eMajor.CHEM);
	assertTrue(John.geteMajor() == eMajor.CHEM);
John.setMajor(eMajor.BUSINESS);

	}
}
		