package humaneval.task_0;

import humaneval.gpt.task_0.Solution;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ImprovedByGptTest {

    private final Solution solution = new Solution();

    @Test
    void detectsCloseElementsInUnsortedInput() {
        assertTrue(
                solution.hasCloseElements(List.of(11.0, 2.0, 3.9, 4.0, 5.0, 2.2), 0.3),
                "Expected a close pair to be found after sorting the input."
        );
    }

    @Test
    void returnsFalseWhenNoPairIsCloserThanThreshold() {
        assertFalse(
                solution.hasCloseElements(List.of(1.0, 2.0, 3.9, 4.0, 5.0, 2.2), 0.05),
                "Expected false when every adjacent pair is at least the threshold apart."
        );

        assertFalse(
                solution.hasCloseElements(List.of(1.1, 2.2, 3.1, 4.1, 5.1), 0.5),
                "Expected false when no pair of values is closer than 0.5."
        );
    }

    @Test
    void usesStrictlyLessThanThresholdComparison() {
        assertTrue(
                solution.hasCloseElements(List.of(1.0, 2.0, 5.9, 4.0, 5.0), 0.95),
                "Expected true because 5.0 and 5.9 differ by 0.9, which is less than 0.95."
        );

        assertFalse(
                solution.hasCloseElements(List.of(1.0, 2.0, 5.9, 4.0, 5.0), 0.9),
                "Expected false because the smallest difference equals the threshold, not less than it."
        );

        assertFalse(
                solution.hasCloseElements(List.of(1.0, 2.0, 5.9, 4.0, 5.0), 0.8),
                "Expected false because the smallest difference is 0.9, which is greater than 0.8."
        );
    }

    @Test
    void detectsDuplicateValuesAsCloseElements() {
        assertTrue(
                solution.hasCloseElements(List.of(1.0, 2.0, 3.0, 4.0, 5.0, 2.0), 0.1),
                "Expected true because duplicate values have a difference of 0.0."
        );
    }

    @Test
    void detectsCloseElementsWithLargerThresholds() {
        assertTrue(
                solution.hasCloseElements(List.of(1.1, 2.2, 3.1, 4.1, 5.1), 1.0),
                "Expected true because 3.1 and 4.1 differ by 0.9999999999999996, which is less than 1.0."
        );
    }
}
