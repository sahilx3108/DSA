package Recursion.Strings;

public class Stream {
    public static void main(String[] args) {
        // METHOD 1: Passing the accumulator (prints directly inside the base case)
        // skip("", "baccdah");

        // METHOD 2: Pure recursion (returns the final string to main)
        // System.out.println(skip("baccdah")); // Output: bccdh

        // METHOD 3: Skipping an entire word
        System.out.println(skipApple("bacapplecdah")); // Output: baccdah
    }

    // ==========================================
    // MODULE 1: The Accumulator Pattern (Void Return)
    // ==========================================
    static void skip(String p, String up) {  // p = processed, up = unprocessed
        // BASE CASE: If the unprocessed string is empty, we are done.
        if (up.isEmpty()) {
            System.out.println(p); // Print the fully processed string
            return;
        }

        // Extract the first character of the unprocessed string
        char ch = up.charAt(0);

        // RECURSIVE RELATION
        if (ch == 'a') {
            // Ignore the 'a'. Pass the processed string as-is, 
            // and chop off the first character of the unprocessed string.
            skip(p, up.substring(1));
        } else {
            // Include the character! Append it to the processed string,
            // and chop off the first character of the unprocessed string.
            skip(p + ch, up.substring(1));
        }
    }

    // ==========================================
    // MODULE 2: Pure Recursion Pattern (String Return)
    // ==========================================
    static String skip(String up) {
        // BASE CASE: If unprocessed is empty, return an empty string to start the chain.
        if (up.isEmpty()) {
            return "";
        }

        // Extract the first character
        char ch = up.charAt(0);

        // RECURSIVE RELATION
        if (ch == 'a') {
            // Ignore the 'a'. Just return the recursive result of the remaining string.
            return skip(up.substring(1));
        } else {
            // Keep the character! Glue 'ch' to the front of the recursive result 
            // coming back from the remaining string.
            return ch + skip(up.substring(1));
        }
    }

    // ==========================================
    // MODULE 3: Skip an Entire Word (Substring Pattern)
    // ==========================================
    static String skipApple(String up) {
        // BASE CASE: If unprocessed is empty, return an empty string to start the chain.
        if (up.isEmpty()) {
            return "";
        }

        // RECURSIVE RELATION
        // Check if the current unprocessed string starts with our exact target word.
        if (up.startsWith("apple")) {
            // Ignore the entire word "apple". 
            // Since "apple" is 5 characters long, we slice off 5 characters 
            // to jump completely over the word.
            return skipApple(up.substring(5));
        } else {
            // It doesn't start with "apple", so we safely keep the first character.
            // Glue it to the result of processing the rest of the string (1 step forward).
            return up.charAt(0) + skipApple(up.substring(1));
        }
    }


    static String skipAppNOtApple(String up) {
        // BASE CASE: If unprocessed is empty, return an empty string to start the chain.
        if (up.isEmpty()) {
            return "";
        }

        // RECURSIVE RELATION
        // Check if the current unprocessed string starts with our exact target word.
        if (up.startsWith("apple")) {
            // Ignore the entire word "apple". 
            // Since "apple" is 5 characters long, we slice off 5 characters 
            // to jump completely over the word.
            return skipAppNOtApple(up.substring(5));
        } else {
            // It doesn't start with "apple", so we safely keep the first character.
            // Glue it to the result of processing the rest of the string (1 step forward).
            return up.charAt(0) + skipAppNOtApple(up.substring(1));
        }
    }
}