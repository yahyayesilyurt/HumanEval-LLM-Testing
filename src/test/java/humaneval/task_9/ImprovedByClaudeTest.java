package humaneval.task_9;

import humaneval.claude.task_9.Solution;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ImprovedByClaudeTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    @DisplayName("empty input returns empty list")
    void emptyInputReturnsEmptyList() {
        assertEquals(List.of(), solution.rollingMax(new ArrayList<>()));
    }

    @Test
    @DisplayName("strictly increasing sequence returns the same sequence")
    void strictlyIncreasingReturnsSame() {
        assertEquals(
                Arrays.asList(1, 2, 3, 4),
                solution.rollingMax(Arrays.asList(1, 2, 3, 4))
        );
    }

    @Test
    @DisplayName("strictly decreasing sequence returns the first element repeated")
    void strictlyDecreasingReturnsFirstRepeated() {
        assertEquals(
                Arrays.asList(4, 4, 4, 4),
                solution.rollingMax(Arrays.asList(4, 3, 2, 1))
        );
    }

    @Test
    @DisplayName("mixed sequence tracks running maximum correctly")
    void mixedSequenceTracksRunningMax() {
        assertEquals(
                Arrays.asList(3, 3, 3, 100, 100),
                solution.rollingMax(Arrays.asList(3, 2, 3, 100, 3))
        );
    }

    @Test
    @DisplayName("single element returns list containing that element")
    void singleElementReturnsSingletonList() {
        assertEquals(
                List.of(7),
                solution.rollingMax(List.of(7))
        );
    }

    @Test
    @DisplayName("all equal elements yields a constant sequence")
    void allEqualElementsYieldConstantSequence() {
        assertEquals(
                Arrays.asList(5, 5, 5, 5),
                solution.rollingMax(Arrays.asList(5, 5, 5, 5))
        );
    }

    @Test
    @DisplayName("handles negative numbers correctly")
    void handlesNegativeNumbers() {
        assertEquals(
                Arrays.asList(-5, -3, -3, -1, -1),
                solution.rollingMax(Arrays.asList(-5, -3, -4, -1, -2))
        );
    }

    @Test
    @DisplayName("handles mix of negative and positive numbers")
    void handlesNegativeAndPositiveNumbers() {
        assertEquals(
                Arrays.asList(-2, -1, 0, 0, 3, 3),
                solution.rollingMax(Arrays.asList(-2, -1, 0, -5, 3, 2))
        );
    }

    @Test
    @DisplayName("handles Integer.MIN_VALUE as the first element")
    void handlesIntegerMinValueAsFirstElement() {
        assertEquals(
                Arrays.asList(Integer.MIN_VALUE, 0, 0),
                solution.rollingMax(Arrays.asList(Integer.MIN_VALUE, 0, -10))
        );
    }

    @Test
    @DisplayName("handles Integer.MAX_VALUE anywhere in the sequence")
    void handlesIntegerMaxValue() {
        assertEquals(
                Arrays.asList(1, 1, Integer.MAX_VALUE, Integer.MAX_VALUE),
                solution.rollingMax(Arrays.asList(1, 1, Integer.MAX_VALUE, 42))
        );
    }

    @Test
    @DisplayName("plateau of the maximum stays at that maximum")
    void plateauOfMaximumStaysAtMaximum() {
        assertEquals(
                Arrays.asList(1, 3, 3, 3, 3, 3, 3, 3),
                solution.rollingMax(Arrays.asList(1, 3, 2, 3, 1, 2, 3, 3))
        );
    }

    @Test
    @DisplayName("result length always equals the input length")
    void resultLengthEqualsInputLength() {
        List<Integer> input = Arrays.asList(10, 20, 15, 25, 5, 30, 30, 1);
        List<Integer> result = solution.rollingMax(input);
        assertEquals(input.size(), result.size());
    }

    @Test
    @DisplayName("result is non-decreasing")
    void resultIsNonDecreasing() {
        List<Integer> input = Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5);
        List<Integer> result = solution.rollingMax(input);
        for (int i = 1; i < result.size(); i++) {
            assertTrue(
                    result.get(i) >= result.get(i - 1),
                    "rolling max must be non-decreasing at index " + i
            );
        }
    }

    @Test
    @DisplayName("final value equals the overall maximum of the input")
    void finalValueEqualsOverallMaximum() {
        List<Integer> input = Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5);
        List<Integer> result = solution.rollingMax(input);
        assertEquals(Collections.max(input), result.get(result.size() - 1));
    }

    @Test
    @DisplayName("each result element is the max of the input prefix up to that index")
    void eachElementIsMaxOfPrefix() {
        List<Integer> input = Arrays.asList(2, 7, 1, 7, 3, 8, 0);
        List<Integer> result = solution.rollingMax(input);
        for (int i = 0; i < input.size(); i++) {
            int expected = Collections.max(input.subList(0, i + 1));
            assertEquals(expected, result.get(i), "mismatch at index " + i);
        }
    }

    @Test
    @DisplayName("does not mutate the input list")
    void doesNotMutateInput() {
        List<Integer> input = new ArrayList<>(Arrays.asList(5, 3, 8, 1, 9, 2));
        List<Integer> snapshot = new ArrayList<>(input);
        solution.rollingMax(input);
        assertEquals(snapshot, input);
    }

    @Test
    @DisplayName("returns a new list instance distinct from the input")
    void returnsNewListInstance() {
        List<Integer> input = Arrays.asList(1, 2, 3);
        List<Integer> result = solution.rollingMax(input);
        assertNotSame(input, result);
    }

    @Nested
    @DisplayName("example from the specification")
    class SpecificationExample {

        @Test
        @DisplayName("rollingMax([1, 2, 3, 2, 3, 4, 2]) == [1, 2, 3, 3, 3, 4, 4]")
        void matchesDocstringExample() {
            assertEquals(
                    Arrays.asList(1, 2, 3, 3, 3, 4, 4),
                    solution.rollingMax(Arrays.asList(1, 2, 3, 2, 3, 4, 2))
            );
        }
    }
}
