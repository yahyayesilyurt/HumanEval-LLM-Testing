package humaneval.task_23;

import humaneval.gpt.task_23.Solution;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ImprovedByGptTest {

    private final Solution solution = new Solution();

    @Test
    void returnsZeroForEmptyString() {
        assertEquals(0, solution.strlen(""));
    }

    @Test
    void returnsOneForSingleCharacterString() {
        assertEquals(1, solution.strlen("x"));
    }

    @Test
    void returnsLengthForLongerString() {
        assertEquals(9, solution.strlen("asdasnakj"));
    }
}
