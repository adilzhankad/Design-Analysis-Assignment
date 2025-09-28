package main;

import sort.MergeSort;
import sort.QuickSort;
import select.DeterministicSelect;
import geometry.ClosestPair;
import util.Metrics;
import util.CSVWriter;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        Metrics metrics = new Metrics();
        CSVWriter csv = new CSVWriter("results.csv", false);

        // записываем заголовок
        csv.writeHeader();

        // --- MergeSort ---
        int[] arr1 = rand.ints(20, 0, 100).toArray();
        metrics.reset();
        MergeSort.sort(arr1, metrics);
        csv.writeRow("MergeSort", arr1.length, metrics);

        // --- QuickSort ---
        int[] arr2 = rand.ints(20, 0, 100).toArray();
        metrics.reset();
        QuickSort.sort(arr2, metrics);
        csv.writeRow("QuickSort", arr2.length, metrics);

        // --- Deterministic Select ---
        int[] arr3 = rand.ints(20, 0, 100).toArray();
        int k = 5;
        metrics.reset();
        DeterministicSelect.select(arr3.clone(), k, metrics);
        csv.writeRow("DeterministicSelect", arr3.length, metrics);

        // --- Closest Pair ---
        ClosestPair.Point[] pts = {
                new ClosestPair.Point(0, 0),
                new ClosestPair.Point(3, 4),
                new ClosestPair.Point(7, 1),
                new ClosestPair.Point(2, 2)
        };
        metrics.reset();
        ClosestPair.findClosest(pts, metrics);
        csv.writeRow("ClosestPair", pts.length, metrics);

        System.out.println("✅ Results saved to results.csv");
    }
}
