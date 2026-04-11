package humaneval.gpt.task_64;

import java.util.*;
import java.lang.*;

public class Solution {
    /**
    Write a function vowelsCount which takes a string representing
    a word as input and returns the number of vowels in the string.
    Vowels in this case are 'a', 'e', 'i', 'o', 'u'. Here, 'y' is also a
    vowel, but only when it is at the end of the given word.

    Example:
    >>> vowelsCount("abcde")
    2
    >>> vowelsCount("ACEDY")
    3
     */
    public int vowelsCount(String s) {
    int count = 0;
    s = s.toLowerCase();

    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if ("aeiou".indexOf(c) >= 0 || (c == 'y' && i == s.length() - 1)) {
            count++;
        }
    }

    return count;
}
}
