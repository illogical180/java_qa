package ru.stqa.sandbox;

public class HelloWorld {

public static void main (String[] args) {

hello("Worlds");
hello("Seas");
Square s = new Square(5);
Rectangle r = new Rectangle(5,6);
Point p1 = new Point();
Point p2 = new Point();
p1.x = -5;
p1.y = 1;
p2.x = 1;
p2.y = 7;
    System.out.println("Расстояние между точками равно " + distance(p1,p2));
    System.out.println("Площадь квадрата со стороной " +s.l+ " равна " +s.area());
    System.out.println("Площадь прямоугольника со стороной " +r.a+ " и " +r.b+ " равна " +r.area());

}
public static double distance(Point p1, Point p2){
    return Math.sqrt((p1.x-p2.x)*(p1.x-p2.x) + (p1.y-p2.y)*(p1.y-p2.y));
}
public static void hello(String somebody ){
    System.out.println("Hello " + somebody);
}


}