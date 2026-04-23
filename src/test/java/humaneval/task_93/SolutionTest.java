package humaneval.task_93;

import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SolutionTest {

    @Test
    void claude() {
        var s = new humaneval.claude.task_93.Solution();
        List<Boolean> correct = Arrays.asList(
                Objects.equals(s.encode("TEST"), "tgst"),
                Objects.equals(s.encode("Mudasir"), "mWDCSKR"),
                Objects.equals(s.encode("YES"), "ygs"),
                Objects.equals(s.encode("This is a message"), "tHKS KS C MGSSCGG"),
                Objects.equals(s.encode("I DoNt KnOw WhAt tO WrItE"), "k dQnT kNqW wHcT Tq wRkTg")
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    
    }

    @Test
    void gpt() {
        var s = new humaneval.gpt.task_93.Solution();
        List<Boolean> correct = Arrays.asList(
                Objects.equals(s.encode("TEST"), "tgst"),
                Objects.equals(s.encode("Mudasir"), "mWDCSKR"),
                Objects.equals(s.encode("YES"), "ygs"),
                Objects.equals(s.encode("This is a message"), "tHKS KS C MGSSCGG"),
                Objects.equals(s.encode("I DoNt KnOw WhAt tO WrItE"), "k dQnT kNqW wHcT Tq wRkTg")
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    
    }

    // Tests with mutations

    // EC8: all five lowercase vowels — Replace s with Mutate(s): all vowels input
    @Test
    void allVowelsLowercase() {
        var s = new humaneval.claude.task_93.Solution();
        assertEquals("CGKQW", s.encode("aeiou"));
    }

    // EC9: null input — NoneType: Returns None mutation
    @Test
    void nullInputThrowsException() {
        var s = new humaneval.claude.task_93.Solution();
        assertThrows(NullPointerException.class,
                () -> s.encode(null));
    }
}
