public class Patterns {
    public static void hollow_rectangle(int totrows, int totcols){
      //outer loop
        for(int i=1;i<=totrows;i++){
        //inner -columns
            for(int j=1;j<=totcols;j++){
                //cell - (i,j)
                if(i==1 || i== totrows || j==1 || j==totcols){
                    //boundry cells
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    public static void main(String argsp[]){
        hollow_rectangle(4,5);
    }
}


    