package sort;

import util.Metrics;
import java.util.Random;

public class QuickSort {
    private static final Random RAND = new Random();

    public static void sort(int[] arr, Metrics metrics) {
        quicksort(arr, 0, arr.length - 1, metrics);
    }

    private static void quicksort(int[] arr, int left, int right, Metrics metrics) {
        while (left < right) {
            metrics.enterRecursion();

            // выбираем pivot случайно
            int pivotIndex = left + RAND.nextInt(right - left + 1);
            int pivot = arr[pivotIndex];
            swap(arr, pivotIndex, right, metrics);

            // partition
            int p = partition(arr, left, right, pivot, metrics);

            metrics.exitRecursion();

            // выбираем меньший подмассив для рекурсии
            if (p - left < right - p) {
                quicksort(arr, left, p - 1, metrics); // рекурсивно меньший
                left = p + 1; // а больший делаем итеративно
            } else {
                quicksort(arr, p + 1, right, metrics);
                right = p - 1;
            }
        }
    }

    private static int partition(int[] arr, int left, int right, int pivot, Metrics metrics) {
        int i = left;
        for (int j = left; j < right; j++) {
            metrics.incComparisons();
            if (arr[j] < pivot) {
                swap(arr, i, j, metrics);
                i++;
            }
        }
        swap(arr, i, right, metrics);
        return i;
    }

    private static void swap(int[] arr, int i, int j, Metrics metrics) {
        if (i != j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            metrics.incSwaps();
        }
    }
}
