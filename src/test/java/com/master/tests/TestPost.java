package com.master.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.helpers.PersonServiceHelper;

public class TestPost {
	PersonServiceHelper personServiceHelper;
	
	@BeforeClass
	public void init() {
		
//when we create an object of personservicehelper, it will set the baseuri 
		personServiceHelper=new PersonServiceHelper();
	}
	
	@Test
	public void createUserTest() {
		String id=personServiceHelper.createAUser().jsonPath().get("id");
		System.out.println(id);
	}
}
