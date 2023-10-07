package ru.mpei.DZ3;

import java.util.ArrayList;
import java.util.List;

public class CreateArray {
    public static void main(String[] args) {
        List<Double> array = new ArrayList<>();

        for(double i = 0; i < 100; i += 0.4){
            array.add(Math.sin(i*180/(2*Math.PI)));
        }
        System.out.println(array);

    }
}
