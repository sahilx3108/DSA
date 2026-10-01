package Recursion.Strings;

import java.util.ArrayList;
import java.util.List;

public class subset {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        
        // Generate the subsets
        List<List<Integer>> ans = subSet(arr);
        
        // Print them out one by one
        for (List<Integer> list : ans) {
            System.out.println(list);
        }
    }
    
    // Returns a List containing Lists of Integers
    static List<List<Integer>> subSet(int[] arr) {
        // This 'outer' list will hold all of our completed subsets
        List<List<Integer>> outer = new ArrayList<>();

        // 1. Add the fundamental base subset: an empty list.
        // If we don't do this, the inner loop will never execute!
        outer.add(new ArrayList<>());

        // 2. Iterate through every number in our input array
        for (int num : arr) {
            // Check how many subsets we currently have in 'outer'.
            // We MUST store this in 'n' before the loop, because 'outer' 
            // is going to grow inside the loop!
            int n = outer.size();
            
            // 3. Loop through all currently existing subsets
            for (int i = 0; i < n; i++) {
                // CLONE: Create a brand new list by copying the existing subset at index 'i'
                List<Integer> internal = new ArrayList<>(outer.get(i));
                
                // APPEND: Add our current number to this newly cloned subset
                internal.add(num);
                
                // STORE: Add the newly formed subset back into the 'outer' master list
                outer.add(internal);
            }
        }

        // Return the final aggregated list of subsets
        return outer;
    }
}