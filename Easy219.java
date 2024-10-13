// CONTAINS DUPLICATE |||


import java.util.HashSet;
import java.util.Set;

public class Easy219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // Create a HashSet to store elements
        Set<Integer> set = new HashSet<>();

        // Iterate over the array
        for (int i = 0; i < nums.length; ++i) {
            // If the set already contains the current element, return true
            if (set.contains(nums[i])) return true;

            // Add the current element to the set
            set.add(nums[i]);

            // If the size of the set exceeds k, remove the element that's too far away
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }

        // If no nearby duplicates are found, return false
        return false;
    }

    public static void main(String[] args) {
        Easy219 solution = new Easy219();

        // Test case
        int[] nums = {1, 2, 3, 1};
        int k = 3;

        // Check for nearby duplicates
        boolean result = solution.containsNearbyDuplicate(nums, k);

        // Print the result
        System.out.println("Contains nearby duplicate: " + result);
    }
}

    

