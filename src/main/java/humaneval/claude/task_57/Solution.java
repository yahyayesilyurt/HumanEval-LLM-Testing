package humaneval.claude.task_57;

import java.util.*;
import java.lang.*;

public class Solution {
    /**
    Return True is list elements are monotonically increasing or decreasing.
    >>> monotonic(Arrays.asList(1, 2, 4, 20))
    true
    >>> monotonic(Arrays.asList(1, 20, 4, 10))
    false
    >>> monotonic(Arrays.asList(4, 1, 0, -10))
    true
     */
    public boolean monotonic(List<Integer> l) {
        if (l.size() <= 1) {
            return true;
        }
        boolean increasing = true;
        boolean decreasing = true;
        for (int i = 1; i < l.size(); i++) {
            if (l.get(i) > l.get(i - 1)) {
                decreasing = false;
            } else if (l.get(i) < l.get(i - 1)) {
                increasing = false;
            }
        }
        return increasing || decreasing;
    }
}
