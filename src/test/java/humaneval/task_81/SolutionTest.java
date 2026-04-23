package humaneval.task_81;

import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SolutionTest {

    @Test
    void claude() {
        var s = new humaneval.claude.task_81.Solution();
        List<Boolean> correct = Arrays.asList(
                s.numericalLetterGrade(new ArrayList<>(Arrays.asList(4.0, 3.0, 1.7, 2.0, 3.5))).equals(Arrays.asList("A+", "B", "C-", "C", "A-")),
                s.numericalLetterGrade(new ArrayList<>(List.of(1.2))).equals(List.of("D+")),
                s.numericalLetterGrade(new ArrayList<>(List.of(0.5))).equals(List.of("D-")),
                s.numericalLetterGrade(new ArrayList<>(List.of(0.0))).equals(List.of("E")),
                s.numericalLetterGrade(new ArrayList<>(Arrays.asList(1.0, 0.3, 1.5, 2.8, 3.3))).equals(Arrays.asList("D", "D-", "C-", "B", "B+")),
                s.numericalLetterGrade(new ArrayList<>(Arrays.asList(0.0, 0.7))).equals(Arrays.asList("E", "D-"))
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    
    }

    @Test
    void gpt() {
        var s = new humaneval.gpt.task_81.Solution();
        List<Boolean> correct = Arrays.asList(
                s.numericalLetterGrade(new ArrayList<>(Arrays.asList(4.0, 3.0, 1.7, 2.0, 3.5))).equals(Arrays.asList("A+", "B", "C-", "C", "A-")),
                s.numericalLetterGrade(new ArrayList<>(List.of(1.2))).equals(List.of("D+")),
                s.numericalLetterGrade(new ArrayList<>(List.of(0.5))).equals(List.of("D-")),
                s.numericalLetterGrade(new ArrayList<>(List.of(0.0))).equals(List.of("E")),
                s.numericalLetterGrade(new ArrayList<>(Arrays.asList(1.0, 0.3, 1.5, 2.8, 3.3))).equals(Arrays.asList("D", "D-", "C-", "B", "B+")),
                s.numericalLetterGrade(new ArrayList<>(Arrays.asList(0.0, 0.7))).equals(Arrays.asList("E", "D-"))
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    
    }

    // Tests with mutations

    // EC15: null list — NoneType: Returns None mutation
    @Test
    void nullListThrowsException() {
        var s = new humaneval.claude.task_81.Solution();
        assertThrows(NullPointerException.class,
                () -> s.numericalLetterGrade(null));
    }

    // Boundary: exactly 3.7 — Returns x±1 mutation on boundary value between A and A-
    @Test
    void exactlyThreePointSevenIsAMinus() {
        var s = new humaneval.claude.task_81.Solution();
        assertEquals(List.of("A-"), s.numericalLetterGrade(List.of(3.7)));
    }
}
