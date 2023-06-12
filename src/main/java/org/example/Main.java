package org.example;

import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final Random random = new Random();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = prepareArray(n);
        printArray(arr);
        bibleSort(arr);
        printArray(arr);
    }

    /**
     * @apiNote массив сортировки пузырьком
     * @param arr
     */
    public static void bibleSort(int[] arr) {
        boolean flag;
        do {
            flag = false;
            for (int i = 0; i < arr.length-1; i++) {
                if(arr[i]>arr[i+1]){
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    flag = true;
                }
            }
        }while(flag);
    }

    /**
     * @apiNote распечатываем массив в консоль
     * @param arr входной массив
     */
    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.printf("%d ",i);
        }
        System.out.println();
    }

    /**
     * @apiNote формируем массив из рандомных чисел
     * @param length длинна массива
     * @return массив
     */
    public static int[] prepareArray(int length) {
        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }
        return arr;
    }

}