//leetcode 3623

//time complexity O(3n)
//space complexity O(n)

class Solution {
    public int countTrapezoids(int[][] points) {
        // TreeMap to group points by their y-coordinate (sorted in increasing order of y)
        Map<Integer, Integer> mp = new TreeMap<>();
        int n = points.length;

        // Define modulo constant correctly
        final int MOD = 1_000_000_007;

        // Step 1: Count how many points lie on each y-coordinate
        for (int i = 0; i < n; i++) {
            int y = points[i][1];
            mp.put(y, mp.getOrDefault(y, 0) + 1);
        }

        // Step 2: For each y-level, calculate how many horizontal segments can be formed
        // That is, number of ways to choose 2 points on the same horizontal line: C(n, 2) = n*(n-1)/2
        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            int key = entry.getKey();         // y-coordinate
            long count = entry.getValue();    // number of points on this y

            long comb = (count * (count - 1)) / 2; // total horizontal segments at this y
            comb %= MOD;

            mp.put(key, (int) comb); // Replace the count with number of segments
        }

        // Step 3: Count trapezoids by combining horizontal segments from different y-levels
        // If one level has 'a' segments and total below it has 'b', they can form a*b trapezoids
        long ans = 0;
        long tot = 0;  // running sum of segments from lower y-levels

        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            long value = entry.getValue(); // number of segments on this y-level

            // Total trapezoids formed between this y-level and all levels below
            ans = (ans + value * tot) % MOD;

            // Update total segments count for the next level
            tot = (tot + value) % MOD;
        }

        // Return final answer
        return (int) ans;
    }
}
