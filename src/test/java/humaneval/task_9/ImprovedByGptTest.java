package humaneval.task_9;

import humaneval.gpt.task_9.Solution;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ImprovedByGptTest {

    private final Solution solution = new Solution();

    @Test
    void returnsEmptyListForEmptyInput() {
        assertEquals(List.of(), solution.rollingMax(List.of()));
    }

    @Test
    void returnsSameSequenceForStrictlyIncreasingInput() {
        assertEquals(
                List.of(1, 2, 3, 4),
                solution.rollingMax(List.of(1, 2, 3, 4))
        );
    }

    @Test
    void repeatsFirstValueForStrictlyDecreasingInput() {
        assertEquals(
                List.of(4, 4, 4, 4),
                solution.rollingMax(List.of(4, 3, 2, 1))
        );
    }

    @Test
    void keepsPreviousMaximumWhenSmallerValuesAppearLater() {
        assertEquals(
                List.of(3, 3, 3, 100, 100),
                solution.rollingMax(List.of(3, 2, 3, 100, 3))
        );
    }

    @Test
    void handlesNegativeValuesCorrectly() {
        assertEquals(
                List.of(-5, -2, -2, -1, -1),
                solution.rollingMax(List.of(-5, -2, -3, -1, -4))
        );
    }
}
