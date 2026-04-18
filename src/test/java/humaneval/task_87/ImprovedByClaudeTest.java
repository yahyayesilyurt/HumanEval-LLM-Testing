package humaneval.task_87;

import humaneval.claude.task_87.Solution;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ImprovedByClaudeTest {

    private final Solution solution = new Solution();

    @Test
    void example1_findsOnesWithColumnsDescendingWithinRow() {
        List<List<Integer>> input = Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5, 6),
                Arrays.asList(1, 2, 3, 4, 1, 6),
                Arrays.asList(1, 2, 3, 4, 5, 1)
        );
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(0, 0),
                Arrays.asList(1, 4),
                Arrays.asList(1, 0),
                Arrays.asList(2, 5),
                Arrays.asList(2, 0)
        );
        assertEquals(expected, solution.getRow(input, 1));
    }

    @Test
    void example2_sameValueAtSameColumnAcrossAllRows() {
        List<List<Integer>> input = Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5, 6),
                Arrays.asList(1, 2, 3, 4, 5, 6),
                Arrays.asList(1, 2, 3, 4, 5, 6),
                Arrays.asList(1, 2, 3, 4, 5, 6),
                Arrays.asList(1, 2, 3, 4, 5, 6),
                Arrays.asList(1, 2, 3, 4, 5, 6)
        );
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(0, 1),
                Arrays.asList(1, 1),
                Arrays.asList(2, 1),
                Arrays.asList(3, 1),
                Arrays.asList(4, 1),
                Arrays.asList(5, 1)
        );
        assertEquals(expected, solution.getRow(input, 2));
    }

    @Test
    void example3_multipleMatchesPerRowDescendingColumns() {
        List<List<Integer>> input = Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5, 6),
                Arrays.asList(1, 2, 3, 4, 5, 6),
                Arrays.asList(1, 1, 3, 4, 5, 6),
                Arrays.asList(1, 2, 1, 4, 5, 6),
                Arrays.asList(1, 2, 3, 1, 5, 6),
                Arrays.asList(1, 2, 3, 4, 1, 6),
                Arrays.asList(1, 2, 3, 4, 5, 1)
        );
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(0, 0),
                Arrays.asList(1, 0),
                Arrays.asList(2, 1),
                Arrays.asList(2, 0),
                Arrays.asList(3, 2),
                Arrays.asList(3, 0),
                Arrays.asList(4, 3),
                Arrays.asList(4, 0),
                Arrays.asList(5, 4),
                Arrays.asList(5, 0),
                Arrays.asList(6, 5),
                Arrays.asList(6, 0)
        );
        assertEquals(expected, solution.getRow(input, 1));
    }

    @Test
    void emptyOuterListReturnsEmpty() {
        assertEquals(Collections.emptyList(), solution.getRow(List.of(), 1));
    }

    @Test
    void singleRowWithoutMatchReturnsEmpty() {
        assertEquals(Collections.emptyList(), solution.getRow(List.of(List.of(1)), 2));
    }

    @Test
    void raggedRowsWithEmptyRowAndSingletonRow() {
        List<List<Integer>> input = Arrays.asList(
                List.of(),
                List.of(1),
                Arrays.asList(1, 2, 3)
        );
        assertEquals(List.of(Arrays.asList(2, 2)), solution.getRow(input, 3));
    }

    @Test
    void noMatchInAnyRowReturnsEmpty() {
        List<List<Integer>> input = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6)
        );
        assertEquals(Collections.emptyList(), solution.getRow(input, 99));
    }

    @Test
    void repeatedValueInSingleRowOrderedByColumnDescending() {
        List<List<Integer>> input = List.of(Arrays.asList(7, 7, 7, 7));
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(0, 3),
                Arrays.asList(0, 2),
                Arrays.asList(0, 1),
                Arrays.asList(0, 0)
        );
        assertEquals(expected, solution.getRow(input, 7));
    }

    @Test
    void handlesNegativeTargetValue() {
        List<List<Integer>> input = Arrays.asList(
                Arrays.asList(-1, 0, -1),
                Arrays.asList(0, -1, 0)
        );
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(0, 2),
                Arrays.asList(0, 0),
                Arrays.asList(1, 1)
        );
        assertEquals(expected, solution.getRow(input, -1));
    }

    @Test
    void handlesLargeIntegerValues() {
        int target = Integer.MAX_VALUE;
        List<List<Integer>> input = Arrays.asList(
                Arrays.asList(target, 1, target),
                Arrays.asList(1, 2, 3)
        );
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(0, 2),
                Arrays.asList(0, 0)
        );
        assertEquals(expected, solution.getRow(input, target));
    }
}
