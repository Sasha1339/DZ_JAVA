package ru.mpei.DZ2;

import java.util.Arrays;

public class DZTwo {

    /**
     * Задан произвольный массив размера m. Необходимо отсоритировать его по возрастанию с помощью
     * пузырьковой сортировки, вывести отсортированный массив в консоль. После чего опредлеить медиану
     * полученного массива и вывести ее в консоль
     */

    public static void main(String[] args) {

        int[] array= {61, 8, 50, 21, 5, 18, 55, 16, 18, 21};

        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j+1]){
                    int change = array[j];
                    array[j] = array[j+1];
                    array[j+1] = change;
                }
            }
        }
        double median = 0;
        if (array.length % 2 == 0){
            int index = array.length / 2;
            median = (double) (array[index-1] + array[index]) / 2;
        }else{
            int index = array.length / 2;
            median = array[index];
        }
        System.out.println("Массив отсортированный");
        System.out.println(Arrays.toString(array));
        System.out.println("Медиана массива = "+median);

        System.out.println("//////////////////////////////////////////////////////////////////////");

        /**
         * Задано число типа int. Необходимо вывести его в консоль справа налево
         */

        int value = 4452272;

        int newValue = 0;
        boolean flag = true;

        while(flag){
            if (value % 10 == 0){
                flag = false;
            }else{
                newValue = (newValue * 10) + (value % 10);
                value = value / 10;
            }
        }
        System.out.println("Число наоборот");
        System.out.println(newValue);


        System.out.println("//////////////////////////////////////////////////////////////////////");

        int[] array2= {61, 8, 50, 21, 13, 80, 13, 500, 80, 88, 96, 77, 21};

        for (int i = array2.length - 1; i > 0; i--) {
            for (int j = 0; j < array2.length - i; j++) {
                if (array2[j] > array2[j+i]){
                    int change = array2[j];
                    array2[j] = array2[j+i];
                    array2[j+i] = change;
                }
            }
        }
        double median2 = 0;
        if (array2.length % 2 == 0){
            int index = array2.length / 2;
            median2 = (double) (array2[index-1] + array2[index]) / 2;
        }else{
            int index = array2.length / 2;
            median2 = array2[index];
        }
        System.out.println("Массив отсортированный");
        System.out.println(Arrays.toString(array2));
        System.out.println("Медиана массива = "+median2);

        System.out.println("//////////////////////////////////////////////////////////////////////");


    }



}
