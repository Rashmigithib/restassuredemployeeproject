package com.employeeapi.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeapi.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_002_GET_SingleEmployeeDetails extends TestBase {
	
	
	RequestSpecification httpRequest;
	Response response;
	
	@BeforeClass
	void getAllEmployees() throws InterruptedException {
		logger.info("**********started TC_002_GET_SingleemployeeDetails*************");
		//logger.error("asdguyasd");
		
		RestAssured.baseURI= "http://dummy.restapiexample.com/api/v1";
		RestAssured.baseURI= "http://dummy.restapiexample.com/api/v1/employee/690";
		httpRequest = RestAssured.given();
		response =httpRequest.request(Method.GET,"/employee/"+empID);
		Thread.sleep(3);
	}
	
	@Test
	void checkResponsebody() {
		logger.info("**********Checking response body*************");
		
		String responsebody = response.getBody().asString();
		//logger.info("Response body==="+responsebody);
		System.out.println(responsebody);
		Assert.assertEquals(responsebody.contains(empID),true);
		
	}
	
	@Test
	void checkStatuscode() {
		logger.info("**********Checking Statuscode*************");
		
		int statuscode = response.getStatusCode();
		logger.info("StatusCode===>"+statuscode);
		System.out.println(statuscode);
		Assert.assertEquals(statuscode, 200);
		
		
	}
	
	@AfterClass
	 
	void tearDown() {
		logger.info("************************Finished TC_001_GET_EmployeeData****************************");
	 
	}

}
