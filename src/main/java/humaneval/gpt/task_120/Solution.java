package humaneval.gpt.task_120;

import java.util.*;
import java.lang.*;

public class Solution {
    /**
    Given an array arr of integers and a positive integer k, return a sorted list
    of length k with the maximum k numbers in arr.
     */
    public List<Integer> maximum(List<Integer> arr, int k) {
        List<Integer> sorted = new ArrayList<>(arr);
        Collections.sort(sorted);

        if (k == 0) {
            return new ArrayList<>();
        }

        return new ArrayList<>(sorted.subList(sorted.size() - k, sorted.size()));
    }
}
