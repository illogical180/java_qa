package ru.stqa.sandbox;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
public class Collections {

    public static void main(String[] args){
        String[] lengs = {"Java","C#","Python","PHP"};

        List<String> languages = Arrays.asList("Java","C#","PHP","Python");


        for (String l : languages){
            System.out.println("I wanna learn "+l);
        }


    }
}
