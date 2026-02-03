package binarySearch;

public class InfiniteSearch {
    public static void main(String args[]){
        int[] arr={3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 29, 31, 33, 35, 37, 39, 41, 43, 45, 47, 49, 51, 53, 55, 57, 59, 61, 63, 65, 67, 69, 71, 73, 75, 77, 79, 81, 83, 85, 87, 89, 91, 93, 95, 97, 99, 101, 103, 105, 107, 109, 111, 113, 115, 117, 119, 121, 123, 125, 127, 129, 131, 133, 135, 137, 139, 141, 143, 145, 147, 149, 151, 153, 155, 157, 159, 161, 163, 165, 167, 169, 171, 173, 175, 177, 179, 181, 183, 185, 187, 189, 191, 193, 195, 197, 199, 201};
        int target=101;
        System.out.println(ans(arr, target));
        
    }
    static int ans(int []arr,int target){
        //first find the range 
        //first start with a box of size 2 
        int start=0;
        int end=1;
        
        //condition for string to lie in the range  
        while (target>arr[end]){
            
            //double the box value
            // end = previous end + sizeofbox*2
            // eg . arr={1,2,4,6,7,9,13,15,18,20,23,27,29,30}
            // starting me 0 aur1 to index liye jinka size 2 hai 
            //uske baad humne box ka size double kar diya jaisa hum binary search me karte hai (bhale 2 se divide karte karte target dhundo ya phir 2 se multiply (chhote se bada karo ya phir bade se chhota ) time complexity log(n) hi aani hai )
            //aur sizeofbox ka formula hai (end-start+1)
            //so next end would be 1(previous end) + (1-0+1)*2 =5

            int temp=end+1; //this is my new start
            end=end+(end-start+1)*2;
            start=temp;
        }
        return binarySearch(arr, target, start, end);
    }

    public static int binarySearch(int arr[],int target,int start,int end){
        while(start<=end){
            int mid= start+ (end-start)/2;

            // comparisions
            if(target<arr[mid]){
                end=mid-1;
            }
            if(target>arr[mid]){  
                start=mid+1;
            }
            else{ 
                return mid;
            }
        }
        return -1;
    }
    
}
