/* @Authors
 * Student Names: Barış Karaer, Melisa Güler, Yahya Yeşilyurt
 * Student IDs: 150230742, 820210315, 150210072
 */
package bookscan.claude.edited;

import java.util.*;
import java.lang.*;

public class BookScan {

    public int strlen(String string) {
        return string.length();
    }

    public int howManyTimes(String string, String substring) {
        if (substring.isEmpty()) return 0;
        int count = 0;
        for (int i = 0; i <= string.length() - substring.length(); i++) {
            if (string.substring(i, i + substring.length()).equals(substring)) {
                count++;
            }
        }
        return count;
    }

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

    public Map<Integer, List<Integer>> wordsOfLength(String text, int length) {
        Map<Integer, List<Integer>> result = new HashMap<>();
        if (length <= 0) return result;

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

    public int countWordsOfLength(String text, int length) {
        if (length <= 0) return 0;

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
