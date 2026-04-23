package humaneval.task_47;

import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertThrows;

class SolutionTest {

    @Test
    void claude() {
        var s = new humaneval.claude.task_47.Solution();
        List<Boolean> correct = Arrays.asList(
                s.median(new ArrayList<>(Arrays.asList(3, 1, 2, 4, 5))) == 3,
                s.median(new ArrayList<>(Arrays.asList(-10, 4, 6, 1000, 10, 20))) == 8.0,
                s.median(new ArrayList<>(Arrays.asList(5))) == 5,
                s.median(new ArrayList<>(Arrays.asList(6, 5))) == 5.5
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    
    }

    @Test
    void gpt() {
        var s = new humaneval.gpt.task_47.Solution();
        List<Boolean> correct = Arrays.asList(
                s.median(new ArrayList<>(Arrays.asList(3, 1, 2, 4, 5))) == 3,
                s.median(new ArrayList<>(Arrays.asList(-10, 4, 6, 1000, 10, 20))) == 8.0,
                s.median(new ArrayList<>(Arrays.asList(5))) == 5,
                s.median(new ArrayList<>(Arrays.asList(6, 5))) == 5.5
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    
    }

    // Tests with mutations
    // EC8: empty list
    @Test
    void emptyListThrowsException() {
        var s = new humaneval.claude.task_47.Solution();
        assertThrows(Exception.class,
                () -> s.median(List.of()));
    }

    // EC9: null list
    @Test
    void nullListThrowsException() {
        var s = new humaneval.claude.task_47.Solution();
        assertThrows(NullPointerException.class,
                () -> s.median(null));
    }
}
