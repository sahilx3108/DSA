package Recursion.Strings;

public class Ascii {
    public static void main(String[] args) {
        // Generates 27 different combinations!
        // Output will include: abc, ab99, a98c, a9899, 97bc, etc.
        subseqAscii("", "abc");
    }

    static void subseqAscii(String p, String up) {
        // BASE CASE: When the unprocessed string is empty, print the result.
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        
        // Extract the current character
        char ch = up.charAt(0);
        
        // ==========================================
        // THE THREE RECURSIVE BRANCHES (O(3^N))
        // ==========================================
        
        // BRANCH 1: "Take It" (Keep the literal character)
        subseqAscii(p + ch, up.substring(1));
        
        // BRANCH 2: "Leave It" (Ignore the character)
        subseqAscii(p, up.substring(1));
        
        // BRANCH 3: "Take the ASCII" 
        // Adding 0 forces numeric promotion, turning 'a' into 97.
        // It then gets concatenated to the string 'p'.
        subseqAscii(p + (ch + 0), up.substring(1));
    }
}
