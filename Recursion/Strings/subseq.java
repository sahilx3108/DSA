package Recursion.Strings;

import java.util.ArrayList;

public class subseq {
    public static void main(String[] args) {
        // Start with an empty processed string, and "abc" as the unprocessed string.
        // This will print: abc, ab, ac, a, bc, b, c, (and one empty line)
        // subsequence("", "abc");

        System.out.println(subsequenceret("", "abc")); 
        // Output: [abc, ab, ac, a, bc, b, c, ]
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



//                       ("", "ab")
//                     /          \
//           Take 'a' /            \ Leave 'a'
//                   /              \
//            ("a", "b")          ("", "b")
//            /        \          /        \
//    Take 'b'/   Leave \ 'b' Take /'b' Leave\ 'b'
//           /           \        /           \
//     ("ab", "")    ("a", "") ("b", "")    ("", "")





    // p = processed, up = unprocessed
    static ArrayList<String> subsequenceret(String p, String up) {
        
        // BASE CASE: No more characters to process.
        if(up.isEmpty()) {
            // Create a new list, put our single completed subsequence inside, 
            // and return it to the caller above us.
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        
        // Extract the current character
        char ch = up.charAt(0);
        
        // ==========================================
        // THE TWO RECURSIVE BRANCHES
        // ==========================================
        
        // CHOICE 1: "Take It"
        // This list will eventually contain all answers from the left branch
        ArrayList<String> left = subsequenceret(p + ch, up.substring(1));
        
        // CHOICE 2: "Leave It"
        // This list will eventually contain all answers from the right branch
        ArrayList<String> right = subsequenceret(p, up.substring(1));

        // ==========================================
        // THE MERGE STEP
        // ==========================================
        
        // Combine the answers from both branches into a single list
        left.addAll(right);
        
        // Return the combined master list up the recursion chain
        return left;
    

}


}