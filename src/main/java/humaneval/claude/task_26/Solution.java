package humaneval.claude.task_26;

import java.util.*;
import java.lang.*;
import java.util.stream.Collectors;

public class Solution {
    /**
    From a list of integers, remove all elements that occur more than once.
    Keep order of elements left the same as in the input.
    >>> removeDuplicates(Array.asList(1, 2, 3, 2, 4))
    [1, 3, 4]
     */
    public List<Integer> removeDuplicates(List<Integer> numbers) {
        Map<Integer, Long> counts = numbers.stream()
            .collect(Collectors.groupingBy(n -> n, Collectors.counting()));
        return numbers.stream()
            .filter(n -> counts.get(n) == 1)
            .collect(Collectors.toList());
    }
}
