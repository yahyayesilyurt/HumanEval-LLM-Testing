package humaneval.task_56;

import org.junit.jupiter.api.Test;
import java.util.*;

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
}
