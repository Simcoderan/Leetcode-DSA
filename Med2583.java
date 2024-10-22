import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// TreeNode class definition
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
    }
}

public class Med2583 {
    public long kthLargestLevelSum(TreeNode root, int k) {
        List<Long> levelSums = new ArrayList<>();
        dfs(root, 0, levelSums);
        
        // If k is greater than the number of levels, return -1
        if (levelSums.size() < k)
            return -1;

        // Sort sums in descending order to get the k-th largest
        Collections.sort(levelSums, Collections.reverseOrder());
        return levelSums.get(k - 1); // Since lists are 0-indexed
    }

    // DFS to compute the sum at each level of the tree
    private void dfs(TreeNode root, int level, List<Long> levelSums) {
        if (root == null)
            return;

        // Add a new level if we haven't reached it yet
        if (levelSums.size() == level)
            levelSums.add(0L);

        // Add the current node's value to its level's sum
        levelSums.set(level, levelSums.get(level) + root.val);

        // Recurse for left and right subtrees
        dfs(root.left, level + 1, levelSums);
        dfs(root.right, level + 1, levelSums);
    }
}
