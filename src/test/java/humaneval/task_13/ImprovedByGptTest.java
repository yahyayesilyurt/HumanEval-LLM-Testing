package humaneval.task_13;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ImprovedByGptTest {

    private final humaneval.gpt.task_13.Solution solution = new humaneval.gpt.task_13.Solution();

    @Test
    void greatestCommonDivisorReturnsExpectedValuesForPositiveInputs() {
        assertAll(
                () -> assertEquals(1, solution.greatestCommonDivisor(3, 7)),
                () -> assertEquals(5, solution.greatestCommonDivisor(10, 15)),
                () -> assertEquals(7, solution.greatestCommonDivisor(49, 14)),
                () -> assertEquals(12, solution.greatestCommonDivisor(144, 60))
        );
    }

    @Test
    void greatestCommonDivisorHandlesZeroInputs() {
        assertAll(
                () -> assertEquals(5, solution.greatestCommonDivisor(0, 5)),
                () -> assertEquals(5, solution.greatestCommonDivisor(5, 0)),
                () -> assertEquals(0, solution.greatestCommonDivisor(0, 0))
        );
    }

    @Test
    void greatestCommonDivisorUsesAbsoluteValuesForNegativeInputs() {
        assertAll(
                () -> assertEquals(6, solution.greatestCommonDivisor(-54, 24)),
                () -> assertEquals(6, solution.greatestCommonDivisor(54, -24)),
                () -> assertEquals(6, solution.greatestCommonDivisor(-54, -24))
        );
    }
}
