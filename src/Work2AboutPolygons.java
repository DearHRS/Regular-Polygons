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

        /*System.out.println("60 = " + Funx.DegreesToRadians(60));
        System.out.println("90 = " + Funx.DegreesToRadians(90));
        System.out.println("120 = " + Funx.DegreesToRadians(120));
        System.out.println("180 = " + Funx.DegreesToRadians(180));*/

        RegularPolygon Triangle = new RegularPolygon(3, 10, input);
        /*System.out.println(" Perimeter = " + Triangle.Perimeter());
        System.out.println(" Area = " + Triangle.Area() + "\n");*/

        RegularPolygon Rectangle = new RegularPolygon(4, 10, input);
        /*System.out.println(" Perimeter = " + Rectangle.Perimeter());
        System.out.println(" Area = " + Rectangle.Area() + "\n");*/

        RegularPolygon Pentagon = new RegularPolygon(5, 10, input);
        /*System.out.println(" Perimeter = " + Pentagon.Perimeter());
        System.out.println(" Area = " + Pentagon.Area() + "\n");*/

        RegularPolygon Hexagon = new RegularPolygon(6, 10, input);
        /*System.out.println(" Perimeter = " + Hexagon.Perimeter());
        System.out.println(" Area = " + Hexagon.Area() + "\n");*/

        RegularPolygon Heptagon = new RegularPolygon(7, 10, input);

        RegularPolygon Octagon = new RegularPolygon(8, 10, input);
    }
}
