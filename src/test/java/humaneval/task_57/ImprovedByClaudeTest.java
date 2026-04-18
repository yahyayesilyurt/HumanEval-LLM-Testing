package humaneval.task_57;

import humaneval.claude.task_57.Solution;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ImprovedByClaudeTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    @DisplayName("Empty list is trivially monotonic")
    void emptyListIsMonotonic() {
        assertTrue(solution.monotonic(Collections.emptyList()));
    }

    @Test
    @DisplayName("Single-element list is trivially monotonic")
    void singleElementListIsMonotonic() {
        assertTrue(solution.monotonic(Collections.singletonList(42)));
    }

    @Test
    @DisplayName("Two-element strictly increasing list is monotonic")
    void twoElementIncreasingIsMonotonic() {
        assertTrue(solution.monotonic(Arrays.asList(1, 2)));
    }

    @Test
    @DisplayName("Two-element strictly decreasing list is monotonic")
    void twoElementDecreasingIsMonotonic() {
        assertTrue(solution.monotonic(Arrays.asList(2, 1)));
    }

    @Test
    @DisplayName("Strictly increasing list is monotonic")
    void strictlyIncreasingIsMonotonic() {
        assertTrue(solution.monotonic(Arrays.asList(1, 2, 4, 10)));
    }

    @Test
    @DisplayName("Another strictly increasing list is monotonic")
    void anotherStrictlyIncreasingIsMonotonic() {
        assertTrue(solution.monotonic(Arrays.asList(1, 2, 4, 20)));
    }

    @Test
    @DisplayName("Fully increasing sequence to large value is monotonic")
    void longIncreasingSequenceIsMonotonic() {
        assertTrue(solution.monotonic(Arrays.asList(1, 2, 3, 4, 5, 60)));
    }

    @Test
    @DisplayName("Strictly decreasing list with negative values is monotonic")
    void strictlyDecreasingWithNegativesIsMonotonic() {
        assertTrue(solution.monotonic(Arrays.asList(4, 1, 0, -10)));
    }

    @Test
    @DisplayName("Non-strictly decreasing list with duplicates is monotonic")
    void nonStrictlyDecreasingWithDuplicatesIsMonotonic() {
        assertTrue(solution.monotonic(Arrays.asList(4, 1, 1, 0)));
    }

    @Test
    @DisplayName("All-equal list is monotonic (both increasing and decreasing vacuously)")
    void allEqualListIsMonotonic() {
        assertTrue(solution.monotonic(Arrays.asList(9, 9, 9, 9)));
    }

    @Test
    @DisplayName("All-equal two-element list is monotonic")
    void twoEqualElementsAreMonotonic() {
        assertTrue(solution.monotonic(Arrays.asList(5, 5)));
    }

    @Test
    @DisplayName("Non-strictly increasing list with duplicates is monotonic")
    void nonStrictlyIncreasingWithDuplicatesIsMonotonic() {
        assertTrue(solution.monotonic(Arrays.asList(1, 1, 2, 3)));
    }

    @Test
    @DisplayName("List with a single dip is not monotonic")
    void listWithDipIsNotMonotonic() {
        assertFalse(solution.monotonic(Arrays.asList(1, 20, 4, 10)));
    }

    @Test
    @DisplayName("List that rises then dips then rises is not monotonic")
    void riseDipRiseIsNotMonotonic() {
        assertFalse(solution.monotonic(Arrays.asList(1, 2, 3, 2, 5, 60)));
    }

    @Test
    @DisplayName("List that decreases then increases is not monotonic")
    void decreaseThenIncreaseIsNotMonotonic() {
        assertFalse(solution.monotonic(Arrays.asList(5, 3, 1, 2)));
    }

    @Test
    @DisplayName("List that increases then decreases is not monotonic")
    void increaseThenDecreaseIsNotMonotonic() {
        assertFalse(solution.monotonic(Arrays.asList(1, 3, 5, 2)));
    }

    @Test
    @DisplayName("Negative-only strictly increasing list is monotonic")
    void negativeStrictlyIncreasingIsMonotonic() {
        assertTrue(solution.monotonic(Arrays.asList(-10, -5, -1, 0)));
    }

    @Test
    @DisplayName("List mixing positives and negatives decreasing is monotonic")
    void mixedSignsDecreasingIsMonotonic() {
        assertTrue(solution.monotonic(Arrays.asList(10, 5, -1, -100)));
    }
}
