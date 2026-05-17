/* @Authors
 * Student Names: Barış Karaer, Melisa Güler, Yahya Yeşilyurt
 * Student IDs: 150230742, 820210315, 150210072
 */
package bookscan.gpt.unmodified;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BookScan {
    private static final Pattern WORD_PATTERN = Pattern.compile("\\p{L}+");

    private final String text;
    private final List<String> lines;

    public BookScan(String text) {
        this.text = Objects.requireNonNull(text, "text");
        this.lines = Collections.unmodifiableList(Arrays.asList(text.split("\\R", -1)));
    }

    /**
     * Find how many times a given substring can be found in the original string.
     * Overlapping matches are counted.
     */
    public int howManyTimes(String string, String substring) {
        Objects.requireNonNull(string, "string");
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
     * Return the length of the given string.
     */
    public int strlen(String string) {
        return Objects.requireNonNull(string, "string").length();
    }

    /**
     * Flip lowercase characters to uppercase and uppercase to lowercase.
     * Non-letter characters are preserved.
     */
    public String flipCase(String string) {
        Objects.requireNonNull(string, "string");

        StringBuilder result = new StringBuilder(string.length());
        for (char ch : string.toCharArray()) {
            if (Character.isLowerCase(ch)) {
                result.append(Character.toUpperCase(ch));
            } else if (Character.isUpperCase(ch)) {
                result.append(Character.toLowerCase(ch));
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }

    /**
     * Count all words in the stored text whose length equals wordLength.
     */
    public int countWordsOfLength(int wordLength) {
        return scanWordsOfLength(wordLength).getTotalOccurrences();
    }

    /**
     * Return the 1-based line numbers that contain at least one word of the given length.
     */
    public List<Integer> linesWithWordsOfLength(int wordLength) {
        return scanWordsOfLength(wordLength).getLineNumbers();
    }

    /**
     * Scan the stored text and return both the total count and per-line counts
     * for words whose length equals wordLength.
     */
    public ScanResult scanWordsOfLength(int wordLength) {
        if (wordLength < 0) {
            throw new IllegalArgumentException("wordLength must be non-negative");
        }

        Map<Integer, Integer> occurrencesByLine = new LinkedHashMap<>();
        int totalOccurrences = 0;

        for (int i = 0; i < lines.size(); i++) {
            int lineNumber = i + 1;
            int countOnLine = countWordsOfLengthInLine(lines.get(i), wordLength);

            if (countOnLine > 0) {
                occurrencesByLine.put(lineNumber, countOnLine);
                totalOccurrences += countOnLine;
            }
        }

        return new ScanResult(wordLength, totalOccurrences, occurrencesByLine);
    }

    public String getText() {
        return text;
    }

    public List<String> getLines() {
        return lines;
    }

    private int countWordsOfLengthInLine(String line, int wordLength) {
        Matcher matcher = WORD_PATTERN.matcher(line);
        int count = 0;

        while (matcher.find()) {
            String word = matcher.group();
            if (strlen(word) == wordLength) {
                count++;
            }
        }

        return count;
    }

    public static final class ScanResult {
        private final int wordLength;
        private final int totalOccurrences;
        private final Map<Integer, Integer> occurrencesByLine;

        public ScanResult(int wordLength, int totalOccurrences, Map<Integer, Integer> occurrencesByLine) {
            this.wordLength = wordLength;
            this.totalOccurrences = totalOccurrences;
            this.occurrencesByLine = Collections.unmodifiableMap(new LinkedHashMap<>(occurrencesByLine));
        }

        public int getWordLength() {
            return wordLength;
        }

        public int getTotalOccurrences() {
            return totalOccurrences;
        }

        public Map<Integer, Integer> getOccurrencesByLine() {
            return occurrencesByLine;
        }

        public List<Integer> getLineNumbers() {
            return Collections.unmodifiableList(new ArrayList<>(occurrencesByLine.keySet()));
        }

        @Override
        public String toString() {
            return "ScanResult{" +
                    "wordLength=" + wordLength +
                    ", totalOccurrences=" + totalOccurrences +
                    ", occurrencesByLine=" + occurrencesByLine +
                    '}';
        }
    }
}
