//GROUP ANAGRAM
import java.util.*;

public class Medium49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<>();
        }

        // Use proper generic types for type safety
        Map<String, List<String>> ansMap = new HashMap<>();

        int[] count = new int[26];
        
        for (String s : strs) {
            Arrays.fill(count, 0);  // Reset count array for each string
            
            // Count the frequency of each character
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }

            // Create a unique key based on the character counts
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                sb.append("#");
                sb.append(count[i]);
            }
            String key = sb.toString();

            // If the key doesn't exist, create a new list
            ansMap.putIfAbsent(key, new ArrayList<>());
            ansMap.get(key).add(s);
        }

        // Return the grouped anagrams as a list of lists
        return new ArrayList<>(ansMap.values());
    }
}
