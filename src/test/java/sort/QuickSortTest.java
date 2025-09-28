package sort;

import org.junit.jupiter.api.Test;
import util.Metrics;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class QuickSortTest {

    @Test
    void testQuickSortRandom() {
        int[] arr = {9, 4, 7, 3, 10, 5};
        int[] expected = {3, 4, 5, 7, 9, 10};

        Metrics metrics = new Metrics();
        QuickSort.sort(arr, metrics);

        assertArrayEquals(expected, arr);
    }

    @Test
    void testQuickSortSorted() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};

        Metrics metrics = new Metrics();
        QuickSort.sort(arr, metrics);

        assertArrayEquals(expected, arr);
    }

    @Test
    void testQuickSortReverse() {
        int[] arr = {5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5};

        Metrics metrics = new Metrics();
        QuickSort.sort(arr, metrics);

        assertArrayEquals(expected, arr);
    }
}
