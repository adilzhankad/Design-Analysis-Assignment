package geometry;

import org.junit.jupiter.api.Test;
import util.Metrics;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClosestPairTest {

    @Test
    void testSimpleCase() {
        ClosestPair.Point[] pts = {
                new ClosestPair.Point(0, 0),
                new ClosestPair.Point(3, 4),
                new ClosestPair.Point(7, 1),
                new ClosestPair.Point(2, 2)
        };
        Metrics metrics = new Metrics();
        double result = ClosestPair.findClosest(pts, metrics);


        assertEquals(Math.sqrt(5), result, 1e-6);
    }


    @Test
    void testTwoPoints() {
        ClosestPair.Point[] pts = {
                new ClosestPair.Point(1, 1),
                new ClosestPair.Point(4, 5)
        };
        Metrics metrics = new Metrics();
        double result = ClosestPair.findClosest(pts, metrics);

        assertEquals(5.0, result, 1e-6); // расстояние = 5
    }
}
