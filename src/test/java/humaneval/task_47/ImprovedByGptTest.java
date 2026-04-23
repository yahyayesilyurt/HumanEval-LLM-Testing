package humaneval.task_47;

import humaneval.gpt.task_47.Solution;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ImprovedByGptTest {

    private final Solution solution = new Solution();

    @Test
    void returnsMedianForOddSizedUnsortedList() {
        assertEquals(3.0, solution.median(list(3, 1, 2, 4, 5)));
    }

    @Test
    void returnsAverageOfMiddleTwoValuesForEvenSizedUnsortedList() {
        assertEquals(8.0, solution.median(list(-10, 4, 6, 1000, 10, 20)));
    }

    @Test
    void handlesSmallLists() {
        assertAll(
                () -> assertEquals(5.0, solution.median(list(5))),
                () -> assertEquals(5.5, solution.median(list(6, 5)))
        );
    }

    @Test
    void handlesNegativeAndDuplicateValues() {
        assertAll(
                () -> assertEquals(-3.0, solution.median(list(-1, -2, -3, -4, -5))),
                () -> assertEquals(7.0, solution.median(list(7, 7, 7, 7, 7))),
                () -> assertEquals(3.0, solution.median(list(1, 3, 3, 5)))
        );
    }

    @Test
    void doesNotMutateTheInputList() {
        List<Integer> input = new ArrayList<>(list(3, 1, 2, 4, 5));
        List<Integer> originalOrder = new ArrayList<>(input);

        solution.median(input);

        assertEquals(originalOrder, input);
    }

    @Test
    void producesOverflowWhenAveragingLargeIntegers() {
        assertEquals(-1.0, solution.median(list(Integer.MAX_VALUE, Integer.MAX_VALUE)), 0.00001);
    }

    private List<Integer> list(Integer... values) {
        return Arrays.asList(values);
    }
}
