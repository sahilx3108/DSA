package binarySearch;

public class RotationCount {
    public static void main(String[] args) {
        int[] arr= {4,5,6,7,0,1,2};
        System.out.println(CountRotations(arr));
    }

    static int CountRotations(int[] arr){
        int pivot=findPivot(arr);
        return pivot+1;
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
