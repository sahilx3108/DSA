package SortingWithoutRecursion;

import java.util.Arrays;

public class bubbleSort {
    public static void main(String[] args) {
        // An already sorted array to test our optimized break condition
        int[] arr = {1, 2, 3, 4, 5};
        bubble(arr);
        System.out.println(Arrays.toString(arr)); // Output: [1, 2, 3, 4, 5]
    }
    
    static void bubble(int[] arr){
        boolean swapped;
        
        // OUTER LOOP: Controls the number of passes through the array
        for(int i = 0; i < arr.length; i++){
            swapped = false; // Reset the flag at the start of every new pass
            
            // INNER LOOP: Compares adjacent elements.
            // As 'i' increases, the largest elements lock into place at the end.
            // 'arr.length - i' prevents us from re-checking elements that are already sorted.
            for(int j = 1; j < arr.length - i; j++){
                
                // If the current element is smaller than the previous one, they are out of order
                if(arr[j] < arr[j-1]){
                    // Standard swap using a temporary variable
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    
                    // A swap occurred, so set the flag to true
                    swapped = true;
                }
            }
            
            // OPTIMIZATION: If no two elements were swapped during this entire pass,
            // it means the array is completely sorted. We can safely break early!
            if(!swapped){
                break;
            }
        }
    }
}