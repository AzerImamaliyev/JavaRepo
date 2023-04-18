package datastructures;

import java.util.HashSet;

public class Sets {
	/*
	 * LinkedHashSet - in order that they were added 
	 * HashSet - complete random order
	 * TreeSet - alphabetical order*/
	public static void main(String[] args) {
		// 1. Define the collections
		HashSet<String> animals = new HashSet<String>();
		HashSet<String> farmAnimals = new HashSet<String>();

		// 2. Adding elements
		animals.add("dog");
		animals.add("cat");
		animals.add("snake");
		animals.add("cow");
		System.out.println(animals.size() + " --> animals: " + animals); // [horse, cat, snake, cow, dog] not ordered

		// 3. Add some more elements
		animals.add("snake");
		animals.add("goose");
		animals.add("cow");
		System.out.println(animals.size() + " --> animals: " + animals); // [horse, goose, cat, snake, cow, dog] no duplicates

		farmAnimals.add("dog");
		farmAnimals.add("sheep");
		farmAnimals.add("horse");
		System.out.println(animals.size() + " --> farm animals: " + farmAnimals);

		// 4. Intersection
		HashSet<String> intersectionSet = new HashSet<String>(animals); // copy of animals
		intersectionSet.retainAll(farmAnimals);
		System.out.println("intersection of two sets: " + intersectionSet);

		// 5. Union
		HashSet<String> unionSet = new HashSet<String>(animals); // copy of animals
		unionSet.addAll(farmAnimals);
		System.out.println("union of two sets: " + unionSet);
		
		// 5. Union
		HashSet<String> minusSet = new HashSet<String>(animals); // copy of animals
		minusSet.removeAll(farmAnimals);
		System.out.println("minus of two sets: " + minusSet);

	}

}
