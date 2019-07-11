package ru.stqa.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

import static ru.stqa.sandbox.MainClass.distance;


public class PointTests {

    @Test
    public void testDistance1(){
        Point p1 = new Point(1,0);
        Point p2 = new Point(2,0);
        Assert.assertEquals(distance(p1,p2), 1);
    }
    @Test
    public void testDistance2(){
        Point p1 = new Point(1,0);
        Point p2 = new Point(-6,0);
        Assert.assertEquals(distance(p1,p2), 7);
    }
    @Test
    public void testDistance3(){
        Point p1 = new Point(0,3);
        Point p2 = new Point(4,0);
        Assert.assertEquals(distance(p1,p2), 5);
    }
}
