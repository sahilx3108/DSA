package Recursion;

public class Palindrome {
    public static void main(String[] args) {
        // Testing the palindrome checker with a known palindrome
        System.out.println(palin(1234321)); // Output will be true
    }

    // ==========================================
    // MODULE 1: The Reversal Setup
    // ==========================================
    static int rev(int n) {
        // Calculate the total number of digits in 'n' instantly using log10
        int digits = (int)(Math.log10(n)) + 1;
        
        // Pass the number and its digit count to the recursive helper
        return helper(n, digits);
    }

    // ==========================================
    // MODULE 2: The Recursive Workhorse
    // ==========================================
    private static int helper(int n, int digits) {
        // BASE CASE: If only one digit is left, return it
        if (n % 10 == n) {
            return n;
        }
        
        // Extract the last digit
        int rem = n % 10;
        
        // Push the extracted digit to its new reversed position using Math.pow,
        // then recursively process the remaining digits.
        return rem * (int)(Math.pow(10, digits - 1)) + helper(n / 10, digits - 1);
    }
    
    // ==========================================
    // MODULE 3: The Palindrome Checker
    // ==========================================
    static boolean palin(int n) {
        // Simply reverse the number using our rev() function and check 
        // if it matches the original number 'n'. 
        // Returns true if they match, false otherwise.
        return (n == rev(n));
    }
}