package Recursion;


public class numbersexamplerecursion {
    public static void main(String[] args) {
        //write a function that takes in a number and prints it 
        //print first 5 numbers:12345
        print(1);
    }

    static void print(int n){
        //base condition
        if(n==5){
            System.out.println(5);
            return;
        }
        System.out.println(n);

        // recursive call
        // if you are calling a funciton again and again , you can treat it as a separate call in the stack
        print(n+1);
    }

    
}
