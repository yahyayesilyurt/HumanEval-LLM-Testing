package humaneval.task_18;

import humaneval.gpt.task_18.Solution;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ImprovedByGptTest {

    private final Solution solution = new Solution();

    @Test
    void returnsZeroWhenSubstringIsNull() {
        assertEquals(0, solution.howManyTimes("abc", null));
    }

    @Test
    void returnsZeroWhenSubstringIsEmpty() {
        assertEquals(0, solution.howManyTimes("abc", ""));
    }

    @Test
    void countsOverlappingOccurrences() {
        assertAll(
                () -> assertEquals(3, solution.howManyTimes("aaaa", "aa")),
                () -> assertEquals(4, solution.howManyTimes("cacacacac", "cac"))
        );
    }

    @Test
    void countsOccurrencesInTypicalCases() {
        assertAll(
                () -> assertEquals(0, solution.howManyTimes("", "x")),
                () -> assertEquals(4, solution.howManyTimes("xyxyxyx", "x")),
                () -> assertEquals(1, solution.howManyTimes("john doe", "john")),
                () -> assertEquals(0, solution.howManyTimes("abc", "z")),
                () -> assertEquals(0, solution.howManyTimes("abc", "abcd"))
        );
    }
}
