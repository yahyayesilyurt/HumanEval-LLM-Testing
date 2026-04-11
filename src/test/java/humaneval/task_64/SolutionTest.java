package humaneval.task_64;

import org.junit.jupiter.api.Test;
import java.util.*;

class SolutionTest {

    @Test
    void claude() {
        var s = new humaneval.claude.task_64.Solution();
        List<Boolean> correct = Arrays.asList(
                s.vowelsCount("abcde") == 2,
                s.vowelsCount("Alone") == 3,
                s.vowelsCount("key") == 2,
                s.vowelsCount("bye") == 1,
                s.vowelsCount("keY") == 2,
                s.vowelsCount("bYe") == 1,
                s.vowelsCount("ACEDY") == 3
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    
    }

    @Test
    void gpt() {
        var s = new humaneval.gpt.task_64.Solution();
        List<Boolean> correct = Arrays.asList(
                s.vowelsCount("abcde") == 2,
                s.vowelsCount("Alone") == 3,
                s.vowelsCount("key") == 2,
                s.vowelsCount("bye") == 1,
                s.vowelsCount("keY") == 2,
                s.vowelsCount("bYe") == 1,
                s.vowelsCount("ACEDY") == 3
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    
    }
}
