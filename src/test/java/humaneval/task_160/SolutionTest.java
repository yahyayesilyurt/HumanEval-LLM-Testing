package humaneval.task_160;

import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SolutionTest {

    @Test
    void claude() {
        var s = new humaneval.claude.task_160.Solution();
        List<Boolean> correct = Arrays.asList(
                s.doAlgebra(new ArrayList<>(Arrays.asList("**", "*", "+")), new ArrayList<>(Arrays.asList(2, 3, 4, 5))) == 37,
                s.doAlgebra(new ArrayList<>(Arrays.asList("+", "*", "-")), new ArrayList<>(Arrays.asList(2, 3, 4, 5))) == 9,
                s.doAlgebra(new ArrayList<>(Arrays.asList("/", "*")), new ArrayList<>(Arrays.asList(7, 3, 4))) == 8,
                s.doAlgebra(new ArrayList<>(Arrays.asList("+", "**", "**")), new ArrayList<>(Arrays.asList(7, 5, 3, 2))) == 1953132
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    
    }

    @Test
    void gpt() {
        var s = new humaneval.gpt.task_160.Solution();
        List<Boolean> correct = Arrays.asList(
                s.doAlgebra(new ArrayList<>(Arrays.asList("**", "*", "+")), new ArrayList<>(Arrays.asList(2, 3, 4, 5))) == 37,
                s.doAlgebra(new ArrayList<>(Arrays.asList("+", "*", "-")), new ArrayList<>(Arrays.asList(2, 3, 4, 5))) == 9,
                s.doAlgebra(new ArrayList<>(Arrays.asList("/", "*")), new ArrayList<>(Arrays.asList(7, 3, 4))) == 8,
                s.doAlgebra(new ArrayList<>(Arrays.asList("+", "**", "**")), new ArrayList<>(Arrays.asList(7, 5, 3, 2))) == 1953132
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    
    }

    // Tests with mutations

    // EC6: single multiplication — Replace operator with Mutate(op): isolated * operator
    @Test
    void singleMultiplication() {
        var s = new humaneval.claude.task_160.Solution();
        assertEquals(12, s.doAlgebra(List.of("*"), Arrays.asList(3, 4)));
    }

    // EC7: single floor division — Replace operator with Mutate(op): isolated / operator
    @Test
    void singleFloorDivision() {
        var s = new humaneval.claude.task_160.Solution();
        assertEquals(3, s.doAlgebra(List.of("/"), Arrays.asList(10, 3)));
    }

    // EC8: single exponentiation — Replace operator with Mutate(op): isolated ** operator
    @Test
    void singleExponentiation() {
        var s = new humaneval.claude.task_160.Solution();
        assertEquals(1024, s.doAlgebra(List.of("**"), Arrays.asList(2, 10)));
    }

    // EC11: unsupported operator — Replace operator with Mutate(op): invalid symbol
    @Test
    void unsupportedOperatorThrowsException() {
        var s = new humaneval.claude.task_160.Solution();
        assertThrows(Exception.class,
                () -> s.doAlgebra(List.of("^"), Arrays.asList(2, 3)));
    }

    // EC12: null operator list — NoneType: Returns None mutation on operator parameter
    @Test
    void nullOperatorListThrowsException() {
        var s = new humaneval.claude.task_160.Solution();
        assertThrows(NullPointerException.class,
                () -> s.doAlgebra(null, Arrays.asList(1, 2)));
    }

    // EC13: null operand list — NoneType: Returns None mutation on operand parameter
    @Test
    void nullOperandListThrowsException() {
        var s = new humaneval.claude.task_160.Solution();
        assertThrows(NullPointerException.class,
                () -> s.doAlgebra(List.of("+"), null));
    }
}
