/* @Authors
 * Student Names: Barış Karaer, Melisa Güler, Yahya Yeşilyurt
 * Student IDs: 150230742, 820210315, 150210072
 */
package bookscan.gpt.edited;

import bookscan.gpt.edited.BookScan;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BookScanIntegrationTest {

    private final BookScan bookScan = new BookScan();

    @Test
    public void strlen_emptyAndTypicalString_returnExactCharacterCounts() {
        assertEquals(0, bookScan.strlen(""));
        assertEquals(5, bookScan.strlen("abcde"));
    }

    @Test
    public void howManyTimes_emptySourceNullSubstringAndEmptySubstring_returnZero() {
        assertEquals(0, bookScan.howManyTimes("", "a"));
        assertEquals(0, bookScan.howManyTimes("abc", null));
        assertEquals(0, bookScan.howManyTimes("abc", ""));
    }

    @Test
    public void howManyTimes_overlappingMatchesNoMatchAndTooLongSubstring_coverLoopBoundaries() {
        assertEquals(3, bookScan.howManyTimes("aaaa", "aa"));
        assertEquals(0, bookScan.howManyTimes("banana", "xy"));
        assertEquals(0, bookScan.howManyTimes("abc", "abcd"));
    }

    @Test
    public void howManyTimes_nullString_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> bookScan.howManyTimes(null, "a"));
    }

    @Test
    public void flipCase_mixedLettersAndNonLetters_flipsOnlyAlphabeticCharacters() {
        assertEquals("hELLO 123!", bookScan.flipCase("Hello 123!"));
    }

    @Test
    public void scan_nullText_throwsNullPointerException_inWordsAndCount() {
        assertThrows(NullPointerException.class, () -> bookScan.wordsOfLength(null, 3));
        assertThrows(NullPointerException.class, () -> bookScan.countWordsOfLength(null, 3));
    }

    @Test
    public void scan_emptyText_positiveLength_returnsEmptyMapAndZeroCount() {
        assertScan("", 3, List.of(), 0);
    }

    @Test
    public void scan_negativeAndZeroLength_returnEarlyWithEmptyResults() {
        String text = "one two\nthree";
        assertScan(text, -1, List.of(), 0);
        assertScan(text, 0, List.of(), 0);
    }

    @Test
    public void scan_singleLine_exactLengthAndPlusMinusOne_distinguishDistinctLinesFromMultiplicity() {
        String text = "sun sea sky";
        assertScan(text, 2, List.of(), 0);
        assertScan(text, 3, List.of(1), 3);
        assertScan(text, 4, List.of(), 0);
    }

    @Test
    public void scan_lengthOneBoundary_findsSingleCharacterWords_onFirstAndLastLines() {
        String text = "a bb\n\nc d";
        assertScan(text, 1, List.of(1, 3), 3);
    }

    @Test
    public void scan_multilineWhitespaceTabsAndEmptyLines_returnsAscendingDistinctLineNumbers() {
        String text =
                "  Call me Ishmael  \n" +
                "\n" +
                "\tSome years ago\t\n" +
                "I   \n" +
                "  at sea  sea ";
        assertScan(text, 3, List.of(3, 5), 3);
    }

    @Test
    public void flipCaseHowManyTimesStrlenAndScan_integrateOnTransformedMultilineText() {
        String originalText = "fire wood\nWIND sand";
        String flippedText = bookScan.flipCase(originalText);
        String flippedWord = bookScan.flipCase("wood");
        int length = bookScan.strlen(flippedWord);

        assertEquals("FIRE WOOD\nwind SAND", flippedText);
        assertEquals(1, bookScan.howManyTimes(flippedText, flippedWord));
        assertEquals(4, length);
        assertScan(flippedText, length, List.of(1, 2), 4);
    }

    private void assertScan(String text, int length, List<Integer> expectedLines, int expectedCount) {
        Map<Integer, List<Integer>> actualMap = bookScan.wordsOfLength(text, length);
        int actualCount = bookScan.countWordsOfLength(text, length);

        assertEquals(expectedCount, actualCount);
        if (expectedLines.isEmpty()) {
            assertTrue(actualMap.isEmpty());
        } else {
            assertEquals(Map.of(length, expectedLines), actualMap);
        }
    }
}
