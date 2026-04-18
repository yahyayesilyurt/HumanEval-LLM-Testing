package humaneval.task_124;

import humaneval.claude.task_124.Solution;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ImprovedByClaudeTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    @DisplayName("accepts a standard valid date in March")
    void acceptsValidMarchDate() {
        assertTrue(solution.validDate("03-11-2000"));
    }

    @Test
    @DisplayName("accepts a standard valid date in June")
    void acceptsValidJuneDate() {
        assertTrue(solution.validDate("06-04-2020"));
    }

    @Test
    @DisplayName("accepts first day of January")
    void acceptsFirstOfJanuary() {
        assertTrue(solution.validDate("01-01-2007"));
    }

    @Test
    @DisplayName("rejects null input")
    void rejectsNull() {
        assertFalse(solution.validDate(null));
    }

    @Test
    @DisplayName("rejects empty string")
    void rejectsEmptyString() {
        assertFalse(solution.validDate(""));
    }

    @Test
    @DisplayName("rejects slash delimiters instead of dashes")
    void rejectsSlashDelimiters() {
        assertFalse(solution.validDate("06/04/2020"));
    }

    @Test
    @DisplayName("rejects dates with no delimiters")
    void rejectsNoDelimiters() {
        assertFalse(solution.validDate("04122003"));
    }

    @Test
    @DisplayName("rejects compact yyyymmdd form")
    void rejectsCompactReverseForm() {
        assertFalse(solution.validDate("20030412"));
    }

    @Test
    @DisplayName("rejects date missing day component")
    void rejectsMissingDay() {
        assertFalse(solution.validDate("2003-04"));
    }

    @Test
    @DisplayName("rejects yyyy-mm-dd ordering")
    void rejectsYearFirstOrdering() {
        assertFalse(solution.validDate("2003-04-12"));
    }

    @Test
    @DisplayName("rejects date missing month component")
    void rejectsMissingMonth() {
        assertFalse(solution.validDate("04-2003"));
    }

    @Test
    @DisplayName("rejects non-digit characters in date parts")
    void rejectsNonDigitCharacters() {
        assertFalse(solution.validDate("aa-bb-cccc"));
    }

    @Test
    @DisplayName("rejects single-digit month/day form")
    void rejectsSingleDigitParts() {
        assertFalse(solution.validDate("4-12-2003"));
    }

    @Test
    @DisplayName("rejects month 0 as below valid range")
    void rejectsMonthZero() {
        assertFalse(solution.validDate("00-15-2020"));
    }

    @Test
    @DisplayName("rejects month 13 as above valid range")
    void rejectsMonthThirteen() {
        assertFalse(solution.validDate("13-10-2020"));
    }

    @Test
    @DisplayName("rejects month 15 as above valid range")
    void rejectsMonthFifteen() {
        assertFalse(solution.validDate("15-01-2012"));
    }

    @Test
    @DisplayName("rejects invalid month with invalid day")
    void rejectsInvalidMonthAndDay() {
        assertFalse(solution.validDate("21-31-2000"));
    }

    @Test
    @DisplayName("rejects day 0")
    void rejectsDayZero() {
        assertFalse(solution.validDate("04-0-2040"));
    }

    @Test
    @DisplayName("rejects day below 1 for valid month")
    void rejectsDayZeroForValidMonth() {
        assertFalse(solution.validDate("01-00-2020"));
    }

    @ParameterizedTest(name = "accepts day 31 for 31-day month: {0}")
    @ValueSource(strings = {
            "01-31-2020",
            "03-31-2020",
            "05-31-2020",
            "07-31-2020",
            "08-31-2020",
            "10-31-2020",
            "12-31-2020"
    })
    void accepts31ForLongMonths(String date) {
        assertTrue(solution.validDate(date));
    }

    @ParameterizedTest(name = "rejects day 32 for 31-day month: {0}")
    @ValueSource(strings = {
            "01-32-2020",
            "03-32-2011",
            "05-32-2020",
            "07-32-2020",
            "08-32-2020",
            "10-32-2020",
            "12-32-2020"
    })
    void rejects32ForLongMonths(String date) {
        assertFalse(solution.validDate(date));
    }

    @ParameterizedTest(name = "accepts day 30 for 30-day month: {0}")
    @ValueSource(strings = {
            "04-30-2020",
            "06-30-2020",
            "09-30-2020",
            "11-30-2020"
    })
    void accepts30For30DayMonths(String date) {
        assertTrue(solution.validDate(date));
    }

    @ParameterizedTest(name = "rejects day 31 for 30-day month: {0}")
    @ValueSource(strings = {
            "04-31-3000",
            "06-31-2020",
            "09-31-2020",
            "11-31-2020"
    })
    void rejects31For30DayMonths(String date) {
        assertFalse(solution.validDate(date));
    }

    @Test
    @DisplayName("February accepts day 29")
    void februaryAcceptsDay29() {
        assertTrue(solution.validDate("02-29-2020"));
    }

    @Test
    @DisplayName("February accepts day 1")
    void februaryAcceptsDay1() {
        assertTrue(solution.validDate("02-01-2020"));
    }

    @Test
    @DisplayName("February rejects day 30")
    void februaryRejectsDay30() {
        assertFalse(solution.validDate("02-30-2020"));
    }
}
