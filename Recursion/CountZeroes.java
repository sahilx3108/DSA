package Recursion;

public class CountZeroes {
    public static void main(String[] args) {
        // Output will be 2
        System.out.println(count(30210)); 
    }

    static int count(int n){
        // EDGE CASE FIX: If the number itself is exactly 0, it has one zero.
        // Uncommenting the line below makes the code 100% foolproof:
        // if (n == 0) return 1;
        
        // Start the recursive helper with an initial count (c) of 0
        return helper(n, 0);
    }

    // The 'c' parameter acts as our state, carrying the count forward.
    // This removes the need for any global or static variables.
    private static int helper (int n, int c){
        // BASE CASE: When the number is fully chopped down to 0, 
        // we've checked all digits. Return the accumulated count.
        if(n == 0){
            return c;
        }

        // 1. Extract the last digit
        int rem = n % 10;
        
        // 2. RECURSIVE RELATION
        if(rem == 0){
            // If the extracted digit is 0, recurse with the rest of the number
            // and increment our counter (c + 1)
            return helper(n / 10, c + 1);
        }
        
        // If it is NOT 0, recurse with the rest of the number 
        // but keep the counter exactly the same (c)
        return helper(n / 10, c);
    }
}