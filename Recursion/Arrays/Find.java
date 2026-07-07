package Recursion.Arrays;

import java.util.ArrayList;

public class Find {
    public static void main(String[] args) {
        int[] arr= {2,3,1,4,4,5};
        System.out.println(find(arr,4,0));
        System.out.println(findindex(arr,4,0));
        System.out.println(findindexlast(arr,4,arr.length-1));
        findAllindex(arr,4,0);
        System.out.println(list);
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

    static ArrayList<Integer> list= new ArrayList<>();

    static void findAllindex(int[] arr,int target,int index){
        if(index==arr.length){
            return ;
        }

        if( arr[index]==target){
            list.add(index);
        }
        
        findAllindex(arr, target, index+1);
    }
}
