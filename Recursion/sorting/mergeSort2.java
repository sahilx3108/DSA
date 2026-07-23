package Recursion.sorting;

import java.util.Arrays;

public class mergeSort2 {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        
        // Pass the array, the starting index (0), and the EXCLUSIVE end index (arr.length)
        mergeSortInPlace(arr, 0, arr.length);
        
        // The original array is modified directly!
        System.out.println(Arrays.toString(arr)); // Output: [1, 2, 3, 4, 5]
    }

    // ==========================================
    // MODULE 1: Pointer-Based Divide Phase
    // ==========================================
    static void mergeSortInPlace(int[] arr, int s, int e) {
        // BASE CASE: If the window size (end - start) is 1, 
        // that single element is already sorted.
        if (e - s == 1) {
            return;
        }

        // Calculate the middle boundary (safe from integer overflow)
        int mid = s + (e - s) / 2;

        // Recursively sort the left slice [s, mid) -> mid is exclusive here
        mergeSortInPlace(arr, s, mid);
        
        // Recursively sort the right slice [mid, e)
        mergeSortInPlace(arr, mid, e);

        // Merge the two sorted slices back together within the original array
        mergeInPlace(arr, s, mid, e);
    }

    // ==========================================
    // MODULE 2: Pointer-Based Merge Phase
    // ==========================================
    private static void mergeInPlace(int[] arr, int s, int m, int e) {
        // Create a temporary array just large enough to hold this specific window
        int[] mix = new int[e - s];

        int i = s; // Pointer for the left sorted half
        int j = m; // Pointer for the right sorted half
        int k = 0; // Pointer for the temporary 'mix' array

        // Compare elements from both halves and store the smaller one in 'mix'
        while (i < m && j < e) {
            if (arr[i] < arr[j]) {
                mix[k] = arr[i];
                i++;
            } else {
                mix[k] = arr[j];
                j++;
            }
            k++;
        }

        // Copy any remaining leftover elements from the left half
        while (i < m) {
            mix[k] = arr[i];
            i++;
            k++;
        }

        // Copy any remaining leftover elements from the right half
        while (j < e) {
            mix[k] = arr[j];
            j++;
            k++;
        }

        // CRITICAL STEP:
        // Copy the sorted elements from our temporary 'mix' array 
        // directly back into the correct window of the ORIGINAL array.
        // 's + l' ensures we write to the exact slice we just merged!
        for (int l = 0; l < mix.length; l++) {
            arr[s + l] = mix[l];
        }
    }
}