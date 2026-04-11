package humaneval.claude.task_156;

import java.util.*;
import java.lang.*;

public class Solution {
    /**
    Given a positive integer, obtain its roman numeral equivalent as a string,
    and return it in lowercase.
    Restrictions: 1 <= num <= 1000

    Examples:
    >>> intToMiniRoman(19) == "xix"
    >>> intToMiniRoman(152) == "clii"
    >>> intToMiniRoman(426) == "cdxxvi"
     */
    public String intToMiniRoman(int number) {
    int[] values =    {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] symbols = {"m", "cm", "d", "cd", "c", "xc", "l", "xl", "x", "ix", "v", "iv", "i"};
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < values.length; i++) {
        while (number >= values[i]) {
            number -= values[i];
            sb.append(symbols[i]);
        }
    }
    return sb.toString();
}
}
