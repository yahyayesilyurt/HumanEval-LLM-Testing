package humaneval.task_56;

import humaneval.claude.task_56.Solution;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ImprovedByClaudeTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void emptyStringIsBalanced() {
        assertTrue(solution.correctBracketing(""));
    }

    @Test
    void singleMatchedPairIsBalanced() {
        assertTrue(solution.correctBracketing("<>"));
    }

    @Test
    void singleOpeningBracketIsUnbalanced() {
        assertFalse(solution.correctBracketing("<"));
    }

    @Test
    void singleClosingBracketIsUnbalanced() {
        assertFalse(solution.correctBracketing(">"));
    }

    @Test
    void closingBeforeOpeningIsUnbalanced() {
        assertFalse(solution.correctBracketing("><<>"));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "<<><>>",
            "<><><<><>><>",
            "<><><<<><><>><>><<><><<>>>",
            "<<<><>>>",
            "<<<<>>>>"
    })
    void nestedAndSequentialBalancedStringsAreBalanced(String brackets) {
        assertTrue(solution.correctBracketing(brackets));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "<<<<",
            ">>>>",
            "<<>",
            "<>>",
            "<<<><>>>>",
            "<><><<><>><>><<>",
            "<><><<><>><>>><>"
    })
    void stringsWithMismatchedBracketsAreUnbalanced(String brackets) {
        assertFalse(solution.correctBracketing(brackets));
    }

    @Test
    void closingBracketDropsDepthBelowZeroEarly() {
        assertFalse(solution.correctBracketing("><><"));
    }

    @Test
    void excessOpeningBracketsLeaveDepthPositive() {
        assertFalse(solution.correctBracketing("<<>"));
    }
}
