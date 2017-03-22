package com.cisc181.Exception;

import com.cisc181.core.Person;
public class PersonException extends Exception {
	private Person a;
	
	public PersonException(Person p) {
		this.a = a;
	}
	
	public Person getp() {
		return a;
	}
}

