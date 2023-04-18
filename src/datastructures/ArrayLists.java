package datastructures;

import java.util.ArrayList;

public class ArrayLists {

	public static void main(String[] args) {

		// 1. create a collection
		ArrayList<String> cities = new ArrayList<String>();

		// 2. Adding some elements
		// cities.add("Baku");
		// cities.add("Ganja");
		
		cities.add(0, "Baku");
		cities.add(1, "Ganja");
		cities.add(2, "Sumgayit");
		cities.add(3, "Zangilan");

		// 3. Iterate the collection
		for (String city : cities) {
			System.out.println(city);
		}

		int size = cities.size();
		System.out.println("There are " + size + " element(s) in the collection");
		
		System.out.println("Second element is: " + cities.get(1));
		
		System.out.println("\nAfter deleting one element");

		
		cities.remove(1);
		
		System.out.println("Second element was removed");

		
		for (String city : cities) {
			System.out.println(city);
		}
		
		size = cities.size();
		System.out.println("Now there are " + size + " element(s) in the collection");
		

	}

}
