package humaneval.task_27;

import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SolutionTest {

    @Test
    void claude() {
        var s = new humaneval.claude.task_27.Solution();
        List<Boolean> correct = Arrays.asList(
                Objects.equals(s.flipCase(""), ""),
                Objects.equals(s.flipCase("Hello!"), "hELLO!"),
                Objects.equals(s.flipCase("These violent delights have violent ends"), "tHESE VIOLENT DELIGHTS HAVE VIOLENT ENDS")
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    
    }

    @Test
    void gpt() {
        var s = new humaneval.gpt.task_27.Solution();
        List<Boolean> correct = Arrays.asList(
                Objects.equals(s.flipCase(""), ""),
                Objects.equals(s.flipCase("Hello!"), "hELLO!"),
                Objects.equals(s.flipCase("These violent delights have violent ends"), "tHESE VIOLENT DELIGHTS HAVE VIOLENT ENDS")
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    
    }

    // Tests with mutations
    // EC9: null input
    @Test
    void nullInputThrowsException() {
        var s = new humaneval.claude.task_27.Solution();
        assertThrows(NullPointerException.class,
                () -> s.flipCase(null));
    }

    // EC10: Unicode / Non-ASCII characters
    @Test
    void flipsCaseForUnicodeCharacters() {
        var s = new humaneval.claude.task_27.Solution();
        assertEquals("ÜğŞ", s.flipCase("üĞş"));
    }
}
