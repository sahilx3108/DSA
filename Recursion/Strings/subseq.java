package Recursion.Strings;

public class subseq {
    public static void main(String[] args) {
        // Start with an empty processed string, and "abc" as the unprocessed string.
        // This will print: abc, ab, ac, a, bc, b, c, (and one empty line)
        subsequence("", "abc");
    }

    // p = processed (the subsequence we are building)
    // up = unprocessed (the remaining characters to choose from)
    static void subsequence(String p, String up) {
        // BASE CASE: When we run out of characters to process, 
        // our 'p' bucket contains one complete combination.
        if(up.isEmpty()) {
            System.out.println(p);
            return;
        }
        
        // Extract the current character we are making a decision on
        char ch = up.charAt(0);
        
        // ==========================================
        // THE TWO RECURSIVE BRANCHES
        // ==========================================
        
        // CHOICE 1: "Take It"
        // We include 'ch' in our processed string (p + ch), 
        // and move to the next character in the unprocessed string.
        subsequence(p + ch, up.substring(1));
        
        // CHOICE 2: "Leave It"
        // We ignore 'ch' (keep 'p' exactly as it is), 
        // and move to the next character in the unprocessed string.
        subsequence(p, up.substring(1));
    }
}