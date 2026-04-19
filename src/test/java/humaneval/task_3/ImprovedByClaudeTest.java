package humaneval.task_3;

import humaneval.claude.task_3.Solution;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ImprovedByClaudeTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    @DisplayName("Empty operations list never goes below zero")
    void emptyOperationsReturnsFalse() {
        assertFalse(solution.belowZero(Collections.emptyList()));
    }

    @Test
    @DisplayName("All positive operations stay above zero")
    void allPositiveOperationsReturnsFalse() {
        assertFalse(solution.belowZero(Arrays.asList(1, 2, 3)));
    }

    @Test
    @DisplayName("Balance returning to zero but never negative returns false")
    void balanceReturnsToZeroWithoutGoingNegativeReturnsFalse() {
        assertFalse(solution.belowZero(Arrays.asList(1, 2, -3, 1, 2, -3)));
    }

    @Test
    @DisplayName("Net-zero alternating deposits and withdrawals returns false")
    void alternatingDepositsAndWithdrawalsReturnsFalse() {
        assertFalse(solution.belowZero(Arrays.asList(1, -1, 2, -2, 5, -5, 4, -4)));
    }

    @Test
    @DisplayName("Balance dips below zero mid-sequence returns true")
    void balanceDipsBelowZeroMidSequenceReturnsTrue() {
        assertTrue(solution.belowZero(Arrays.asList(1, 2, -4, 5, 6)));
    }

    @Test
    @DisplayName("Balance goes below zero only on final operation returns true")
    void balanceBelowZeroOnFinalOperationReturnsTrue() {
        assertTrue(solution.belowZero(Arrays.asList(1, -1, 2, -2, 5, -5, 4, -5)));
    }

    @Test
    @DisplayName("Balance goes below zero early then recovers still returns true")
    void balanceBelowZeroEarlyThenRecoversReturnsTrue() {
        assertTrue(solution.belowZero(Arrays.asList(1, -2, 2, -2, 5, -5, 4, -4)));
    }

    @Test
    @DisplayName("Single negative operation from zero returns true")
    void singleNegativeOperationReturnsTrue() {
        assertTrue(solution.belowZero(Collections.singletonList(-1)));
    }

    @Test
    @DisplayName("Single zero operation returns false")
    void singleZeroOperationReturnsFalse() {
        assertFalse(solution.belowZero(Collections.singletonList(0)));
    }

    @Test
    @DisplayName("First operation drives balance negative returns true")
    void firstOperationNegativeReturnsTrue() {
        assertTrue(solution.belowZero(Arrays.asList(-5, 10, 20)));
    }
}
