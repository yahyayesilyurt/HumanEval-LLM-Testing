/* @Authors
 * Student Names: Barış Karaer, Melisa Güler, Yahya Yeşilyurt
 * Student IDs: 150230742, 820210315, 150210072
 */
package bookscan.gpt.unmodified;

import bookscan.gpt.unmodified.BookScan;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class BookScanIntegrationTest {

    @Test
    void constructor_nullText_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new BookScan(null));
    }

    @Test
    void getTextAndGetLines_preserveOriginalText_splitBlankLines_andExposeUnmodifiableLines() {
        String text = "\nAlpha\n\nBeta\n";
        BookScan scan = new BookScan(text);

        assertEquals(text, scan.getText());
        assertEquals(List.of("", "Alpha", "", "Beta", ""), scan.getLines());
        assertThrows(UnsupportedOperationException.class, () -> scan.getLines().add("Gamma"));
    }

    @Test
    void scanApis_negativeWordLength_throwIllegalArgumentException() {
        BookScan scan = new BookScan("Alpha beta");

        assertThrows(IllegalArgumentException.class, () -> scan.scanWordsOfLength(-1));
        assertThrows(IllegalArgumentException.class, () -> scan.countWordsOfLength(-1));
        assertThrows(IllegalArgumentException.class, () -> scan.linesWithWordsOfLength(-1));
    }

    @Test
    void howManyTimes_coversNullAndEmptySubstring_overlappingMatches_andNoMatchBoundaries() {
        BookScan scan = new BookScan("unused");

        assertThrows(NullPointerException.class, () -> scan.howManyTimes(null, "a"));
        assertEquals(0, scan.howManyTimes("banana", null));
        assertEquals(0, scan.howManyTimes("banana", ""));
        assertEquals(2, scan.howManyTimes("aaaa", "aaa"));
        assertEquals(0, scan.howManyTimes("abc", "d"));
        assertEquals(0, scan.howManyTimes("ab", "abc"));
    }

    @Test
    void strlenAndFlipCase_coverNullMixedCaseAndNonLetterBranches() {
        BookScan scan = new BookScan("unused");

        assertThrows(NullPointerException.class, () -> scan.strlen(null));
        assertThrows(NullPointerException.class, () -> scan.flipCase(null));

        assertEquals(7, scan.strlen("AbC123!"));
        assertEquals("aBc123!", scan.flipCase("AbC123!"));
    }

    @Test
    void scanWordsOfLength_emptyText_andZeroLength_returnNoMatches() {
        BookScan scan = new BookScan("");

        BookScan.ScanResult result = scan.scanWordsOfLength(0);

        assertEquals(0, result.getWordLength());
        assertEquals(0, result.getTotalOccurrences());
        assertEquals(Map.of(), result.getOccurrencesByLine());
        assertEquals(List.of(), result.getLineNumbers());
        assertEquals(0, scan.countWordsOfLength(0));
        assertEquals(List.of(), scan.linesWithWordsOfLength(0));
    }

    @Test
    void scanWordsOfLength_multilineTextWithLeadingTrailingWhitespaceTabsAndBlankLines_countsPerLine() {
        String text = "  a bb\tccc  \n\nDD eee ffff\nx yy zzz yy\n";
        BookScan scan = new BookScan(text);

        BookScan.ScanResult result = scan.scanWordsOfLength(2);

        assertEquals(2, result.getWordLength());
        assertEquals(4, result.getTotalOccurrences());
        assertEquals(linkedMap(1, 1, 3, 1, 4, 2), result.getOccurrencesByLine());
        assertEquals(List.of(1, 3, 4), result.getLineNumbers());
        assertEquals(4, scan.countWordsOfLength(2));
        assertEquals(List.of(1, 3, 4), scan.linesWithWordsOfLength(2));
        assertThrows(UnsupportedOperationException.class, () -> result.getOccurrencesByLine().put(5, 1));
        assertThrows(UnsupportedOperationException.class, () -> result.getLineNumbers().add(5));
    }

    @Test
    void countWordsOfLength_singleLine_exactWordSize_andPlusMinusOne_boundaries_changeCounts() {
        BookScan scan = new BookScan("bb ccc ccc dddd");

        assertEquals(1, scan.countWordsOfLength(2));
        assertEquals(2, scan.countWordsOfLength(3));
        assertEquals(1, scan.countWordsOfLength(4));
        assertEquals(List.of(1), scan.linesWithWordsOfLength(3));
        assertEquals(linkedMap(1, 2), scan.scanWordsOfLength(3).getOccurrencesByLine());
    }

    @Test
    void scanWordsOfLength_singleCharacterWords_areCountedAcrossWhitespaceSeparatedMultilineText() {
        String text = "  a bb\tccc  \n\nDD eee ffff\nx yy zzz yy\n";
        BookScan scan = new BookScan(text);

        BookScan.ScanResult result = scan.scanWordsOfLength(1);

        assertEquals(2, result.getTotalOccurrences());
        assertEquals(linkedMap(1, 1, 4, 1), result.getOccurrencesByLine());
        assertEquals(List.of(1, 4), result.getLineNumbers());
    }

    @Test
    void linesWithWordsOfLength_includeFirstAndLastLine_whenBoundaryLinesMatch() {
        BookScan scan = new BookScan("aa\nmiddle\ncc");

        BookScan.ScanResult result = scan.scanWordsOfLength(2);

        assertEquals(2, result.getTotalOccurrences());
        assertEquals(List.of(1, 3), result.getLineNumbers());
        assertEquals(linkedMap(1, 1, 3, 1), result.getOccurrencesByLine());
        assertEquals(List.of(1, 3), scan.linesWithWordsOfLength(2));
    }

    @Test
    void scanWordsOfLength_lengthLongerThanAnyWord_returnsEmptyCollectionsAndZeroCount() {
        String text = "  a bb\tccc  \n\nDD eee ffff\nx yy zzz yy\n";
        BookScan scan = new BookScan(text);

        BookScan.ScanResult result = scan.scanWordsOfLength(5);

        assertEquals(5, result.getWordLength());
        assertEquals(0, result.getTotalOccurrences());
        assertEquals(Map.of(), result.getOccurrencesByLine());
        assertEquals(List.of(), result.getLineNumbers());
        assertEquals(0, scan.countWordsOfLength(5));
        assertEquals(List.of(), scan.linesWithWordsOfLength(5));
    }

    @Test
    void flipCase_strlen_andHowManyTimes_integrateWithScan_onCaseFlippedMultilineText() {
        BookScan utility = new BookScan("unused");

        String flippedText = utility.flipCase("ab ab\nab");
        String flippedWord = utility.flipCase("ab");
        int wordLength = utility.strlen(flippedWord);

        assertEquals("AB AB\nAB", flippedText);
        assertEquals(3, utility.howManyTimes(flippedText, flippedWord));

        BookScan scan = new BookScan(flippedText);
        BookScan.ScanResult result = scan.scanWordsOfLength(wordLength);

        assertEquals(2, wordLength);
        assertEquals(3, result.getTotalOccurrences());
        assertEquals(linkedMap(1, 2, 2, 1), result.getOccurrencesByLine());
        assertEquals(List.of(1, 2), result.getLineNumbers());
    }

    private static Map<Integer, Integer> linkedMap(int... keyValuePairs) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < keyValuePairs.length; i += 2) {
            map.put(keyValuePairs[i], keyValuePairs[i + 1]);
        }
        return map;
    }
}
