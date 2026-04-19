package humaneval.task_49;

import humaneval.claude.task_49.Solution;
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
    @DisplayName("modp(3, 5) returns 2^3 mod 5 = 3")
    void modpReturnsThreeForBaseCase() {
        assertEquals(3, solution.modp(3, 5));
    }

    @Test
    @DisplayName("modp(1101, 101) returns 2^1101 mod 101 = 2")
    void modpHandlesLargeExponent() {
        assertEquals(2, solution.modp(1101, 101));
    }

    @Test
    @DisplayName("modp(0, 101) returns 2^0 mod 101 = 1")
    void modpReturnsOneWhenExponentIsZero() {
        assertEquals(1, solution.modp(0, 101));
    }

    @Test
    @DisplayName("modp(3, 11) returns 2^3 mod 11 = 8")
    void modpReturnsEightForSmallModulus() {
        assertEquals(8, solution.modp(3, 11));
    }

    @Test
    @DisplayName("modp(100, 101) returns 2^100 mod 101 = 1 (Fermat's little theorem)")
    void modpSatisfiesFermatLittleTheorem() {
        assertEquals(1, solution.modp(100, 101));
    }

    @Test
    @DisplayName("modp(30, 5) returns 2^30 mod 5 = 4")
    void modpReturnsFourForExponentThirty() {
        assertEquals(4, solution.modp(30, 5));
    }

    @Test
    @DisplayName("modp(31, 5) returns 2^31 mod 5 = 3")
    void modpReturnsThreeForExponentThirtyOne() {
        assertEquals(3, solution.modp(31, 5));
    }

    @Test
    @DisplayName("modp(n, 1) always returns 0 since anything mod 1 is 0")
    void modpReturnsZeroWhenModulusIsOne() {
        assertEquals(0, solution.modp(0, 1));
        assertEquals(0, solution.modp(5, 1));
        assertEquals(0, solution.modp(1000, 1));
    }

    @Test
    @DisplayName("modp(1, p) returns 2 when p > 2")
    void modpReturnsTwoForExponentOne() {
        assertEquals(2, solution.modp(1, 7));
        assertEquals(2, solution.modp(1, 101));
    }

    @Test
    @DisplayName("modp(2, p) returns 4 when p > 4")
    void modpReturnsFourForExponentTwo() {
        assertEquals(4, solution.modp(2, 7));
        assertEquals(4, solution.modp(2, 101));
    }

    @Test
    @DisplayName("modp(1, 2) returns 0 since 2 mod 2 = 0")
    void modpReturnsZeroWhenPowerEqualsModulus() {
        assertEquals(0, solution.modp(1, 2));
    }

    @Test
    @DisplayName("modp(10, 1024) returns 0 since 2^10 = 1024")
    void modpReturnsZeroWhenExactDivisor() {
        assertEquals(0, solution.modp(10, 1024));
    }

    @Test
    @DisplayName("modp(10, 1023) returns 1 since 2^10 mod 1023 = 1")
    void modpReturnsOneJustAboveDivisor() {
        assertEquals(1, solution.modp(10, 1023));
    }
}
