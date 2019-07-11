package ru.stqa.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class EquationTest {
    public void test0(){
        Equation e = new Equation(1,1,1);
        Assert.assertEquals(e.rootNumber(),0);
    }
    public void test1(){
        Equation e = new Equation(1,2,1);
        Assert.assertEquals(e.rootNumber(),1);
    }
    public void test2(){
        Equation e = new Equation(1,5,6);
        Assert.assertEquals(e.rootNumber(),2);
    }
    public void linear(){
        Equation e = new Equation(0,1,1);
        Assert.assertEquals(e.rootNumber(),1);
    }
    public void constant(){
        Equation e = new Equation(0,0,1);
        Assert.assertEquals(e.rootNumber(),0);
    }
    public void zeroTest(){
        Equation e = new Equation(0,0,0);
        Assert.assertEquals(e.rootNumber(),-1);
    }
}


