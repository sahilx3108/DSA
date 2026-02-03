package binarySearch;

public class PeakInMountainArray {
 public static void main(String[] args) {
   int[] arr = {1,2,3,5,7,8,7,5,3};
   int ans= peakIndexInMountainArray(arr);
   System.out.println(ans);
 }
 public static int peakIndexInMountainArray(int[] arr){
    int start=0;
    int end=arr.length-1;

    while(start<end){
        int mid= start+ (end-start)/2;
        if(arr[mid]>arr[mid+1]){
            //you are in decreasing part of array
            //this may be the answer , but look at the left
            //this is why end !=mid-1 
            end=mid;
        }else{
            //you are in asc part of an array
            start=mid+1; // because we know that mid +1 element >mid element

        }

    
    }
    return start;
    // in the end , start == end and pointing to largest number because of  the 2 checks above
    // start and end always trying to find the max element in above 2 checks 
    // hence when they are pointing to the 1 element it is the largest element 
    // more elaboration : at every point of time for start and end , they have the  best possible answer till that time 

 }
}
