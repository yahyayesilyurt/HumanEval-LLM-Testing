package humaneval.task_4;

import humaneval.claude.task_4.Solution;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ImprovedByClaudeTest {

    private static final double EPS = 1e-6;

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    @DisplayName("MAD of [1.0, 2.0, 3.0] equals 2/3")
    void madOfThreeConsecutiveIntegers() {
        double result = solution.meanAbsoluteDeviation(Arrays.asList(1.0, 2.0, 3.0));
        assertEquals(2.0 / 3.0, result, EPS);
    }

    @Test
    @DisplayName("MAD of [1.0, 2.0, 3.0, 4.0] equals 1.0 (docstring example)")
    void madOfFourConsecutiveIntegers() {
        double result = solution.meanAbsoluteDeviation(Arrays.asList(1.0, 2.0, 3.0, 4.0));
        assertEquals(1.0, result, EPS);
    }

    @Test
    @DisplayName("MAD of [1.0, 2.0, 3.0, 4.0, 5.0] equals 6/5")
    void madOfFiveConsecutiveIntegers() {
        double result = solution.meanAbsoluteDeviation(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0));
        assertEquals(6.0 / 5.0, result, EPS);
    }

    @Test
    @DisplayName("MAD of a single-element list is zero")
    void madOfSingletonIsZero() {
        double result = solution.meanAbsoluteDeviation(Collections.singletonList(42.0));
        assertEquals(0.0, result, EPS);
    }

    @Test
    @DisplayName("MAD of identical elements is zero")
    void madOfIdenticalElementsIsZero() {
        double result = solution.meanAbsoluteDeviation(Arrays.asList(7.0, 7.0, 7.0, 7.0));
        assertEquals(0.0, result, EPS);
    }

    @Test
    @DisplayName("MAD handles negative numbers")
    void madOfNegativeNumbers() {
        double result = solution.meanAbsoluteDeviation(Arrays.asList(-1.0, -2.0, -3.0, -4.0));
        assertEquals(1.0, result, EPS);
    }

    @Test
    @DisplayName("MAD handles mixed positive and negative numbers symmetric around zero")
    void madOfSymmetricRange() {
        double result = solution.meanAbsoluteDeviation(Arrays.asList(-2.0, -1.0, 1.0, 2.0));
        assertEquals(1.5, result, EPS);
    }

    @Test
    @DisplayName("MAD is translation-invariant: shifting all values by a constant does not change MAD")
    void madIsTranslationInvariant() {
        List<Double> base = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0);
        List<Double> shifted = Arrays.asList(101.0, 102.0, 103.0, 104.0, 105.0);
        assertEquals(
                solution.meanAbsoluteDeviation(base),
                solution.meanAbsoluteDeviation(shifted),
                EPS
        );
    }

    @Test
    @DisplayName("MAD scales linearly with uniform multiplication of all values")
    void madScalesLinearly() {
        List<Double> base = Arrays.asList(1.0, 2.0, 3.0, 4.0);
        List<Double> scaled = Arrays.asList(3.0, 6.0, 9.0, 12.0);
        assertEquals(
                3.0 * solution.meanAbsoluteDeviation(base),
                solution.meanAbsoluteDeviation(scaled),
                EPS
        );
    }

    @Test
    @DisplayName("MAD of two-element list equals half the absolute difference")
    void madOfTwoElements() {
        double result = solution.meanAbsoluteDeviation(Arrays.asList(10.0, 20.0));
        assertEquals(5.0, result, EPS);
    }

    @Test
    @DisplayName("MAD handles fractional values")
    void madOfFractionalValues() {
        double result = solution.meanAbsoluteDeviation(Arrays.asList(0.5, 1.5, 2.5, 3.5));
        assertEquals(1.0, result, EPS);
    }

    @ParameterizedTest(name = "MAD({0}) == {1}")
    @MethodSource("madCases")
    void madMatchesExpected(List<Double> input, double expected) {
        assertEquals(expected, solution.meanAbsoluteDeviation(input), EPS);
    }

    static Stream<Arguments> madCases() {
        return Stream.of(
                Arguments.of(Arrays.asList(1.0, 2.0, 3.0), 2.0 / 3.0),
                Arguments.of(Arrays.asList(1.0, 2.0, 3.0, 4.0), 1.0),
                Arguments.of(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0), 6.0 / 5.0),
                Arguments.of(Collections.singletonList(5.0), 0.0),
                Arguments.of(Arrays.asList(0.0, 0.0, 0.0), 0.0),
                Arguments.of(Arrays.asList(-5.0, 5.0), 5.0)
        );
    }
}
