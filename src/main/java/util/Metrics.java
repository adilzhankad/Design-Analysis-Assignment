package util;

public class Metrics {
    private long comparisons = 0;
    private long swaps = 0;
    private long allocations = 0;

    private int currentDepth = 0;
    private int maxDepth = 0;

    public void incComparisons() { comparisons++; }
    public void incSwaps() { swaps++; }
    public void incAllocations() { allocations++; }

    public void enterRecursion() {
        currentDepth++;
        if (currentDepth > maxDepth) {
            maxDepth = currentDepth;
        }
    }

    public void exitRecursion() {
        currentDepth--;
    }

    public long getComparisons() { return comparisons; }
    public long getSwaps() { return swaps; }
    public long getAllocations() { return allocations; }
    public int getMaxDepth() { return maxDepth; }

    public void reset() {
        comparisons = swaps = allocations = 0;
        currentDepth = maxDepth = 0;
    }
}
