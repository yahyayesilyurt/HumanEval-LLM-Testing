/* @Authors
 * Student Names: Barış Karaer, Melisa Güler, Yahya Yeşilyurt
 * Student IDs: 150230742, 820210315, 150210072
 */
package humaneval.task_93;

import humaneval.gpt.task_93.Solution;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ImprovedByGptTest {

    private final Solution solution = new Solution();

    @Test
    void encodeSwapsCaseAndShiftsVowelsForSingleWords() {
        assertAll(
                () -> assertEquals("tgst", solution.encode("TEST")),
                () -> assertEquals("mWDCSKR", solution.encode("Mudasir")),
                () -> assertEquals("ygs", solution.encode("YES"))
        );
    }

    @Test
    void encodeHandlesSentencesAndPreservesSpaces() {
        assertAll(
                () -> assertEquals("tHKS KS C MGSSCGG", solution.encode("This is a message")),
                () -> assertEquals("k dQnT kNqW wHcT Tq wRkTg", solution.encode("I DoNt KnOw WhAt tO WrItE"))
        );
    }
}
