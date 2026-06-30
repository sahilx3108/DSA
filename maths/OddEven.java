package maths; 

public class OddEven {
    public static void main(String[] args) {
        int n = 67;
        System.out.println(isOdd(n));
    }

    /**
     * Checks if a number is odd using a Bitwise AND operator.
     * 
     * THE CONCEPT:
     * Every number is represented in binary (0s and 1s) under the hood.
     * The rightmost bit is called the Least Significant Bit (LSB).
     * - If the LSB is 1, the number is ODD  (e.g., 3 is ...0011)
     * - If the LSB is 0, the number is EVEN (e.g., 4 is ...0100)
     * 
     * THE TRICK (n & 1):
     * The number 1 in binary is just ...0001. 
     * When you do a bitwise AND (&) between 'n' and 1, it compares them bit by bit.
     * Because 1 has zeros everywhere except the end, it masks (hides) all other bits of 'n' 
     * and only checks that very last bit.
     * 
     * Example with 67:
     *   1000011  (67 in binary)
     * & 0000001  (1 in binary)
     *   -------
     *   0000001  (Result is 1. Since it equals 1, the number is odd!)
     */
    private static boolean isOdd(int n) {
        return (n & 1) == 1;
    }
}