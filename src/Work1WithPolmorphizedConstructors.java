public class Work1WithPolmorphizedConstructors {
    public static void main(String[] args) {
        //Constructor without inputs
        MyClass object1 = new MyClass();

        //Constructor one input
        MyClass object2 = new MyClass(12);

        //Constructor two inputs
        MyClass object3 = new MyClass(12, 13);

        //Constructor two inputs
        MyClass object4 = new MyClass(12, 13, "hello");

        //Constructor two inputs
        MyClass object5 = new MyClass(12, 13, "hello", ", world!");
    }
}


