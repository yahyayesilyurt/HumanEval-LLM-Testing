package humaneval.task_26;

import humaneval.claude.task_26.Solution;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ImprovedByClaudeTest {

    private final Solution solution = new Solution();

    @Test
    @DisplayName("empty list returns empty list")
    void emptyListReturnsEmpty() {
        assertEquals(Collections.emptyList(), solution.removeDuplicates(Collections.emptyList()));
    }

    @Test
    @DisplayName("list with all unique elements is unchanged")
    void allUniqueElementsUnchanged() {
        assertEquals(Arrays.asList(1, 2, 3, 4),
                solution.removeDuplicates(Arrays.asList(1, 2, 3, 4)));
    }

    @Test
    @DisplayName("elements occurring more than once are removed, order preserved")
    void duplicatesRemovedPreservingOrder() {
        assertEquals(Arrays.asList(1, 4, 5),
                solution.removeDuplicates(Arrays.asList(1, 2, 3, 2, 4, 3, 5)));
    }

    @Test
    @DisplayName("all elements duplicated produces empty list")
    void allDuplicatesProduceEmpty() {
        assertEquals(Collections.emptyList(),
                solution.removeDuplicates(Arrays.asList(1, 1, 2, 2, 3, 3)));
    }

    @Test
    @DisplayName("single element list is unchanged")
    void singleElementUnchanged() {
        assertEquals(List.of(42), solution.removeDuplicates(List.of(42)));
    }

    @Test
    @DisplayName("element occurring three times is removed")
    void tripleOccurrenceRemoved() {
        assertEquals(Arrays.asList(1, 3),
                solution.removeDuplicates(Arrays.asList(1, 2, 2, 2, 3)));
    }

    @Test
    @DisplayName("negative numbers are handled correctly")
    void negativeNumbersHandled() {
        assertEquals(Arrays.asList(-1, -3),
                solution.removeDuplicates(Arrays.asList(-1, -2, -2, -3)));
    }

    @Test
    @DisplayName("input list is not mutated")
    void inputListNotMutated() {
        List<Integer> input = Arrays.asList(1, 2, 2, 3);
        List<Integer> snapshot = Arrays.asList(1, 2, 2, 3);
        solution.removeDuplicates(input);
        assertEquals(snapshot, input);
    }
}
