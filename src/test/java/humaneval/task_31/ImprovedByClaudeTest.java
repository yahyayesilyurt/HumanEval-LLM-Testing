package humaneval.task_31;

import humaneval.claude.task_31.Solution;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ImprovedByClaudeTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1})
    void returnsFalseForValuesBelowTwo(int n) {
        assertFalse(solution.isPrime(n));
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 3})
    void returnsTrueForSmallPrimesBelowFour(int n) {
        assertTrue(solution.isPrime(n));
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 6, 8, 100, 1000})
    void returnsFalseForEvenCompositesAtLeastFour(int n) {
        assertFalse(solution.isPrime(n));
    }

    @ParameterizedTest
    @ValueSource(ints = {9, 15, 25, 49, 77, 85, 121, 255379})
    void returnsFalseForOddComposites(int n) {
        assertFalse(solution.isPrime(n));
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 7, 11, 13, 17, 19, 61, 101, 13441})
    void returnsTrueForOddPrimes(int n) {
        assertTrue(solution.isPrime(n));
    }

    @Test
    void negativeNumberIsNotPrime() {
        assertFalse(solution.isPrime(-7));
    }
}
