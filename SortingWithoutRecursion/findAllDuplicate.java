package SortingWithoutRecursion;

import java.util.ArrayList;
import java.util.List;

public class findAllDuplicate {
    public List<Integer> findDuplicates(int[] arr) {
        int i=0;
        while(i<arr.length){
            int correct=arr[i] -1;
            if( arr[i]!=arr[correct]){
                swap(arr,i,correct);
            } else{
                i++;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int index = 0; index < arr.length; index++) {
            // If the value doesn't match the index + 1, it's a missing number
            if (arr[index] != index + 1) {
                ans.add(arr[index]);
            }
        }
        return ans;
    }

    static void swap(int[] arr,int first,int second){
        int temp=arr[first];
        arr[first]=arr[second];
        arr[second]=temp;
    }
}
