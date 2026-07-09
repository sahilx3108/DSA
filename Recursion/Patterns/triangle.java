package Recursion.Patterns;

public class triangle {
    public static void main(String[] args) {
        System.out.println("--- Inverted Triangle ---");
        tiriangle(4, 0); 
        
        System.out.println("--- Normal Triangle ---");
        tiriangle2(4, 0);
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
}