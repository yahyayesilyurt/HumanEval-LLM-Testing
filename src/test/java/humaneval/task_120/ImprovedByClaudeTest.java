package humaneval.task_120;

import humaneval.claude.task_120.Solution;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ImprovedByClaudeTest {

    private final Solution solution = new Solution();

    @Test
    @DisplayName("Example 1: mixed negatives and positive with k equal to array length")
    void returnsAllElementsSortedWhenKEqualsArrayLength() {
        assertEquals(Arrays.asList(-4, -3, 5),
                solution.maximum(new ArrayList<>(Arrays.asList(-3, -4, 5)), 3));
    }

    @Test
    @DisplayName("Example 2: duplicates are preserved in the result")
    void preservesDuplicatesInResult() {
        assertEquals(Arrays.asList(4, 4),
                solution.maximum(new ArrayList<>(Arrays.asList(4, -4, 4)), 2));
    }

    @Test
    @DisplayName("Example 3: single maximum element when k is 1")
    void returnsSingleMaximumWhenKIsOne() {
        assertEquals(List.of(2),
                solution.maximum(new ArrayList<>(Arrays.asList(-3, 2, 1, 2, -1, -2, 1)), 1));
    }

    @Test
    @DisplayName("Returns top three largest in ascending order from mixed array")
    void returnsTopThreeLargestInAscendingOrder() {
        assertEquals(Arrays.asList(2, 20, 123),
                solution.maximum(new ArrayList<>(Arrays.asList(123, -123, 20, 0, 1, 2, -3)), 3));
    }

    @Test
    @DisplayName("Returns top four largest in ascending order")
    void returnsTopFourLargestInAscendingOrder() {
        assertEquals(Arrays.asList(0, 1, 2, 20),
                solution.maximum(new ArrayList<>(Arrays.asList(-123, 20, 0, 1, 2, -3)), 4));
    }

    @Test
    @DisplayName("Returns entire array sorted when k equals array length with zeros")
    void returnsAllElementsSortedIncludingZeros() {
        assertEquals(Arrays.asList(-13, -8, 0, 0, 3, 5, 15),
                solution.maximum(new ArrayList<>(Arrays.asList(5, 15, 0, 3, -13, -8, 0)), 7));
    }

    @Test
    @DisplayName("Returns top two when array has both negatives and positives")
    void returnsTopTwoFromMixedArray() {
        assertEquals(Arrays.asList(3, 5),
                solution.maximum(new ArrayList<>(Arrays.asList(-1, 0, 2, 5, 3, -10)), 2));
    }

    @Test
    @DisplayName("Returns single maximum from small positive-leaning array")
    void returnsSingleMaximumFromSmallArray() {
        assertEquals(List.of(5),
                solution.maximum(new ArrayList<>(Arrays.asList(1, 0, 5, -7)), 1));
    }

    @Test
    @DisplayName("Returns both elements sorted when array has exactly two elements")
    void returnsBothElementsSortedForTwoElementArray() {
        assertEquals(Arrays.asList(-4, 4),
                solution.maximum(new ArrayList<>(Arrays.asList(4, -4)), 2));
    }

    @Test
    @DisplayName("Returns both elements sorted for array of two already-ordered elements")
    void returnsBothElementsSortedWhenAlreadyOrdered() {
        assertEquals(Arrays.asList(-10, 10),
                solution.maximum(new ArrayList<>(Arrays.asList(-10, 10)), 2));
    }

    @Test
    @DisplayName("Returns empty list when k is zero (covers k==0 branch)")
    void returnsEmptyListWhenKIsZero() {
        List<Integer> result = solution.maximum(
                new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)), 0);
        assertEquals(Collections.emptyList(), result);
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("Returns empty list when k is zero and input array is empty")
    void returnsEmptyListWhenKIsZeroAndArrayIsEmpty() {
        assertEquals(Collections.emptyList(),
                solution.maximum(new ArrayList<>(), 0));
    }

    @Test
    @DisplayName("Does not mutate the input list")
    void doesNotMutateInputList() {
        List<Integer> input = new ArrayList<>(Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6));
        List<Integer> snapshot = new ArrayList<>(input);
        solution.maximum(input, 3);
        assertEquals(snapshot, input);
    }

    @Test
    @DisplayName("Returns a new list instance, not the input")
    void returnsNewListInstance() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> result = solution.maximum(input, 2);
        assertNotSame(input, result);
    }

    @Test
    @DisplayName("Handles all-negative array returning top negatives")
    void handlesAllNegativeArray() {
        var result = solution.maximum(new ArrayList<>(Arrays.asList(-5, -3, -1, -7, -2)), 2);
        assertEquals(Arrays.asList(-2, -1), result.stream().sorted().toList());
    }

    @Test
    @DisplayName("Handles single-element array with k=1")
    void handlesSingleElementArray() {
        assertEquals(List.of(42),
                solution.maximum(new ArrayList<>(List.of(42)), 1));
    }

    @Test
    @DisplayName("Handles single-element array with k=0")
    void handlesSingleElementArrayWithKZero() {
        assertEquals(Collections.emptyList(),
                solution.maximum(new ArrayList<>(List.of(42)), 0));
    }
}
