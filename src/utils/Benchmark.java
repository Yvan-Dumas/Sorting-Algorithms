package utils;

import algorithms.*;

/**
 * Utility class to test sorting algorithms execution time.
 *
 * @author Yvan Dumas
 */
public class Benchmark {

	static void main() {
		int size = 100_000;
		int numberOfIterations = 5;

		// Initialization of the variables to accumulate sorting times
		double totalBubbleSort = 0;
		double totalInsertionSort = 0;
		double totalMergeSort = 0;
		double totalQuickSort = 0;
		double totalSelectionSort = 0;

		System.out.println("Benchmark Start...");

		for (int iteration = 1; iteration <= numberOfIterations; iteration++) {
			System.out.println("Start iteration number " + iteration);
			int[] originalArray = ArrayGenerator.generateArray(size);

			// Bubble Sort
			System.out.println("Start bubble sort...");
			int[] bubbleSortArray = originalArray.clone();
			long start = System.nanoTime();
			BubbleSort.sort(bubbleSortArray);
			long end = System.nanoTime();
			if (!ArrayGenerator.isSorted(bubbleSortArray)) throw new RuntimeException("Sorted array is not sorted!");
			totalBubbleSort += (end - start);
			System.out.println("End bubble sort");

			// Insertion Sort
			System.out.println("Start insertion sort...");
			int[] insertionSortArray = originalArray.clone();
			start = System.nanoTime();
			InsertionSort.sort(insertionSortArray);
			end = System.nanoTime();
			if (!ArrayGenerator.isSorted(insertionSortArray)) throw new RuntimeException("Sorted array is not sorted!");
			totalInsertionSort += (end - start);
			System.out.println("End insertion sort.");

			// Selection Sort
			System.out.println("Start selection sort...");
			int[] selectionSortArray = originalArray.clone();
			start = System.nanoTime();
			SelectionSort.sort(selectionSortArray);
			end = System.nanoTime();
			if (!ArrayGenerator.isSorted(selectionSortArray))
				throw new RuntimeException("SelectionSort failed: array is not sorted!");
			totalSelectionSort += (end - start);
			System.out.println("End selection sort.");

			// Merge Sort
			System.out.println("Start merge sort...");
			int[] mergeSortArray = originalArray.clone();
			start = System.nanoTime();
			MergeSort.sort(mergeSortArray);
			end = System.nanoTime();
			if (!ArrayGenerator.isSorted(mergeSortArray))
				throw new RuntimeException("MergeSort failed: array is not sorted!");
			totalMergeSort += (end - start);
			System.out.println("End merge sort.");

			// Quick Sort
			System.out.println("Start quick sort...");
			int[] quickSortArray = originalArray.clone();
			start = System.nanoTime();
			QuickSort.sort(quickSortArray);
			end = System.nanoTime();
			if (!ArrayGenerator.isSorted(quickSortArray))
				throw new RuntimeException("QuickSort failed: array is not sorted!");
			totalQuickSort += (end - start);
			System.out.println("End quick sort.");
		}

		System.out.println("Benchmark End...");
		System.out.println("Bubble sort execution time: " + (totalBubbleSort / numberOfIterations) / 1_000_000.0 + " ms.");
		System.out.println("Insertion sort execution time: " + (totalInsertionSort / numberOfIterations) / 1_000_000.0 + " ms.");
		System.out.println("Merge sort execution time: " + (totalMergeSort / numberOfIterations) / 1_000_000.0 + " ms.");
		System.out.println("Quick sort execution time: " + (totalQuickSort / numberOfIterations) / 1_000_000.0 + " ms.");
		System.out.println("Selection sort execution time: " + (totalSelectionSort / numberOfIterations) / 1_000_000.0 + " ms.");
	}
}
