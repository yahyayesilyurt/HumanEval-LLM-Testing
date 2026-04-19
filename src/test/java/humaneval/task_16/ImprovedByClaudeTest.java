package humaneval.task_16;

import humaneval.claude.task_16.Solution;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ImprovedByClaudeTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    @DisplayName("Empty string has zero distinct characters")
    void emptyStringReturnsZero() {
        assertEquals(0, solution.countDistinctCharacters(""));
    }

    @Test
    @DisplayName("All unique lowercase characters counted correctly")
    void allUniqueLowercaseCharacters() {
        assertEquals(5, solution.countDistinctCharacters("abcde"));
    }

    @Test
    @DisplayName("Mixed case duplicates counted as same character")
    void mixedCaseDuplicatesTreatedAsSame() {
        assertEquals(5, solution.countDistinctCharacters("abcdecadeCADE"));
    }

    @Test
    @DisplayName("Single repeated character regardless of case returns one")
    void singleRepeatedCharacterRegardlessOfCase() {
        assertEquals(1, solution.countDistinctCharacters("aaaaAAAAaaaa"));
    }

    @Test
    @DisplayName("Word with mixed case and spaces counts distinct characters")
    void wordWithMixedCaseAndSpaces() {
        assertEquals(5, solution.countDistinctCharacters("Jerry jERRY JeRRRY"));
    }

    @Test
    @DisplayName("Single character string returns one")
    void singleCharacterReturnsOne() {
        assertEquals(1, solution.countDistinctCharacters("a"));
    }

    @Test
    @DisplayName("String with digits and symbols counts each distinctly")
    void digitsAndSymbolsCountedDistinctly() {
        assertEquals(6, solution.countDistinctCharacters("1!2@3#"));
    }

    @Test
    @DisplayName("Whitespace characters are counted as distinct characters")
    void whitespaceCountedAsCharacter() {
        assertEquals(2, solution.countDistinctCharacters("a a a"));
    }

    @Test
    @DisplayName("Uppercase-only string counted by lowercased characters")
    void uppercaseOnlyStringCountedByLowercase() {
        assertEquals(3, solution.countDistinctCharacters("XYZ"));
    }

    @Test
    @DisplayName("Unicode characters counted distinctly")
    void unicodeCharactersCountedDistinctly() {
        assertEquals(3, solution.countDistinctCharacters("äöüÄÖÜ"));
    }
}
