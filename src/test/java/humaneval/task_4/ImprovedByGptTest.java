package humaneval.task_4;

import humaneval.gpt.task_4.Solution;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ImprovedByGptTest {

    private static final double EPSILON = 1e-9;

    @Test
    void computesMeanAbsoluteDeviationForTypicalInputs() {
        Solution solution = new Solution();

        assertEquals(2.0 / 3.0,
                solution.meanAbsoluteDeviation(Arrays.asList(1.0, 2.0, 3.0)),
                EPSILON);

        assertEquals(1.0,
                solution.meanAbsoluteDeviation(Arrays.asList(1.0, 2.0, 3.0, 4.0)),
                EPSILON);

        assertEquals(6.0 / 5.0,
                solution.meanAbsoluteDeviation(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0)),
                EPSILON);
    }

    @Test
    void returnsZeroForSingleElementList() {
        Solution solution = new Solution();

        assertEquals(0.0, solution.meanAbsoluteDeviation(Collections.singletonList(42.0)), EPSILON);
    }

    @Test
    void throwsIllegalArgumentExceptionForNullInput() {
        Solution solution = new Solution();

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> solution.meanAbsoluteDeviation(null)
        );

        assertEquals("numbers must not be null or empty", exception.getMessage());
    }

    @Test
    void throwsIllegalArgumentExceptionForEmptyInput() {
        Solution solution = new Solution();

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> solution.meanAbsoluteDeviation(Collections.emptyList())
        );

        assertEquals("numbers must not be null or empty", exception.getMessage());
    }
}
