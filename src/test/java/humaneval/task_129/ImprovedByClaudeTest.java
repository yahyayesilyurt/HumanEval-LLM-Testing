package humaneval.task_129;

import humaneval.claude.task_129.Solution;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ImprovedByClaudeTest {

    private final Solution solution = new Solution();

    @Test
    @DisplayName("3x3 sequential grid with k=3 returns [1,2,1]")
    void threeByThreeSequentialK3() {
        List<List<Integer>> grid = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9));
        assertEquals(Arrays.asList(1, 2, 1), solution.minPath(grid, 3));
    }

    @Test
    @DisplayName("Scrambled 3x3 grid with k=1 returns singleton [1]")
    void scrambled3x3K1() {
        List<List<Integer>> grid = Arrays.asList(
                Arrays.asList(5, 9, 3),
                Arrays.asList(4, 1, 6),
                Arrays.asList(7, 8, 2));
        assertEquals(List.of(1), solution.minPath(grid, 1));
    }

    @Test
    @DisplayName("4x4 sequential grid with k=4 alternates between 1 and its min neighbor 2")
    void fourByFourSequentialK4() {
        List<List<Integer>> grid = Arrays.asList(
                Arrays.asList(1, 2, 3, 4),
                Arrays.asList(5, 6, 7, 8),
                Arrays.asList(9, 10, 11, 12),
                Arrays.asList(13, 14, 15, 16));
        assertEquals(Arrays.asList(1, 2, 1, 2), solution.minPath(grid, 4));
    }

    @Test
    @DisplayName("4x4 scrambled grid with 1 on right edge; min neighbor is 10, k=7")
    void scrambled4x4MinNeighborTenK7() {
        List<List<Integer>> grid = Arrays.asList(
                Arrays.asList(6, 4, 13, 10),
                Arrays.asList(5, 7, 12, 1),
                Arrays.asList(3, 16, 11, 15),
                Arrays.asList(8, 14, 9, 2));
        assertEquals(Arrays.asList(1, 10, 1, 10, 1, 10, 1), solution.minPath(grid, 7));
    }

    @Test
    @DisplayName("4x4 scrambled grid with 1 in interior; min neighbor is 7, k=5")
    void scrambled4x4MinNeighborSevenK5() {
        List<List<Integer>> grid = Arrays.asList(
                Arrays.asList(8, 14, 9, 2),
                Arrays.asList(6, 4, 13, 15),
                Arrays.asList(5, 7, 1, 12),
                Arrays.asList(3, 10, 11, 16));
        assertEquals(Arrays.asList(1, 7, 1, 7, 1), solution.minPath(grid, 5));
    }

    @Test
    @DisplayName("4x4 scrambled grid with 1 in bottom-right corner; min neighbor is 6, k=9")
    void scrambled4x4BottomRightCornerK9() {
        List<List<Integer>> grid = Arrays.asList(
                Arrays.asList(11, 8, 7, 2),
                Arrays.asList(5, 16, 14, 4),
                Arrays.asList(9, 3, 15, 6),
                Arrays.asList(12, 13, 10, 1));
        assertEquals(Arrays.asList(1, 6, 1, 6, 1, 6, 1, 6, 1), solution.minPath(grid, 9));
    }

    @Test
    @DisplayName("4x4 scrambled grid with 1 in top-right corner; min neighbor is 6, k=12")
    void scrambled4x4TopRightCornerK12() {
        List<List<Integer>> grid = Arrays.asList(
                Arrays.asList(12, 13, 10, 1),
                Arrays.asList(9, 3, 15, 6),
                Arrays.asList(5, 16, 14, 4),
                Arrays.asList(11, 8, 7, 2));
        assertEquals(Arrays.asList(1, 6, 1, 6, 1, 6, 1, 6, 1, 6, 1, 6), solution.minPath(grid, 12));
    }

    @Test
    @DisplayName("3x3 grid with 1 at center; min neighbor is 3, even k=8")
    void threeByThreeCenterOneEvenK() {
        List<List<Integer>> grid = Arrays.asList(
                Arrays.asList(2, 7, 4),
                Arrays.asList(3, 1, 5),
                Arrays.asList(6, 8, 9));
        assertEquals(Arrays.asList(1, 3, 1, 3, 1, 3, 1, 3), solution.minPath(grid, 8));
    }

    @Test
    @DisplayName("3x3 grid with 1 on top edge; min neighbor is 5, even k=8")
    void threeByThreeTopEdgeOneEvenK() {
        List<List<Integer>> grid = Arrays.asList(
                Arrays.asList(6, 1, 5),
                Arrays.asList(3, 8, 9),
                Arrays.asList(2, 7, 4));
        assertEquals(Arrays.asList(1, 5, 1, 5, 1, 5, 1, 5), solution.minPath(grid, 8));
    }

    @Test
    @DisplayName("Minimum-size 2x2 grid with k=10 alternates [1,2]")
    void minimumSize2x2K10() {
        List<List<Integer>> grid = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(3, 4));
        assertEquals(Arrays.asList(1, 2, 1, 2, 1, 2, 1, 2, 1, 2), solution.minPath(grid, 10));
    }

    @Test
    @DisplayName("2x2 grid where min neighbor equals 3 (both neighbors are 3), k=10")
    void twoByTwoMinNeighborThreeK10() {
        List<List<Integer>> grid = Arrays.asList(
                Arrays.asList(1, 3),
                Arrays.asList(3, 2));
        assertEquals(Arrays.asList(1, 3, 1, 3, 1, 3, 1, 3, 1, 3), solution.minPath(grid, 10));
    }
}
