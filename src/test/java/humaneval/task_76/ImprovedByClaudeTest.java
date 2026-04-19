package humaneval.task_76;

import humaneval.claude.task_76.Solution;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ImprovedByClaudeTest {

    private final Solution solution = new Solution();

    @Test
    @DisplayName("1 is a simple power of any base")
    void oneIsSimplePowerOfAnyBase() {
        assertTrue(solution.isSimplePower(1, 4));
        assertTrue(solution.isSimplePower(1, 1));
        assertTrue(solution.isSimplePower(1, 12));
    }

    @Test
    @DisplayName("base itself is a simple power (n^1 = n)")
    void baseItselfIsSimplePower() {
        assertTrue(solution.isSimplePower(2, 2));
    }

    @Test
    @DisplayName("higher powers of 2 are detected")
    void higherPowersOfTwo() {
        assertTrue(solution.isSimplePower(4, 2));
        assertTrue(solution.isSimplePower(8, 2));
        assertTrue(solution.isSimplePower(16, 2));
    }

    @Test
    @DisplayName("powers of 3 and 4 are detected")
    void powersOfThreeAndFour() {
        assertTrue(solution.isSimplePower(9, 3));
        assertTrue(solution.isSimplePower(16, 4));
    }

    @Test
    @DisplayName("non-powers of 2 return false")
    void nonPowersOfTwo() {
        assertFalse(solution.isSimplePower(3, 2));
        assertFalse(solution.isSimplePower(24, 2));
    }

    @Test
    @DisplayName("values above any power of 1 other than 1 return false")
    void valuesGreaterThanOneAreNotPowersOfOne() {
        assertFalse(solution.isSimplePower(3, 1));
    }

    @Test
    @DisplayName("non-powers of 3, 4, and 6 return false")
    void nonPowersOfOtherBases() {
        assertFalse(solution.isSimplePower(5, 3));
        assertFalse(solution.isSimplePower(128, 4));
        assertFalse(solution.isSimplePower(12, 6));
    }

    @Test
    @DisplayName("large non-power of 16 returns false")
    void largeNonPowerOfSixteen() {
        assertFalse(solution.isSimplePower(143214, 16));
    }
}
