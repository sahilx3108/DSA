package Recursion.Patterns;

import java.util.Arrays;

public class triangle {
    public static void main(String[] args) {
        System.out.println("--- Inverted Triangle ---");
        tiriangle(4, 0); 
        
        System.out.println("--- Normal Triangle ---");
        tiriangle2(4, 0);

int[] arr = {4, 3, 2, 1};
        
        // Start the sort!
        // r = arr.length - 1 (We want to stop comparing at the last index)
        // c = 0 (We start comparing from the 0th index)
        bubble(arr, arr.length - 1, 0);


        System.out.println(Arrays.toString(arr));

         // Start the sort!
        // r = arr.length (The whole array is initially unsorted)
        // c = 0 (Start scanning from the 0th index)
        // max = 0 (Assume the 0th index is the maximum to begin with)
        selection(arr, arr.length, 0, 0);
        
        // Output: [1, 2, 3, 4]
        System.out.println(Arrays.toString(arr));
    }

    // ==========================================
    // METHOD 1: Action BEFORE the Recursive Call
    // ==========================================
    static void tiriangle(int r, int c) {
        // BASE CASE: When we reach row 0, the whole pattern is done.
        if(r == 0) {
            return;
        }
        
        // RECURSIVE RELATION (Printing the columns)
        if(c < r) {
            // Action happens FIRST. We print the star immediately.
            System.out.print("*");
            // Then we move to the next column in the same row.
            tiriangle(r, c + 1);
        } 
        // When we reach the end of the row (c == r)
        else {
            // Action happens FIRST. We print a newline immediately.
            System.out.println();
            // Then we move to the NEXT row (r-1) and reset columns to 0.
            tiriangle(r - 1, 0);
        }
    }

    // ==========================================
    // METHOD 2: Action AFTER the Recursive Call (Unwinding)
    // ==========================================
    static void tiriangle2(int r, int c) {
        // BASE CASE: When we reach row 0, stop and start returning.
        if(r == 0) {
            return;
        }
        
        // RECURSIVE RELATION (Printing the columns)
        if(c < r) {
            // Recursion happens FIRST. We dive deeper into the next column.
            tiriangle2(r, c + 1);
            // We only print the star AFTER returning from the dive.
            // This causes the pattern to build bottom-up!
            System.out.print("*");
        } 
        // When we reach the end of the row (c == r)
        else {
            // Recursion happens FIRST. We dive into the next row.
            tiriangle2(r - 1, 0);
            // We only print the newline AFTER returning from the dive.
            System.out.println();
        }
    }


   static void bubble(int[] arr, int r, int c) {
        // BASE CASE: If our boundary 'r' reaches 0, the entire array is sorted.
        if(r == 0) {
            return;
        }
        
        // ==========================================
        // PHASE 1: The "Inner Loop" Equivalent (Traversing the array)
        // ==========================================
        if(c < r) {
            
            // Compare the current element with the next element
            if(arr[c] > arr[c+1]){
                // They are out of order, so perform a standard swap
                int temp = arr[c];
                arr[c] = arr[c+1];
                arr[c+1] = temp;
            }

            // Move to the next pair in the current pass (increment 'c')
            bubble(arr, r, c + 1);
        } 
        
        // ==========================================
        // PHASE 2: The "Outer Loop" Equivalent (Resetting for the next pass)
        // ==========================================
        else {
            // We reached the end of the unsorted portion (c == r).
            // The largest element is now at index 'r'.
            // Shrink the boundary (r - 1) and reset our starting index to 0.
            bubble(arr, r - 1, 0);
        }
    }


    static void selection(int[] arr, int r, int c, int max) {
        // BASE CASE: If our unsorted boundary 'r' shrinks to 0, 
        // the entire array is sorted.
        if (r == 0) {
            return;
        }
        
        // ==========================================
        // PHASE 1: The "Inner Loop" Equivalent (Finding the max)
        // ==========================================
        if (c < r) {
            // Compare the current element with our tracked maximum
            if (arr[c] > arr[max]) {
                // If current is bigger, advance 'c' and update the max to 'c'
                selection(arr, r, c + 1, c);
            } else {
                // If current is NOT bigger, advance 'c' but keep the old 'max'
                selection(arr, r, c + 1, max);
            }
        } 
        
        // ==========================================
        // PHASE 2: The "Outer Loop" Equivalent (Swapping & Resetting)
        // ==========================================
        else {
            // We have finished scanning the current unsorted portion (c == r).
            // 'max' now accurately points to the largest element.
            
            // Swap the max element with the last element of the unsorted boundary (r - 1)
            int temp = arr[max];
            arr[max] = arr[r - 1];
            arr[r - 1] = temp;

            // Start the next full pass:
            // Shrink the boundary (r - 1)
            // Reset the current index (c = 0)
            // Reset the max tracker (max = 0)
            selection(arr, r - 1, 0, 0);
        }
    }
}