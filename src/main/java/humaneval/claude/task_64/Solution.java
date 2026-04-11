package humaneval.claude.task_64;

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
    String vowels = "aeiouAEIOU";
    for (int i = 0; i < s.length(); i++) {
        if (vowels.indexOf(s.charAt(i)) != -1) {
            count++;
        }
    }
    char last = s.charAt(s.length() - 1);
    if (last == 'y' || last == 'Y') {
        count++;
    }
    return count;
}
}
