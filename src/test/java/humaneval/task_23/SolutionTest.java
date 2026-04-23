package humaneval.task_23;

import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SolutionTest {

    @Test
    void claude() {
        var s = new humaneval.claude.task_23.Solution();
        List<Boolean> correct = Arrays.asList(
                s.strlen("") == 0,
                s.strlen("x") == 1,
                s.strlen("asdasnakj") == 9
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    
    }

    @Test
    void gpt() {
        var s = new humaneval.gpt.task_23.Solution();
        List<Boolean> correct = Arrays.asList(
                s.strlen("") == 0,
                s.strlen("x") == 1,
                s.strlen("asdasnakj") == 9
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    
    }

    // Tests with mutations
    // EC5: special characters
    @Test
    void stringWithSpecialCharacters() {
        var s = new humaneval.claude.task_23.Solution();
        assertEquals(3, s.strlen("ab!"));
    }

    // EC6: null input
    @Test
    void nullInputThrowsException() {
        var s = new humaneval.claude.task_23.Solution();
        assertThrows(NullPointerException.class,
                () -> s.strlen(null));
    }

    // EC7: Surrogate pairs / Emojis (Java length returns code units, not code points)
    @Test
    void surrogatePairsReturnTwoCodeUnits() {
        var s = new humaneval.claude.task_23.Solution();
        assertEquals(2, s.strlen("😀"));
    }
}
