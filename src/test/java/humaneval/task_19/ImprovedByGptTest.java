package humaneval.task_19;

import humaneval.gpt.task_19.Solution;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ImprovedByGptTest {

    private final Solution solution = new Solution();

    @Test
    void returnsEmptyStringForNullOrBlankInput() {
        assertAll(
                () -> assertEquals("", solution.sortNumbers(null)),
                () -> assertEquals("", solution.sortNumbers("")),
                () -> assertEquals("", solution.sortNumbers("   \t\n  "))
        );
    }

    @Test
    void returnsSingleNumeralUnchanged() {
        assertEquals("three", solution.sortNumbers("three"));
    }

    @Test
    void leavesAlreadySortedNumbersUnchanged() {
        assertEquals("three five nine", solution.sortNumbers("three five nine"));
    }

    @Test
    void sortsNumbersInAscendingOrder() {
        assertEquals(
                "zero four five seven eight nine",
                solution.sortNumbers("five zero four seven nine eight")
        );
    }

    @Test
    void preservesDuplicatesWhileSorting() {
        assertEquals(
                "zero one one two nine nine",
                solution.sortNumbers("nine one zero nine two one")
        );
    }
}
