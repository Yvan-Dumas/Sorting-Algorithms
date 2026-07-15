package algorithms;

import utils.ArrayGenerator;

/**
 * Quick sort implementation.
 * Complexity : O(nlog(n))
 *
 * @author Yvan Dumas
 */
public class QuickSort {

	/**
	 * Sorts an array using the quick sort algorithm.
	 *
	 * @param array The array to sort.
	 */
	public static void sort(int[] array) {
		if (array == null || array.length <= 1) return;
		quickSort(array, 0, array.length - 1);
	}

	// This method handles both the partitioning and the recursion
	private static void quickSort(int[] array, int low, int high) {
		if (low >= high) return;

		int pivot = array[high];
		int i = low - 1;

		for (int j = low; j < high; j++) {
			if (array[j] <= pivot) {
				i++;
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}

		// place the pivot in its final place
		int temp = array[i + 1];
		array[i + 1] = array[high];
		array[high] = temp;
		int pivotIdx = i + 1;

		quickSort(array, low, pivotIdx - 1);  // Left part
		quickSort(array, pivotIdx + 1, high); // Right part
	}

	/**
	 * Main method for testing.
	 */
	static void main() {
		int size = 100_000;
		int[] array = ArrayGenerator.generateArray(size);

		System.out.println("Start of quick sort on " + size + " elements...");
		long start = System.nanoTime();
		sort(array);
		long end = System.nanoTime();
		System.out.println("End quick sort.");

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