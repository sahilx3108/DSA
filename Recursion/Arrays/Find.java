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

        // ArrayList<Integer> ans= findAllindex(arr, 4, 0, new ArrayList<>());
        // System.out.println(ans);

        System.out.println(findAllindex2(arr, 4, 0));
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

    static ArrayList<Integer> findAllindex2(int[] arr,int target,int index){
        
        ArrayList<Integer> list= new ArrayList<>();
        
        if(index==arr.length){
            return list;
        }

        //this will contain answer for that function call only
        if( arr[index]==target){
            list.add(index);
        }
        
       ArrayList<Integer> ansFromBelowCalls=  findAllindex2(arr, target, index+1);

       list.addAll(ansFromBelowCalls);

       return list;
    }
}
