package humaneval.task_86;

import humaneval.claude.task_86.Solution;
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
    @DisplayName("empty string returns empty string")
    void emptyString() {
        assertEquals("", solution.antiShuffle(""));
    }

    @Test
    @DisplayName("single character is unchanged")
    void singleCharacter() {
        assertEquals("a", solution.antiShuffle("a"));
    }

    @Test
    @DisplayName("already-sorted single word is unchanged")
    void alreadySortedWord() {
        assertEquals("abcd", solution.antiShuffle("abcd"));
    }

    @Test
    @DisplayName("two-character word preserves its order when already sorted")
    void twoCharacterSortedWord() {
        assertEquals("Hi", solution.antiShuffle("Hi"));
    }

    @ParameterizedTest(name = "antiShuffle(\"{0}\") = \"{1}\"")
    @CsvSource(delimiter = '|', value = {
            "hello            | ehllo",
            "number           | bemnru",
            "world            | dlorw"
    })
    @DisplayName("single word is sorted by ASCII value")
    void singleWordIsSorted(String input, String expected) {
        assertEquals(expected, solution.antiShuffle(input));
    }

    @Test
    @DisplayName("uppercase letters sort before lowercase (ASCII order)")
    void asciiOrderingMixesCase() {
        assertEquals("Hello !!!Wdlor", solution.antiShuffle("Hello World!!!"));
    }

    @Test
    @DisplayName("punctuation is sorted along with letters by ASCII value")
    void punctuationIsSorted() {
        assertEquals(".Hi My aemn is Meirst .Rboot How aer ?ouy",
                solution.antiShuffle("Hi. My name is Mister Robot. How are you?"));
    }

    @Test
    @DisplayName("word order and single-space separators are preserved")
    void wordOrderPreserved() {
        assertEquals("abc def ghi", solution.antiShuffle("cba fed ihg"));
    }

    @Test
    @DisplayName("consecutive spaces produce empty sorted tokens, preserving spacing")
    void consecutiveSpacesPreserved() {
        assertEquals("abc  def", solution.antiShuffle("cba  fed"));
    }

    @Test
    @DisplayName("leading and trailing spaces are preserved")
    void leadingAndTrailingSpacesPreserved() {
        assertEquals(" abc def ", solution.antiShuffle(" cba fed "));
    }

    @Test
    @DisplayName("string containing only spaces is returned unchanged")
    void onlySpaces() {
        assertEquals("   ", solution.antiShuffle("   "));
    }

    @Test
    @DisplayName("digits are sorted by ASCII value within a word")
    void digitsAreSorted() {
        assertEquals("12345", solution.antiShuffle("53124"));
    }

    @Test
    @DisplayName("returned string has the same length as the input")
    void lengthIsPreserved() {
        String input = "The quick brown fox jumps over the lazy dog";
        assertEquals(input.length(), solution.antiShuffle(input).length());
    }
}
