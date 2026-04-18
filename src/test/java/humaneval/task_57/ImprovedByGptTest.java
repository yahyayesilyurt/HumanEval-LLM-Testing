package humaneval.task_57;

import humaneval.gpt.task_57.Solution;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ImprovedByGptTest {

    private final Solution solution = new Solution();

    @Test
    void returnsTrueForMonotonicallyIncreasingOrDecreasingLists() {
        assertAll(
                () -> assertTrue(solution.monotonic(list(1, 2, 4, 10))),
                () -> assertTrue(solution.monotonic(list(1, 2, 4, 20))),
                () -> assertTrue(solution.monotonic(list(4, 1, 0, -10))),
                () -> assertTrue(solution.monotonic(list(4, 1, 1, 0))),
                () -> assertTrue(solution.monotonic(list(1, 2, 3, 4, 5, 60))),
                () -> assertTrue(solution.monotonic(list(9, 9, 9, 9)))
        );
    }

    @Test
    void returnsFalseForListsThatChangeDirection() {
        assertAll(
                () -> assertFalse(solution.monotonic(list(1, 20, 4, 10))),
                () -> assertFalse(solution.monotonic(list(1, 2, 3, 2, 5, 60)))
        );
    }

    private List<Integer> list(Integer... values) {
        return Arrays.asList(values);
    }
}
