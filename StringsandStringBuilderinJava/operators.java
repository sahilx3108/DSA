package StringsandStringBuilderinJava;

import java.util.ArrayList;

public class operators {
    public static void main(String[] args) {
        System.out.println('a'+'b'); //195 converting the characters in its acsii value and adding it so 195 will get printed
        System.out.println("a"+"b");//ab
        System.out.println((char)('a'+3)); //d  'a' + 3 will give me 100 and d's ascii value is 100 so d will be printed

        System.out.println("a"+1);
        //this is same as after a few steps : "a"+ "1"
        //integer will be converted to integer that will call toString()

        System.out.println("Kunal" + new ArrayList<>());
        System.out.println("Kunal"+ new Integer(56));
        // System.out.println( new Integer(56) + new ArrayList<>()); //in java + operator is defined to do only 2 things 1. numeric addition: if both operands are numbers (int double or wrappers like Integer) 2 . String concatination . in this code left side and right side are object (integer and list object) so neither is string so rule 2 breaks ,but rule 1 also breaks because arraylist is a data structure not a number so it wont even get added so it will give error like error: bad operand types for binary operator '+'
    }
}
