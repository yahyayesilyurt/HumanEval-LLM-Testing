package humaneval.task_3;

import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SolutionTest {

    @Test
    void claude() {
        var s = new humaneval.claude.task_3.Solution();
        List<Boolean> correct = Arrays.asList(
                !s.belowZero(new ArrayList<>(Arrays.asList())),
                !s.belowZero(new ArrayList<>(Arrays.asList(1, 2, -3, 1, 2, -3))),
                s.belowZero(new ArrayList<>(Arrays.asList(1, 2, -4, 5, 6))),
                !s.belowZero(new ArrayList<>(Arrays.asList(1, -1, 2, -2, 5, -5, 4, -4))),
                s.belowZero(new ArrayList<>(Arrays.asList(1, -1, 2, -2, 5, -5, 4, -5))),
                s.belowZero(new ArrayList<>(Arrays.asList(1, -2, 2, -2, 5, -5, 4, -4)))
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    
    }

    @Test
    void gpt() {
        var s = new humaneval.gpt.task_3.Solution();
        List<Boolean> correct = Arrays.asList(
                !s.belowZero(new ArrayList<>(Arrays.asList())),
                !s.belowZero(new ArrayList<>(Arrays.asList(1, 2, -3, 1, 2, -3))),
                s.belowZero(new ArrayList<>(Arrays.asList(1, 2, -4, 5, 6))),
                !s.belowZero(new ArrayList<>(Arrays.asList(1, -1, 2, -2, 5, -5, 4, -4))),
                s.belowZero(new ArrayList<>(Arrays.asList(1, -1, 2, -2, 5, -5, 4, -5))),
                s.belowZero(new ArrayList<>(Arrays.asList(1, -2, 2, -2, 5, -5, 4, -4)))
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    
    }

    // Tests with mutations
    // EC6: Single positive operation
    @Test
    void singlePositiveOperationReturnsFalse() {
        var s = new humaneval.claude.task_3.Solution();
        assertFalse(s.belowZero(Collections.singletonList(10)));
    }

    // EC10: null input
    @Test
    void nullInputThrowsException() {
        var s = new humaneval.claude.task_3.Solution();
        assertThrows(NullPointerException.class,
                () -> s.belowZero(null));
    }
}
