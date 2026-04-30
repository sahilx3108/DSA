package Recursion;

public class message {
    public static void main(String[] args) {
        //write a function that prints hello world
        message0();
    }

    static void message0(){
        System.out.println("hello world");
        message1();
    }

    static void message1(){
        System.out.println("hello world");
        message2();
    }

    static void message2(){
        System.out.println("hello world");
        message3();
    }

    static void message3(){
        System.out.println("hello world");
    }
    
}

