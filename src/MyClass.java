public class MyClass{
    double Re, Im;
    String dummy, dummier;

    //outputs all attributes
    void show(){
        System.out.println("\nAttributes of object:" +
                           "\n      Re = " + Re +
                           "\n      Im = " + Im +
                           "\n   dummy = " + dummy +
                           "\n dummier = " + dummier);
    }

    //Constructor without inputs
    public MyClass(){
        Re = 0;
        Im = 0;
        dummy = "zero";
        dummier = "inputs";

        show();
    }

    //Constructor with one input
    public MyClass(double x){
        Re = x;
        Im = x;
        dummy = "one";
        dummier = "input";

        show();
    }

    //Constructor with two inputs
    public MyClass(double x, double y){
        Re = x;
        Im = y;
        dummy = "two";
        dummier = "inputs";

        show();
    }

    //Constructor with three inputs
    public MyClass(double x, double y, String dummy){
        Re = x;
        Im = y;
        this.dummy = dummy;
        dummier = "three inputs";

        show();
    }

    //Constructor with four inputs
    public MyClass(double x, double y, String dummy, String dummier){
        Re = x;
        Im = y;
        this.dummy = dummy;
        this.dummier = dummier;

        show();
    }
}
