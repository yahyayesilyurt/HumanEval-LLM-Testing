package humaneval.task_49;

import humaneval.gpt.task_49.Solution;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ImprovedByGptTest {

    private final Solution solution = new Solution();

    @Test
    void returnsExpectedValuesForDocumentedExamples() {
        assertAll(
                () -> assertEquals(3, solution.modp(3, 5)),
                () -> assertEquals(2, solution.modp(1101, 101)),
                () -> assertEquals(1, solution.modp(0, 101)),
                () -> assertEquals(8, solution.modp(3, 11)),
                () -> assertEquals(1, solution.modp(100, 101))
        );
    }

    @Test
    void producesExpectedCycleForConsecutiveExponentsModuloFive() {
        assertAll(
                () -> assertEquals(4, solution.modp(30, 5)),
                () -> assertEquals(3, solution.modp(31, 5))
        );
    }

    @Test
    void handlesEdgeCasesAroundModulusAndExactDivisibility() {
        assertAll(
                () -> assertEquals(0, solution.modp(0, 1)),
                () -> assertEquals(0, solution.modp(5, 1)),
                () -> assertEquals(0, solution.modp(10, 1024)),
                () -> assertEquals(1, solution.modp(10, 1023))
        );
    }

    @Test
    void matchesBigIntegerModPowForLargeInputs() {
        assertEquals(expectedModP(2048, 257), solution.modp(2048, 257));
    }

    private int expectedModP(int n, int p) {
        return BigInteger.TWO
                .modPow(BigInteger.valueOf(n), BigInteger.valueOf(p))
                .intValue();
    }
}
