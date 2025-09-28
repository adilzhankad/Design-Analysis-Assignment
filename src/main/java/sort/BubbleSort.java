package sort;

import util.Metrics;

public class BubbleSort {
    public static void sort(int[] arr, int left, int right, Metrics metrics) {
        for (int i = left; i <= right; i++) {
            for (int j = left; j < right - (i - left); j++) {
                metrics.incComparisons();
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    metrics.incSwaps();
                }
            }
        }
    }
}
