package maths;

public class FindUnique {
    public static void main(String[] args) {
        int[] arr = {2, 3, 3, 4, 2, 6, 4};
        System.out.println(ans(arr)); // Output will be 6
    }

    /**
     * Finds the single non-repeating element in an array where every other element repeats twice.
     * 
     * THE CONCEPT: Bitwise XOR (^)
     * XOR compares bits and returns 1 only if the bits are DIFFERENT.
     * 0 ^ 1 = 1
     * 1 ^ 0 = 1
     * 0 ^ 0 = 0
     * 1 ^ 1 = 0
     * 
     * THE TRICK (Crucial XOR Properties):
     * 1. Any number XORed with itself is 0   (a ^ a = 0) -> Duplicates cancel out!
     * 2. Any number XORed with 0 is itself   (a ^ 0 = a)
     * 3. Order does not matter               (a ^ b ^ a  is the same as  a ^ a ^ b)
     * 
     * HOW IT WORKS WITH THIS ARRAY: {2, 3, 3, 4, 2, 6, 4}
     * As the loop runs, the XOR operation effectively pairs up the duplicates and turns them to 0.
     * 
     * Breakdown:
     * unique = 0
     * unique = 0 ^ 2 = 2
     * unique = 2 ^ 3 = (2^3)
     * unique = (2^3) ^ 3 = 2 ^ (3^3) = 2 ^ 0 = 2  <-- The 3s cancelled each other out!
     * 
     * Eventually, all pairs (2^2, 3^3, 4^4) become 0. 
     * You are left with: 0 ^ 6 = 6. 
     * The unique number survives.
     */
    private static int ans(int[] arr) {
        int unique = 0;
        for (int n : arr) {
            unique ^= n; // XOR the current number with the running total
        }
        return unique;
    }
}