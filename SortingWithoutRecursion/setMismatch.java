package SortingWithoutRecursion;

import java.util.Arrays;

public class setMismatch {

    public static void main(String[] args) {
        int[] testArray = {1, 2, 2, 4};

        int[] result = findErrorNums(testArray);

        System.out.println("Result [Duplicate, Missing]: " + Arrays.toString(result));
    }

    public static int[] findErrorNums(int[] arr) {
        int i = 0;
        while(i < arr.length){
            int correct = arr[i] - 1;
            if(arr[i] != arr[correct]){
                swap(arr, i, correct);
            } else{
                i++;
            }
        }
        
        for(int index = 0; index < arr.length; index++){
            if(arr[index] != index + 1){
                return new int[] {arr[index], index + 1};
            }
        }
        return new int[] {-1, -1};
    }

    static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}