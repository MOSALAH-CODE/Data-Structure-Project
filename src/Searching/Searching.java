package Searching;

import java.util.Arrays;
import java.util.Random;

public class Searching {

    public static int linearSearch(int[] arr, int target){
        for (int i = 0; i < arr.length; i++) {
            if (target == arr[i])
                return i;
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int value = arr[mid];

            System.out.println("middle value: " + value);

            if (target < value) high = mid - 1;
            else if (value < target) low = mid + 1;
            else{
                System.out.println("Element Found at " + mid + " index!");
                return mid;
            }
        }
        return -1;
    }
    private static int interpolationSearch(int[] array, int target) {
        int high = array.length - 1;
        int low = 0;

        while(target >= array[low] && target <= array[high] && low <= high) {
            int probe = low + (high - low) * (target - array[low]) /
                    (array[high] - array[low]);
//            System.out.println("probe: " + probe);

            if(array[probe] == target) return probe;
            else if(target < array[probe]) high = probe - 1;
            else low = probe + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[100];
//        int[] arr = new int[999999999];
        Random random = new Random();

        long start, elapsedTime;
        double elapsedTimeInSecond;
        for (int i = 0; i < arr.length; i++) {
//            arr[i] = random.nextInt(1000000);
            arr[i] = i*i;
        }
        System.out.println(Arrays.toString(arr));

//        start = System.nanoTime();
//        System.out.println("Index: " + Searching.linearSearch(arr, 1089));
//        elapsedTime = System.nanoTime() - start;
//        elapsedTimeInSecond  = (double) elapsedTime / 1_000_000_000;
//        System.out.println("Linear Search Elapsed Time In Second " + elapsedTimeInSecond);

//        start = System.nanoTime();
//        Searching.binarySearch(arr, 999999999);
//        elapsedTime = System.nanoTime() - start;
//        elapsedTimeInSecond  = (double) elapsedTime / 1_000_000_000;
//        System.out.println("Binary Search Elapsed Time In Second " + elapsedTimeInSecond);
//
//        start = System.nanoTime();
//        System.out.println(Searching.interpolationSearch(arr, 1089));
//        elapsedTime = System.nanoTime() - start;
//        elapsedTimeInSecond  = (double) elapsedTime / 1_000_000_000;
//        System.out.println("Interpolation Search Elapsed Time In Second " + elapsedTimeInSecond);

    }

}
