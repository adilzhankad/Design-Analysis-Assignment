package select;

import org.junit.jupiter.api.Test;
import util.Metrics;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeterministicSelectTest {

    @Test
    void testSelectSmall() {
        int[] arr = {7, 2, 1, 6, 8, 5, 3, 4};
        Metrics metrics = new Metrics();

        int val = DeterministicSelect.select(arr, 3, metrics); // 4-й элемент в отсортированном массиве
        Arrays.sort(arr);
        assertEquals(arr[3], val);
    }

    @Test
    void testSelectRandom100() {
        Random rand = new Random();
        for (int t = 0; t < 100; t++) {
            int[] arr = rand.ints(20, 0, 100).toArray();
            int k = rand.nextInt(arr.length);
            Metrics metrics = new Metrics();

            int val = DeterministicSelect.select(arr.clone(), k, metrics);
            Arrays.sort(arr);
            assertEquals(arr[k], val);
        }
    }
}
