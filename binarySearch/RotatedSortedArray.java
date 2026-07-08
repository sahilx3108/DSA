package binarySearch;

public class RotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        // We are just printing the pivot index here to test the findPivot function.
        // For the full search, you would call search(arr, target) instead.
        System.out.println(findPivot(arr)); 
    }

    // ==========================================
    // MODULE 1: The Main Search Router
    // ==========================================
    static int search(int[] nums, int target) {
        int pivot = findPivot(nums);

        // CASE 1: No pivot found. 
        // This means the array is NOT rotated (it's just a normal sorted array).
        if (pivot == -1) {
            // Just do a normal binary search over the whole array
            return binarySearch(nums, target, 0, nums.length - 1);
        }

        // CASE 2: Pivot is exactly our target! We got lucky.
        if (nums[pivot] == target) {
            return pivot;
        }

        // CASE 3: Routing the search
        // If the target is >= the first element, it MUST be in the left sorted half.
        // Why? Because all numbers in the left half are > all numbers in the right half.
        if (target >= nums[0]) {
            return binarySearch(nums, target, 0, pivot - 1);
        }
        
        // CASE 4: Target is smaller than the first element, so it MUST be in the right half.
        return binarySearch(nums, target, pivot + 1, nums.length - 1);
    }

    // ==========================================
    // MODULE 2: Standard Binary Search
    // ==========================================
    static int binarySearch(int arr[], int target, int start, int end) { 
        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] == target) {
                return mid; // Found it!
            }
            if (arr[mid] < target) {  
                start = mid + 1; // Target is larger, search right
            } else { 
                end = mid - 1;   // Target is smaller, search left
            }
        }
        return -1; // Target not found
    }

    // ==========================================
    // MODULE 3: The Pivot Finder (The tricky part!)
    // ==========================================
    static int findPivot(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // THE 4 PIVOT CASES:
            
            // Case 1: Did we find the drop-off? (mid is greater than the next element)
            // Example: [7, 0] -> mid is 7, next is 0. 7 is the pivot!
            if (mid < end && arr[mid] > arr[mid + 1]) {  
                return mid;
            }
            
            // Case 2: Did we land just AFTER the drop-off? 
            // Example: [7, 0] -> mid is 0, previous is 7. 7 is the pivot!
            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }
            
            // Case 3: The left side is completely sorted.
            // If the element at mid is smaller than or equal to the start, 
            // it means the pivot MUST be in the left half somewhere.
            if (arr[mid] <= arr[start]) {
                end = mid - 1; // Eliminate the right side
            } 
            
            // Case 4: The left side is strictly increasing up to mid.
            // This means the drop-off (pivot) hasn't happened yet, so it MUST be to the right.
            else {
                start = mid + 1; // Eliminate the left side
            }
        }
        
        return -1; // No pivot found (array is completely sorted)
    }
}

//there is a better version that we will do in recursion