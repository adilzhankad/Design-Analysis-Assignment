package sort;

import util.Metrics;

public class MergeSort {
    private static final int CUTOFF = 16; // если меньше → BubbleSort

    public static void sort(int[] arr, Metrics metrics) {
        int[] buffer = new int[arr.length];
        metrics.incAllocations(); // считаем одно выделение памяти
        mergeSort(arr, buffer, 0, arr.length - 1, metrics);
    }

    private static void mergeSort(int[] arr, int[] buffer, int l, int r, Metrics metrics) {
        if (r - l + 1 <= CUTOFF) {
            BubbleSort.sort(arr, l, r, metrics);
            return;
        }

        if (l < r) {
            metrics.enterRecursion();
            int mid = (l + r) / 2;

            mergeSort(arr, buffer, l, mid, metrics);
            mergeSort(arr, buffer, mid + 1, r, metrics);
            merge(arr, buffer, l, mid, r, metrics);

            metrics.exitRecursion();
        }
    }

    private static void merge(int[] arr, int[] buffer, int l, int mid, int r, Metrics metrics) {
        System.arraycopy(arr, l, buffer, l, r - l + 1);

        int i = l, j = mid + 1, k = l;
        while (i <= mid && j <= r) {
            metrics.incComparisons();
            if (buffer[i] <= buffer[j]) {
                arr[k++] = buffer[i++];
            } else {
                arr[k++] = buffer[j++];
            }
        }
        while (i <= mid) arr[k++] = buffer[i++];
        while (j <= r) arr[k++] = buffer[j++];
    }
}
