package com.test.qa;

public class FinalKeyword1 extends FinalKeyword { //final class can't be inherited or extended
	//public void method() 
	public void method(int age) {
		
		System.out.println(); //Compile time error ,can't override the final method
	}

}
 