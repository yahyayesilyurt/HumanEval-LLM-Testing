package humaneval.task_160;

import humaneval.gpt.task_160.Solution;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ImprovedByGptTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    @DisplayName("Evaluates mixed precedence with exponentiation before multiplication before addition")
    void evaluatesMixedPrecedence() {
        int result = solution.doAlgebra(
                List.of("**", "*", "+"),
                List.of(2, 3, 4, 5));

        assertEquals(37, result);
    }

    @Test
    @DisplayName("Evaluates multiplication before subtraction and addition")
    void respectsStandardOperatorPrecedence() {
        int result = solution.doAlgebra(
                List.of("+", "*", "-"),
                List.of(2, 3, 4, 5));

        assertEquals(9, result);
    }

    @Test
    @DisplayName("Evaluates chained exponentiation as right associative")
    void evaluatesRightAssociativeExponentiation() {
        int result = solution.doAlgebra(
                List.of("+", "**", "**"),
                List.of(7, 5, 3, 2));

        assertEquals(1953132, result);
    }

    @Test
    @DisplayName("Integer division truncates toward zero; zero exponent yields 1")
    void integerDivisionAndZeroExponent() {
        assertEquals(-2, solution.doAlgebra(List.of("-", "/"), List.of(1, 10, 3)));
        assertEquals(3, solution.doAlgebra(List.of("+", "**"), List.of(2, 5, 0)));
    }

    @Test
    @DisplayName("Throws when an unsupported operator is provided")
    void throwsForUnsupportedOperator() {
        assertThrows(
                NoSuchElementException.class,
                () -> solution.doAlgebra(List.of("%"), List.of(2, 3))
        );
    }
}
