package humaneval.task_47;

import humaneval.claude.task_47.Solution;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ImprovedByClaudeTest {

    private final Solution solution = new Solution();

    @Test
    @DisplayName("median of odd-sized list returns the middle element")
    void medianOfOddSizedListReturnsMiddleElement() {
        assertEquals(3.0, solution.median(Arrays.asList(3, 1, 2, 4, 5)));
    }

    @Test
    @DisplayName("median of even-sized list returns average of two middle elements")
    void medianOfEvenSizedListReturnsAverageOfTwoMiddleElements() {
        assertEquals(8.0, solution.median(Arrays.asList(-10, 4, 6, 1000, 10, 20)));
    }

    @Test
    @DisplayName("median of single-element list returns that element")
    void medianOfSingleElementListReturnsThatElement() {
        assertEquals(5.0, solution.median(Arrays.asList(5)));
    }

    @Test
    @DisplayName("median of two-element list returns their average")
    void medianOfTwoElementListReturnsTheirAverage() {
        assertEquals(5.5, solution.median(Arrays.asList(6, 5)));
    }

    @Test
    @DisplayName("median of sorted list returns the middle element")
    void medianOfSortedListReturnsMiddleElement() {
        assertEquals(4.0, solution.median(Arrays.asList(1, 2, 3, 4, 5, 6, 7)));
    }

    @Test
    @DisplayName("median of list with all identical elements equals that element")
    void medianOfIdenticalElementsEqualsThatElement() {
        assertEquals(7.0, solution.median(Arrays.asList(7, 7, 7, 7, 7)));
    }

    @Test
    @DisplayName("median of all-negative list returns the middle value")
    void medianOfAllNegativeListReturnsMiddleValue() {
        assertEquals(-3.0, solution.median(Arrays.asList(-1, -2, -3, -4, -5)));
    }

    @Test
    @DisplayName("median of mixed-sign even list averages middle two")
    void medianOfMixedSignEvenListAveragesMiddleTwo() {
        assertEquals(0.5, solution.median(Arrays.asList(-3, -1, 2, 4)));
    }

    @Test
    @DisplayName("median where middle two sum is odd yields fractional result")
    void medianWithOddSumOfMiddleTwoYieldsFractionalResult() {
        assertEquals(2.5, solution.median(Arrays.asList(1, 2, 3, 4)));
    }

    @Test
    @DisplayName("median is independent of input order")
    void medianIsIndependentOfInputOrder() {
        List<Integer> unsorted = Arrays.asList(9, 3, 7, 1, 5);
        List<Integer> reversed = Arrays.asList(5, 1, 7, 3, 9);
        assertEquals(solution.median(unsorted), solution.median(reversed));
        assertEquals(5.0, solution.median(unsorted));
    }

    @Test
    @DisplayName("median does not mutate the input list")
    void medianDoesNotMutateInputList() {
        List<Integer> input = Arrays.asList(3, 1, 2, 4, 5);
        List<Integer> snapshot = new java.util.ArrayList<>(input);
        solution.median(input);
        assertEquals(snapshot, input);
    }

    @Test
    @DisplayName("median handles extreme integer values without overflow in average")
    void medianHandlesExtremeIntegerValues() {
        assertEquals(((double) Integer.MAX_VALUE + Integer.MIN_VALUE) / 2.0,
                solution.median(Arrays.asList(Integer.MIN_VALUE, Integer.MAX_VALUE)));
    }

    @Test
    @DisplayName("median of list containing zero is computed correctly")
    void medianOfListContainingZero() {
        assertEquals(0.0, solution.median(Arrays.asList(-2, -1, 0, 1, 2)));
    }

    @Test
    @DisplayName("median of duplicated values in even list")
    void medianOfDuplicatedValuesInEvenList() {
        assertEquals(3.0, solution.median(Arrays.asList(1, 3, 3, 5)));
    }

    @Test
    @DisplayName("median of reverse-sorted list matches sorted result")
    void medianOfReverseSortedList() {
        List<Integer> values = Arrays.asList(10, 8, 6, 4, 2);
        Collections.reverse(values);
        assertEquals(6.0, solution.median(values));
    }
}
