package utils;

import java.util.Random;

/**
 * Utility class to generate and verify arrays for testing sorting algorithms.
 *
 * @author Yvan Dumas
 */
public class ArrayGenerator {

	/**
	 * Generates an array filled with random integers.
	 *
	 * @param size Number of elements in the array.
	 * @return An array of random integers.
	 */
	public static int[] generateArray(int size) {
		int[] array = new int[size];
		Random random = new Random();

		for (int i = 0; i < size; i++) {
			array[i] = random.nextInt();
		}

		return array;
	}

	/**
	 * Checks if an array is sorted (ascending order).
	 *
	 * @param array The array to check.
	 * @return true if the array is sorted, false otherwise.
	 */
	public static boolean isSorted(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] > array[i + 1]) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Prints the array elements.
	 * @param array The array to print.
	 */
	public static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
			if (i != array.length - 1) {
				System.out.print(", ");
			} else {
				System.out.println();
			}
		}
	}

	/**
	 * Main method for testing.
	 */
	static void main() {
		int[] array = generateArray(10);
		System.out.print("Generated array: ");
		printArray(array);

		System.out.println("Is sorted: " + isSorted(array));
		System.out.println();

		int[] array2 = new int[]{1,2,3};
		System.out.print("Array2: ");
		printArray(array2);
		System.out.println("Is sorted: " + isSorted(array2));
	}
}