package humaneval.task_120;

import humaneval.gpt.task_120.Solution;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

class ImprovedByGptTest {

    private final Solution solution = new Solution();

    @Test
    void returnsExpectedMaximumsForRepresentativeExamples() {
        assertAll(
                () -> assertEquals(List.of(-4, -3, 5),
                        solution.maximum(new ArrayList<>(List.of(-3, -4, 5)), 3)),
                () -> assertEquals(List.of(4, 4),
                        solution.maximum(new ArrayList<>(List.of(4, -4, 4)), 2)),
                () -> assertEquals(List.of(2),
                        solution.maximum(new ArrayList<>(List.of(-3, 2, 1, 2, -1, -2, 1)), 1)),
                () -> assertEquals(List.of(2, 20, 123),
                        solution.maximum(new ArrayList<>(List.of(123, -123, 20, 0, 1, 2, -3)), 3)),
                () -> assertEquals(List.of(0, 1, 2, 20),
                        solution.maximum(new ArrayList<>(List.of(-123, 20, 0, 1, 2, -3)), 4)),
                () -> assertEquals(List.of(-13, -8, 0, 0, 3, 5, 15),
                        solution.maximum(new ArrayList<>(List.of(5, 15, 0, 3, -13, -8, 0)), 7)),
                () -> assertEquals(List.of(3, 5),
                        solution.maximum(new ArrayList<>(List.of(-1, 0, 2, 5, 3, -10)), 2)),
                () -> assertEquals(List.of(5),
                        solution.maximum(new ArrayList<>(List.of(1, 0, 5, -7)), 1)),
                () -> assertEquals(List.of(-4, 4),
                        solution.maximum(new ArrayList<>(List.of(4, -4)), 2)),
                () -> assertEquals(List.of(-10, 10),
                        solution.maximum(new ArrayList<>(List.of(-10, 10)), 2))
        );
    }

    @Test
    void returnsEmptyListWhenKIsZero() {
        assertEquals(List.of(), solution.maximum(new ArrayList<>(List.of(5, 1, 3)), 0));
    }

    @Test
    void preservesDuplicateValuesAmongLargestElements() {
        assertEquals(List.of(7, 7, 7),
                solution.maximum(new ArrayList<>(List.of(7, 1, 7, -2, 7, 0)), 3));
    }

    @Test
    void returnsAllElementsSortedWhenKMatchesInputSize() {
        assertEquals(List.of(-9, -1, 0, 4),
                solution.maximum(new ArrayList<>(List.of(0, -1, 4, -9)), 4));
    }

    @Test
    void doesNotMutateInputList() {
        List<Integer> input = new ArrayList<>(List.of(3, 1, 4, 1, 5));
        List<Integer> original = new ArrayList<>(input);

        solution.maximum(input, 3);

        assertEquals(original, input);
    }

    @Test
    void returnsANewListInstance() {
        List<Integer> input = new ArrayList<>(List.of(9, 2, 8, 1));

        List<Integer> result = solution.maximum(input, 2);

        assertEquals(List.of(8, 9), result);
        assertNotSame(input, result);
    }
}
