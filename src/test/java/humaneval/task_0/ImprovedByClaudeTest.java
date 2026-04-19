package humaneval.task_0;

import humaneval.claude.task_0.Solution;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ImprovedByClaudeTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Nested
    @DisplayName("when pairs are within the threshold")
    class CloseElementsPresent {

        @Test
        @DisplayName("returns true when a duplicate value exists and threshold is positive")
        void detectsDuplicateValuesAsClose() {
            assertTrue(solution.hasCloseElements(
                    Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0, 2.0), 0.1));
        }

        @Test
        @DisplayName("returns true when adjacent values differ by less than the threshold")
        void detectsNearbyValues() {
            assertTrue(solution.hasCloseElements(
                    Arrays.asList(11.0, 2.0, 3.9, 4.0, 5.0, 2.2), 0.3));
        }

        @Test
        @DisplayName("returns true when the gap equals just under a wider threshold")
        void detectsValuesWithinWideThreshold() {
            assertTrue(solution.hasCloseElements(
                    Arrays.asList(1.0, 2.0, 5.9, 4.0, 5.0), 0.95));
        }

        @Test
        @DisplayName("returns true when every consecutive pair is within threshold 1.0")
        void detectsEvenlySpacedValues() {
            assertTrue(solution.hasCloseElements(
                    Arrays.asList(1.1, 2.2, 3.1, 4.1, 5.1), 1.0));
        }

        @Test
        @DisplayName("returns true when only the last pair is close (exercises inner loop tail)")
        void detectsClosePairAtEnd() {
            assertTrue(solution.hasCloseElements(
                    Arrays.asList(10.0, 20.0, 30.0, 30.05), 0.1));
        }
    }

    @Nested
    @DisplayName("when no pair is within the threshold")
    class NoCloseElements {

        @Test
        @DisplayName("returns false when threshold is very small and values are distinct")
        void rejectsDistinctValuesWithTightThreshold() {
            assertFalse(solution.hasCloseElements(
                    Arrays.asList(1.0, 2.0, 3.9, 4.0, 5.0, 2.2), 0.05));
        }

        @Test
        @DisplayName("returns false when threshold is below minimum pairwise distance")
        void rejectsValuesBelowThreshold() {
            assertFalse(solution.hasCloseElements(
                    Arrays.asList(1.0, 2.0, 5.9, 4.0, 5.0), 0.8));
        }

        @Test
        @DisplayName("returns false when evenly spaced values exceed the threshold")
        void rejectsEvenlySpacedValues() {
            assertFalse(solution.hasCloseElements(
                    Arrays.asList(1.1, 2.2, 3.1, 4.1, 5.1), 0.5));
        }

        @Test
        @DisplayName("returns false for the strict-less-than comparison at the exact threshold")
        void rejectsDifferenceExactlyEqualToThreshold() {
            assertFalse(solution.hasCloseElements(
                    Arrays.asList(1.0, 2.0), 1.0));
        }
    }

    @Nested
    @DisplayName("edge cases")
    class EdgeCases {

        @Test
        @DisplayName("returns false for an empty list")
        void emptyListHasNoCloseElements() {
            assertFalse(solution.hasCloseElements(Collections.emptyList(), 1.0));
        }

        @Test
        @DisplayName("returns false for a single-element list")
        void singletonHasNoCloseElements() {
            assertFalse(solution.hasCloseElements(Collections.singletonList(42.0), 10.0));
        }

        @Test
        @DisplayName("returns false when threshold is zero and all values are distinct")
        void zeroThresholdWithDistinctValues() {
            assertFalse(solution.hasCloseElements(Arrays.asList(1.0, 2.0, 3.0), 0.0));
        }

        @Test
        @DisplayName("handles negative numbers using absolute distance")
        void handlesNegativeNumbers() {
            assertTrue(solution.hasCloseElements(
                    Arrays.asList(-5.0, -4.9, 10.0), 0.2));
        }
    }

    @ParameterizedTest(name = "[{index}] hasCloseElements({0}, {1}) == {2}")
    @MethodSource("humanEvalCases")
    @DisplayName("matches the original HumanEval expectations")
    void matchesHumanEvalExpectations(List<Double> numbers, double threshold, boolean expected) {
        if (expected) {
            assertTrue(solution.hasCloseElements(numbers, threshold));
        } else {
            assertFalse(solution.hasCloseElements(numbers, threshold));
        }
    }

    static Stream<Arguments> humanEvalCases() {
        return Stream.of(
                Arguments.of(Arrays.asList(11.0, 2.0, 3.9, 4.0, 5.0, 2.2), 0.3, true),
                Arguments.of(Arrays.asList(1.0, 2.0, 3.9, 4.0, 5.0, 2.2), 0.05, false),
                Arguments.of(Arrays.asList(1.0, 2.0, 5.9, 4.0, 5.0), 0.95, true),
                Arguments.of(Arrays.asList(1.0, 2.0, 5.9, 4.0, 5.0), 0.8, false),
                Arguments.of(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0, 2.0), 0.1, true),
                Arguments.of(Arrays.asList(1.1, 2.2, 3.1, 4.1, 5.1), 1.0, true),
                Arguments.of(Arrays.asList(1.1, 2.2, 3.1, 4.1, 5.1), 0.5, false)
        );
    }
}
