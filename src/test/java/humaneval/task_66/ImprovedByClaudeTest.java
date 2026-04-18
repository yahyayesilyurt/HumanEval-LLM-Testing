package humaneval.task_66;

import humaneval.claude.task_66.Solution;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ImprovedByClaudeTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    @DisplayName("Empty string returns 0")
    void emptyStringReturnsZero() {
        assertEquals(0, solution.digitSum(""));
    }

    @Test
    @DisplayName("All lowercase string returns 0")
    void allLowercaseReturnsZero() {
        assertEquals(0, solution.digitSum("abcdef"));
    }

    @Test
    @DisplayName("Single uppercase character returns its ASCII code")
    void singleUppercaseReturnsAscii() {
        assertEquals(65, solution.digitSum("A"));
        assertEquals(90, solution.digitSum("Z"));
    }

    @Test
    @DisplayName("String with only uppercase letters sums all ASCII codes")
    void allUppercaseSumsAllAscii() {
        assertEquals(65 + 66 + 67, solution.digitSum("ABC"));
    }

    @Test
    @DisplayName("Digits and punctuation are ignored")
    void digitsAndPunctuationIgnored() {
        assertEquals(0, solution.digitSum("12345!?."));
        assertEquals(65, solution.digitSum("1A2?3"));
    }

    @Test
    @DisplayName("Whitespace characters are ignored")
    void whitespaceIgnored() {
        assertEquals(0, solution.digitSum("   \t\n"));
    }

    @ParameterizedTest(name = "digitSum(\"{0}\") == {1}")
    @CsvSource(delimiter = '|', value = {
            "''                  | 0",
            "abAB                | 131",
            "abcCd               | 67",
            "helloE              | 69",
            "woArBld             | 131",
            "aAaaaXa             | 153",
            "' How are yOu?'     | 151",
            "You arE Very Smart  | 327"
    })
    void specExamplesProduceExpectedSums(String input, int expected) {
        assertEquals(expected, solution.digitSum(input));
    }
}
