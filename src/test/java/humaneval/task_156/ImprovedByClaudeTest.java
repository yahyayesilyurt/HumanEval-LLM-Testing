package humaneval.task_156;

import humaneval.claude.task_156.Solution;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ImprovedByClaudeTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @ParameterizedTest(name = "intToMiniRoman({0}) == \"{1}\"")
    @CsvSource({
            "1, i",
            "4, iv",
            "5, v",
            "9, ix",
            "10, x",
            "19, xix",
            "40, xl",
            "43, xliii",
            "50, l",
            "90, xc",
            "94, xciv",
            "100, c",
            "152, clii",
            "251, ccli",
            "400, cd",
            "426, cdxxvi",
            "500, d",
            "532, dxxxii",
            "900, cm",
            "994, cmxciv",
            "1000, m"
    })
    void convertsNumberToLowercaseRomanNumeral(int number, String expected) {
        assertEquals(expected, solution.intToMiniRoman(number));
    }
}
