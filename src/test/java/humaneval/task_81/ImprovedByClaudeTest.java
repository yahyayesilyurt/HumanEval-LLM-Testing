package humaneval.task_81;

import humaneval.claude.task_81.Solution;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ImprovedByClaudeTest {

    private final Solution solution = new Solution();

    @Test
    void exampleFromDocstring() {
        assertEquals(
                Arrays.asList("A+", "B", "C-", "C", "A-"),
                solution.numericalLetterGrade(Arrays.asList(4.0, 3.0, 1.7, 2.0, 3.5))
        );
    }

    @Test
    void aPlusAtExactlyFour() {
        assertEquals(List.of("A+"), solution.numericalLetterGrade(List.of(4.0)));
    }

    @Test
    void aAboveThreePointSeven() {
        assertEquals(List.of("A"), solution.numericalLetterGrade(List.of(3.8)));
    }

    @Test
    void aMinusAboveThreePointThree() {
        assertEquals(List.of("A-"), solution.numericalLetterGrade(List.of(3.5)));
    }

    @Test
    void bPlusAboveThree() {
        assertEquals(List.of("B+"), solution.numericalLetterGrade(List.of(3.1)));
    }

    @Test
    void bAboveTwoPointSeven() {
        assertEquals(List.of("B"), solution.numericalLetterGrade(List.of(2.8)));
    }

    @Test
    void bMinusAboveTwoPointThree() {
        assertEquals(List.of("B-"), solution.numericalLetterGrade(List.of(2.4)));
    }

    @Test
    void cPlusAboveTwo() {
        assertEquals(List.of("C+"), solution.numericalLetterGrade(List.of(2.1)));
    }

    @Test
    void cAboveOnePointSeven() {
        assertEquals(List.of("C"), solution.numericalLetterGrade(List.of(1.8)));
    }

    @Test
    void cMinusAboveOnePointThree() {
        assertEquals(List.of("C-"), solution.numericalLetterGrade(List.of(1.5)));
    }

    @Test
    void dPlusAboveOne() {
        assertEquals(List.of("D+"), solution.numericalLetterGrade(List.of(1.2)));
    }

    @Test
    void dAboveZeroPointSeven() {
        assertEquals(List.of("D"), solution.numericalLetterGrade(List.of(0.9)));
    }

    @Test
    void dMinusAboveZero() {
        assertEquals(List.of("D-"), solution.numericalLetterGrade(List.of(0.5)));
    }

    @Test
    void eAtZero() {
        assertEquals(List.of("E"), solution.numericalLetterGrade(List.of(0.0)));
    }

    @Test
    void boundaryValuesTakeLowerGrade() {
        assertEquals(
                Arrays.asList("B+", "B", "B-", "C+", "C", "C-", "D+", "D", "D-"),
                solution.numericalLetterGrade(Arrays.asList(3.3, 3.0, 2.7, 2.3, 2.0, 1.7, 1.3, 1.0, 0.7))
        );
    }

    @Test
    void everyGradeInOneCall() {
        assertEquals(
                Arrays.asList("A+", "A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D", "D-", "E"),
                solution.numericalLetterGrade(Arrays.asList(4.0, 3.8, 3.5, 3.1, 2.8, 2.4, 2.1, 1.8, 1.5, 1.2, 0.9, 0.5, 0.0))
        );
    }

    @Test
    void emptyInputReturnsEmpty() {
        assertEquals(Collections.emptyList(), solution.numericalLetterGrade(Collections.emptyList()));
    }
}
