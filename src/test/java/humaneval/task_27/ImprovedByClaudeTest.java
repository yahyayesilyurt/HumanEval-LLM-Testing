package humaneval.task_27;

import humaneval.claude.task_27.Solution;
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
    @DisplayName("Empty string returns empty string")
    void flipCaseEmptyString() {
        assertEquals("", solution.flipCase(""));
    }

    @Test
    @DisplayName("Mixed case word with punctuation is flipped")
    void flipCaseMixedCaseWithPunctuation() {
        assertEquals("hELLO!", solution.flipCase("Hello!"));
    }

    @Test
    @DisplayName("Sentence with spaces has all letters flipped and spaces preserved")
    void flipCaseSentenceWithSpaces() {
        assertEquals(
                "tHESE VIOLENT DELIGHTS HAVE VIOLENT ENDS",
                solution.flipCase("These violent delights have violent ends")
        );
    }

    @Test
    @DisplayName("All lowercase becomes all uppercase")
    void flipCaseAllLowercase() {
        assertEquals("ABCXYZ", solution.flipCase("abcxyz"));
    }

    @Test
    @DisplayName("All uppercase becomes all lowercase")
    void flipCaseAllUppercase() {
        assertEquals("abcxyz", solution.flipCase("ABCXYZ"));
    }

    @Test
    @DisplayName("Digits and symbols are preserved unchanged")
    void flipCaseNonLetterCharactersUnchanged() {
        assertEquals("123 !@#_.", solution.flipCase("123 !@#_."));
    }

    @Test
    @DisplayName("Applying flipCase twice returns the original string (involution)")
    void flipCaseIsInvolution() {
        String original = "Hello, World! 42";
        assertEquals(original, solution.flipCase(solution.flipCase(original)));
    }

    @Test
    @DisplayName("Single lowercase character becomes uppercase")
    void flipCaseSingleLowercaseChar() {
        assertEquals("A", solution.flipCase("a"));
    }

    @Test
    @DisplayName("Single uppercase character becomes lowercase")
    void flipCaseSingleUppercaseChar() {
        assertEquals("a", solution.flipCase("A"));
    }

    @Test
    @DisplayName("Single non-letter character is preserved")
    void flipCaseSingleNonLetterChar() {
        assertEquals("5", solution.flipCase("5"));
    }
}
