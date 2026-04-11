package humaneval.task_76;

import org.junit.jupiter.api.Test;
import java.util.*;

class SolutionTest {

    @Test
    void claude() {
        var s = new humaneval.claude.task_76.Solution();
        List<Boolean> correct = Arrays.asList(
                s.isSimplePower(1, 4),
                s.isSimplePower(2, 2),
                s.isSimplePower(8, 2),
                !s.isSimplePower(3, 2),
                !s.isSimplePower(3, 1),
                !s.isSimplePower(5, 3),
                s.isSimplePower(16, 2),
                !s.isSimplePower(143214, 16),
                s.isSimplePower(4, 2),
                s.isSimplePower(9, 3),
                s.isSimplePower(16, 4),
                !s.isSimplePower(24, 2),
                !s.isSimplePower(128, 4),
                !s.isSimplePower(12, 6),
                s.isSimplePower(1, 1),
                s.isSimplePower(1, 12)
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    
    }

    @Test
    void gpt() {
        var s = new humaneval.gpt.task_76.Solution();
        List<Boolean> correct = Arrays.asList(
                s.isSimplePower(1, 4),
                s.isSimplePower(2, 2),
                s.isSimplePower(8, 2),
                !s.isSimplePower(3, 2),
                !s.isSimplePower(3, 1),
                !s.isSimplePower(5, 3),
                s.isSimplePower(16, 2),
                !s.isSimplePower(143214, 16),
                s.isSimplePower(4, 2),
                s.isSimplePower(9, 3),
                s.isSimplePower(16, 4),
                !s.isSimplePower(24, 2),
                !s.isSimplePower(128, 4),
                !s.isSimplePower(12, 6),
                s.isSimplePower(1, 1),
                s.isSimplePower(1, 12)
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    
    }
}
