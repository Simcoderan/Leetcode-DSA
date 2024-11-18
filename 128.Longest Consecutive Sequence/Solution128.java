import java.util.HashSet;
import java.util.Set;

class Solution128 {
    public int longestConsecutive(int[] nums) {
        // Handle edge case for empty input
        if (nums == null || nums.length == 0) return 0;

        // Add all elements to a HashSet
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longestLength = 0;

        // Iterate over the set
        for (int num : numSet) {
            // Start a sequence only if `num - 1` is not present
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentLength = 1;

                // Count consecutive numbers
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                }

                longestLength = Math.max(longestLength, currentLength);
            }
        }

        return longestLength;
    }

    public static void main(String[] args) {
        Solution128 solution = new Solution128();

        // Example test case
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println("Longest Consecutive Sequence Length: " + solution.longestConsecutive(nums));
    }
}
