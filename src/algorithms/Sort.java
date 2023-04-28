package algorithms;

public class Sort {

	public static void bubbleSort(int[] dataset) {
		boolean swapped;
		System.out.println("Original Array");
		printArray(dataset);
		do {
			swapped = false;
			for (int i = 0; i < dataset.length - 1; i++) {
				if (dataset[i] > dataset[i + 1]) {
					int temp = dataset[i];
					dataset[i] = dataset[i + 1];
					dataset[i + 1] = temp;
					System.out.print("SWAP ");
					printArray(dataset);
					swapped = true;
				}
			}
		} while (swapped);
	}

	private static void printArray(int[] arr) {
		for (int elem : arr) {
			System.out.print(elem + " ");
		}
		System.out.println();
	}

}