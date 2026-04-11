package humaneval.gpt.task_19;

import java.util.*;
import java.lang.*;

public class Solution {
    /**
    Input is a space-delimited string of numberals from 'zero' to 'nine'.
    Valid choices are 'zero', 'one', 'two', 'three', 'four', 'five', 'six', 'seven', 'eight' and 'nine'.
    Return the string with numbers sorted from smallest to largest
    >>> sortNumbers("three one five")
    "one three five"
     */
    public String sortNumbers(String numbers) {
    if (numbers == null || numbers.trim().isEmpty()) {
        return "";
    }

    Map<String, Integer> order = new HashMap<>();
    order.put("zero", 0);
    order.put("one", 1);
    order.put("two", 2);
    order.put("three", 3);
    order.put("four", 4);
    order.put("five", 5);
    order.put("six", 6);
    order.put("seven", 7);
    order.put("eight", 8);
    order.put("nine", 9);

    String[] parts = numbers.trim().split("\\s+");
    Arrays.sort(parts, Comparator.comparingInt(order::get));

    return String.join(" ", parts);
}
}
