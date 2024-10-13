//CONTAINS DUPLICATE
import java.util.HashSet;
    import java.util.Set;
    
    public class Easy217 {
        public boolean containsDuplicate(int[] nums) {
            // Create a HashSet to store visited elements
            Set<Integer> visited = new HashSet<>();
    
            // Iterate over the array
            for (int i = 0; i < nums.length; i++) {
                // If the element is already in the set, return true
                if (visited.contains(nums[i])) {
                    return true;
                } 
                // Otherwise, add the element to the set
                else {
                    visited.add(nums[i]);
                }
            }
            // If no duplicates are found, return false
            return false;
        }
    }
    