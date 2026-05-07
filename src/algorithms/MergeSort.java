package algorithms;

import utils.ArrayGenerator;

import java.util.Arrays;

/**
 * Merge sort implementation.
 * Complexity : O(nlog(n))
 *
 * @author Yvan Dumas
 */
public class MergeSort {


	/**
	 * Sorts an array using the merge sort algorithm.
	 *
	 * @param array The array to sort.
	 */
	public static void sort(int[] array) {
		if (array.length < 2) return;

		// Divide the array in two parts
		int midIndex = array.length / 2;
		int[] left = Arrays.copyOfRange(array, 0, midIndex);
		int[] right = Arrays.copyOfRange(array, midIndex, array.length);

		// Sort the two parts recursively
		sort(left);
		sort(right);

		// Merge the two parts
		merge(array, left, right);
	}

	/**
	 * Merges two sorted sub-arrays in one merged array.
	 *
	 * @param array Final destination merged array
	 * @param left  First sub-array to merge
	 * @param right Second sub-array to merge
	 */
	private static void merge(int[] array, int[] left, int[] right) {
		int i = 0; // left part pointer
		int j = 0; // right part pointer
		int k = 0; // main array pointer

		// Compare elements from both arrays and insert them
		while (i < left.length && j < right.length) {
			if (left[i] > right[j]) {
				array[k] = right[j];
				j++;
			} else {
				array[k] = left[i];
				i++;
			}
			k++;
		}

		// Append remaining elements
		while (i < left.length) {
			array[k] = left[i];
			i++;
			k++;
		}

		// Append remaining elements
		while (j < right.length) {
			array[k] = right[j];
			j++;
			k++;
		}
	}

	/**
	 * Main method for testing.
	 */
	static void main() {
		int size = 100_000;
		int[] array = ArrayGenerator.generateArray(size);

		System.out.println("Start of merge sort on " + size + " elements...");
		long start = System.nanoTime();
		sort(array);
		long end = System.nanoTime();
		System.out.println("End merge sort.");

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
