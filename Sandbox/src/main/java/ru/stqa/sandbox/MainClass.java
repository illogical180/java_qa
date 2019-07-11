package ru.stqa.sandbox;

public class MainClass {

public static void main (String[] args) {

Point p1 = new Point();
Point p2 = new Point();
p1.x = -5;
p1.y = 1;
p2.x = 1;
p2.y = 7;
    System.out.println("Расстояние между точками равно " + distance(p1,p2));

}
public static double distance(Point p1, Point p2){
    return Math.sqrt((p1.x-p2.x)*(p1.x-p2.x) + (p1.y-p2.y)*(p1.y-p2.y));
}


}