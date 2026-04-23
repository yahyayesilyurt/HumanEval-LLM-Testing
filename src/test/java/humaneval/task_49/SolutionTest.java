package humaneval.task_49;

import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SolutionTest {

    @Test
    void claude() {
        var s = new humaneval.claude.task_49.Solution();
        List<Boolean> correct = Arrays.asList(
                s.modp(3, 5) == 3,
                s.modp(1101, 101) == 2,
                s.modp(0, 101) == 1,
                s.modp(3, 11) == 8,
                s.modp(100, 101) == 1,
                s.modp(30, 5) == 4,
                s.modp(31, 5) == 3
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    
    }

    @Test
    void gpt() {
        var s = new humaneval.gpt.task_49.Solution();
        List<Boolean> correct = Arrays.asList(
                s.modp(3, 5) == 3,
                s.modp(1101, 101) == 2,
                s.modp(0, 101) == 1,
                s.modp(3, 11) == 8,
                s.modp(100, 101) == 1,
                s.modp(30, 5) == 4,
                s.modp(31, 5) == 3
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    
    }

    // Tests with mutations
    // EC8: p = 0 causes division by zero
    @Test
    void modulusZeroThrowsArithmeticException() {
        var s = new humaneval.claude.task_49.Solution();
        assertThrows(ArithmeticException.class,
                () -> s.modp(3, 0));
    }

    // EC9: Negative exponent might not be supported or requires modular inverse
    @Test
    void negativeExponentReturnsOne() {
        var s = new humaneval.claude.task_49.Solution();
        assertEquals(1, s.modp(-3, 5));
    }

    // EC10: Negative modulus behavior
    @Test
    void negativeModulusStillComputesResult() {
        var s = new humaneval.claude.task_49.Solution();
        assertEquals(3, s.modp(3, -5));
    }
}
