package humaneval.task_27;

import humaneval.gpt.task_27.Solution;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ImprovedByGptTest {

    private final Solution solution = new Solution();

    @Test
    void flipCaseReturnsEmptyStringWhenInputIsEmpty() {
        assertEquals("", solution.flipCase(""));
    }

    @Test
    void flipCaseFlipsLetterCaseAndPreservesNonAlphabeticCharacters() {
        assertAll(
                () -> assertEquals("hELLO!", solution.flipCase("Hello!")),
                () -> assertEquals("a1B2-c3", solution.flipCase("A1b2-C3"))
        );
    }

    @Test
    void flipCaseFlipsEveryLetterInASentence() {
        assertEquals(
                "tHESE VIOLENT DELIGHTS HAVE VIOLENT ENDS",
                solution.flipCase("These violent delights have violent ends")
        );
    }
}
