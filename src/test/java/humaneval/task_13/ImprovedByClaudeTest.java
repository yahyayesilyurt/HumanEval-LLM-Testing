package humaneval.task_13;

import humaneval.claude.task_13.Solution;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ImprovedByClaudeTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    @DisplayName("GCD of coprime integers is 1")
    void gcdOfCoprimeIntegersIsOne() {
        assertEquals(1, solution.greatestCommonDivisor(3, 7));
    }

    @Test
    @DisplayName("GCD where smaller divides larger returns the smaller")
    void gcdWhereSmallerDividesLarger() {
        assertEquals(5, solution.greatestCommonDivisor(10, 15));
    }

    @Test
    @DisplayName("GCD of 49 and 14 is 7")
    void gcdOfFortyNineAndFourteen() {
        assertEquals(7, solution.greatestCommonDivisor(49, 14));
    }

    @Test
    @DisplayName("GCD of 144 and 60 is 12")
    void gcdOfOneHundredFortyFourAndSixty() {
        assertEquals(12, solution.greatestCommonDivisor(144, 60));
    }

    @Test
    @DisplayName("GCD with zero as second argument returns the first argument")
    void gcdWithZeroSecondArgument() {
        assertEquals(9, solution.greatestCommonDivisor(9, 0));
    }

    @Test
    @DisplayName("GCD with zero as first argument returns the second argument")
    void gcdWithZeroFirstArgument() {
        assertEquals(9, solution.greatestCommonDivisor(0, 9));
    }

    @Test
    @DisplayName("GCD of two equal numbers is the number itself")
    void gcdOfEqualNumbers() {
        assertEquals(8, solution.greatestCommonDivisor(8, 8));
    }

    @Test
    @DisplayName("GCD with one returns one")
    void gcdWithOneReturnsOne() {
        assertEquals(1, solution.greatestCommonDivisor(1, 17));
    }
}
