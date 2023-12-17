package com.test.qa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class List_Set_HashMap {

	public static void main(String[] args) {
		HashMap();
	}

	public static void list() {
		ArrayList<String> empName = new ArrayList<String>();
		empName.add("DK");
		empName.add("VK");
		empName.add("DK");
		empName.add("CK");
		empName.add("MK");

		for (String name : empName) {
			System.out.println("EmpName:" + name);
		}
		// assesing by index
		for (int i = 0; i < empName.size(); i++) {
			System.out.println("empName: " + i + ":" + empName.get(i));
		}
	}
	

	public static void set() {
		Set<String> cityName = new HashSet<String>();
		cityName.add("New Delhi");
		cityName.add("New Delhi");
		cityName.add("Bangaluru");
		cityName.add("Chennai");
		cityName.add("Mumbai");
		cityName.add("Chandigarh");

		for (String city : cityName) {
			System.out.println("CityName:" + city);
		}
		// use of iteration to get or Access the value
		Iterator<String> iterator = cityName.iterator();

		while (iterator.hasNext()) {
			String city = iterator.next();
			System.out.println(city);
		}
	}

	
	public static void HashMap() {
		// Key-value
		//  HashMap<K, V> hm = new HashMap<K, V>();
		
		Map<String, Integer> hashMap = new HashMap<String, Integer>();
		hashMap.put("Dheerendra", 32);
		hashMap.put("Vikas", 28);
		hashMap.put("Pranav", 31);
		hashMap.put("Vivek", 12);
		hashMap.put("Jitendra", 37);

		System.out.println("HashMap size : " + hashMap.size());
		// Print all the Value
		System.out.println("Print all the Value in HashMap :"+hashMap);
		System.out.println("Dheerndra (Value) Age is: " + hashMap.get("Dheerendra"));
		System.out.println("HashMap value remove: " + hashMap.remove("jitendra"));
		System.out.println("Check element is present in the HashMap:" + " Key-" + hashMap.containsKey("Vivek")
				+ " :Value-" + hashMap.containsValue(12));
	}

}
