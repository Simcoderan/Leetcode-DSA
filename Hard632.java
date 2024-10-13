//Smallest Range Covering Elements from K Lists

import java.util.*;

public class Hard632 {
  public int[] smallestRange(List<List<Integer>> nums) {
    // Record to store the element, its list index (i), and its index in that list (j)
    record T(int i, int j, int num) {}

    // Min-heap to keep track of the smallest elements from each list
    Queue<T> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.num, b.num));

    // Variables to keep track of the current minimum and maximum in the heap
    int mn = Integer.MAX_VALUE;
    int mx = Integer.MIN_VALUE;

    // Initialize the min-heap with the first element of each list
    for (int i = 0; i < nums.size(); ++i) {
      final int num = nums.get(i).get(0); // Get the first element of list i
      minHeap.offer(new T(i, 0, num));    // Add it to the heap
      mn = Math.min(mn, num);             // Update the global minimum
      mx = Math.max(mx, num);             // Update the global maximum
    }

    // Variables to store the smallest range
    int minRange = mn;
    int maxRange = mx;

    // Loop until we have elements from all the lists in the heap
    while (minHeap.size() == nums.size()) {
      final int i = minHeap.peek().i;      // Get the list index of the smallest element
      final int j = minHeap.poll().j;      // Remove the smallest element and get its index

      // If there are more elements in the current list
      if (j + 1 < nums.get(i).size()) {
        // Add the next element from the same list to the heap
        minHeap.offer(new T(i, j + 1, nums.get(i).get(j + 1)));
        mx = Math.max(mx, nums.get(i).get(j + 1)); // Update the global maximum
        mn = minHeap.peek().num;                  // The new minimum is at the top of the heap
      }

      // Check if the current range is smaller than the previously found range
      if (mx - mn < maxRange - minRange) {
        minRange = mn;
        maxRange = mx;
      }
    }

    // Return the smallest range found
    return new int[] {minRange, maxRange};
  }
}

