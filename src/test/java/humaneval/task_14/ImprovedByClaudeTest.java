package humaneval.task_14;

import humaneval.claude.task_14.Solution;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ImprovedByClaudeTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    @DisplayName("empty string returns empty list")
    void emptyStringReturnsEmptyList() {
        assertEquals(Collections.emptyList(), solution.allPrefixes(""));
    }

    @Test
    @DisplayName("prefixes of a multi-character string are ordered shortest to longest")
    void prefixesOfMultiCharacterString() {
        assertEquals(
                Arrays.asList("a", "as", "asd", "asdf", "asdfg", "asdfgh"),
                solution.allPrefixes("asdfgh")
        );
    }

    @Test
    @DisplayName("prefixes of a string with repeated characters preserve each character")
    void prefixesOfRepeatedCharacterString() {
        assertEquals(
                Arrays.asList("W", "WW", "WWW"),
                solution.allPrefixes("WWW")
        );
    }

    @Test
    @DisplayName("single character string returns a single prefix")
    void singleCharacterString() {
        assertEquals(Collections.singletonList("x"), solution.allPrefixes("x"));
    }
}
