package humaneval.task_156;

import humaneval.gpt.task_156.Solution;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ImprovedByGptTest {

    private final Solution solution = new Solution();

    @Test
    void convertsRepresentativeNumbersToMiniRoman() {
        assertAll(
                () -> assertMiniRoman(19, "xix"),
                () -> assertMiniRoman(152, "clii"),
                () -> assertMiniRoman(251, "ccli"),
                () -> assertMiniRoman(426, "cdxxvi"),
                () -> assertMiniRoman(500, "d"),
                () -> assertMiniRoman(532, "dxxxii")
        );
    }

    @Test
    void handlesSubtractiveNotationCorrectly() {
        assertAll(
                () -> assertMiniRoman(4, "iv"),
                () -> assertMiniRoman(43, "xliii"),
                () -> assertMiniRoman(90, "xc"),
                () -> assertMiniRoman(94, "xciv"),
                () -> assertMiniRoman(900, "cm"),
                () -> assertMiniRoman(994, "cmxciv")
        );
    }

    @Test
    void handlesLowerAndUpperBounds() {
        assertAll(
                () -> assertMiniRoman(1, "i"),
                () -> assertMiniRoman(1000, "m")
        );
    }

    @Test
    void returnsLowercaseRomanNumerals() {
        assertAll(
                () -> assertTrue(solution.intToMiniRoman(19).equals(solution.intToMiniRoman(19).toLowerCase())),
                () -> assertTrue(solution.intToMiniRoman(426).equals(solution.intToMiniRoman(426).toLowerCase())),
                () -> assertTrue(solution.intToMiniRoman(994).equals(solution.intToMiniRoman(994).toLowerCase()))
        );
    }

    private void assertMiniRoman(int number, String expected) {
        assertEquals(expected, solution.intToMiniRoman(number), "Unexpected Roman numeral for " + number);
    }
}
