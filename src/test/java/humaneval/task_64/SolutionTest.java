package humaneval.task_64;

import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    // Tests with mutations

    // EC9: single consonant — Returns x-1 mutation: remove all vowels, expect 0
    @Test
    void singleConsonantReturnsZero() {
        var s = new humaneval.claude.task_64.Solution();
        assertEquals(0, s.vowelsCount("b"));
    }

    // EC10: empty string — Remove a random item mutation: empty input
    // Bug discovered via mutation testing: original implementation threw
    // StringIndexOutOfBoundsException on empty string due to s.charAt(s.length()-1)
    // Fixed in T2.4 by adding isEmpty() guard
    @Test
    void emptyStringReturnsZero() {
        var s = new humaneval.claude.task_64.Solution();
        assertEquals(0, s.vowelsCount(""));
    }

    // EC11: null input — NoneType: Returns None mutation
    @Test
    void nullInputThrowsException() {
        var s = new humaneval.claude.task_64.Solution();
        assertThrows(NullPointerException.class,
                () -> s.vowelsCount(null));
    }
}