package humaneval.task_18;

import humaneval.claude.task_18.Solution;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ImprovedByClaudeTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void emptyStringReturnsZero() {
        assertEquals(0, solution.howManyTimes("", "x"));
    }

    @Test
    void emptySubstringReturnsZero() {
        assertEquals(0, solution.howManyTimes("abc", ""));
    }

    @Test
    void bothEmptyReturnsZero() {
        assertEquals(0, solution.howManyTimes("", ""));
    }

    @Test
    void countsNonOverlappingSingleCharOccurrences() {
        assertEquals(4, solution.howManyTimes("xyxyxyx", "x"));
    }

    @Test
    void countsOverlappingOccurrences() {
        assertEquals(4, solution.howManyTimes("cacacacac", "cac"));
    }

    @Test
    void countsSingleWordOccurrence() {
        assertEquals(1, solution.howManyTimes("john doe", "john"));
    }

    @Test
    void returnsZeroWhenSubstringNotPresent() {
        assertEquals(0, solution.howManyTimes("hello world", "xyz"));
    }

    @Test
    void returnsZeroWhenSubstringLongerThanString() {
        assertEquals(0, solution.howManyTimes("ab", "abcd"));
    }

    @Test
    void countsWhenSubstringEqualsString() {
        assertEquals(1, solution.howManyTimes("abc", "abc"));
    }

    @Test
    void countsAllOverlappingPairs() {
        assertEquals(3, solution.howManyTimes("aaaa", "aa"));
    }

    @Test
    void countsAllSingleChars() {
        assertEquals(3, solution.howManyTimes("aaa", "a"));
    }
}
