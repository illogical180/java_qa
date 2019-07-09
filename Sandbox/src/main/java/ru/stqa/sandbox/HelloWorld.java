package ru.stqa.sandbox;

public class HelloWorld {

public static void main (String[] args) {
hello("Worlds");
hello("Seas");
Square s = new Square(5);
Rectangle r = new Rectangle(5,6);
    System.out.println("Площадь квадрата со стороной " +s.l+ " равна " +s.area());
    System.out.println("Площадь прямоугольника со стороной " +r.a+ " и " +r.b+ " равна " +r.area());

}
public static void hello(String somebody ){
    System.out.println("Hello " + somebody);
}


}