package org.example;

import java.util.Scanner;

import static org.example.Main.prepareArray;
import static org.example.Main.printArray;

public class Ex2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = prepareArray(n);
        printArray(arr);
        int startPosition, endPosition;
        startPosition = 0;
        endPosition = arr.length - 1;
        quickSort(arr, startPosition, endPosition);
        printArray(arr);
    }

    /**
     * @apiNote быстрая сортировка
     * @param arr входной массив
     * @param startPosition начальная позиция
     * @param endPosition конечная позиция
     */
    public static void quickSort(int[] arr, int startPosition, int endPosition) {
        int left = startPosition;
        int right = endPosition;
        int pivot = arr[(startPosition + endPosition) / 2];
        do {
            while (arr[left] < pivot) {
                left++;
            }
            while (arr[right] > pivot) {
                right--;
            }
            if (left <= right){
                if (left != right){
                    int temp = arr[left];
                    arr[left] = arr[right];
                    arr[right] = temp;
                }
                left++;
                right--;
            }
        } while (left <= right);
        if (left < endPosition) {
            quickSort(arr, left, endPosition);
        }
        if (startPosition < right) {
            quickSort(arr, startPosition, right);
        }
    }

}
