/*
Сделать программу,в которой реализован класс для работы с правильным
многоугольником.Класс должен содержать методы его создания(определение
координат вершин),а также вычисления его периметра и площади.Подумайте.
*/

/*
Make a program that implements a class for working with a regular polygon.
The class must contain methods for creating it (determining the coordinates
of the vertices), as well as calculating its perimeter and area.Think about it.
*/

import java.util.Scanner;

public class Work2AboutPolygons {
    public static void main(String[] args) {
        Scanner Scan = new Scanner(System.in);
        double[] input = {5, 5};

        RegularPolygon Triangle = new RegularPolygon("Triangle",3, 10, input);
        System.out.println("\n----------------------------");
        /*System.out.println(" Perimeter = " + Triangle.Perimeter());
        System.out.println(" Area = " + Triangle.Area() + "\n");*/

        RegularPolygon Square = new RegularPolygon("Square",4, 10, input);
        /*System.out.println(" Perimeter = " + Rectangle.Perimeter());
        System.out.println(" Area = " + Rectangle.Area() + "\n");*/
        System.out.println("\n----------------------------");

        RegularPolygon Pentagon = new RegularPolygon("Pentagon",5, 10, input);
        /*System.out.println(" Perimeter = " + Pentagon.Perimeter());
        System.out.println(" Area = " + Pentagon.Area() + "\n");*/
        System.out.println("\n----------------------------");

        RegularPolygon Hexagon = new RegularPolygon("Hexagon",6, 10, input);
        /*System.out.println(" Perimeter = " + Hexagon.Perimeter());
        System.out.println(" Area = " + Hexagon.Area() + "\n");*/
        System.out.println("\n----------------------------");

        RegularPolygon Heptagon = new RegularPolygon("Heptagon",7, 10, input);
        System.out.println("\n----------------------------");

        RegularPolygon Octagon = new RegularPolygon("Octagon",8, 10, input);
        System.out.println("\n----------------------------");

        RegularPolygon Nonagon = new RegularPolygon("Nonagon",9, 10, input);
        System.out.println("\n----------------------------");
    }
}
