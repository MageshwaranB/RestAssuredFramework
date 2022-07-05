package com.master.tests;

import java.util.List;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.helpers.PersonServiceHelper;
import com.model.MultiUsers;

public class GetPerson {
	
		PersonServiceHelper personServiceHelper;
		
		@BeforeMethod
		public void init() {
//when we create an object of personservicehelper, it will set the baseuri 
			personServiceHelper=new PersonServiceHelper();
		}
	
		@Test
		public void getAllUsersTest() {
			MultiUsers userList=personServiceHelper.getAllUsers();
			//For my reference I have used an sysout statement to get all the firstNames from the endpoint
			userList.getData().forEach(a->System.out.println(a.getFirstName()));
			System.out.println(userList.getData().get(0).getFirstName());
			Assert.assertNotNull(userList,"Person list is not empty");
		}
}
