package algorithms;

public class Demo {

	public static void main(String[] args) {

		// Linear Search
		System.out.println("Linear Search");
		int[] numbers = { 10, 7, 433, 95, 73, 132, 5 };

		int pos = algorithms.Search.linearSearchFunc(numbers, 66);

		if (pos != -1) {
			System.out.println("Found at position: " + pos);

		} else {
			System.out.println("Array element doesn't exist");

		}

		/***********************************************************************************************************/

		// Binary Search
		System.out.println("\nBinary Search");
		int[] sortedNumbers = { 7, 15, 23, 28, 35, 37, 45, 49, 58, 65, 69, 77, 78, 82, 87, 89, 91, 92, 96, 97, 99 };

		int index = algorithms.Search.BinarySearchFunc(sortedNumbers, 37, 0, sortedNumbers.length - 1);
		System.out.println("Found at position: " + index);

		// Bubble sort
		System.out.println("\nBubble Sort");
		Sort.bubbleSort(numbers);

	}

}
