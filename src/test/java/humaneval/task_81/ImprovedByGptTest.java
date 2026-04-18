package humaneval.task_81;

import humaneval.gpt.task_81.Solution;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class ImprovedByGptTest {

    private final Solution solution = new Solution();

    @Test
    void convertsRepresentativeGradeLists() {
        assertAll(
                () -> assertIterableEquals(
                        List.of("A+", "B", "C-", "C", "A-"),
                        solution.numericalLetterGrade(List.of(4.0, 3.0, 1.7, 2.0, 3.5))
                ),
                () -> assertIterableEquals(
                        List.of("D+"),
                        solution.numericalLetterGrade(List.of(1.2))
                ),
                () -> assertIterableEquals(
                        List.of("D-"),
                        solution.numericalLetterGrade(List.of(0.5))
                ),
                () -> assertIterableEquals(
                        List.of("E"),
                        solution.numericalLetterGrade(List.of(0.0))
                ),
                () -> assertIterableEquals(
                        List.of("D", "D-", "C-", "B", "B+"),
                        solution.numericalLetterGrade(List.of(1.0, 0.3, 1.5, 2.8, 3.3))
                ),
                () -> assertIterableEquals(
                        List.of("E", "D-"),
                        solution.numericalLetterGrade(List.of(0.0, 0.7))
                )
        );
    }

    @Test
    void handlesExactThresholdValuesWithLowerBracketExceptPerfectScore() {
        assertIterableEquals(
                List.of("A+", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D", "D-", "E"),
                solution.numericalLetterGrade(List.of(4.0, 3.7, 3.3, 3.0, 2.7, 2.3, 2.0, 1.7, 1.3, 1.0, 0.7, 0.0))
        );
    }

    @Test
    void handlesValuesJustAboveBoundariesAndNegativeGrades() {
        assertIterableEquals(
                List.of("A", "B-", "C+", "D+", "D", "E"),
                solution.numericalLetterGrade(List.of(3.8, 2.4, 2.1, 1.1, 0.8, -0.5))
        );
    }
}
