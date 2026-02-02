package binarySearch;

public class SearchInsertPosition {
    
     public static int searchInsert(int[] nums, int target) {
        int start=0;
        int end=nums.length -1;
        

        while(start<=end){
            int mid=start+(end-start)/2;
            if(target==nums[mid]){
                return mid;
            }
            if(target<nums[mid]){
                end=mid-1;
            }else if(target>nums[mid]){
                start=mid+1;
            }
        }
        return start;
        
    }
    public static void main(String[] args) {
        int[] nums={2,4,6,12,14,17};
        int target=10;
        int ans=searchInsert(nums,target);
        System.out.println(ans);
    }
}

//Ceiling of a number has same code 

//for floor of a number code (largest number smaller than the target) just return end instead of start 

//Smallest character in an array larger than than the target char , that question also has the same code , the only diff will be removal of  