package ru.stqa.sandbox;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
public class Collections {

    public static void main(String[] args){
        String[] lengs = {"Java","C#","Python","PHP"};

        List languages = Arrays.asList("Java","C#","PHP","Python");


        for (Object l : languages){
            System.out.println("I wanna learn "+languages.get(l));
        }


    }
}
