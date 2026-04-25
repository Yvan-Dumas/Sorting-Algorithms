package algorithms;

import utils.ArrayGenerator;

/**
 * Bubble sort implementation.
 * Complexity : O(n²)
 *
 * @author Yvan Dumas
 */
public class BubbleSort {

	/**
	 * Sorts an array using the bubble sort algorithm.
	 * @param array The array to sort.
	 */
	public static void sort(int[] array) {
		int temp;

		for (int i = array.length-1; i> 0; i--) {
			for (int j = 0; j<i; j++) {
				if (array[j] > array[j+1]) {
					// Swap elements
					temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
	}

	/**
	 * Main method for testing.
	 */
	static void main() {
		int size = 100_000;
		int[] array = ArrayGenerator.generateArray(size);

		System.out.println("Start of bubble sort on " + size + " elements...");
		long start = System.nanoTime();
		sort(array);
		long end = System.nanoTime();
		System.out.println("End bubble sort.");

		if (!ArrayGenerator.isSorted(array)) {
			System.err.println("Array is not sorted.");
			return;
		}

		long duration = end - start;
		// Conversion from nanoseconds to milliseconds
		double durationMs = duration / 1_000_000.0;
		System.out.println("Execution time: " + durationMs + "ms.");
	}
}
