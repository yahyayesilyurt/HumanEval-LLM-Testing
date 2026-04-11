package humaneval.gpt.task_18;

import java.util.*;
import java.lang.*;

public class Solution {
    /**
    Find how many times a given substring can be found in the original string. Count overlaping cases.
    >>> howManyTimes("", "a")
    0
    >>> howManyTimes("aaa", "a")
    3
    >>> howManyTimes("aaaa", "aa")
    3
     */
    public int howManyTimes(String string, String substring) {
    if (substring == null || substring.isEmpty()) {
        return 0;
    }

    int count = 0;
    for (int i = 0; i <= string.length() - substring.length(); i++) {
        if (string.substring(i, i + substring.length()).equals(substring)) {
            count++;
        }
    }
    return count;
}
}
