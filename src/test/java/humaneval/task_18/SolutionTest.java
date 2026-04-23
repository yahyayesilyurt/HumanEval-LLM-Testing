package humaneval.task_18;

import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertThrows;

class SolutionTest {

    @Test
    void claude() {
        var s = new humaneval.claude.task_18.Solution();
        List<Boolean> correct = Arrays.asList(
                s.howManyTimes("", "x") == 0,
                s.howManyTimes("xyxyxyx", "x") == 4,
                s.howManyTimes("cacacacac", "cac") == 4,
                s.howManyTimes("john doe", "john") == 1
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    
    }

    @Test
    void gpt() {
        var s = new humaneval.gpt.task_18.Solution();
        List<Boolean> correct = Arrays.asList(
                s.howManyTimes("", "x") == 0,
                s.howManyTimes("xyxyxyx", "x") == 4,
                s.howManyTimes("cacacacac", "cac") == 4,
                s.howManyTimes("john doe", "john") == 1
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    
    }

    // Tests with mutations
    // EC9: null main string
    @Test
    void nullStringThrowsException() {
        var s = new humaneval.claude.task_18.Solution();
        assertThrows(NullPointerException.class,
                () -> s.howManyTimes(null, "x"));
    }
}
