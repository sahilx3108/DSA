package binarySearch;

public class RotatedSortedArray {
    public static void main(String[] args) {
        int[] arr= {4,5,6,7,0,1,2};
        System.out.println(findPivot(arr));
    }
    static int search(int[]nums,int target){
        int pivot=findPivot(nums);

        //if you did not find pivot it means array is not rotated 
        if(pivot==-1){
            //just do normal binary search
            return binarySearch(nums, target, 0, nums.length-1) ;
        }
        // if pivot is found , you have 2 asc sorted arrays 
        if(nums[pivot]==target){
            return pivot;
        }
        if(target>=nums[0]){
            return(binarySearch(nums, target, 0, pivot-1));
        }
        return binarySearch(nums, target, pivot+1,nums.length-1);
    }
    static int binarySearch(int arr[],int target,int start ,int end){ 
        while(start<=end){
            int mid= (start +end)/2;

            // comparisions
            if(arr[mid]==target){
                return mid;
            }
            if(arr[mid]<target){  //right
                start=mid+1;
            }
            else{ //left
                end=mid-1;
            }
        }
        return -1;
    }

    static int findPivot(int[] arr){
        int start=0;
        int end=arr.length-1;

        while (start<=end) {
            int mid= start+(end-start)/2;

            // 4 cases over here
            // mid is the pivot
            if(mid<end && arr[mid]>arr[mid+1]){  //put the first condition to prevent an ArrayIndexOutBounds error
                return mid;
            }
            // mid-1 is the pivot
            if( mid>start && arr[mid]<arr[mid-1]){
                return mid-1;
                //search left
            }if(arr[mid]<=arr[start]){
                end=mid-1;
            }else{
                //search right
                start=mid+1;
            }
        }
        return -1;
    }
}

//there is a better version that we will do in recursion