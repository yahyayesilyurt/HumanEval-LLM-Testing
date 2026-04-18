package humaneval.task_26;

import humaneval.gpt.task_26.Solution;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ImprovedByGptTest {

    private final Solution solution = new Solution();

    @Test
    void returnsEmptyListForEmptyInput() {
        assertEquals(List.of(), solution.removeDuplicates(List.of()));
    }

    @Test
    void returnsOriginalListWhenAllElementsAreUnique() {
        assertEquals(List.of(1, 2, 3, 4), solution.removeDuplicates(List.of(1, 2, 3, 4)));
    }

    @Test
    void removesAllElementsThatAppearMoreThanOnce() {
        assertEquals(List.of(1, 4, 5), solution.removeDuplicates(List.of(1, 2, 3, 2, 4, 3, 5)));
    }

    @Test
    void preservesOrderOfRemainingUniqueElements() {
        assertEquals(List.of(3, 1, 5), solution.removeDuplicates(List.of(9, 3, 9, 1, 2, 2, 5)));
    }
}
