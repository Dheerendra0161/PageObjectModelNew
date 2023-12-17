package com.test.qa;
import org.testng.annotations.Test;
public class DependsOnMethod {

	    @Test
	    public void loginTest() {
	        // Your login test logic goes here
	        System.out.println("Executing loginTest");
	    }

	    
	    @Test(dependsOnMethods = "loginTest")
	    public void homePageTest() {
	        // Your home page test logic goes here
	        System.out.println("Executing homePageTest");
	    }

	    
	    @Test(dependsOnMethods = {"loginTest", "homePageTest"})
	    public void dashboardTest() {
	        // Your dashboard test logic goes here
	        System.out.println("Executing dashboardTest");
	    }
	}

//TestNG will ensure that the methods are executed in the specified 
//order based on their dependencies. If the loginTest method fails, 
//the homePageTest and dashboardTest methods will be skipped.
//Please note that circular dependencies should be avoided, as they
//may lead to unexpected behavior. Additionally, ensure that the names
//specified in dependsOnMethods correspond to the actual method names in your class.
//
//In TestNG, you can use the dependsOnMethods attribute to specify that a particular test method 
//depends on the successful execution of one or more other test methods. This ensures that the 
//dependent methods are executed in a specific order. 
//If any of the methods the current method depends on fails, the dependent method is skipped.
