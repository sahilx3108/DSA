package Recursion;

public class reverse {
    public static void main(String[] args) {
        // Testing the pure recursive function
        System.out.println(rev2(1234)); 
    }

    // ==========================================
    // METHOD 1: Using an external state variable
    // ==========================================
    static int sum = 0; // Global state variable to hold the reversed number

    static void rev1(int n) {
        // BASE CASE: If the number becomes 0, we've processed all digits.
        if (n == 0) {
            return;
        }
        
        // 1. Extract the last digit
        int rem = n % 10;
        
        // 2. Append the digit to our global sum 
        // (Multiplying by 10 shifts existing digits left, making room for the new one)
        sum = sum * 10 + rem;
        
        // 3. RECURSIVE CALL: Pass the remaining number (chopping off the last digit)
        rev1(n / 10);
    }

    // ==========================================
    // METHOD 2: Pure Recursion (Using a Helper Function)
    // ==========================================
    static int rev2(int n) {
        // We need an extra parameter (number of digits) for our recursive math,
        // so we calculate it here and pass it to a private helper function.
        
        // Using the log base 10 trick to find total digits in O(1) time
        int digits = (int) (Math.log10(n)) + 1;
        
        return helper(n, digits);
    }

    private static int helper(int n, int digits) {
        // BASE CASE: If the number is a single digit (n % 10 == n), 
        // just return it as is.
        if (n % 10 == n) {
            return n;
        }
        
        // 1. Extract the last digit
        int rem = n % 10;
        
        // 2. RECURSIVE RELATION: 
        // Multiply the extracted digit by 10^(digits-1) to place it at the correct 
        // highest-order position, then add it to the reversed rest of the number.
        // Example: For 1234 -> 4 * 10^3 + helper(123, 3)
        return rem * (int)(Math.pow(10, digits - 1)) + helper(n / 10, digits - 1);
    }
}