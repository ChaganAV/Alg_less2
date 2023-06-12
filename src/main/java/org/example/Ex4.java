package org.example;

import java.util.Scanner;

import static org.example.Ex2.quickSort;
import static org.example.Main.prepareArray;
import static org.example.Main.printArray;

public class Ex4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = prepareArray(n);
        printArray(arr);
        int startPosition = 0;
        int endPosition = arr.length - 1;
        quickSort(arr, startPosition, endPosition);
        printArray(arr);
        int value = scanner.nextInt();
        System.out.println("binarySearch(arr, value, 0, arr.length - 1) = " + binarySearch(arr, value, 0, arr.length - 1));
    }

    /**
     * @apiNote бинарный поиск
     * @param arr входной массив
     * @param value искомое значение
     * @param left левая граница
     * @param right правая граница
     * @return индекс элемента
     */
    private static int binarySearch(int[] arr, int value, int left, int right) {
        int mid;
        if (right < left) {
            return -1;
        } else {
            mid = (right - left) / 2 + left;
        }

        if (value > arr[mid]) {
            return binarySearch(arr, value, mid + 1, right);
        } else if (value < arr[mid]) {
            return binarySearch(arr, value, left, mid - 1);
        } else {
            return mid;
        }
    }
}
