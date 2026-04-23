package humaneval.task_57;

import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    void claude() {
        var s = new humaneval.claude.task_57.Solution();
        List<Boolean> correct = Arrays.asList(
                s.monotonic(new ArrayList<>(Arrays.asList(1, 2, 4, 10))),
                s.monotonic(new ArrayList<>(Arrays.asList(1, 2, 4, 20))),
                !s.monotonic(new ArrayList<>(Arrays.asList(1, 20, 4, 10))),
                s.monotonic(new ArrayList<>(Arrays.asList(4, 1, 0, -10))),
                s.monotonic(new ArrayList<>(Arrays.asList(4, 1, 1, 0))),
                !s.monotonic(new ArrayList<>(Arrays.asList(1, 2, 3, 2, 5, 60))),
                s.monotonic(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 60))),
                s.monotonic(new ArrayList<>(Arrays.asList(9, 9, 9, 9)))
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    
    }

    @Test
    void gpt() {
        var s = new humaneval.gpt.task_57.Solution();
        List<Boolean> correct = Arrays.asList(
                s.monotonic(new ArrayList<>(Arrays.asList(1, 2, 4, 10))),
                s.monotonic(new ArrayList<>(Arrays.asList(1, 2, 4, 20))),
                !s.monotonic(new ArrayList<>(Arrays.asList(1, 20, 4, 10))),
                s.monotonic(new ArrayList<>(Arrays.asList(4, 1, 0, -10))),
                s.monotonic(new ArrayList<>(Arrays.asList(4, 1, 1, 0))),
                !s.monotonic(new ArrayList<>(Arrays.asList(1, 2, 3, 2, 5, 60))),
                s.monotonic(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 60))),
                s.monotonic(new ArrayList<>(Arrays.asList(9, 9, 9, 9)))
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    
    }

    // Tests with mutations

    // EC11: null input — NoneType: Returns None mutation
    @Test
    void nullInputThrowsException() {
        var s = new humaneval.claude.task_57.Solution();
        assertThrows(NullPointerException.class,
                () -> s.monotonic(null));
    }

    // Boundary: increases then plateau — [1, 2, 2] should return true
    @Test
    void increasesThenPlateauReturnsTrue() {
        var s = new humaneval.claude.task_57.Solution();
        assertTrue(s.monotonic(Arrays.asList(1, 2, 2)));
    }
}
