import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {

        // Step 1: Sort intervals based on starting point
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Step 2: Store merged intervals
        List<int[]> ans = new ArrayList<>();

        // Step 3: Traverse all intervals
        for (int[] interval : intervals) {

            // If list is empty or no overlap
            if (ans.isEmpty() || ans.get(ans.size() - 1)[1] < interval[0]) {
                ans.add(new int[]{interval[0], interval[1]});
            }
            // Overlapping intervals
            else {
                ans.get(ans.size() - 1)[1] = Math.max(
                        ans.get(ans.size() - 1)[1],
                        interval[1]
                );
            }
        }

        // Step 4: Convert List<int[]> to int[][]
        return ans.toArray(new int[ans.size()][]);
    }
}