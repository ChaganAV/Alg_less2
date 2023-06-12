package org.example;

import java.util.Arrays;
import java.util.Date;

import static org.example.Main.prepareArray;

public class Ex3 {
    public static void main(String[] args) {
        for (int i = 10_000; i < 100_000; i+=10_000) {
            int[] arr = prepareArray(i);
            Date start = new Date();
            Main.bibleSort(Arrays.copyOf(arr, arr.length));
            Date end = new Date();
            long diff = end.getTime() - start.getTime();
            System.out.println(diff);

            Date start2 = new Date();
            Ex2.quickSort(Arrays.copyOf(arr, arr.length), 0, arr.length - 1);
            Date end2 = new Date();
            long diff2 = end2.getTime() - start2.getTime();
            System.out.println(diff2);
            System.out.println("===============");
        }
    }
}
