package com.employeeapi.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeapi.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC_001_GET_Allemployeesdata extends TestBase {
	
	@BeforeClass
	void getAllEmployees() throws InterruptedException {
		logger.info("**********started TC_001_GET_Allemployeedata*************");
		//logger.error("asdguyasd");
		
		RestAssured.baseURI= "http://dummy.restapiexample.com/api/v1";
		httpRequest = RestAssured.given();
		response =httpRequest.request(Method.GET,"/employees");
		Thread.sleep(3);
	}
	@Test
	void checkResponsebody() {
		logger.info("**********Checking response body*************");
		
		String responsebody = response.getBody().asString();
		logger.info("Response body==="+responsebody);
		//System.out.println(responsebody);
		Assert.assertTrue(responsebody!=null);
		
	}
		

@Test
void checkStatuscode() {
	logger.info("**********Checking Statuscode*************");
	
	int statuscode = response.getStatusCode();
	logger.info("StatusCode===>"+statuscode);
	System.out.println(statuscode);
	Assert.assertEquals(statuscode, 200);
	
	
}

@Test
void checkResponseTime() {
	logger.info("**********Checking ResponseTime*************");
	
	long responseTime = response.getTime();
	logger.info("StatusCode===>"+responseTime);
	if(responseTime>2000) 
		logger.warn("responseTime is greater than 2000");
	
	Assert.assertTrue(responseTime<2000);
	
	
}


@Test
void checkStatusLine() {
	logger.info("**********Checking StatusLine*************");
	
	String statusline = response.getStatusLine();
	logger.info("Status Line===>"+statusline);
	System.out.println(statusline);
	Assert.assertEquals(statusline, "HTTP/1.1 200 OK");
	
}	

@Test
void checkContentType() {
	logger.info("**********Checking Content-Type*************");
	
	String contenttype = response.header("Content-Type");
	logger.info("ContentType===>"+contenttype);
	System.out.println(contenttype);
	Assert.assertEquals(contenttype, "ext/html; charset=UTF-8");
	
}		
	
@Test
void checkServerType() {
	logger.info("**********Checking Server-Type*************");
	
	String servertype = response.header("Server");
	logger.info("server-Type===>"+servertype);
	System.out.println(servertype);
	//logger.error("asdguyasd");
	Assert.assertEquals(servertype, "nginx/1.16.0");
	 
	
}	
@Test
void checkContentLength() {
	logger.info("**********Checking ContentLength*************");
	
	String contentLength = response.header("Content-Length");
	logger.info("checkContentLength===>"+contentLength);
	if(Integer.parseInt(contentLength)<100) 
		logger.warn("content length is less than 100");
	
	System.out.println(contentLength);
	Assert.assertTrue(Integer.parseInt(contentLength)>100);
	
}

@AfterClass
 
void tearDown() {
	logger.info("************************Finished TC_001_GET_EmployeeData****************************");
 
}
	

}
