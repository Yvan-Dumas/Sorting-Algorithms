package algorithms;

import utils.ArrayGenerator;

/**
 * Insertion sort implementation.
 * Complexity : O(n²)
 *
 * @author Yvan Dumas
 */
public class InsertionSort {

	/**
	 * Sorts an array using the insertion sort algorithm.
	 * @param array The array to sort.
	 */
	public static void sort(int[] array) {
		for (int i=1; i<array.length; i++) {
			int temp = array[i];
			int j = i-1;

			// Move elements higher than our temp one position ahead
			while (j >= 0 && array[j] > temp) {
				array[j+1] = array[j];
				j = j-1;
			}
			array[j+1] = temp;
		}
	}

	/**
	 * Main method for testing.
	 */
	static void main() {
		int size = 100_000;
		int[] array = ArrayGenerator.generateArray(size);

		System.out.println("Start of insertion sort on " + size + " elements...");
		long start = System.nanoTime();
		sort(array);
		long end = System.nanoTime();
		System.out.println("End insertion sort.");

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
