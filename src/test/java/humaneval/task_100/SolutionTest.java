package humaneval.task_100;

import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void claude() {
        var s = new humaneval.claude.task_100.Solution();
        List<Boolean> correct = Arrays.asList(
                s.makeAPile(3).equals(Arrays.asList(3, 5, 7)),
                s.makeAPile(4).equals(Arrays.asList(4, 6, 8, 10)),
                s.makeAPile(5).equals(Arrays.asList(5, 7, 9, 11, 13)),
                s.makeAPile(6).equals(Arrays.asList(6, 8, 10, 12, 14, 16)),
                s.makeAPile(8).equals(Arrays.asList(8, 10, 12, 14, 16, 18, 20, 22))
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    
    }

    @Test
    void gpt() {
        var s = new humaneval.gpt.task_100.Solution();
        List<Boolean> correct = Arrays.asList(
                s.makeAPile(3).equals(Arrays.asList(3, 5, 7)),
                s.makeAPile(4).equals(Arrays.asList(4, 6, 8, 10)),
                s.makeAPile(5).equals(Arrays.asList(5, 7, 9, 11, 13)),
                s.makeAPile(6).equals(Arrays.asList(6, 8, 10, 12, 14, 16)),
                s.makeAPile(8).equals(Arrays.asList(8, 10, 12, 14, 16, 18, 20, 22))
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    
    }

    // Tests with mutations

    // EC6: n = 0 — Returns x-1 mutation: boundary at zero, expect empty list
    @Test
    void nEqualsZeroReturnsEmpty() {
        var s = new humaneval.claude.task_100.Solution();
        assertEquals(List.of(), s.makeAPile(0));
    }

    // EC7: n negative — Returns x-1 mutation applied below zero boundary
    @Test
    void nNegativeReturnsEmpty() {
        var s = new humaneval.claude.task_100.Solution();
        assertEquals(List.of(), s.makeAPile(-1));
    }
}
