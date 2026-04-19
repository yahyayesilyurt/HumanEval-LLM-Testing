package humaneval.task_160;

import humaneval.claude.task_160.Solution;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ImprovedByClaudeTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    @DisplayName("Evaluates expression with exponentiation, multiplication and addition: 2**3*4+5 = 37")
    void evaluatesExpressionWithExponentiationMultiplicationAndAddition() {
        int result = solution.doAlgebra(
                Arrays.asList("**", "*", "+"),
                Arrays.asList(2, 3, 4, 5));

        assertEquals(37, result);
    }

    @Test
    @DisplayName("Evaluates expression honoring operator precedence: 2+3*4-5 = 9")
    void evaluatesExpressionHonoringOperatorPrecedence() {
        int result = solution.doAlgebra(
                Arrays.asList("+", "*", "-"),
                Arrays.asList(2, 3, 4, 5));

        assertEquals(9, result);
    }

    @Test
    @DisplayName("Evaluates expression with floor division and multiplication left-to-right: 7/3*4 = 8")
    void evaluatesExpressionWithFloorDivisionAndMultiplication() {
        int result = solution.doAlgebra(
                Arrays.asList("/", "*"),
                Arrays.asList(7, 3, 4));

        assertEquals(8, result);
    }

    @Test
    @DisplayName("Evaluates right-associative chained exponentiation: 7 + 5**3**2 = 1953132")
    void evaluatesRightAssociativeChainedExponentiation() {
        int result = solution.doAlgebra(
                Arrays.asList("+", "**", "**"),
                Arrays.asList(7, 5, 3, 2));

        assertEquals(1953132, result);
    }

    @Test
    @DisplayName("Evaluates single-operator addition: 2 + 3 = 5")
    void evaluatesSingleOperatorAddition() {
        int result = solution.doAlgebra(
                List.of("+"),
                Arrays.asList(2, 3));

        assertEquals(5, result);
    }

    @Test
    @DisplayName("Evaluates single-operator subtraction producing negative result: 3 - 10 = -7")
    void evaluatesSingleOperatorSubtractionProducingNegativeResult() {
        int result = solution.doAlgebra(
                List.of("-"),
                Arrays.asList(3, 10));

        assertEquals(-7, result);
    }

    @Test
    @DisplayName("Integer division truncates toward zero (Java semantics): 1 - 10/3 = -2")
    void integerDivisionTruncatesTowardZero() {
        int result = solution.doAlgebra(
                Arrays.asList("-", "/"),
                Arrays.asList(1, 10, 3));

        assertEquals(-2, result);
    }

    @Test
    @DisplayName("Evaluates expression containing a zero operand: 5 * 0 + 7 = 7")
    void evaluatesExpressionContainingZeroOperand() {
        int result = solution.doAlgebra(
                Arrays.asList("*", "+"),
                Arrays.asList(5, 0, 7));

        assertEquals(7, result);
    }

    @Test
    @DisplayName("Exponentiation to zero power yields 1: 2 + 5**0 = 3")
    void exponentiationToZeroPowerYieldsOne() {
        int result = solution.doAlgebra(
                Arrays.asList("+", "**"),
                Arrays.asList(2, 5, 0));

        assertEquals(3, result);
    }

    @Test
    @DisplayName("Does not mutate the caller's operator and operand lists")
    void doesNotMutateInputLists() {
        List<String> operators = Arrays.asList("+", "*", "-");
        List<Integer> operands = Arrays.asList(2, 3, 4, 5);
        List<String> operatorsCopy = List.copyOf(operators);
        List<Integer> operandsCopy = List.copyOf(operands);

        solution.doAlgebra(operators, operands);

        assertEquals(operatorsCopy, operators);
        assertEquals(operandsCopy, operands);
    }
}
