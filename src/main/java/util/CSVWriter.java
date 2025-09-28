package util;

import java.io.FileWriter;
import java.io.IOException;

public class CSVWriter {
    private final String filePath;
    private final boolean append;

    public CSVWriter(String filePath, boolean append) {
        this.filePath = filePath;
        this.append = append;
    }

    public void writeHeader() {
        try (FileWriter writer = new FileWriter(filePath, append)) {
            writer.write("Algorithm,Size,Comparisons,Swaps,Allocations,MaxDepth\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeRow(String algorithm, int size, Metrics metrics) {
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write(String.format("%s,%d,%d,%d,%d,%d\n",
                    algorithm,
                    size,
                    metrics.getComparisons(),
                    metrics.getSwaps(),
                    metrics.getAllocations(),
                    metrics.getMaxDepth()
            ));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
