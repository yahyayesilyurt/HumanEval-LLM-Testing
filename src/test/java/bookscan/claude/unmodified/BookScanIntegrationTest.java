/* @Authors
 * Student Names: Barış Karaer, Melisa Güler, Yahya Yeşilyurt
 * Student IDs: 150230742, 820210315, 150210072
 */
package bookscan.claude.unmodified;

import bookscan.claude.unmodified.BookScan;

import java.util.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BookScanIntegrationTest {

    private final BookScan bookScan = new BookScan();

    // ===== EQUIVALENCE CLASS PARTITIONING: text parameter =====

    @Test
    void scan_emptyText_returnsEmptyMap() {
        Map<String, List<Integer>> result = bookScan.scan("", 3);
        assertTrue(result.isEmpty());
    }

    @Test
    void scan_singleLineSingleWord_matchingLength_returnsFlippedKeyWithLine1() {
        Map<String, List<Integer>> result = bookScan.scan("Hello", 5);
        assertEquals(List.of(1), result.get("hELLO"));
        assertEquals(1, result.size());
    }

    @Test
    void scan_singleLineMultipleWords_filtersbyLength() {
        Map<String, List<Integer>> result = bookScan.scan("I am a cat", 3);
        assertEquals(List.of(1), result.get("CAT"));
        assertNull(result.get("i"));
        assertNull(result.get("AM"));
        assertEquals(1, result.size());
    }

    @Test
    void scan_multiLineText_returnsCorrectLineNumbers() {
        String text = "the fox\njumped over\nthe lazy dog";
        Map<String, List<Integer>> result = bookScan.scan(text, 3);
        assertEquals(List.of(1), result.get("THE"));
        assertEquals(List.of(1), result.get("FOX"));
        assertEquals(List.of(3), result.get("DOG"));
        assertTrue(result.containsKey("THE"));
    }

    @Test
    void scan_textWithOnlyWhitespace_returnsEmptyMap() {
        Map<String, List<Integer>> result = bookScan.scan("   \t  ", 3);
        assertTrue(result.isEmpty());
    }

    // ===== EQUIVALENCE CLASS PARTITIONING: wordLength parameter =====

    @Test
    void scan_wordLengthZero_returnsEmptyMap() {
        Map<String, List<Integer>> result = bookScan.scan("hello world", 0);
        assertTrue(result.isEmpty());
    }

    @Test
    void scan_wordLengthOne_matchesSingleCharWords() {
        Map<String, List<Integer>> result = bookScan.scan("I am a hero", 1);
        assertTrue(result.containsKey("i"));
        assertTrue(result.containsKey("A"));
        assertEquals(List.of(1), result.get("i"));
        assertEquals(List.of(1), result.get("A"));
    }

    @Test
    void scan_wordLengthNegative_returnsEmptyMap() {
        Map<String, List<Integer>> result = bookScan.scan("hello world", -1);
        assertTrue(result.isEmpty());
    }

    @Test
    void scan_wordLengthLongerThanAnyWord_returnsEmptyMap() {
        Map<String, List<Integer>> result = bookScan.scan("short words here", 100);
        assertTrue(result.isEmpty());
    }

    @Test
    void scan_typicalWordLength_matchesCorrectly() {
        String text = "Java code runs fast";
        Map<String, List<Integer>> result = bookScan.scan(text, 4);
        assertTrue(result.containsKey("jAVA"));
        assertTrue(result.containsKey("CODE"));
        assertTrue(result.containsKey("RUNS"));
        assertTrue(result.containsKey("FAST"));
        assertEquals(4, result.size());
    }

    // ===== BOUNDARY VALUE ANALYSIS =====

    @Test
    void scan_wordLengthExactlyMatchesWord_included() {
        Map<String, List<Integer>> result = bookScan.scan("cat", 3);
        assertEquals(List.of(1), result.get("CAT"));
    }

    @Test
    void scan_wordLengthOneMoreThanWord_excluded() {
        Map<String, List<Integer>> result = bookScan.scan("cat", 4);
        assertTrue(result.isEmpty());
    }

    @Test
    void scan_wordLengthOneLessThanWord_excluded() {
        Map<String, List<Integer>> result = bookScan.scan("cat", 2);
        assertTrue(result.isEmpty());
    }

    @Test
    void scan_firstLineMatch_returnsLineOne() {
        String text = "dog\ncat\nfox";
        Map<String, List<Integer>> result = bookScan.scan(text, 3);
        assertTrue(result.get("DOG").contains(1));
    }

    @Test
    void scan_lastLineMatch_returnsCorrectLineNumber() {
        String text = "dog\ncat\nfox";
        Map<String, List<Integer>> result = bookScan.scan(text, 3);
        assertTrue(result.get("FOX").contains(3));
    }

    @Test
    void scan_leadingWhitespaceOnLine_tokensStillParsed() {
        Map<String, List<Integer>> result = bookScan.scan("   cat", 3);
        assertEquals(List.of(1), result.get("CAT"));
    }

    @Test
    void scan_trailingWhitespaceOnLine_tokensStillParsed() {
        Map<String, List<Integer>> result = bookScan.scan("cat   ", 3);
        assertEquals(List.of(1), result.get("CAT"));
    }

    @Test
    void scan_multipleSpacesAndTabsBetweenWords_parsedCorrectly() {
        Map<String, List<Integer>> result = bookScan.scan("cat\t\t  dog", 3);
        assertTrue(result.containsKey("CAT"));
        assertTrue(result.containsKey("DOG"));
        assertEquals(2, result.size());
    }

    @Test
    void scan_emptyLinesBetweenText_lineNumbersAccountForEmpties() {
        String text = "cat\n\n\ndog";
        Map<String, List<Integer>> result = bookScan.scan(text, 3);
        assertEquals(List.of(1), result.get("CAT"));
        assertEquals(List.of(4), result.get("DOG"));
    }

    @Test
    void scan_trailingNewlines_emptyLinesPreserved() {
        String text = "cat\n\n";
        Map<String, List<Integer>> result = bookScan.scan(text, 3);
        assertEquals(List.of(1), result.get("CAT"));
        assertEquals(1, result.size());
    }

    // ===== BRANCH COVERAGE: howManyTimes paths =====

    @Test
    void scan_wordAppearsMultipleTimesOnSameLine_lineAddedMultipleTimes() {
        String text = "cat sat cat";
        Map<String, List<Integer>> result = bookScan.scan(text, 3);
        // "cat" appears twice as token; howManyTimes("cat sat cat", "cat") = 2
        // processed twice: 2 + 2 = 4 entries of line 1
        assertEquals(List.of(1, 1, 1, 1), result.get("CAT"));
    }

    @Test
    void scan_noMatchingWords_returnsEmptyMap() {
        Map<String, List<Integer>> result = bookScan.scan("hello world", 3);
        assertTrue(result.isEmpty());
    }

    @Test
    void scan_sameWordOnMultipleLines_allLinesRecorded() {
        String text = "run\nfun\nrun";
        Map<String, List<Integer>> result = bookScan.scan(text, 3);
        assertEquals(List.of(1, 3), result.get("RUN"));
        assertEquals(List.of(2), result.get("FUN"));
    }

    // ===== BRANCH COVERAGE: flipCase paths =====

    @Test
    void scan_allUppercaseWord_flippedToLowercase() {
        Map<String, List<Integer>> result = bookScan.scan("ABC", 3);
        assertEquals(List.of(1), result.get("abc"));
    }

    @Test
    void scan_allLowercaseWord_flippedToUppercase() {
        Map<String, List<Integer>> result = bookScan.scan("abc", 3);
        assertEquals(List.of(1), result.get("ABC"));
    }

    @Test
    void scan_mixedCaseWord_eachCharFlipped() {
        Map<String, List<Integer>> result = bookScan.scan("AbC", 3);
        assertEquals(List.of(1), result.get("aBc"));
    }

    @Test
    void scan_wordWithDigitsAndSpecialChars_nonLettersUnchanged() {
        Map<String, List<Integer>> result = bookScan.scan("a1B", 3);
        assertEquals(List.of(1), result.get("A1b"));
    }

    // ===== INTEGRATION: combining flipCase/howManyTimes/strlen in scan =====

    @Test
    void scan_multiLineBookText_integratesAllMethods() {
        String text = "The Quick brown FOX\njumps Over the Lazy\nDOG the fox THE";
        // wordLength = 3: matches "The"(3), "FOX"(3), "the"(3), "DOG"(3), "fox"(3), "THE"(3)
        Map<String, List<Integer>> result = bookScan.scan(text, 3);

        // "The" on line 1: flipCase -> "tHE", howManyTimes("The Quick brown FOX", "The") = 1
        assertTrue(result.containsKey("tHE"));
        assertTrue(result.get("tHE").contains(1));

        // "FOX" on line 1: flipCase -> "fox", howManyTimes finds "FOX" once
        assertTrue(result.containsKey("fox"));
        assertTrue(result.get("fox").contains(1));

        // "the" on line 2: flipCase -> "THE", howManyTimes("jumps Over the Lazy", "the") = 1
        assertTrue(result.containsKey("THE"));
        assertTrue(result.get("THE").contains(2));

        // "DOG" on line 3: flipCase -> "dog"
        assertTrue(result.containsKey("dog"));
        assertTrue(result.get("dog").contains(3));

        // "fox" on line 3: flipCase -> "FOX"
        assertTrue(result.containsKey("FOX"));
        assertTrue(result.get("FOX").contains(3));
    }

    @Test
    void scan_overlappingSubstringInLine_howManyTimesCountsOverlaps() {
        // Line: "aa aa" with wordLength=2
        // Token "aa" appears twice; howManyTimes("aa aa", "aa") = 2
        // Each token encounter adds lineNumber twice → 4 total
        String text = "aa aa";
        Map<String, List<Integer>> result = bookScan.scan(text, 2);
        assertEquals(List.of(1, 1, 1, 1), result.get("AA"));
    }

    @Test
    void scan_tokenSubstringOfAnotherTokenOnSameLine_howManyTimesCountsAll() {
        // "ab xab ab" wordLength=2: token "ab" matches
        // howManyTimes("ab xab ab", "ab") finds "ab" at positions 0, 4, 7 → 3
        // "ab" appears as token twice (positions 0 and 7)
        // each token encounter: 3 entries → total 6
        String text = "ab xab ab";
        Map<String, List<Integer>> result = bookScan.scan(text, 2);
        assertEquals(List.of(1, 1, 1, 1, 1, 1), result.get("AB"));
    }

    @Test
    void scan_strlenUsedForFiltering_verifyLengthCheck() {
        // Verify strlen distinguishes words precisely
        String text = "to be or not";
        Map<String, List<Integer>> result = bookScan.scan(text, 2);
        assertTrue(result.containsKey("TO"));
        assertTrue(result.containsKey("BE"));
        assertTrue(result.containsKey("OR"));
        assertFalse(result.containsKey("NOT"));
        // "not" has length 3, should not appear
        assertEquals(3, result.size());
    }

    @Test
    void scan_resultPreservesInsertionOrder() {
        String text = "fox cat dog";
        Map<String, List<Integer>> result = bookScan.scan(text, 3);
        List<String> keys = new ArrayList<>(result.keySet());
        assertEquals("FOX", keys.get(0));
        assertEquals("CAT", keys.get(1));
        assertEquals("DOG", keys.get(2));
    }

    // ===== STANDALONE METHOD TESTS (used as primitives by scan) =====

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
    void howManyTimes_noMatch_returnsZero() {
        assertEquals(0, bookScan.howManyTimes("hello", "xyz"));
    }

    @Test
    void howManyTimes_singleMatch_returnsOne() {
        assertEquals(1, bookScan.howManyTimes("hello", "hell"));
    }

    @Test
    void howManyTimes_overlappingMatches_countsAll() {
        assertEquals(3, bookScan.howManyTimes("aaaa", "aa"));
    }

    @Test
    void howManyTimes_substringLongerThanString_returnsZero() {
        assertEquals(0, bookScan.howManyTimes("ab", "abc"));
    }

    @Test
    void flipCase_emptyString_returnsEmpty() {
        assertEquals("", bookScan.flipCase(""));
    }

    @Test
    void flipCase_digitsAndSymbols_unchanged() {
        assertEquals("123!@#", bookScan.flipCase("123!@#"));
    }

    @Test
    void strlen_emptyString_returnsZero() {
        assertEquals(0, bookScan.strlen(""));
    }

    @Test
    void strlen_nonEmptyString_returnsLength() {
        assertEquals(5, bookScan.strlen("hello"));
    }

    // ===== EDGE CASES =====

    @Test
    void scan_singleNewline_twoEmptyLines() {
        Map<String, List<Integer>> result = bookScan.scan("\n", 1);
        assertTrue(result.isEmpty());
    }

    @Test
    void scan_wordWithAllDigits_matchedByLength() {
        Map<String, List<Integer>> result = bookScan.scan("123 ab", 3);
        assertEquals(List.of(1), result.get("123"));
    }

    @Test
    void scan_caseSensitiveTokenDistinction_separateKeys() {
        // "Cat" and "cat" are different tokens → different flipped keys
        String text = "Cat cat";
        Map<String, List<Integer>> result = bookScan.scan(text, 3);
        // flipCase("Cat") = "cAT", flipCase("cat") = "CAT"
        assertTrue(result.containsKey("cAT"));
        assertTrue(result.containsKey("CAT"));
    }

    @Test
    void scan_longMultiLineBookPassage_fullIntegration() {
        String text = String.join("\n",
            "It was the best of times",
            "it was the worst of times",
            "it was the age of wisdom",
            "it was the age of foolishness"
        );
        Map<String, List<Integer>> result = bookScan.scan(text, 2);
        // "It" on line 1: flipCase -> "iT"
        assertTrue(result.containsKey("iT"));
        assertTrue(result.get("iT").get(0) == 1);
        // "it" on lines 2,3,4: flipCase -> "IT"
        assertTrue(result.containsKey("IT"));
        assertEquals(3, result.get("IT").stream().distinct().count());
        // "of" on all 4 lines: flipCase -> "OF"
        assertTrue(result.containsKey("OF"));
        assertEquals(List.of(1, 2, 3, 4), result.get("OF"));
    }
}
