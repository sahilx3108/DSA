package SortingWithoutRecursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class findAllMissing {
    public static void main(String[] args) {
        // Example with missing numbers: 4 and 7 are missing in range [1, 7]
        int[] arr = {4, 3, 2, 7, 8, 2, 3, 1}; 
        
        // Since the method is now static, we can call it directly
        List<Integer> missing = findDisappearedNumbers(arr);
        
        System.out.println("Missing Numbers: " + missing);
        System.out.println("Sorted Array (with duplicates): " + Arrays.toString(arr));
    }

    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
     
    // Added 'static' so it can be called from main
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correct = nums[i] - 1; // Correct index for value 'x' is 'x-1'
            
            // Check if current number is at its correct index
            if (nums[i] != nums[correct]) {
                swap(nums, i, correct);
            } else {
                i++;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int index = 0; index < nums.length; index++) {
            // If the value doesn't match the index + 1, it's a missing number
            if (nums[index] != index + 1) {
                ans.add(index + 1);
            }
        }
        return ans;
    }
}