/* @Authors
 * Student Names: Barış Karaer, Melisa Güler, Yahya Yeşilyurt
 * Student IDs: 150230742, 820210315, 150210072
 */
package bookscan.gpt.edited;

import java.util.*;
import java.lang.*;

public class BookScan {
    /**
    Return length of given string
    >>> strlen("")
    0
    >>> strlen("abc")
    3
     */
    public int strlen(String string) {
        return string.length();
    }

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

    /**
    For a given string, flip lowercase characters to uppercase and uppercase to lowercase.
    >>> flipCase("Hello")
    "hELLO"
     */
    public String flipCase(String string) {
        StringBuilder sb = new StringBuilder();
        for (char c : string.toCharArray()) {
            if (Character.isUpperCase(c)) {
                sb.append(Character.toLowerCase(c));
            } else if (Character.isLowerCase(c)) {
                sb.append(Character.toUpperCase(c));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
    Return a map with exactly one entry: the queried length mapped to the
    ascending list of DISTINCT 1-based line numbers that contain at least one
    word of that length (measured via strlen). Empty map if no line qualifies.
    >>> wordsOfLength("hi bye\nfo\nabc de", 3)
    {3=[1, 3]}
     */
    public Map<Integer, List<Integer>> wordsOfLength(String text, int length) {
        Objects.requireNonNull(text);

        Map<Integer, List<Integer>> result = new LinkedHashMap<>();
        if (length <= 0) {
            return result;
        }

        String[] lines = text.split("\n", -1);
        List<Integer> lineNumbers = new ArrayList<>();

        for (int i = 0; i < lines.length; i++) {
            String[] words = lines[i].split("\\s+");
            for (String word : words) {
                if (!word.isEmpty() && strlen(word) == length) {
                    lineNumbers.add(i + 1);
                    break;
                }
            }
        }

        if (!lineNumbers.isEmpty()) {
            result.put(length, lineNumbers);
        }
        return result;
    }

    /**
    Return the total number of words (counting multiplicity) of exactly the
    given length across the whole text (word length measured via strlen).
    >>> countWordsOfLength("hi bye\nfo\nabc de", 3)
    2
     */
    public int countWordsOfLength(String text, int length) {
        Objects.requireNonNull(text);

        if (length <= 0) {
            return 0;
        }

        int count = 0;
        String[] lines = text.split("\n", -1);

        for (String line : lines) {
            String[] words = line.split("\\s+");
            for (String word : words) {
                if (!word.isEmpty() && strlen(word) == length) {
                    count++;
                }
            }
        }

        return count;
    }
}
