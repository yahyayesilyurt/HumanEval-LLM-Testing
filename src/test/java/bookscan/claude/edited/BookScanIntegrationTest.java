/* @Authors
 * Student Names: Barış Karaer, Melisa Güler, Yahya Yeşilyurt
 * Student IDs: 150230742, 820210315, 150210072
 */
package bookscan.claude.edited;

import bookscan.claude.edited.BookScan;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;

public class BookScanIntegrationTest {

    private BookScan bookScan;

    @BeforeEach
    void setUp() {
        bookScan = new BookScan();
    }

    // ==================== wordsOfLength: Equivalence Class Partitioning ====================

    @Test
    void wordsOfLength_emptyText_returnsEmptyMap() {
        Map<Integer, List<Integer>> result = bookScan.wordsOfLength("", 3);
        assertTrue(result.isEmpty());
    }

    @Test
    void wordsOfLength_singleLineWithMatch_returnsLineOne() {
        Map<Integer, List<Integer>> result = bookScan.wordsOfLength("the cat sat", 3);
        assertEquals(List.of(1), result.get(3));
    }

    @Test
    void wordsOfLength_multiLineText_returnsAllMatchingLines() {
        String text = "hello world\nfoo bar baz\nhi there";
        Map<Integer, List<Integer>> result = bookScan.wordsOfLength(text, 3);
        assertEquals(List.of(2, 3), result.get(3));
    }

    @Test
    void wordsOfLength_negativeLength_returnsEmptyMap() {
        Map<Integer, List<Integer>> result = bookScan.wordsOfLength("hello world", -1);
        assertTrue(result.isEmpty());
    }

    @Test
    void wordsOfLength_zeroLength_returnsEmptyMap() {
        Map<Integer, List<Integer>> result = bookScan.wordsOfLength("hello world", 0);
        assertTrue(result.isEmpty());
    }

    @Test
    void wordsOfLength_lengthOne_matchesSingleCharWords() {
        String text = "I am a person";
        Map<Integer, List<Integer>> result = bookScan.wordsOfLength(text, 1);
        assertEquals(List.of(1), result.get(1));
    }

    @Test
    void wordsOfLength_lengthLongerThanAnyWord_returnsEmptyMap() {
        Map<Integer, List<Integer>> result = bookScan.wordsOfLength("short words only", 50);
        assertTrue(result.isEmpty());
    }

    @Test
    void wordsOfLength_noMatchOnAnyLine_returnsEmptyMap() {
        String text = "hello\nworld\ngreat";
        Map<Integer, List<Integer>> result = bookScan.wordsOfLength(text, 2);
        assertTrue(result.isEmpty());
    }

    // ==================== wordsOfLength: Boundary Value Analysis ====================

    @Test
    void wordsOfLength_wordExactlyAtLength_matches() {
        Map<Integer, List<Integer>> result = bookScan.wordsOfLength("cat", 3);
        assertEquals(List.of(1), result.get(3));
    }

    @Test
    void wordsOfLength_lengthOneLessThanWord_noMatch() {
        Map<Integer, List<Integer>> result = bookScan.wordsOfLength("cat", 2);
        assertTrue(result.isEmpty());
    }

    @Test
    void wordsOfLength_lengthOneMoreThanWord_noMatch() {
        Map<Integer, List<Integer>> result = bookScan.wordsOfLength("cat", 4);
        assertTrue(result.isEmpty());
    }

    @Test
    void wordsOfLength_firstAndLastLineMatch() {
        String text = "foo\nhello\nbar";
        Map<Integer, List<Integer>> result = bookScan.wordsOfLength(text, 3);
        assertEquals(List.of(1, 3), result.get(3));
    }

    @Test
    void wordsOfLength_multipleSpacesBetweenWords() {
        Map<Integer, List<Integer>> result = bookScan.wordsOfLength("the   cat   sat", 3);
        assertEquals(List.of(1), result.get(3));
    }

    @Test
    void wordsOfLength_tabSeparatedWords() {
        Map<Integer, List<Integer>> result = bookScan.wordsOfLength("the\tcat\tsat", 3);
        assertEquals(List.of(1), result.get(3));
    }

    @Test
    void wordsOfLength_leadingAndTrailingWhitespace() {
        Map<Integer, List<Integer>> result = bookScan.wordsOfLength("  cat  ", 3);
        assertEquals(List.of(1), result.get(3));
    }

    @Test
    void wordsOfLength_emptyLinesBetweenText() {
        String text = "foo\n\nbar";
        Map<Integer, List<Integer>> result = bookScan.wordsOfLength(text, 3);
        assertEquals(List.of(1, 3), result.get(3));
    }

    @Test
    void wordsOfLength_lineWithOnlyWhitespace_noMatch() {
        String text = "foo\n   \nbar";
        Map<Integer, List<Integer>> result = bookScan.wordsOfLength(text, 3);
        assertEquals(List.of(1, 3), result.get(3));
    }

    @Test
    void wordsOfLength_singleCharacterOnSingleLine() {
        Map<Integer, List<Integer>> result = bookScan.wordsOfLength("x", 1);
        assertEquals(List.of(1), result.get(1));
    }

    // ==================== countWordsOfLength: Equivalence Class Partitioning ====================

    @Test
    void countWordsOfLength_emptyText_returnsZero() {
        assertEquals(0, bookScan.countWordsOfLength("", 3));
    }

    @Test
    void countWordsOfLength_singleLineMultipleMatches() {
        assertEquals(3, bookScan.countWordsOfLength("the cat sat", 3));
    }

    @Test
    void countWordsOfLength_multiLineCountsAll() {
        String text = "the cat\nsat on\nthe mat";
        assertEquals(5, bookScan.countWordsOfLength(text, 3));
    }

    @Test
    void countWordsOfLength_negativeLength_returnsZero() {
        assertEquals(0, bookScan.countWordsOfLength("hello", -5));
    }

    @Test
    void countWordsOfLength_zeroLength_returnsZero() {
        assertEquals(0, bookScan.countWordsOfLength("hello", 0));
    }

    @Test
    void countWordsOfLength_noMatches_returnsZero() {
        assertEquals(0, bookScan.countWordsOfLength("hi go me", 5));
    }

    @Test
    void countWordsOfLength_lengthOne_countsSingleCharWords() {
        assertEquals(2, bookScan.countWordsOfLength("I am a boy", 1));
    }

    // ==================== countWordsOfLength: Boundary Value Analysis ====================

    @Test
    void countWordsOfLength_multipleSpacesNotCountedAsWords() {
        assertEquals(2, bookScan.countWordsOfLength("cat   dog", 3));
    }

    @Test
    void countWordsOfLength_tabsAndSpacesMixed() {
        assertEquals(3, bookScan.countWordsOfLength("cat\t dog\t\t bat", 3));
    }

    @Test
    void countWordsOfLength_leadingTrailingSpacesIgnored() {
        assertEquals(1, bookScan.countWordsOfLength("  cat  ", 3));
    }

    @Test
    void countWordsOfLength_emptyLinesContributeNothing() {
        String text = "cat\n\n\ndog";
        assertEquals(2, bookScan.countWordsOfLength(text, 3));
    }

    @Test
    void countWordsOfLength_longestWordInText() {
        String text = "extraordinary simple";
        assertEquals(1, bookScan.countWordsOfLength(text, 13));
    }

    // ==================== howManyTimes: Equivalence Class Partitioning ====================

    @Test
    void howManyTimes_emptySubstring_returnsZero() {
        assertEquals(0, bookScan.howManyTimes("hello", ""));
    }

    @Test
    void howManyTimes_emptyString_returnsZero() {
        assertEquals(0, bookScan.howManyTimes("", "a"));
    }

    @Test
    void howManyTimes_bothEmpty_returnsZero() {
        assertEquals(0, bookScan.howManyTimes("", ""));
    }

    @Test
    void howManyTimes_noOccurrence_returnsZero() {
        assertEquals(0, bookScan.howManyTimes("hello world", "xyz"));
    }

    @Test
    void howManyTimes_singleOccurrence() {
        assertEquals(1, bookScan.howManyTimes("hello world", "world"));
    }

    @Test
    void howManyTimes_multipleNonOverlapping() {
        assertEquals(2, bookScan.howManyTimes("abcabc", "abc"));
    }

    @Test
    void howManyTimes_overlappingOccurrences() {
        assertEquals(3, bookScan.howManyTimes("aaaa", "aa"));
    }

    @Test
    void howManyTimes_substringLongerThanString_returnsZero() {
        assertEquals(0, bookScan.howManyTimes("hi", "hello"));
    }

    @Test
    void howManyTimes_substringEqualsString() {
        assertEquals(1, bookScan.howManyTimes("exact", "exact"));
    }

    @Test
    void howManyTimes_singleCharSubstring() {
        assertEquals(3, bookScan.howManyTimes("banana", "a"));
    }

    // ==================== flipCase: Equivalence Class Partitioning ====================

    @Test
    void flipCase_emptyString_returnsEmpty() {
        assertEquals("", bookScan.flipCase(""));
    }

    @Test
    void flipCase_allLowerCase_returnsAllUpper() {
        assertEquals("HELLO", bookScan.flipCase("hello"));
    }

    @Test
    void flipCase_allUpperCase_returnsAllLower() {
        assertEquals("hello", bookScan.flipCase("HELLO"));
    }

    @Test
    void flipCase_mixedCase_flipsEachCharacter() {
        assertEquals("hELLO wORLD", bookScan.flipCase("Hello World"));
    }

    @Test
    void flipCase_numbersAndSpecialChars_unchanged() {
        assertEquals("123!@#", bookScan.flipCase("123!@#"));
    }

    @Test
    void flipCase_mixedWithDigitsAndPunctuation() {
        assertEquals("hELLO 123 wORLD!", bookScan.flipCase("Hello 123 World!"));
    }

    // ==================== strlen: Equivalence Class Partitioning ====================

    @Test
    void strlen_emptyString_returnsZero() {
        assertEquals(0, bookScan.strlen(""));
    }

    @Test
    void strlen_singleChar_returnsOne() {
        assertEquals(1, bookScan.strlen("x"));
    }

    @Test
    void strlen_typicalString_returnsCorrectLength() {
        assertEquals(5, bookScan.strlen("hello"));
    }

    @Test
    void strlen_stringWithSpaces_countsSpaces() {
        assertEquals(11, bookScan.strlen("hello world"));
    }

    // ==================== Integration: Combining Methods ====================

    @Test
    void integration_scanMultiLineBookText_findWordsAndCountOccurrences() {
        String bookText = "The quick brown fox\njumps over the lazy dog\nThe fox runs fast";
        int targetLength = 3;

        Map<Integer, List<Integer>> lineMap = bookScan.wordsOfLength(bookText, targetLength);
        int totalCount = bookScan.countWordsOfLength(bookText, targetLength);

        assertEquals(List.of(1, 2, 3), lineMap.get(3));
        assertEquals(5, totalCount);

        int foxOccurrences = bookScan.howManyTimes(bookText, "fox");
        assertEquals(2, foxOccurrences);
    }

    @Test
    void integration_flipCaseAndCountWordsOfFlippedLength() {
        String original = "Hello World";
        String flipped = bookScan.flipCase(original);
        assertEquals("hELLO wORLD", flipped);

        int len = bookScan.strlen("Hello");
        assertEquals(5, len);

        int count = bookScan.countWordsOfLength(flipped, len);
        assertEquals(2, count);
    }

    @Test
    void integration_strlenDeterminesSearchLength_wordsOfLengthFindsLines() {
        String bookText = "Once upon a time\nin a land far away\nthe brave knight rode";
        String searchWord = "brave";
        int length = bookScan.strlen(searchWord);

        Map<Integer, List<Integer>> result = bookScan.wordsOfLength(bookText, length);
        assertEquals(List.of(3), result.get(5));

        int repetitions = bookScan.howManyTimes(bookText, "a ");
        assertEquals(4, repetitions);
    }

    @Test
    void integration_flipCaseThenScanForOccurrences() {
        String bookText = "The Cat SAT on THE mat";
        String flipped = bookScan.flipCase(bookText);
        assertEquals("tHE cAT sat ON the MAT", flipped);

        int satCount = bookScan.howManyTimes(flipped, "sat");
        assertEquals(1, satCount);

        int theCountOriginal = bookScan.howManyTimes(bookText, "The");
        assertEquals(1, theCountOriginal);

        int theCountFlipped = bookScan.howManyTimes(flipped, "the");
        assertEquals(1, theCountFlipped);
    }

    @Test
    void integration_multiLineBookScan_allMethodsCollaborate() {
        String bookText = "It was a dark and stormy night\n"
                + "The wind howled through the trees\n"
                + "A lone figure walked the empty road";

        String flipped = bookScan.flipCase(bookText);
        assertTrue(flipped.contains("iT WAS A DARK AND STORMY NIGHT"));

        int lengthOfStormy = bookScan.strlen("stormy");
        assertEquals(6, lengthOfStormy);

        Map<Integer, List<Integer>> sixLetterLines = bookScan.wordsOfLength(bookText, lengthOfStormy);
        assertEquals(List.of(1, 3), sixLetterLines.get(6));

        int countSixLetter = bookScan.countWordsOfLength(bookText, lengthOfStormy);
        assertEquals(3, countSixLetter);

        int theCount = bookScan.howManyTimes(bookText, "the");
        assertEquals(3, theCount);
    }

    @Test
    void integration_howManyTimesOnExtractedLine() {
        String bookText = "she sells sea shells\nby the sea shore\nshe is shy";
        int targetLen = bookScan.strlen("she");

        Map<Integer, List<Integer>> lines = bookScan.wordsOfLength(bookText, targetLen);
        assertEquals(List.of(1, 2, 3), lines.get(3));

        int sheCount = bookScan.howManyTimes(bookText, "she");
        assertEquals(3, sheCount);

        int seaCount = bookScan.howManyTimes(bookText, "sea");
        assertEquals(2, seaCount);
    }

    @Test
    void integration_wordsOfLengthReportsLineOnceEvenIfMultipleMatchesOnSameLine() {
        String text = "cat bat hat rat\ndog fog log";
        Map<Integer, List<Integer>> result = bookScan.wordsOfLength(text, 3);
        assertEquals(List.of(1, 2), result.get(3));

        assertEquals(7, bookScan.countWordsOfLength(text, 3));
    }

    @Test
    void integration_flipCasePreservesWordLengthsForScan() {
        String text = "Hello World";
        String flipped = bookScan.flipCase(text);

        assertEquals(
                bookScan.countWordsOfLength(text, 5),
                bookScan.countWordsOfLength(flipped, 5)
        );

        assertEquals(
                bookScan.wordsOfLength(text, 5).get(5),
                bookScan.wordsOfLength(flipped, 5).get(5)
        );
    }

    // ==================== Branch Coverage: Edge Paths ====================

    @Test
    void wordsOfLength_allLinesMatch_returnsAllLineNumbers() {
        String text = "cat\ndog\nbat";
        Map<Integer, List<Integer>> result = bookScan.wordsOfLength(text, 3);
        assertEquals(List.of(1, 2, 3), result.get(3));
    }

    @Test
    void wordsOfLength_onlyMiddleLineMatches() {
        String text = "hello\ncat\nworld";
        Map<Integer, List<Integer>> result = bookScan.wordsOfLength(text, 3);
        assertEquals(List.of(2), result.get(3));
    }

    @Test
    void wordsOfLength_lineWithMixedLengthWords_matchesOnFirstEligible() {
        String text = "a bb ccc dddd";
        Map<Integer, List<Integer>> result = bookScan.wordsOfLength(text, 3);
        assertEquals(List.of(1), result.get(3));
    }

    @Test
    void countWordsOfLength_multipleMatchesPerLine_countsAll() {
        String text = "one two six ten";
        assertEquals(4, bookScan.countWordsOfLength(text, 3));
    }

    @Test
    void wordsOfLength_trailingNewline_emptyLastLineNoMatch() {
        String text = "cat\n";
        Map<Integer, List<Integer>> result = bookScan.wordsOfLength(text, 3);
        assertEquals(List.of(1), result.get(3));
    }

    @Test
    void countWordsOfLength_trailingNewline_emptyLastLineContributesZero() {
        String text = "cat dog\n";
        assertEquals(2, bookScan.countWordsOfLength(text, 3));
    }

    @Test
    void howManyTimes_substringAtStartMiddleEnd() {
        assertEquals(3, bookScan.howManyTimes("abcabcabc", "abc"));
    }

    @Test
    void howManyTimes_caseSensitive() {
        assertEquals(0, bookScan.howManyTimes("Hello", "hello"));
        assertEquals(1, bookScan.howManyTimes("Hello", "Hello"));
    }

    @Test
    void flipCase_singleUpperChar() {
        assertEquals("a", bookScan.flipCase("A"));
    }

    @Test
    void flipCase_singleLowerChar() {
        assertEquals("A", bookScan.flipCase("a"));
    }
}
