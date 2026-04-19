package humaneval.task_31;

import humaneval.gpt.task_31.Solution;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ImprovedByGptTest {

    private final Solution solution = new Solution();

    @Test
    void returnsFalseForNumbersLessThanTwo() {
        assertAll(
                () -> assertFalse(solution.isPrime(-7)),
                () -> assertFalse(solution.isPrime(0)),
                () -> assertFalse(solution.isPrime(1))
        );
    }

    @Test
    void returnsTrueForPrimeNumbersIncludingSmallBoundaryCases() {
        assertAll(
                () -> assertTrue(solution.isPrime(2)),
                () -> assertTrue(solution.isPrime(3)),
                () -> assertTrue(solution.isPrime(5)),
                () -> assertTrue(solution.isPrime(11)),
                () -> assertTrue(solution.isPrime(17)),
                () -> assertTrue(solution.isPrime(61)),
                () -> assertTrue(solution.isPrime(101)),
                () -> assertTrue(solution.isPrime(13441))
        );
    }

    @Test
    void returnsFalseForCompositeNumbers() {
        assertAll(
                () -> assertFalse(solution.isPrime(4)),
                () -> assertFalse(solution.isPrime(6)),
                () -> assertFalse(solution.isPrime(5 * 17)),
                () -> assertFalse(solution.isPrime(11 * 7)),
                () -> assertFalse(solution.isPrime(13441 * 19))
        );
    }
}
