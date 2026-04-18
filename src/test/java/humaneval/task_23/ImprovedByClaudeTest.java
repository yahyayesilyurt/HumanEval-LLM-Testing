package humaneval.task_23;

import humaneval.claude.task_23.Solution;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ImprovedByClaudeTest {

    @Test
    void strlenOfEmptyStringIsZero() {
        Solution s = new Solution();
        assertEquals(0, s.strlen(""));
    }

    @Test
    void strlenOfSingleCharacterIsOne() {
        Solution s = new Solution();
        assertEquals(1, s.strlen("x"));
    }

    @Test
    void strlenOfMultiCharacterString() {
        Solution s = new Solution();
        assertEquals(9, s.strlen("asdasnakj"));
    }

    @Test
    void strlenOfExampleFromDocstring() {
        Solution s = new Solution();
        assertEquals(3, s.strlen("abc"));
    }

    @Test
    void strlenCountsWhitespaceCharacters() {
        Solution s = new Solution();
        assertEquals(5, s.strlen("a b c"));
    }
}
