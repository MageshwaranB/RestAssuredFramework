package com.master.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.helpers.PersonServiceHelper;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class TestPost {
	PersonServiceHelper personServiceHelper;
	
	@BeforeClass
	public void init() {
		
//when we create an object of personservicehelper, it will set the baseuri 
		personServiceHelper=new PersonServiceHelper();
	}
	
	@Test
	@Owner("Mageshwaran")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test to check the creation of an user")
	public void createUserTest() {
		String id=personServiceHelper.createAUser().jsonPath().get("id");
		System.out.println(id);
	}
}
