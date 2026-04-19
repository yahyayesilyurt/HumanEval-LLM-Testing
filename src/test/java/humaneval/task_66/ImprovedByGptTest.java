package humaneval.task_66;

import humaneval.gpt.task_66.Solution;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ImprovedByGptTest {

    private final Solution solution = new Solution();

    @Test
    void digitSumMatchesProvidedExamples() {
        assertAll("provided examples",
                () -> assertEquals(0, solution.digitSum("")),
                () -> assertEquals(131, solution.digitSum("abAB")),
                () -> assertEquals(67, solution.digitSum("abcCd")),
                () -> assertEquals(69, solution.digitSum("helloE")),
                () -> assertEquals(131, solution.digitSum("woArBld")),
                () -> assertEquals(153, solution.digitSum("aAaaaXa"))
        );
    }

    @Test
    void digitSumHandlesSpacesAndMixedSentenceContent() {
        assertAll("mixed sentence content",
                () -> assertEquals(151, solution.digitSum(" How are yOu?")),
                () -> assertEquals(327, solution.digitSum("You arE Very Smart"))
        );
    }

    @Test
    void digitSumIgnoresNonUppercaseCharacters() {
        assertAll("ignores lowercase, digits, whitespace, and punctuation",
                () -> assertEquals(0, solution.digitSum("abcxyz")),
                () -> assertEquals(0, solution.digitSum("1234!? \t")),
                () -> assertEquals('A' + 'Z', solution.digitSum("a1!A zZ?"))
        );
    }
}
