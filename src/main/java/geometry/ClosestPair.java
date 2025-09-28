package geometry;

import util.Metrics;
import java.util.Arrays;
import java.util.Comparator;

public class ClosestPair {

    public static double findClosest(Point[] points, Metrics metrics) {
        // сортируем по x
        Point[] pts = points.clone();
        Arrays.sort(pts, Comparator.comparingInt(p -> p.x));
        return divideAndConquer(pts, 0, pts.length - 1, metrics);
    }

    private static double divideAndConquer(Point[] pts, int left, int right, Metrics metrics) {
        // если мало точек → считаем напрямую (brute force)
        if (right - left <= 3) {
            double min = Double.MAX_VALUE;
            for (int i = left; i <= right; i++) {
                for (int j = i + 1; j <= right; j++) {
                    metrics.incComparisons();
                    min = Math.min(min, pts[i].dist(pts[j]));
                }
            }
            return min;
        }

        int mid = (left + right) / 2;
        double dLeft = divideAndConquer(pts, left, mid, metrics);
        double dRight = divideAndConquer(pts, mid + 1, right, metrics);
        double d = Math.min(dLeft, dRight);

        // делаем "полосу" шириной 2d вокруг середины
        Point midPoint = pts[mid];
        Point[] strip = new Point[right - left + 1];
        int size = 0;
        for (int i = left; i <= right; i++) {
            if (Math.abs(pts[i].x - midPoint.x) < d) {
                strip[size++] = pts[i];
            }
        }

        // сортируем полосу по y
        Arrays.sort(strip, 0, size, Comparator.comparingInt(p -> p.y));

        // проверяем только ближайших соседей (≤ 7 точек вперёд)
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size && (strip[j].y - strip[i].y) < d; j++) {
                metrics.incComparisons();
                d = Math.min(d, strip[i].dist(strip[j]));
            }
        }

        return d;
    }

    //структура Point
    public static class Point {
        public final int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public double dist(Point other) {
            int dx = this.x - other.x;
            int dy = this.y - other.y;
            return Math.sqrt(dx * dx + dy * dy);
        }
    }
}
