package humaneval.task_16;

import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertThrows;

class SolutionTest {

    @Test
    void claude() {
        var s = new humaneval.claude.task_16.Solution();
        List<Boolean> correct = Arrays.asList(
                s.countDistinctCharacters("") == 0,
                s.countDistinctCharacters("abcde") == 5,
                s.countDistinctCharacters("abcde" + "cade" + "CADE") == 5,
                s.countDistinctCharacters("aaaaAAAAaaaa") == 1,
                s.countDistinctCharacters("Jerry jERRY JeRRRY") == 5
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    
    }

    @Test
    void gpt() {
        var s = new humaneval.gpt.task_16.Solution();
        List<Boolean> correct = Arrays.asList(
                s.countDistinctCharacters("") == 0,
                s.countDistinctCharacters("abcde") == 5,
                s.countDistinctCharacters("abcde" + "cade" + "CADE") == 5,
                s.countDistinctCharacters("aaaaAAAAaaaa") == 1,
                s.countDistinctCharacters("Jerry jERRY JeRRRY") == 5
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    
    }

    // Tests with mutations
    // EC8: null input
    @Test
    void nullInputThrowsException() {
        var s = new humaneval.claude.task_16.Solution();
        assertThrows(NullPointerException.class,
                () -> s.countDistinctCharacters(null));
    }
}
