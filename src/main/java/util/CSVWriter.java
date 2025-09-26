package util;

import java.io.FileWriter;
import java.io.IOException;

public class CSVWriter {
    private final String file;

    public CSVWriter(String file) {
        this.file = file;
        try (FileWriter writer = new FileWriter(file)) {
            writer.write("n,algorithm,time_ms,comparisons,allocations,max_depth\n");
        } catch (IOException e) {
            throw new RuntimeException("Failed to init CSV file", e);
        }
    }

    public void writeResult(int n, String algorithm, long timeMs, Metrics metrics) {
        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write(String.format("%d,%s,%d,%d,%d,%d\n",
                    n, algorithm, timeMs,
                    metrics.getComparisons(),
                    metrics.getAllocations(),
                    metrics.getMaxDepth()));
        } catch (IOException e) {
            throw new RuntimeException("Failed to write CSV line", e);
        }
    }
}
