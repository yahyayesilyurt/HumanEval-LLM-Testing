package humaneval.task_19;

import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    // Tests with mutations
    // EC9: invalid word not in the defined set
    @Test
    void unknownWordThrowsExceptionWhenCompared() {
        var s = new humaneval.claude.task_19.Solution();
        assertThrows(NullPointerException.class,
                () -> s.sortNumbers("ten one"));
    }

    // Boundary: Lowest valid single numeral
    @Test
    void singleLowestNumeralReturnsItself() {
        var s = new humaneval.claude.task_19.Solution();
        assertEquals("zero", s.sortNumbers("zero"));
    }

    // Boundary: Highest valid single numeral
    @Test
    void singleHighestNumeralReturnsItself() {
        var s = new humaneval.claude.task_19.Solution();
        assertEquals("nine", s.sortNumbers("nine"));
    }
}
