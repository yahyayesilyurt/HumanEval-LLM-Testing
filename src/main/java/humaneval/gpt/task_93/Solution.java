package humaneval.gpt.task_93;

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

    for (char c : message.toCharArray()) {
        if ("aeiou".indexOf(c) >= 0) {
            result.append(Character.toUpperCase((char) (c + 2)));
        } else if ("AEIOU".indexOf(c) >= 0) {
            result.append(Character.toLowerCase((char) (c + 2)));
        } else if (Character.isLowerCase(c)) {
            result.append(Character.toUpperCase(c));
        } else if (Character.isUpperCase(c)) {
            result.append(Character.toLowerCase(c));
        } else {
            result.append(c);
        }
    }

    return result.toString();
}
}
