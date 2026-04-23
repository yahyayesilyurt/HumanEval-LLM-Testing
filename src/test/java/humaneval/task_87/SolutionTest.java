package humaneval.task_87;

import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SolutionTest {

    @Test
    void claude() {
        var s = new humaneval.claude.task_87.Solution();
        List<Boolean> correct = Arrays.asList(
                s.getRow(Arrays.asList(
                        Arrays.asList(1, 2, 3, 4, 5, 6),
                        Arrays.asList(1, 2, 3, 4, 1, 6),
                        Arrays.asList(1, 2, 3, 4, 5, 1)
                ), 1).equals(Arrays.asList(Arrays.asList(0, 0), Arrays.asList(1, 4), Arrays.asList(1, 0), Arrays.asList(2, 5), Arrays.asList(2, 0))),
                s.getRow(Arrays.asList(
                        Arrays.asList(1, 2, 3, 4, 5, 6),
                        Arrays.asList(1, 2, 3, 4, 5, 6),
                        Arrays.asList(1, 2, 3, 4, 5, 6),
                        Arrays.asList(1, 2, 3, 4, 5, 6),
                        Arrays.asList(1, 2, 3, 4, 5, 6),
                        Arrays.asList(1, 2, 3, 4, 5, 6)
                ), 2).equals(Arrays.asList(Arrays.asList(0, 1), Arrays.asList(1, 1), Arrays.asList(2, 1), Arrays.asList(3, 1), Arrays.asList(4, 1), Arrays.asList(5, 1))),
                s.getRow(Arrays.asList(
                        Arrays.asList(1, 2, 3, 4, 5, 6),
                        Arrays.asList(1, 2, 3, 4, 5, 6),
                        Arrays.asList(1, 1, 3, 4, 5, 6),
                        Arrays.asList(1, 2, 1, 4, 5, 6),
                        Arrays.asList(1, 2, 3, 1, 5, 6),
                        Arrays.asList(1, 2, 3, 4, 1, 6),
                        Arrays.asList(1, 2, 3, 4, 5, 1)
                ), 1).equals(Arrays.asList(Arrays.asList(0, 0), Arrays.asList(1, 0), Arrays.asList(2, 1), Arrays.asList(2, 0), Arrays.asList(3, 2), Arrays.asList(3, 0), Arrays.asList(4, 3), Arrays.asList(4, 0), Arrays.asList(5, 4), Arrays.asList(5, 0), Arrays.asList(6, 5), Arrays.asList(6, 0))),
                s.getRow(List.of(), 1).equals(List.of()),
                s.getRow(List.of(List.of(1)), 2).equals(List.of()),
                s.getRow(Arrays.asList(List.of(), List.of(1), Arrays.asList(1, 2, 3)), 3).equals(List.of(Arrays.asList(2, 2)))
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    
    }

    @Test
    void gpt() {
        var s = new humaneval.gpt.task_87.Solution();
        List<Boolean> correct = Arrays.asList(
                s.getRow(Arrays.asList(
                        Arrays.asList(1, 2, 3, 4, 5, 6),
                        Arrays.asList(1, 2, 3, 4, 1, 6),
                        Arrays.asList(1, 2, 3, 4, 5, 1)
                ), 1).equals(Arrays.asList(Arrays.asList(0, 0), Arrays.asList(1, 4), Arrays.asList(1, 0), Arrays.asList(2, 5), Arrays.asList(2, 0))),
                s.getRow(Arrays.asList(
                        Arrays.asList(1, 2, 3, 4, 5, 6),
                        Arrays.asList(1, 2, 3, 4, 5, 6),
                        Arrays.asList(1, 2, 3, 4, 5, 6),
                        Arrays.asList(1, 2, 3, 4, 5, 6),
                        Arrays.asList(1, 2, 3, 4, 5, 6),
                        Arrays.asList(1, 2, 3, 4, 5, 6)
                ), 2).equals(Arrays.asList(Arrays.asList(0, 1), Arrays.asList(1, 1), Arrays.asList(2, 1), Arrays.asList(3, 1), Arrays.asList(4, 1), Arrays.asList(5, 1))),
                s.getRow(Arrays.asList(
                        Arrays.asList(1, 2, 3, 4, 5, 6),
                        Arrays.asList(1, 2, 3, 4, 5, 6),
                        Arrays.asList(1, 1, 3, 4, 5, 6),
                        Arrays.asList(1, 2, 1, 4, 5, 6),
                        Arrays.asList(1, 2, 3, 1, 5, 6),
                        Arrays.asList(1, 2, 3, 4, 1, 6),
                        Arrays.asList(1, 2, 3, 4, 5, 1)
                ), 1).equals(Arrays.asList(Arrays.asList(0, 0), Arrays.asList(1, 0), Arrays.asList(2, 1), Arrays.asList(2, 0), Arrays.asList(3, 2), Arrays.asList(3, 0), Arrays.asList(4, 3), Arrays.asList(4, 0), Arrays.asList(5, 4), Arrays.asList(5, 0), Arrays.asList(6, 5), Arrays.asList(6, 0))),
                s.getRow(List.of(), 1).equals(List.of()),
                s.getRow(List.of(List.of(1)), 2).equals(List.of()),
                s.getRow(Arrays.asList(List.of(), List.of(1), Arrays.asList(1, 2, 3)), 3).equals(List.of(Arrays.asList(2, 2)))
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    
    }

    // Tests with mutations

    // EC6: searching for zero — Replace s with Mutate(s): target value mutated to 0
    @Test
    void searchForZero() {
        var s = new humaneval.claude.task_87.Solution();
        assertEquals(
                Arrays.asList(Arrays.asList(0, 0), Arrays.asList(1, 1)),
                s.getRow(Arrays.asList(Arrays.asList(0, 1), Arrays.asList(2, 0)), 0)
        );
    }

    // EC7: single cell grid, match — Remove/Repeat mutation: minimal 1x1 grid
    @Test
    void singleCellMatch() {
        var s = new humaneval.claude.task_87.Solution();
        assertEquals(
                List.of(Arrays.asList(0, 0)),
                s.getRow(List.of(List.of(5)), 5)
        );
    }

    // EC9: null outer list — NoneType: Returns None mutation
    @Test
    void nullOuterListThrowsException() {
        var s = new humaneval.claude.task_87.Solution();
        assertThrows(NullPointerException.class,
                () -> s.getRow(null, 1));
    }
}
