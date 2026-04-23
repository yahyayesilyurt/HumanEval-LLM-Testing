package humaneval.task_56;

import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SolutionTest {

    @Test
    void claude() {
        var s = new humaneval.claude.task_56.Solution();
        List<Boolean> correct = Arrays.asList(
                s.correctBracketing("<>"),
                s.correctBracketing("<<><>>"),
                s.correctBracketing("<><><<><>><>"),
                s.correctBracketing("<><><<<><><>><>><<><><<>>>"),
                !s.correctBracketing("<<<><>>>>"),
                !s.correctBracketing("><<>"),
                !s.correctBracketing("<"),
                !s.correctBracketing("<<<<"),
                !s.correctBracketing(">"),
                !s.correctBracketing("<<>"),
                !s.correctBracketing("<><><<><>><>><<>"),
                !s.correctBracketing("<><><<><>><>>><>")
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    
    }

    @Test
    void gpt() {
        var s = new humaneval.gpt.task_56.Solution();
        List<Boolean> correct = Arrays.asList(
                s.correctBracketing("<>"),
                s.correctBracketing("<<><>>"),
                s.correctBracketing("<><><<><>><>"),
                s.correctBracketing("<><><<<><><>><>><<><><<>>>"),
                !s.correctBracketing("<<<><>>>>"),
                !s.correctBracketing("><<>"),
                !s.correctBracketing("<"),
                !s.correctBracketing("<<<<"),
                !s.correctBracketing(">"),
                !s.correctBracketing("<<>"),
                !s.correctBracketing("<><><<><>><>><<>"),
                !s.correctBracketing("<><><<><>><>>><>")
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    
    }

    // Tests with mutations

    // EC7: Extra close at end — Replace s with Mutate(s): append extra '>'
    @Test
    void extraCloseAtEndReturnsFalse() {
        var s = new humaneval.claude.task_56.Solution();
        assertFalse(s.correctBracketing("<>>"));
    }

    // EC9: null input — NoneType: Returns None mutation
    @Test
    void nullInputThrowsException() {
        var s = new humaneval.claude.task_56.Solution();
        assertThrows(NullPointerException.class,
                () -> s.correctBracketing(null));
    }
}
