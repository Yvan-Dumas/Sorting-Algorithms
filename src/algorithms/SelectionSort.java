package algorithms;

import utils.ArrayGenerator;

/**
 * Selection sort implementation.
 * Complexity : O(n²)
 *
 * @author Yvan Dumas
 */
public class SelectionSort {

	/**
	 * Sorts an array using the selection sort algorithm.
	 * Searches for the minimum element in the unsorted part and puts it at the beginning.
	 * @param array The array to sort.
	 */
	public static void sort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			int minIndex = i;

			// Look for the minimum element in the unsorted part (i+1)
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[minIndex]) {
					minIndex = j;
				}
			}
			// Swap elements
			int temp = array[i];
			array[i] = array[minIndex];
			array[minIndex] = temp;
		}
	}

	/**
	 * Main method for testing.
	 */
	static void main() {
		int size = 100_000;
		int[] array = ArrayGenerator.generateArray(size);

		System.out.println("Start of selection sort on " + size + " elements...");
		long start = System.nanoTime();
		sort(array);
		long end = System.nanoTime();
		System.out.println("End selection sort.");

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