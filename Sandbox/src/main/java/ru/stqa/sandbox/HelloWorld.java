package ru.stqa.sandbox;

public class HelloWorld {

public static void main (String[] args) {
hello("Worlds");
hello("Seas");
double l =5;
    System.out.println("Площадь квадрата со стороной " +l+ " равна " +area(l));
    double a = 6;
    double b = 5;
    System.out.println("Площадь прямоугольника со стороной " +a+ " и " +b+ " равна " +area(a,b));

}
public static void hello(String somebody ){
    System.out.println("Hello " + somebody);
}
public static double area(double len) {
    return len*len;
}
public static double area(double a, double b){
    return a*b;
}
}