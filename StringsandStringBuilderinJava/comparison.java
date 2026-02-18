package StringsandStringBuilderinJava;

public class comparison {
    public static void main(String[] args) {
        String a= "Sahil";
        String b= "Sahil";

        // using == (comparator operator)
        System.out.println(a==b); //(would return true)

        String name1= new String("Sahil");
        String name2= new String("Sahil");
        
        System.out.println(name1==name2);// would return false

        System.out.println(name1.equals(name2)); //would return true (because it is only want to check the values)
    }
}
