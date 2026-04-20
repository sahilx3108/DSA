package StringsandStringBuilderinJava;

import java.util.Arrays;

public class Methods {
    public static void main(String[] args) {
        String name= "Sahil Kumar";
        System.out.println(Arrays.toString(name.toCharArray()));//what this line does is it converts the string into a character array and then it prints the character array in a readable format using Arrays.toString() method so the output will be [S, a, h, i, l,  , K, u, m, a, r]
        System.out.println(name.toLowerCase());//sahil kumar
        System.out.println(name.toUpperCase());//SAHIL KUMAR
        System.out.println(name);//the original string will not change because strings are immutable in java so the toLowerCase() and toUpperCase() methods will return a new string with the modified case but the original string will remain unchanged so when we print the original string it will still be "Sahil Kumar"
        System.out.println(name.indexOf('a'));//1 the indexOf() method returns the index of the first occurrence of the specified character in the string so in this case the first occurrence of 'a' is at index 1 (0-based index) so it will return 1
        System.out.println("     sahil     ".strip());//the strip() method removes the leading and trailing whitespace from the string so in this case it will remove the leading and trailing spaces from the string "     sahil     " and return "sahil"
    }
}
