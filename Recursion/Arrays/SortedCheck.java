package Recursion.Arrays;

public class SortedCheck {
    public static void main(String[] args){
        int[] arr = {1, 2, 4, 5, 6};
        
        // Start the check from index 0
        System.out.println(sorted(arr, 0)); // Output: true
    }

    static boolean sorted(int[] arr, int index) {
        // EDGE CASE FIX: If the array is completely empty, 
        // consider it sorted to prevent out-of-bounds errors.
        // if (arr.length == 0) return true;

        // BASE CASE: If we have reached the last element safely, 
        // it means all previous elements were sorted.
        if(index == arr.length - 1){
            return true;
        }

        // RECURSIVE RELATION:
        // 1. Check current pair: Is the current element <= the next one? 
        //    (Using <= instead of < allows for duplicate numbers like {1, 2, 2, 5})
        // 2. AND (&&) check the rest: Is the remaining array sorted?
        //
        // NOTE: Because of short-circuit evaluation in Java (&&), 
        // if arr[index] <= arr[index + 1] is FALSE, it immediately returns false 
        // and doesn't even make the next recursive call. This saves memory!
        return arr[index] <= arr[index + 1] && sorted(arr, index + 1);
    }
}