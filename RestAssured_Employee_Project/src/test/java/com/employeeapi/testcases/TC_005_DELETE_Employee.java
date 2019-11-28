package com.employeeapi.testcases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeapi.base.TestBase;
import com.employeeapi.utilities.RestUtilies;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_005_DELETE_Employee extends TestBase{
	

	RequestSpecification httpRequest;
	Response response;

		@BeforeClass
	    void deleteEmployee() throws InterruptedException {
		logger.info("**********started TC_003_DELETE_employee*************");
		// logger.error("asdguyasd");

		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		httpRequest = RestAssured.given();
		response = httpRequest.request(Method.GET,"/employees");
		
		JsonPath jsonpathEvaluator = response.jsonPath();

		String empID = jsonpathEvaluator.get("[0].id");
		
		response = httpRequest.request(Method.DELETE, "/delete/"+empID);
		Thread.sleep(3000);
	}

	@Test
	void checkResponsebody() {
		logger.info("**********Checking response body*************");

		String responsebody = response.getBody().asString();
		// logger.info("Response body==="+responsebody);
		 System.out.println(responsebody);
		Assert.assertEquals(responsebody.contains("successfully! deleted Records"), true);
		
	}
	
	@Test
	void checkStatuscode() {
		logger.info("**********Checking Statuscode*************");

		int statuscode = response.getStatusCode();
		logger.info("StatusCode===>" + statuscode);
		System.out.println(statuscode);
		Assert.assertEquals(statuscode, 200);

	}

	
	  @Test void checkResponseTime() {
	  logger.info("**********Checking ResponseTime*************");
	  
	  long responseTime = response.getTime();
	  logger.info("StatusCode===>"+responseTime); if(responseTime>2000)
	  logger.warn("responseTime is greater than 2000");
	  
	  Assert.assertTrue(responseTime<2000);
	  
	  
	  }
	 

	@Test
	void checkStatusLine() {
		logger.info("**********Checking StatusLine*************");

		String statusline = response.getStatusLine();
		logger.info("Status Line===>" + statusline);
		System.out.println(statusline);
		Assert.assertEquals(statusline, "HTTP/1.1 200 OK");

	}

	@Test
	void checkContentType() {
		logger.info("**********Checking Content-Type*************");

		String contenttype = response.header("Content-Type");
		logger.info("ContentType===>" + contenttype);
		System.out.println(contenttype);
		Assert.assertEquals(contenttype, "text/html; charset=UTF-8");

	}

	@Test
	void checkServerType() {
		logger.info("**********Checking Server-Type*************");

		String servertype = response.header("Server");
		logger.info("server-Type===>" + servertype);
		System.out.println(servertype);
		// logger.error("asdguyasd");
		Assert.assertEquals(servertype, "nginx/1.16.0");

	}

	@AfterClass

	void tearDown() {
		logger.info("************************Finished TC_006_DELETE_EmployeeData****************************");

	}

}
