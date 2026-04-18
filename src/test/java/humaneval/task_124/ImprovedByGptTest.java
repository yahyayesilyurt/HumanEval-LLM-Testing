package humaneval.task_124;

import humaneval.gpt.task_124.Solution;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ImprovedByGptTest {

    private final Solution solution = new Solution();

    @Test
    void acceptsWellFormedDatesWithinAllowedRanges() {
        assertAll(
                () -> assertTrue(solution.validDate("03-11-2000")),
                () -> assertTrue(solution.validDate("06-04-2020")),
                () -> assertTrue(solution.validDate("01-01-2007")),
                () -> assertTrue(solution.validDate("06-06-2005")),
                () -> assertTrue(solution.validDate("04-12-2003")),
                () -> assertTrue(solution.validDate("02-29-2000"))
        );
    }

    @Test
    void rejectsNullEmptyAndMalformedInputs() {
        assertAll(
                () -> assertFalse(solution.validDate(null)),
                () -> assertFalse(solution.validDate("")),
                () -> assertFalse(solution.validDate("04-0-2040")),
                () -> assertFalse(solution.validDate("04122003")),
                () -> assertFalse(solution.validDate("20030412")),
                () -> assertFalse(solution.validDate("2003-04")),
                () -> assertFalse(solution.validDate("2003-04-12")),
                () -> assertFalse(solution.validDate("04-2003"))
        );
    }

    @Test
    void rejectsMonthsOutsideOneToTwelve() {
        assertAll(
                () -> assertFalse(solution.validDate("00-15-2020")),
                () -> assertFalse(solution.validDate("13-01-2012")),
                () -> assertFalse(solution.validDate("15-01-2012")),
                () -> assertFalse(solution.validDate("21-31-2000"))
        );
    }

    @Test
    void rejectsDaysOutsideAllowedMonthLimits() {
        assertAll(
                () -> assertFalse(solution.validDate("03-00-2011")),
                () -> assertFalse(solution.validDate("03-32-2011")),
                () -> assertFalse(solution.validDate("04-31-3000"))
        );
    }
}
