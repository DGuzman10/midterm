package com.cisc181.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import com.cisc181.core.Staff;
import com.cisc181.eNums.eTitle;

import com.cisc181.Exception.PersonException;

public class Staff_Test {

	@BeforeClass
	public static void setup() {
	}
	
	@Test
	public void test() {
		
		Staff PapaHuevo = new Staff(eTitle.MR, 30000.00);
		Staff Godly = new Staff(eTitle.MR, 100000.00);
		Staff Kira = new Staff(eTitle.MR, 125000.00);
		Staff Choriza = new Staff(eTitle.MRS, 40000.00);
		Staff Dientuda = new Staff(eTitle.MS, 20000.00);
		
		ArrayList<Staff> staff = new ArrayList<Staff>();
		staff.add(PapaHuevo);
		staff.add(Godly);
		staff.add(Kira);
		staff.add(Choriza);
		staff.add(Dientuda);
		
		double TotalSalary = 0;
		double ExpectedAvg= (30000+100000+125000+40000+20000) / 5;
		double AvgSalary;
		for (Staff x : staff)  {
			TotalSalary += x.getSalary();
		}
		AvgSalary = TotalSalary / staff.size();
		
		assertEquals(ExpectedAvg, AvgSalary, 0.01);
	}
	
	
	@Test (expected = PersonException.class)
	public void PersonExceptionTest1() throws PersonException {
		Staff Kunkka = new Staff (eTitle.MR, "1(302)9813349");
	}
		
	@Test (expected = PersonException.class)
	public void PersonExceptionTest2() throws PersonException {
		Staff Tom = new Staff(eTitle.MR);
		Tom.setDOB(new Date(12,2,3));
		
		
		
		
		
		
		assertEquals(1,1);
	}	

}
