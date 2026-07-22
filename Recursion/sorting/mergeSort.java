package Recursion.sorting;

import java.util.Arrays;

public class mergeSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        
        // Because our method returns a completely NEW array, 
        // we have to reassign 'arr' to capture the sorted result.
        arr = mergesort(arr); 
        
        System.out.println(Arrays.toString(arr)); // Output: [1, 2, 3, 4, 5]
    }

    // ==========================================
    // MODULE 1: The "Divide" Phase
    // ==========================================
    static int[] mergesort(int[] arr) {
        // BASE CASE: If the array only has 1 element, it is inherently sorted.
        if (arr.length == 1) {
            return arr;
        }

        // Find the middle point to split the array
        int mid = arr.length / 2;

        // Recursively split the left side. 
        // copyOfRange creates a new array from index 0 to mid (exclusive)
        int[] left = mergesort(Arrays.copyOfRange(arr, 0, mid));
        
        // Recursively split the right side.
        // copyOfRange creates a new array from index mid to the end
        int[] right = mergesort(Arrays.copyOfRange(arr, mid, arr.length));

        // Once the left and right are fully split and sorted, merge them together!
        return merge(left, right);
    }

    // ==========================================
    // MODULE 2: The "Conquer" Phase (Two-Pointer Merge)
    // ==========================================
    private static int[] merge(int[] first, int[] second) {
        // Create a new array large enough to hold both halves
        int[] mix = new int[first.length + second.length];

        int i = 0; // Pointer for the 'first' array
        int j = 0; // Pointer for the 'second' array
        int k = 0; // Pointer for the 'mix' array

        // Compare elements from both arrays and insert the smaller one into 'mix'
        while (i < first.length && j < second.length) {
            if (first[i] < second[j]) {
                mix[k] = first[i];
                i++;
            } else {
                mix[k] = second[j];
                j++;
            }
            k++;
        }

        // CLEANUP PHASE:
        // It's possible that one array was completely emptied while the other 
        // still has leftover elements. Since both arrays are already sorted, 
        // we just blindly copy the remaining elements.
        
        // If 'first' has leftovers:
        while (i < first.length) {
            mix[k] = first[i];
            i++;
            k++;
        }

        // If 'second' has leftovers:
        while (j < second.length) {
            mix[k] = second[j];
            j++;
            k++;
        }

        // Return the perfectly merged and sorted array back up the recursion tree
        return mix;
    }
}