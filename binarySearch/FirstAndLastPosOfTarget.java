//below code is just for running in the local java system
package binarySearch;

import java.util.Arrays; // Import this to print the array properly

public class FirstAndLastPosOfTarget {
    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 4, 5, 5, 5, 5, 6, 7, 8};
        int target = 5;
        
        // Call the method and store the array
        int[] ans = searchRange(nums, target);
        
        // Use Arrays.toString to see the actual content [4, 7]
        System.out.println(Arrays.toString(ans));
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        // Now calling the static search method
        ans[0] = search(nums, target, true);
        ans[1] = search(nums, target, false);

        return ans;
    }

    // Added 'static' keyword here
    static int search(int[] nums, int target, boolean findStartIndex) {
        int ans = -1;
        int start = 0;
        int end = nums.length - 1;
        
        while (start <= end) {
            int mid = start + (end - start) / 2;
            
            if (target < nums[mid]) {
                end = mid - 1;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                // Potential answer found
                ans = mid;
                if (findStartIndex) {
                    end = mid - 1; // Squeeze left to find the first occurrence
                } else {
                    start = mid + 1; // Squeeze right to find the last occurrence
                }
            }
        }
        return ans;
    }
}












// package binarySearch;

// public class FirstAndLastPosOfTarget {
//    public static int[] searchRange(int[] nums, int target) {
//         int [] ans={-1,-1};
//         int start=search(nums,target,true);
//         int end=search(nums,target,false);
//         ans[0]=start;
//         ans[1]=end;

//         return ans;
//     }
//    public static int  search(int[] nums,int target,boolean findStartIndex){
//         int ans=-1;
//         int start=0;
//         int end=nums.length-1;
//         while(start<=end){
//             int mid=start+(end-start)/2;
//             if(target<nums[mid]){
//                 end=mid-1;
//             }else if(target>nums[mid]){
//                 start=mid+1;
//             }else{
//                 ans=mid;
//                 if(findStartIndex){
//                     end=mid-1;
//                 }else{
//                     start=mid+1;
//                 }
//             }
//         }
//         return ans;
//     }
// }

