
//  BRUTE FORCE APPROACH (n^3 time complexity)
// package arrays;

// public class MaxSubarraySum {
//     public static void printSub(int numbers[]){
//         int currSum=0;
//         int maxSum=Integer.MIN_VALUE;

//         for(int i=0;i<numbers.length;i++){
//             int start=i;
//             for(int j=i;j<numbers.length;j++){
//                 int end=j;
//                 currSum=0;
//                 for(int k=start;k<=end;k++){
//                     currSum+=numbers[k];                    
//                 }
//                 System.out.println(currSum);
//                 if(maxSum<currSum){
//                     maxSum=currSum;
//                 }
//             }
//         }
//         System.out.println("Maximum sum of subarrays"+maxSum);

//     }

//     public static void main(String args[]){
//         int numbers[]={2,4,6,8,10};
//         printSub(numbers);


//     }
// }



// PREFIX SUM METHOD (n^2 time complexity)

// package arrays;

// public class MaxSubarraySum{
//     public static void printSub(int numbers[]){
//         int currSum=0;
//         int maxSum=Integer.MIN_VALUE;
//         int prefix[]=new int [numbers.length];

//         // calculate prefix array
//         prefix[0]=numbers[0];
//         for (int i=1;i<prefix.length;i++){
//             prefix[i]=prefix[i-1]+ numbers[i];
//         }

//         for(int i=0;i<numbers.length;i++){
//             int start=i;
//             for(int j=i;j<numbers.length;j++){
//                 int end=j;
//                 currSum= start ==0 ? prefix[end] : prefix[end]-prefix[i-1];
//                 System.out.println(currSum);
//                 if(maxSum<currSum){
//                     maxSum=currSum;
//                 }
//             }
//         }
//         System.out.println("Maximum sum of subarrays(prefix)"+maxSum);

//     }

//     public static void main(String args[]){
//         int numbers[]={-2, -3, 4, -1, -2, 1, 5, -3};
//         printSub(numbers);


//     }

// }



// KADANE'S ALGORITHM(n time complexity)

// positive +positive =positive 

// big positive + small negative = positive 

// small positive + big negative = negative 

// so kadane said to change the negative number to 0

// so for example take an array

//             arr = -2 -3  4 -1 -2  1  5 -3
// CS(current sum) =  0  0  4  3  1  2  7  4
// MS(maximum sum) =  0  0  4  4  4  4  7  7

// so here we can say that subarray from 4 to 5 in array will give max value 


// package arrays;

// public class MaxSubarraySum{
//     public static void kadanes(int numbers[]){
//          int ms= Integer.MIN_VALUE;
//          int cs=0;

//          for (int i=0;i<numbers.length;i++){
//             cs=cs+numbers[i];
//             if(cs<0){
//                 cs=0;
//             }
//             ms=Math.max(cs,ms);
//          }
//          System.out.println("our max subarray sum is :" + ms);

//          }

//     public static void main(String args[]){
//         int numbers[]= {-2, -3, 4, -1, -2, 1, 5, -3};
//         kadanes(numbers);
//     }
// }