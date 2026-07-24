package Recursion.sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = { 5, 4, 3, 2, 1 };

        // Notice we use INCLUSIVE bounds (arr.length - 1) because we need to
        // physically read and swap elements at the exact end index!
        sort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr)); // Output: [1, 2, 3, 4, 5]

    }

    static void sort(int[] nums, int low, int hi) {
        // BASE CASE: If the window size shrinks to 1 or 0 elements,
        // that slice is already sorted.
        if (low >= hi) {
            return;
        }

        // Create temporary pointers so we don't lose our original window bounds (low,
        // hi)
        int s = low;
        int e = hi;

        // Calculate mid and select the middle element as our Pivot.
        // Selecting mid avoids O(N^2) worst-case performance on already sorted arrays!
        int m = s + (e - s) / 2;
        int pivot = nums[m];

        // ==========================================
        // PHASE 1: The Partitioning Loop
        // ==========================================
        // Keep running until the start pointer crosses the end pointer
        while (s <= e) {

            // Step 1: Move 's' forward as long as elements are already smaller than pivot.
            // When this loop stops, nums[s] is sitting on the WRONG side (>= pivot).
            while (nums[s] < pivot) {
                s++;
            }

            // Step 2: Move 'e' backward as long as elements are already larger than pivot.
            // When this loop stops, nums[e] is sitting on the WRONG side (<= pivot).
            while (nums[e] > pivot) {
                e--;
            }

            // Step 3: If pointers haven't crossed yet, swap the two out-of-place elements!
            if (s <= e) {
                int temp = nums[s];
                nums[s] = nums[e];
                nums[e] = temp;

                // Move both pointers inward to continue the partition scan
                s++;
                e--;
            }
        }

        // ==========================================
        // PHASE 2: Recursive Calls on Partitions
        // ==========================================
        // Now that the pointers have crossed, 'e' marks the end of the left partition,
        // and 's' marks the start of the right partition.

        // Recursively sort the left half [low to e] (all numbers <= pivot)
        sort(nums, low, e);

        // Recursively sort the right half [s to hi] (all numbers >= pivot)
        sort(nums, s, hi);
    }
}

// also a reason why if it already sorted it will not swap
// now my pivot is at correct index , please sort two halves now
