package humaneval.claude.task_93;

import java.util.*;
import java.lang.*;

public class Solution {
    /**
    Write a function that takes a message, and encodes in such a
    way that it swaps case of all letters, replaces all vowels in
    the message with the letter that appears 2 places ahead of that
    vowel in the english alphabet.
    Assume only letters.

    Examples:
    >>> encode("test")
    "TGST"
    >>> encode("This is a message")
    "tHKS KS C MGSSCGG"
     */
    public String encode(String message) {
    StringBuilder result = new StringBuilder();
    String vowels = "aeiouAEIOU";
    for (char c : message.toCharArray()) {
        char swapped;
        if (Character.isUpperCase(c)) {
            swapped = Character.toLowerCase(c);
        } else if (Character.isLowerCase(c)) {
            swapped = Character.toUpperCase(c);
        } else {
            swapped = c;
        }
        if (vowels.indexOf(c) >= 0) {
            swapped = (char) (swapped + 2);
        }
        result.append(swapped);
    }
    return result.toString();
}
}
