package Recursion.Arrays;

import java.util.ArrayList;

public class Find {
    public static void main(String[] args) {
        int[] arr= {2,3,1,4,4,5};
        // System.out.println(find(arr,4,0));
        // System.out.println(findindex(arr,4,0));
        // System.out.println(findindexlast(arr,4,arr.length-1));
        // findAllindex(arr,4,0);
        // System.out.println(list);

        ArrayList<Integer> ans= findAllindex(arr, 4, 0, new ArrayList<>());
        System.out.println(ans);
    }

    static boolean find(int[] arr,int target,int index){
        if(index==arr.length){
            return false;
        }

        
        return arr[index]==target || find(arr,target,index+1);
        }
    

    static int findindex(int[] arr,int target,int index){
        if(index==arr.length){
            return -1;
        }

        if( arr[index]==target){
            return index;
        }
        else{

        
        return findindex(arr,target,index+1);
        }
    }

    static int findindexlast(int[] arr,int target,int index){
        if(index==-1){
            return -1;
        }

        if( arr[index]==target){
            return index;
        }
        else{

        
        return findindex(arr,target,index- 1);
        }
    }
    

    static ArrayList<Integer> findAllindex(int[] arr,int target,int index,ArrayList<Integer> list){
        if(index==arr.length){
            return list;
        }

        if( arr[index]==target){
            list.add(index);
        }
        
       return findAllindex(arr, target, index+1,list);
    }
}
