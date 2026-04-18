package humaneval.task_87;

import humaneval.gpt.task_87.Solution;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ImprovedByGptTest {

    private final Solution solution = new Solution();

    @Test
    void returnsCoordinatesSortedByRowAndDescendingColumnWithinEachRow() {
        List<List<Integer>> input = List.of(
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 1, 6),
                List.of(1, 2, 3, 4, 5, 1)
        );

        List<List<Integer>> expected = List.of(
                List.of(0, 0),
                List.of(1, 4),
                List.of(1, 0),
                List.of(2, 5),
                List.of(2, 0)
        );

        assertEquals(expected, solution.getRow(input, 1));
    }

    @Test
    void returnsSingleMatchFromEachRowWhenTargetAppearsInSameColumn() {
        List<List<Integer>> input = List.of(
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 6)
        );

        List<List<Integer>> expected = List.of(
                List.of(0, 1),
                List.of(1, 1),
                List.of(2, 1),
                List.of(3, 1),
                List.of(4, 1),
                List.of(5, 1)
        );

        assertEquals(expected, solution.getRow(input, 2));
    }

    @Test
    void returnsMultipleMatchesPerRowInDescendingColumnOrder() {
        List<List<Integer>> input = List.of(
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 1, 3, 4, 5, 6),
                List.of(1, 2, 1, 4, 5, 6),
                List.of(1, 2, 3, 1, 5, 6),
                List.of(1, 2, 3, 4, 1, 6),
                List.of(1, 2, 3, 4, 5, 1)
        );

        List<List<Integer>> expected = List.of(
                List.of(0, 0),
                List.of(1, 0),
                List.of(2, 1),
                List.of(2, 0),
                List.of(3, 2),
                List.of(3, 0),
                List.of(4, 3),
                List.of(4, 0),
                List.of(5, 4),
                List.of(5, 0),
                List.of(6, 5),
                List.of(6, 0)
        );

        assertEquals(expected, solution.getRow(input, 1));
    }

    @Test
    void returnsEmptyListForEmptyOuterList() {
        assertEquals(List.of(), solution.getRow(List.of(), 1));
    }

    @Test
    void returnsEmptyListWhenTargetDoesNotExist() {
        assertEquals(List.of(), solution.getRow(List.of(List.of(1)), 2));
    }

    @Test
    void handlesRaggedRowsAndFindsMatchInLaterRow() {
        List<List<Integer>> input = List.of(
                List.of(),
                List.of(1),
                List.of(1, 2, 3)
        );

        List<List<Integer>> expected = List.of(List.of(2, 2));

        assertEquals(expected, solution.getRow(input, 3));
    }
}
