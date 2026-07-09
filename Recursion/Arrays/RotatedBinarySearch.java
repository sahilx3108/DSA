package Recursion.Arrays;

public class RotatedBinarySearch {
    public static void main(String[] args) {
        int[] arr = {5, 6, 7, 8, 9, 1, 2, 3};
        // Searching for 8, which is at index 3.
        System.out.println(search(arr, 8, 0, arr.length - 1)); // Output: 3
    }

    static int search(int[] arr, int target, int s, int e) {
        // BASE CASE: If start crosses end, the element doesn't exist.
        if (s > e) {
            return -1;
        }

        int m = s + (e - s) / 2;
        
        // BASE CASE 2: We found the target exactly at mid!
        if (arr[m] == target) {
            return m;
        }

        // ==========================================
        // CONDITION 1: Is the LEFT half perfectly sorted?
        // ==========================================
        if (arr[s] <= arr[m]) {
            // Yes, left half is sorted. Does the target live inside this left range?
            if (target >= arr[s] && target <= arr[m]) {
                // BUG FIXED: Added 'return' here. Target is in the left half.
                return search(arr, target, s, m - 1);
            } else {
                // Target is NOT in the left half, so it must be in the right half.
                return search(arr, target, m + 1, e);
            }
        }

        // ==========================================
        // CONDITION 2: If the left half ISN'T sorted, 
        // the RIGHT half MUST be perfectly sorted.
        // ==========================================
        
        // Does the target live inside this perfectly sorted right range?
        if (target >= arr[m] && target <= arr[e]) {
            // Yes, target is in the right half.
            return search(arr, target, m + 1, e);
        } else {
            // No, target is NOT in the right half, so it must be in the left half.
            return search(arr, target, s, m - 1);
        }
    }
}