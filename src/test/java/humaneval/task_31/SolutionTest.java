package humaneval.task_31;

import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    void claude() {
        var s = new humaneval.claude.task_31.Solution();
        List<Boolean> correct = Arrays.asList(
                !s.isPrime(6),
                s.isPrime(101),
                s.isPrime(11),
                s.isPrime(13441),
                s.isPrime(61),
                !s.isPrime(4),
                !s.isPrime(1),
                s.isPrime(5),
                s.isPrime(11),
                s.isPrime(17),
                !s.isPrime(5 * 17),
                !s.isPrime(11 * 7),
                !s.isPrime(13441 * 19)
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    
    }

    @Test
    void gpt() {
        var s = new humaneval.gpt.task_31.Solution();
        List<Boolean> correct = Arrays.asList(
                !s.isPrime(6),
                s.isPrime(101),
                s.isPrime(11),
                s.isPrime(13441),
                s.isPrime(61),
                !s.isPrime(4),
                !s.isPrime(1),
                s.isPrime(5),
                s.isPrime(11),
                s.isPrime(17),
                !s.isPrime(5 * 17),
                !s.isPrime(11 * 7),
                !s.isPrime(13441 * 19)
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    
    }

    // Tests with mutations
    // Boundary: Exact negative boundary just below 0
    @Test
    void negativeOneIsNotPrime() {
        var s = new humaneval.claude.task_31.Solution();
        assertFalse(s.isPrime(-1));
    }

    // Boundary / Edge Case: Maximum integer value (causes infinite loop in naive i*i <= n implementations)
    @Test
    void integerMaxValueIsPrimeAndDoesNotOverflow() {
        var s = new humaneval.claude.task_31.Solution();
        assertTrue(s.isPrime(Integer.MAX_VALUE));
    }
}
