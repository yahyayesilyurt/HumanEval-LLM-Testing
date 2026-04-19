package humaneval.task_76;

import humaneval.gpt.task_76.Solution;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ImprovedByGptTest {

    private final Solution solution = new Solution();

    @Test
    void returnsTrueWhenXIsOne() {
        assertAll(
                () -> assertTrue(solution.isSimplePower(1, 4)),
                () -> assertTrue(solution.isSimplePower(1, 1)),
                () -> assertTrue(solution.isSimplePower(1, 12))
        );
    }

    @Test
    void returnsTrueForExactPowersOfValidBases() {
        assertAll(
                () -> assertTrue(solution.isSimplePower(2, 2)),
                () -> assertTrue(solution.isSimplePower(4, 2)),
                () -> assertTrue(solution.isSimplePower(8, 2)),
                () -> assertTrue(solution.isSimplePower(16, 2)),
                () -> assertTrue(solution.isSimplePower(9, 3)),
                () -> assertTrue(solution.isSimplePower(16, 4))
        );
    }

    @Test
    void returnsFalseForNumbersThatAreNotSimplePowers() {
        assertAll(
                () -> assertFalse(solution.isSimplePower(3, 2)),
                () -> assertFalse(solution.isSimplePower(5, 3)),
                () -> assertFalse(solution.isSimplePower(24, 2)),
                () -> assertFalse(solution.isSimplePower(128, 4)),
                () -> assertFalse(solution.isSimplePower(12, 6)),
                () -> assertFalse(solution.isSimplePower(143214, 16))
        );
    }

    @Test
    void returnsFalseForNonPositiveXOrInvalidBaseGreaterThanOneRequirement() {
        assertAll(
                () -> assertFalse(solution.isSimplePower(0, 2)),
                () -> assertFalse(solution.isSimplePower(-8, 2)),
                () -> assertFalse(solution.isSimplePower(3, 1)),
                () -> assertFalse(solution.isSimplePower(9, 0)),
                () -> assertFalse(solution.isSimplePower(9, -3))
        );
    }
}
