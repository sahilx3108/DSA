package SortingWithoutRecursion;

import java.util.Arrays;

public class findDuplicate {

    public static void main(String[] args) {
        int[] arr = {4, 3, 7, 2, 3, 1}; 
        
        int missing = findDuplicate(arr);
        
        System.out.println("Duplicate Number: " + missing);
    }

    public static int findDuplicate(int[] nums) {
         int i=0;
        while(i<nums.length){

            if(nums[i]!=i+1){
                int correct=nums[i] -1;
            if(nums[i] !=nums[correct]){
                swap(nums,i,correct);
            } else{
                return nums[i];
            }
            }else {
                i++;
            }
            
        }
        return -1;
    }

    static void swap(int[] arr,int first,int second){
        int temp=arr[first];
        arr[first]=arr[second];
        arr[second]=temp;
    }
    
}
