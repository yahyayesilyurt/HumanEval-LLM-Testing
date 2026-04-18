package humaneval.task_56;

import humaneval.gpt.task_56.Solution;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ImprovedByGptTest {

    private final Solution solution = new Solution();

    @Test
    void returnsTrueForBalancedBracketSequences() {
        assertAll(
                () -> assertTrue(solution.correctBracketing("")),
                () -> assertTrue(solution.correctBracketing("<>")),
                () -> assertTrue(solution.correctBracketing("<<><>>")),
                () -> assertTrue(solution.correctBracketing("<><><<><>><>")),
                () -> assertTrue(solution.correctBracketing("<><><<<><><>><>><<><><<>>>"))
        );
    }

    @Test
    void returnsFalseWhenAClosingBracketAppearsTooEarly() {
        assertAll(
                () -> assertFalse(solution.correctBracketing(">")),
                () -> assertFalse(solution.correctBracketing("><<>")),
                () -> assertFalse(solution.correctBracketing("<<<><>>>>")),
                () -> assertFalse(solution.correctBracketing("<><><<><>><>>><>"))
        );
    }

    @Test
    void returnsFalseWhenOpeningBracketsRemainUnmatched() {
        assertAll(
                () -> assertFalse(solution.correctBracketing("<")),
                () -> assertFalse(solution.correctBracketing("<<<<")),
                () -> assertFalse(solution.correctBracketing("<<>")),
                () -> assertFalse(solution.correctBracketing("<><><<><>><>><<>"))
        );
    }

    @Test
    void ignoresNonBracketCharactersWhenComputingBalance() {
        assertAll(
                () -> assertTrue(solution.correctBracketing("abc")),
                () -> assertTrue(solution.correctBracketing("<a><b>")),
                () -> assertFalse(solution.correctBracketing("a><"))
        );
    }
}
