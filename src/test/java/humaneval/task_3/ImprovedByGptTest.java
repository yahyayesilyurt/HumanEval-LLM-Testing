package humaneval.task_3;

import humaneval.gpt.task_3.Solution;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ImprovedByGptTest {

    private final Solution solution = new Solution();

    @Test
    void returnsFalseForEmptyOperations() {
        assertFalse(solution.belowZero(List.of()));
    }

    @Test
    void returnsFalseWhenBalanceNeverGoesBelowZero() {
        assertFalse(solution.belowZero(List.of(1, 2, -3, 1, 2, -3)));
    }

    @Test
    void returnsTrueWhenBalanceDropsBelowZeroAfterSeveralOperations() {
        assertTrue(solution.belowZero(List.of(1, 2, -4, 5, 6)));
    }

    @Test
    void returnsFalseWhenBalanceTouchesZeroButNeverBecomesNegative() {
        assertFalse(solution.belowZero(List.of(1, -1, 2, -2, 5, -5, 4, -4)));
    }

    @Test
    void returnsTrueWhenFinalOperationMakesBalanceNegative() {
        assertTrue(solution.belowZero(List.of(1, -1, 2, -2, 5, -5, 4, -5)));
    }

    @Test
    void returnsTrueWhenBalanceBecomesNegativeEarly() {
        assertTrue(solution.belowZero(List.of(1, -2, 2, -2, 5, -5, 4, -4)));
    }
}
