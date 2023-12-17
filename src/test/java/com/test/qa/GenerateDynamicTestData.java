package com.test.qa;

import java.util.Date;
import java.util.Random;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class GenerateDynamicTestData {
	public static String generateUniqueEmail() {

		String constantPart = "dheerendra";
		String constantPart1 = "@gmail.com";
		int randomPart = new Random().nextInt(1000); // Change the range as needed
		return constantPart + randomPart + constantPart1;
	}

	public static String generateUniqueUsername() {
		String constantPart = "dheerendra";
		int randomPart = new Random().nextInt(1000); // Change the range as needed
		return constantPart + randomPart;
	}

	public static String generateUniqueMobile() {
		String constantPart = "875017";
		int randomPart = new Random().nextInt(1000); // Change the range as needed
		return constantPart + randomPart;
	}
	
	
	public static String timeStamp() {
		Date date=new Date();
		date.toString().replaceAll(":", "").replace(" ", "");
		SimpleDateFormat dateFormat=new SimpleDateFormat("ddMMyyyyhhmmss");
		String newDate=dateFormat.format(date);
		System.out.println(newDate);
		return newDate;
		
//		y	Year				Year						1996; 96
//		Y	Week year			Year						2009; 09
//		M	Month in year 		(context sensitive)	Month	July; Jul; 07
//		L	Month in year 		(standalone form)	Month	July; Jul; 07
//		a	Am/pm marker		Text						PM
//		
//		K	Hour in am/pm (0-11)	Number	0
//		h	Hour in am/pm (1-12)	Number	12
//		m	Minute in hour			Number	30
//		s	Second in minute		Number	55
//		S	Millisecond				Number	978
	}
	
	public static String dynamicGmail() {
		System.out.println("dheerendra" + System.currentTimeMillis() + "@gmail.com");
		return "dheerendra" + System.currentTimeMillis() + "@gmail.com";
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		generateUniqueEmail();
		dynamicGmail();
	}
	

}
