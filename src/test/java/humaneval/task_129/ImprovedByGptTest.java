package humaneval.task_129;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ImprovedByGptTest {

    private final humaneval.gpt.task_129.Solution solution = new humaneval.gpt.task_129.Solution();

    @Test
    void alternatesBetweenOneAndSmallestNeighborFromTopLeftCorner() {
        List<List<Integer>> grid = List.of(
                List.of(1, 2, 3),
                List.of(4, 5, 6),
                List.of(7, 8, 9)
        );

        assertEquals(List.of(1, 2, 1), solution.minPath(grid, 3));
    }

    @Test
    void returnsOnlyTheStartingCellWhenKIsOne() {
        List<List<Integer>> grid = List.of(
                List.of(5, 9, 3),
                List.of(4, 1, 6),
                List.of(7, 8, 2)
        );

        assertEquals(List.of(1), solution.minPath(grid, 1));
    }

    @Test
    void findsOneAfterScanningMultipleRowsAndUsesBestEdgeNeighbor() {
        List<List<Integer>> grid = List.of(
                List.of(11, 8, 7, 2),
                List.of(5, 16, 14, 4),
                List.of(9, 3, 15, 6),
                List.of(12, 13, 10, 1)
        );

        assertEquals(
                List.of(1, 6, 1, 6, 1, 6, 1, 6, 1),
                solution.minPath(grid, 9)
        );
    }

    @Test
    void choosesTheMinimumAmongAllFourNeighborsForAnInteriorStart() {
        List<List<Integer>> grid = List.of(
                List.of(8, 14, 9, 2),
                List.of(6, 4, 13, 15),
                List.of(5, 7, 1, 12),
                List.of(3, 10, 11, 16)
        );

        assertEquals(List.of(1, 7, 1, 7, 1), solution.minPath(grid, 5));
    }

    @Test
    void prefersTheFirstEncounteredNeighborWhenMinimumValuesTie() {
        List<List<Integer>> grid = List.of(
                List.of(1, 3),
                List.of(3, 2)
        );

        assertEquals(
                List.of(1, 3, 1, 3, 1, 3, 1, 3, 1, 3),
                solution.minPath(grid, 10)
        );
    }

    @Test
    void returnsEmptyPathWhenKIsZeroEvenForAnEmptyGrid() {
        assertEquals(List.of(), solution.minPath(List.of(), 0));
    }
}
