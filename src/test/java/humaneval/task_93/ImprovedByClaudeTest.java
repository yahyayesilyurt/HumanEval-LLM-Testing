package humaneval.task_93;

import humaneval.claude.task_93.Solution;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ImprovedByClaudeTest {

    private final Solution solution = new Solution();

    @Test
    @DisplayName("encodes all-uppercase input by lowercasing and shifting vowels by 2")
    void encodesAllUppercaseInput() {
        assertEquals("tgst", solution.encode("TEST"));
    }

    @Test
    @DisplayName("encodes mixed-case input swapping case and shifting vowels")
    void encodesMixedCaseInput() {
        assertEquals("mWDCSKR", solution.encode("Mudasir"));
    }

    @Test
    @DisplayName("encodes another all-uppercase input")
    void encodesAnotherAllUppercaseInput() {
        assertEquals("ygs", solution.encode("YES"));
    }

    @Test
    @DisplayName("encodes sentence with spaces preserving whitespace")
    void encodesSentenceWithSpaces() {
        assertEquals("tHKS KS C MGSSCGG", solution.encode("This is a message"));
    }

    @Test
    @DisplayName("encodes long mixed-case sentence with all vowel variants")
    void encodesLongMixedCaseSentence() {
        assertEquals("k dQnT kNqW wHcT Tq wRkTg", solution.encode("I DoNt KnOw WhAt tO WrItE"));
    }

    @Test
    @DisplayName("returns empty string for empty input")
    void returnsEmptyStringForEmptyInput() {
        assertEquals("", solution.encode(""));
    }

    @Test
    @DisplayName("shifts lowercase vowel a to uppercase C")
    void shiftsLowercaseVowelA() {
        assertEquals("C", solution.encode("a"));
    }

    @Test
    @DisplayName("shifts lowercase vowel e to uppercase G")
    void shiftsLowercaseVowelE() {
        assertEquals("G", solution.encode("e"));
    }

    @Test
    @DisplayName("shifts lowercase vowel i to uppercase K")
    void shiftsLowercaseVowelI() {
        assertEquals("K", solution.encode("i"));
    }

    @Test
    @DisplayName("shifts lowercase vowel o to uppercase Q")
    void shiftsLowercaseVowelO() {
        assertEquals("Q", solution.encode("o"));
    }

    @Test
    @DisplayName("shifts lowercase vowel u to uppercase W")
    void shiftsLowercaseVowelU() {
        assertEquals("W", solution.encode("u"));
    }

    @Test
    @DisplayName("shifts uppercase vowel A to lowercase c")
    void shiftsUppercaseVowelA() {
        assertEquals("c", solution.encode("A"));
    }

    @Test
    @DisplayName("shifts uppercase vowel E to lowercase g")
    void shiftsUppercaseVowelE() {
        assertEquals("g", solution.encode("E"));
    }

    @Test
    @DisplayName("shifts uppercase vowel I to lowercase k")
    void shiftsUppercaseVowelI() {
        assertEquals("k", solution.encode("I"));
    }

    @Test
    @DisplayName("shifts uppercase vowel O to lowercase q")
    void shiftsUppercaseVowelO() {
        assertEquals("q", solution.encode("O"));
    }

    @Test
    @DisplayName("shifts uppercase vowel U to lowercase w")
    void shiftsUppercaseVowelU() {
        assertEquals("w", solution.encode("U"));
    }

    @Test
    @DisplayName("swaps case of consonant without shifting")
    void swapsCaseOfLowercaseConsonant() {
        assertEquals("B", solution.encode("b"));
    }

    @Test
    @DisplayName("swaps case of uppercase consonant without shifting")
    void swapsCaseOfUppercaseConsonant() {
        assertEquals("z", solution.encode("Z"));
    }
}
