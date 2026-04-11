package humaneval.task_19;

import org.junit.jupiter.api.Test;
import java.util.*;

class SolutionTest {

    @Test
    void claude() {
        var s = new humaneval.claude.task_19.Solution();
        List<Boolean> correct = Arrays.asList(
                s.sortNumbers("").equals(""),
                s.sortNumbers("three").equals("three"),
                s.sortNumbers("three five nine").equals("three five nine"),
                s.sortNumbers("five zero four seven nine eight").equals("zero four five seven eight nine")
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    
    }

    @Test
    void gpt() {
        var s = new humaneval.gpt.task_19.Solution();
        List<Boolean> correct = Arrays.asList(
                s.sortNumbers("").equals(""),
                s.sortNumbers("three").equals("three"),
                s.sortNumbers("three five nine").equals("three five nine"),
                s.sortNumbers("five zero four seven nine eight").equals("zero four five seven eight nine")
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    
    }
}
