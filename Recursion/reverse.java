package Recursion;

public class reverse {
    public static void main(String[] args) {
        rev1(1234);
        System.out.println(sum);
    }

    static int sum =0;
    static void rev1(int n){
        if(n==0){
            return;
        }
        int rem= n%10;
        sum =sum * 10 +rem;
        rev1(n/10);
    }

    static int rev2(int n){
          //sometimes you might need some additional variables in the argument
          // in that case , make another function
          int digits =(int) (Math.log10(n))+1;
          return helper (n,digits);
    }
}
