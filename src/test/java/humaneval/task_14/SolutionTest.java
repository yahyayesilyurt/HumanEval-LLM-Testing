package humaneval.task_14;

import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertThrows;

class SolutionTest {

    @Test
    void claude() {
        var s = new humaneval.claude.task_14.Solution();
        List<Boolean> correct = Arrays.asList(
                s.allPrefixes("").equals(List.of()),
                s.allPrefixes("asdfgh").equals(Arrays.asList("a", "as", "asd", "asdf", "asdfg", "asdfgh")),
                s.allPrefixes("WWW").equals(Arrays.asList("W", "WW", "WWW"))
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    
    }

    @Test
    void gpt() {
        var s = new humaneval.gpt.task_14.Solution();
        List<Boolean> correct = Arrays.asList(
                s.allPrefixes("").equals(List.of()),
                s.allPrefixes("asdfgh").equals(Arrays.asList("a", "as", "asd", "asdf", "asdfg", "asdfgh")),
                s.allPrefixes("WWW").equals(Arrays.asList("W", "WW", "WWW"))
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    
    }

    // Tests with mutations
    // EC6: null input
    @Test
    void nullInputThrowsException() {
        var s = new humaneval.claude.task_14.Solution();
        assertThrows(NullPointerException.class,
                () -> s.allPrefixes(null));
    }
}
