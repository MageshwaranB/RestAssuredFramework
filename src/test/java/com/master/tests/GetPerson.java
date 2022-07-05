package com.master.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.helpers.PersonServiceHelper;
import com.model.MultiUsers;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class GetPerson {
	
		PersonServiceHelper personServiceHelper;
		
		@BeforeClass
		public void init() {
//when we create an object of personservicehelper, it will set the baseuri 
			personServiceHelper=new PersonServiceHelper();
		}
	
		@Test
		@Owner("Magesh")
		@Severity(SeverityLevel.MINOR)
		@Description("Getting all the users")
		public void getAllUsersTest() {
			MultiUsers userList=personServiceHelper.getAllUsers();
			//For my reference I have used an sysout statement to get all the firstNames from the endpoint
			userList.getData().forEach(a->System.out.println(a.getFirstName()));
			System.out.println(userList.getData().get(0).getFirstName());
			Assert.assertNotNull(userList,"Person list is not empty");
		}
}
