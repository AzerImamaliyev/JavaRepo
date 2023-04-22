package algorithms;

public class Search {

	public static int linearSearchFunc(int[] dataSet, int target) {
		for (int i = 0; i < dataSet.length; i++) {
			if (dataSet[i] == target) {
				return i;
			}
		}
		return -1;
	}

	public static int BinarySearchFunc(int[] dataSet, int target, int start, int end) {
		System.out.println("Searching between " + dataSet[start] + " and " + dataSet[end]);
		int midpoint = (int) Math.floor((start + end) / 2);
		int value = dataSet[midpoint];

		// System.out.println("Midpoint is: " + midpoint);

		if (target > value) {
			System.out.println(target + " > " + value);
			return BinarySearchFunc(dataSet, target, midpoint + 1, end);
		} else if (target < value) {
			System.out.println(target + " < " + value);
			return BinarySearchFunc(dataSet, target, start, midpoint - 1);

		}
		System.out.println(target + " = " + value);
		return midpoint;
	}
}
