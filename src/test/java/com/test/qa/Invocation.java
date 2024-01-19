package com.test.qa;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Invocation {

	// The number of times this method should be invoked.
	@Test(invocationCount = 5)
	public void runTestMultipleTimes() {
		System.out.println("Hello");
		
		//OutPut:
		//Hello
		//Hello
		//Hello
		//Hello
		//Hello
		
	}

	
	
	
	
	// if you need to pass different parameters for each invocation, you can use the
	// dataProvider attribute along with a data provider method.
	@DataProvider(name = "testData")
	public Object[][] testData() {
		
		//return new Object[][] { { "DK", "123" }, { "VK", "132" }, { "SK", "321" } };
		
		Object[][] data= {{"Dheerendra",123,"Graduate"},{"Vikas",321,"PG"},{"Vivek",213,"Diploma"}};
		return data;
				
	}

	@Test(dataProvider = "testData")
	public void runTestData(String name,String degree,int value) {
		System.out.println("Employee Name:"+name+","+" Employee value:"+value+","+"Degree of employee"+degree);
		
		
		//OutPut:
		//Employee Name:Dheerendra, Employee value:123
		//Employee Name:Vikas, Employee value:321
		//Employee Name:Vivek, Employee value:213

	}

}