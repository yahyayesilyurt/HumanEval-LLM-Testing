package humaneval.gpt.task_86;

import java.util.*;
import java.lang.*;

public class Solution {
    /**
    Write a function that takes a string and returns an ordered version of it.
    Ordered version of string, is a string where all words (separated by space)
    are replaced by a new word where all the characters arranged in
    ascending order based on ascii value.
    Note: You should keep the order of words and blank spaces in the sentence.

    For example:
    antiShuffle("Hi") returns "Hi"
    antiShuffle("hello") returns "ehllo"
    antiShuffle("Hello World!!!") returns "Hello !!!Wdlor"
     */
    public String antiShuffle(String s) {
    StringBuilder result = new StringBuilder();
    int i = 0;

    while (i < s.length()) {
        if (s.charAt(i) == ' ') {
            result.append(' ');
            i++;
        } else {
            int j = i;
            while (j < s.length() && s.charAt(j) != ' ') {
                j++;
            }

            char[] word = s.substring(i, j).toCharArray();
            Arrays.sort(word);
            result.append(word);

            i = j;
        }
    }

    return result.toString();
}
}
