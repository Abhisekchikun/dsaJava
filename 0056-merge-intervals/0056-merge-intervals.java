import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {

        // Sort intervals based on starting time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Store merged intervals
        List<int[]> merged = new ArrayList<>();

        // Traverse all intervals
        for (int[] interval : intervals) {

            // If there is no overlap, add the interval
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
                merged.add(new int[]{interval[0], interval[1]});
            }
            // If there is overlap, merge the intervals
            else {
                merged.get(merged.size() - 1)[1] = Math.max(
                        merged.get(merged.size() - 1)[1],
                        interval[1]
                );
            }
        }

        // Convert List<int[]> to int[][]
        return merged.toArray(new int[merged.size()][]);
    }
}