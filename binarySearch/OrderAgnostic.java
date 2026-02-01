package binarySearch;

public class OrderAgnostic {
    public static void main(String[] args) {
        int[] arr = { 99, 87, 76, 65, 53, 48, 32 };
        int target = 65;
        int ans = orderAgnosticBS(arr, target);
        System.out.println(ans);
    }

    static int orderAgnosticBS(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        //find whether array is ascending or descending
        boolean isasc=arr[start]<arr[end];

        while(start<=end){
            int mid =start+(end-start)/2;
            if(arr[mid]==target){
                return mid;
            }

            if(isasc){
                if(target<arr[mid]){
                    end=mid-1;
                }else{
                    start=mid+1;
                }
            }else{
                if(target>arr[mid]){
                    end=mid-1;
                }else{
                    start=mid+1;
                }
            }
        }
        return -1;
    }
}