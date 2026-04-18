package humaneval.task_14;

import humaneval.gpt.task_14.Solution;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ImprovedByGptTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    @DisplayName("Empty string returns no prefixes")
    void emptyStringReturnsEmptyList() {
        assertEquals(List.of(), solution.allPrefixes(""));
    }

    @Test
    @DisplayName("Single character string returns one prefix")
    void singleCharacterReturnsSinglePrefix() {
        assertEquals(List.of("x"), solution.allPrefixes("x"));
    }

    @Test
    @DisplayName("Prefixes are returned from shortest to longest")
    void multiCharacterStringReturnsOrderedPrefixes() {
        assertEquals(
                List.of("a", "as", "asd", "asdf", "asdfg", "asdfgh"),
                solution.allPrefixes("asdfgh")
        );
    }

    @Test
    @DisplayName("Repeated characters are preserved in each prefix")
    void repeatedCharactersProduceDistinctGrowingPrefixes() {
        assertEquals(
                List.of("W", "WW", "WWW"),
                solution.allPrefixes("WWW")
        );
    }

    @Test
    @DisplayName("Whitespace is preserved when building prefixes")
    void prefixesPreserveWhitespace() {
        assertEquals(
                List.of("a", "a ", "a b"),
                solution.allPrefixes("a b")
        );
    }
}
