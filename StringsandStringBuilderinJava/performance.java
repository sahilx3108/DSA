// package StringsandStringBuilderinJava;

// public class performance {
//     public static void main(String[] args) {
//         String series= "";
//         for (int i=0;i<26;i++){
//             char ch=(char)('a'+i);
//             series=series+ch;//series+=ch
//         }
//         System.out.println(series); 
//     }
// }
 //there is one problem with this code that is it will create 26 string objects in the memory and each time we will add a character to the string it will create a new string object and copy the old string and add the new character to it so it will take more time and memory as well so this is not a good way to concatenate strings in java.

//to solve this problem we can use StringBuilder class which is a mutable class and it will not create new string object every time we will add a character to it it will just modify the existing string object and add the new character to it so it will take less time and memory as well.

// package StringsandStringBuilderinJava;
// public class performance {
//     public static void main(String[] args) {
//         StringBuilder series= new StringBuilder();
//         for (int i=0;i<26;i++){
//             char ch=(char)('a'+i);
//             series.append(ch);
//         }
//         System.out.println(series); 
//     }
// }

//in this code we are using StringBuilder class and its append() method to add characters to the string builder object and it will not create new string object every time we will add a character to it it will just modify the existing string object and add the new character to it so it will take less time and memory as well.
// other methods of StringBuilder class are insert(), delete(), reverse() etc. which can be used to manipulate the string builder object in different ways.

package StringsandStringBuilderinJava;
public class performance {
    public static void main(String[] args) {
        StringBuilder series= new StringBuilder();
        for (int i=0;i<26;i++){
            char ch=(char)('a'+i);
            series.append(ch);
        }
        System.out.println(series); 

        series.deleteCharAt(0);
        System.out.println(series);
        series.insert(0, 'z');
        System.out.println(series);
        series.reverse();
        System.out.println(series);
    }
}
