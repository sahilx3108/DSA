package Recursion.Arrays;

import java.util.ArrayList;

public class Find {
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 4, 4, 5};
        
        // System.out.println(find(arr, 4, 0));
        // System.out.println(findindex(arr, 4, 0));
        
        // Start from the last index for backward search
        // System.out.println(findindexlast(arr, 4, arr.length - 1)); 

        // Passing an empty list to be filled by the recursive calls
        // ArrayList<Integer> ans = findAllindex(arr, 4, 0, new ArrayList<>());
        // System.out.println(ans);

        // Does not require an initial list, builds it on the fly!
        System.out.println(findAllindex2(arr, 4, 0)); // Output: [3, 4]
    }

    // ==========================================
    // MODULE 1: Boolean Check (Does it exist?)
    // ==========================================
    static boolean find(int[] arr, int target, int index) {
        if (index == arr.length) {
            return false; // Reached the end, target not found
        }
        // Short-circuit OR (||): If arr[index] == target is true, 
        // it immediately returns true and doesn't even make the recursive call!
        return arr[index] == target || find(arr, target, index + 1);
    }
    
    // ==========================================
    // MODULE 2: Forward Index Search (First occurrence)
    // ==========================================
    static int findindex(int[] arr, int target, int index) {
        if (index == arr.length) {
            return -1;
        }
        if (arr[index] == target) {
            return index; // Found it!
        } else {
            return findindex(arr, target, index + 1); // Keep searching forward
        }
    }

    // ==========================================
    // MODULE 3: Backward Index Search (Last occurrence)
    // ==========================================
    static int findindexlast(int[] arr, int target, int index) {
        if (index == -1) {
            return -1; // Reached the beginning, target not found
        }
        if (arr[index] == target) {
            return index;
        } else {
            // BUG FIXED: Now recursively calls itself (findindexlast) 
            // instead of findindex!
            return findindexlast(arr, target, index - 1);
        }
    }

    // ==========================================
    // MODULE 4: Find All (Passing the List as State)
    // ==========================================
    static ArrayList<Integer> findAllindex(int[] arr, int target, int index, ArrayList<Integer> list) {
        if (index == arr.length) {
            return list;
        }
        if (arr[index] == target) {
            list.add(index);
        }
        // Since 'list' is a reference object, all recursive calls 
        // are adding to the exact same list in memory.
        return findAllindex(arr, target, index + 1, list);
    }

    // ==========================================
    // MODULE 5: Find All (Creating and Merging Lists - The Hard Way!)
    // ==========================================
    static ArrayList<Integer> findAllindex2(int[] arr, int target, int index) {
        
        // This list is LOCAL to this specific function call only!
        ArrayList<Integer> list = new ArrayList<>();
        
        if (index == arr.length) {
            return list;
        }

        // If this specific index has the target, add it to our local list
        if (arr[index] == target) {
            list.add(index);
        }
        
        // Make the recursive dive to get the answers from the rest of the array
        ArrayList<Integer> ansFromBelowCalls = findAllindex2(arr, target, index + 1);

        // Merge the answers from below into our current local list
        list.addAll(ansFromBelowCalls);

        // Pass the newly merged list back up the chain
        return list;
    }
}