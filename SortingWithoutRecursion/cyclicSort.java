package SortingWithoutRecursion;

import java.util.Arrays;
//works only when every no .from 1 to N is there like(35214 will become 12345 after sorting and every number from 1 to 5 is there )
public class cyclicSort {
    public static void main(String[] args) {
        int[] arr= {3,5,2,1,4};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void swap(int[] arr,int first,int second){
        int temp=arr[first];
        arr[first]=arr[second];
        arr[second]=temp;
    }
     
    static void sort(int[] arr){
        int i=0;
        while(i<arr.length){
            int correct=arr[i]-1;
            if(arr[i]!=arr[correct]){
                swap(arr,i,correct);
            } else{
                i++;
            }
        }
    }
}
