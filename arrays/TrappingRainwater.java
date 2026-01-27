// Given a non-negative integers representing an elevation map where width of each bar is 1 ,compute how much water can be trapped after raining 
    //              __
    //             |  |      __
    //     __      |  |     |  |
    //    |  |     |  |__   |  |
    //    |__|__   |  |  |__|  |
    //    |  |  |  |  |  |  |  |
    //    |  |  |  |  |  |  |  |
    //     4  2  0  6  3  2   5   bar height
    //     0  2  4  0  2  3   0   water stored 

    //    the formula used is  (water level- barleve/height)*width

    // water level = min(max left boundary,max right boundary)


    
    // first thing =if bars are only one or two , water will get spilled 
    // eg.
    //     __
    //    |  |
    //    |  |  1 bar 


    //     __
    //    |  |
    //    |  |__
    //    |  |  |     2 bars 


package arrays;

public class TrappingRainwater {
    
    public static int trappedRainwotah(int height[]){
        int n=height.length;
        //calculate left max boundary-array 
        int leftMax[]=new int[n];
        leftMax[0]=height[0];
        for(int i=1;i<n;i++){
            leftMax[i]=Math.max(height[i],leftMax[i-1]);
        }

        //Calculate right max boundary -array
        int rightMax[]=new int[n];
        rightMax[n-1]=height[n-1];
        for(int i=n-2;i>=0;i--){
            rightMax[i]= Math.max(height[i],rightMax[i+1]); 
        }

        int trappedWater=0;
        //loop
        for(int i=0;i<n;i++){
            //waterLevel=min(leftMax bound , rightmax bound)
            int waterLevel=Math.min(leftMax[i],rightMax[i]);
            //trapped water=waterLevel-height[i]
            trappedWater+=waterLevel-height[i];
        }

        return trappedWater;

    }
    public static void main(String args[]){
        int height[]={4,2,0,6,3,2,5};
        System.out.println(trappedRainwotah(height));

    }
}
 