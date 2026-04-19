package humaneval.task_64;

import humaneval.claude.task_64.Solution;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ImprovedByClaudeTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @ParameterizedTest(name = "vowelsCount(\"{0}\") == {1}")
    @CsvSource({
            "abcde, 2",
            "Alone, 3",
            "key, 2",
            "bye, 1",
            "keY, 2",
            "bYe, 1",
            "ACEDY, 3"
    })
    @DisplayName("Counts standard vowels and trailing y across sample words")
    void countsVowelsForSampleWords(String input, int expected) {
        assertEquals(expected, solution.vowelsCount(input));
    }

    @ParameterizedTest(name = "vowelsCount(\"{0}\") == 1")
    @ValueSource(strings = {"a", "E", "i", "O", "u"})
    @DisplayName("Single-letter vowels count as one")
    void singleVowelLettersCountAsOne(String input) {
        assertEquals(1, solution.vowelsCount(input));
    }

    @Test
    @DisplayName("Standalone y at end counts as a vowel")
    void standaloneYCountsAsVowel() {
        assertEquals(1, solution.vowelsCount("y"));
        assertEquals(1, solution.vowelsCount("Y"));
    }

    @Test
    @DisplayName("Y only counts when it is the last character")
    void yOnlyCountsAtEnd() {
        assertEquals(1, solution.vowelsCount("yba"));
        assertEquals(1, solution.vowelsCount("Yba"));
    }

    @Test
    @DisplayName("Words without vowels return zero")
    void wordWithoutVowelsReturnsZero() {
        assertEquals(0, solution.vowelsCount("bcdfg"));
        assertEquals(0, solution.vowelsCount("BCDFG"));
    }

    @Test
    @DisplayName("Trailing y adds exactly one to the vowel count")
    void trailingYAddsOneToVowelCount() {
        assertEquals(3, solution.vowelsCount("easy"));
        assertEquals(4, solution.vowelsCount("EASILY"));
    }

    @Test
    @DisplayName("Counts every vowel occurrence in a long word")
    void countsEveryVowelInLongWord() {
        assertEquals(5, solution.vowelsCount("education"));
    }

    @Test
    @DisplayName("Uppercase vowels are counted the same as lowercase")
    void uppercaseVowelsCountedSameAsLowercase() {
        assertEquals(solution.vowelsCount("education"), solution.vowelsCount("EDUCATION"));
    }
}
