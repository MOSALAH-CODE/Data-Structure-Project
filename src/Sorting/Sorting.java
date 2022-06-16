package Sorting;

import java.util.Arrays;

class Sorting {

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i -1; j++) {
                if (arr[j] > arr[j+1])
                    swap(arr, j, j+1);
            }
        }
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[min] > arr[j]){
                    min = j;
                }
            }
            swap(arr, i, min);
        }
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int j = i -1;
            while (j >= 0 && arr[j] > current){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = current;
        }
    }

    public static void mergeSort(int[] arr){
        int len = arr.length;
        if (len <= 1)
            return;

        int mid = len / 2;
        int[] leftArr = new int[mid];
        int[] rightArr = new int[len - mid];

        int j = 0;

        for (int i = 0 ; i < len; i++) {
            if (i < mid)
                leftArr[i] = arr[i];
            else {
                rightArr[j] = arr[i];
                j++;
            }
        }
        mergeSort(leftArr);
        mergeSort(rightArr);
        merge(arr, leftArr, rightArr);
    }
    private static void merge(int[] arr, int[] leftArr, int[] rightArr){
        int leftLen = leftArr.length;
        int rightLen = rightArr.length;
        int i = 0, l = 0, r = 0;

        while (l < leftLen && r < rightLen){
            if (leftArr[l] < rightArr[r]){
                arr[i] = leftArr[l];
                i++;
                l++;
            }else {
                arr[i] = rightArr[r];
                i++;
                r++;
            }
        }

        while (l < leftLen){
            arr[i] = leftArr[l];
            i++;
            l++;
        }
        while (r < rightLen){
            arr[i] = rightArr[r];
            i++;
            r++;
        }



    }

    public static void quickSort(int[] arr){
        quickSort(arr, 0, arr.length-1);
    }
    public static void quickSort(int[] arr, int start, int end){
        if (end <= start)
            return;

        int pivot = partition(arr, start, end);
        quickSort(arr, start, pivot - 1);
        quickSort(arr, pivot + 1, end);
    }
    public static int partition(int[] arr, int start, int end){
        int pivot = arr[end];
        int i = start - 1;

        for (int j = start; j < end ; j++) {
            if (arr[j] < pivot){
                i++;
                swap(arr, i, j);
            }
        }
        i++;
        swap(arr, i, end);
        return i;
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {2, 8, 4, 1, 3};

        Sorting.quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
