package sort;

import org.junit.jupiter.api.Test;
import util.Metrics;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MergeSortTest {

    @Test
    void testMergeSortSmallArray() {
        int[] arr = {5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5};

        Metrics metrics = new Metrics();
        MergeSort.sort(arr, metrics);

        assertArrayEquals(expected, arr);
    }

    @Test
    void testMergeSortLargeArray() {
        int[] arr = {10, 7, 8, 9, 1, 5};
        int[] expected = {1, 5, 7, 8, 9, 10};

        Metrics metrics = new Metrics();
        MergeSort.sort(arr, metrics);

        assertArrayEquals(expected, arr);
    }
}
