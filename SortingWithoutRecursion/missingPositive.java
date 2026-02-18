package SortingWithoutRecursion;

import java.util.Arrays;

public class missingPositive {

    // --- NEW: Main Method to Run the Code ---
    public static void main(String[] args) {
        // Test Case 1
        int[] arr1 = {3, 4, -1, 1};
        System.out.println("Input Array: " + Arrays.toString(arr1));
        int result1 = firstMissingPositive(arr1);
        System.out.println("First Missing Positive: " + result1);

        System.out.println("-----------------");

        // Test Case 2
        int[] arr2 = {1, 2, 0};
        System.out.println("Input Array: " + Arrays.toString(arr2));
        int result2 = firstMissingPositive(arr2);
        System.out.println("First Missing Positive: " + result2);
    }
    // ----------------------------------------

    static int firstMissingPositive(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correct = arr[i] - 1;
            // Check boundaries and duplicates to avoid infinite loops
            if (arr[i] > 0 && arr[i] <= arr.length && arr[i] != arr[correct]) {
                swap(arr, i, correct);
            } else {
                i++;
            }
        }

        // Search for first missing number
        for (int index = 0; index < arr.length; index++) {
            if (arr[index] != index + 1) {
                return index + 1;
            }
        }

        // Case 2: All numbers are present (e.g., {1, 2, 3})
        return arr.length + 1;
    }

    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}