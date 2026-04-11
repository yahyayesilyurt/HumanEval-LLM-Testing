package humaneval.gpt.task_0;

import java.util.*;
import java.lang.*;

public class Solution {
    /**
    Check if in given list of numbers, are any two numbers closer to each other than given threshold.
    >>> hasCloseElements(Arrays.asList(1.0, 2.0, 3.0), 0.5)
    false
    >>> hasCloseElements(Arrays.asList(1.0, 2.8, 3.0, 4.0, 5.0, 2.0), 0.3)
    true
     */
    public boolean hasCloseElements(List<Double> numbers, double threshold) {
        List<Double> sorted = new ArrayList<>(numbers);
        Collections.sort(sorted);

        for (int i = 1; i < sorted.size(); i++) {
            if (sorted.get(i) - sorted.get(i - 1) < threshold) {
                return true;
            }
        }

        return false;
    }
}
