package com.employeeapi.utilities;



import org.apache.commons.lang3.RandomStringUtils;

public class RestUtilies {
	
	public static String empName() {
		
		String generatedString=  RandomStringUtils.randomAlphabetic(1);
		return("jhon"+generatedString);
	}

public static String empSal() {
		
		String generatedString = RandomStringUtils.randomNumeric(10);
		System.out.println("genrate salary==>"+generatedString);
		return(generatedString);
}
		

public static String empAge() {
	
	String generatedString=  RandomStringUtils.randomNumeric(2);
	return(generatedString);
}

}
