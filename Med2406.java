//Line Sweeping Algorithm
 import java.util.Map;
 import java.util.TreeMap;
        
        public class Med2406 {
            public int minGroups(int[][] intervals) {
                // TreeMap to store the start and end times with their corresponding counts
                TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        
                // Iterate through each interval
                for (int[] interval : intervals) {
                    int startTime = interval[0];
                    int endTime = interval[1] + 1;  // Adding 1 to the endTime for easier handling of overlaps
        
                    // Increment the count at the start time
                    treeMap.put(startTime, treeMap.getOrDefault(startTime, 0) + 1);
                    // Decrement the count at the end time
                    treeMap.put(endTime, treeMap.getOrDefault(endTime, 0) - 1);
                }
        
                int currentCount = 0;  // Tracks the current number of overlapping groups
                int maxCount = 0;      // Tracks the maximum number of overlapping groups
        
                // Iterate through the TreeMap entries
                for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
                    // Update the current count by adding the value (increment or decrement)
                    currentCount += entry.getValue();
                    // Update the max count if the current count exceeds it
                    maxCount = Math.max(currentCount, maxCount);
                }
        
                return maxCount;  // Return the maximum number of groups required
            }
        }