package humaneval.task_19;

import humaneval.claude.task_19.Solution;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ImprovedByClaudeTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    @DisplayName("Empty string returns empty string")
    void sortNumbers_emptyString_returnsEmpty() {
        assertEquals("", solution.sortNumbers(""));
    }

    @Test
    @DisplayName("Null input returns empty string")
    void sortNumbers_nullInput_returnsEmpty() {
        assertEquals("", solution.sortNumbers(null));
    }

    @Test
    @DisplayName("Single numeral returns itself")
    void sortNumbers_singleNumeral_returnsItself() {
        assertEquals("three", solution.sortNumbers("three"));
    }

    @Test
    @DisplayName("Already sorted input is unchanged")
    void sortNumbers_alreadySorted_unchanged() {
        assertEquals("three five nine", solution.sortNumbers("three five nine"));
    }

    @Test
    @DisplayName("Mixed numerals are sorted ascending")
    void sortNumbers_mixedOrder_sortedAscending() {
        assertEquals(
                "zero four five seven eight nine",
                solution.sortNumbers("five zero four seven nine eight")
        );
    }

    @Test
    @DisplayName("Reverse sorted input is reordered ascending")
    void sortNumbers_reverseSorted_sortedAscending() {
        assertEquals(
                "zero one two three four five six seven eight nine",
                solution.sortNumbers("nine eight seven six five four three two one zero")
        );
    }

    @Test
    @DisplayName("All ten numerals in arbitrary order")
    void sortNumbers_allTenNumerals_sortedAscending() {
        assertEquals(
                "zero one two three four five six seven eight nine",
                solution.sortNumbers("six two nine zero five one eight three seven four")
        );
    }

    @Test
    @DisplayName("Duplicate numerals preserved")
    void sortNumbers_duplicates_allPreserved() {
        assertEquals("one one two two three", solution.sortNumbers("two one three two one"));
    }

    @Test
    @DisplayName("Two numerals smallest first")
    void sortNumbers_twoNumerals_smallestFirst() {
        assertEquals("zero nine", solution.sortNumbers("nine zero"));
    }

    @Test
    @DisplayName("Result is non-null for valid input")
    void sortNumbers_validInput_isNonNull() {
        assertNotNull(solution.sortNumbers("one"));
    }
}
