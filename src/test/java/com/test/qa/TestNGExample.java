package com.test.qa;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestNGExample {

	@BeforeSuite
	public void beforeSuit() {
		System.out.println("BeforeSuite - run before the suite starts. ");
		//  A suite in TestNG refers to a collection of tests that you want to run together.
		//The annotated method will be run before all tests in this suite have run.
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("BeforeTest - This runs once before any test method in the test suite.");
		// Common setup for the entire test suite
		// The annotated method will be run before any test method belonging to the classes inside the <test> tag is run.
	
	
/*<test name="T1">
  <classes>
    <class name= "TestWebServer" />
  </classes>
</test>
 
<test name="T2">
  <classes>
    <class name= "TestWebServer"/>
  </classes>
</test>
*/


	
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("BeforeMethod - This runs before each test method.");
		// Setup specific to each test method
	}

	@Test
	public void a() {
		System.out.println("Test Method a");
		// Test method 1 logic
	}

	@Test
	public void b() {
		System.out.println("Test Method b");
		// Test method 2 logic
	}

	@Test(priority = -1)     // negative(-) priority  >>Alphabetic>>  Positive(+)priority
	public void priority() {
		System.out.println("Priority -1");
		// Test method 3 logic
	}

    @Test(priority = 1)
    public void priorityA() {
    	System.out.println("Priority 1");
      
    }

    @Test(priority = 2)
    public void priorityB() {
    	System.out.println("Priority 2");
    }

}

