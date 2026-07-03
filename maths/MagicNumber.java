package maths;

public class MagicNumber {
    public static void main(String[] args) {
        int n = 6; // The position of the magic number we want to find (6th magic number)

        int ans = 0;   // Accumulator to store our final calculated magic number
        int base = 5;  // Tracks the current power of 5 (starts at 5^1, then 5^2, 5^3, etc.)
        
        // Loop runs until all bits of 'n' have been processed
        while (n > 0) {
            // Step 1: Get the last bit (rightmost bit) of 'n' using bitwise AND
            // 'n & 1' results in 1 if the last bit is 1, or 0 if the last bit is 0
            int last = n & 1;
            
            // Step 2: Right-shift 'n' by 1 bit to discard the bit we just checked
            // This prepares the next bit for the next iteration
            n = n >> 1;
            
            // Step 3: If the last bit was 1, add the current power of 5 to our answer.
            // If it was 0, 'last * base' becomes 0 and adds nothing.
            ans += last * base;
            
            // Step 4: Multiply base by 5 to move to the next power (5 -> 25 -> 125 -> ...)
            base = base * 5;
        }

        // Output the final result (For n=6, binary is 110, so ans = 0*5 + 1*25 + 1*125 = 150)
        System.out.println(ans); 
    }
}