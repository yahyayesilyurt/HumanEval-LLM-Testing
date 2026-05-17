/* @Authors
 * Student Names: Barış Karaer, Melisa Güler, Yahya Yeşilyurt
 * Student IDs: 150230742, 820210315, 150210072
 */
package bookscan.claude.unmodified;

import java.util.*;
import java.lang.*;

public class BookScan {

    public int strlen(String string) {
        return string.length();
    }

    public String flipCase(String string) {
        StringBuilder result = new StringBuilder();
        for (char c : string.toCharArray()) {
            if (Character.isUpperCase(c))
                result.append(Character.toLowerCase(c));
            else if (Character.isLowerCase(c))
                result.append(Character.toUpperCase(c));
            else
                result.append(c);
        }
        return result.toString();
    }

    public int howManyTimes(String string, String substring) {
        if (substring.isEmpty() || string.isEmpty()) return 0;
        int count = 0;
        for (int i = 0; i <= string.length() - substring.length(); i++) {
            if (string.substring(i, i + substring.length()).equals(substring))
                count++;
        }
        return count;
    }

    /**
     * Scans multi-line text for words of the given length.
     * Returns a map from each matching word (case-flipped) to its 1-based line numbers.
     * Uses all three primitives: strlen for length checks, flipCase for key normalization,
     * and howManyTimes for counting overlapping occurrences within a line.
     */
    public Map<String, List<Integer>> scan(String text, int wordLength) {
        Map<String, List<Integer>> result = new LinkedHashMap<>();
        String[] lines = text.split("\n", -1);

        for (int i = 0; i < lines.length; i++) {
            int lineNumber = i + 1;
            String line = lines[i];
            for (String token : line.split("\\s+")) {
                if (token.isEmpty()) continue;
                if (strlen(token) == wordLength) {
                    String key = flipCase(token);
                    int times = howManyTimes(line, token);
                    List<Integer> entries = result.computeIfAbsent(key, k -> new ArrayList<>());
                    for (int t = 0; t < times; t++) {
                        entries.add(lineNumber);
                    }
                }
            }
        }

        return result;
    }
}
