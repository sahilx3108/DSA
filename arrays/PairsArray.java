// eg= arr=[2,4,6,8,10]

// pairs = (2,4) (2,6) (2,8) (2,10)
//         (4,6) (4,8) (4,10) 
//         (6,8) (6,10)
//         (8,10)
package arrays;

public class PairsArray {
    public static void PrintPair(int numbers[]){
        int tp=0;
        for(int i=0;i<numbers.length;i++){
            int curr=numbers[i];
            for(int j=i+1;j<numbers.length;j++){
                System.out.print("("+curr+","+numbers[j]+")");
                tp++;
            }
            System.out.println();
        }
        System.out.println(tp);
    }
    public static void main(String args[]){
        int numbers[]={2,4,6,8,10};
        PrintPair(numbers);

        }
}
