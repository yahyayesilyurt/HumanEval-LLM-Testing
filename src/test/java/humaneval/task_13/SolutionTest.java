package humaneval.task_13;

import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void claude() {
        var s = new humaneval.claude.task_13.Solution();
        List<Boolean> correct = Arrays.asList(
                s.greatestCommonDivisor(3, 7) == 1,
                s.greatestCommonDivisor(10, 15) == 5,
                s.greatestCommonDivisor(49, 14) == 7,
                s.greatestCommonDivisor(144, 60) == 12
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    
    }

    @Test
    void gpt() {
        var s = new humaneval.gpt.task_13.Solution();
        List<Boolean> correct = Arrays.asList(
                s.greatestCommonDivisor(3, 7) == 1,
                s.greatestCommonDivisor(10, 15) == 5,
                s.greatestCommonDivisor(49, 14) == 7,
                s.greatestCommonDivisor(144, 60) == 12
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    
    }

    // Tests with mutations
    // EC3 & Boundary: One is a multiple of the other (non-zero)
    @Test
    void gcdWhenOneIsMultipleOfOther() {
        var s = new humaneval.claude.task_13.Solution();
        assertEquals(4, s.greatestCommonDivisor(12, 4));
        assertEquals(4, s.greatestCommonDivisor(4, 12));
    }
}
