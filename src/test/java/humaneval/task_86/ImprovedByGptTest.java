package humaneval.task_86;

import humaneval.gpt.task_86.Solution;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ImprovedByGptTest {

    private final Solution solution = new Solution();

    @Test
    void sortsCharactersWithinSingleWords() {
        assertAll(
                () -> assertEquals("Hi", solution.antiShuffle("Hi")),
                () -> assertEquals("ehllo", solution.antiShuffle("hello")),
                () -> assertEquals("bemnru", solution.antiShuffle("number")),
                () -> assertEquals("abcd", solution.antiShuffle("abcd"))
        );
    }

    @Test
    void sortsEachWordIndependentlyInSentences() {
        assertAll(
                () -> assertEquals("Hello !!!Wdlor", solution.antiShuffle("Hello World!!!")),
                () -> assertEquals(
                        ".Hi My aemn is Meirst .Rboot How aer ?ouy",
                        solution.antiShuffle("Hi. My name is Mister Robot. How are you?")
                )
        );
    }

    @Test
    void preservesEmptyInputAndExactSpacing() {
        assertAll(
                () -> assertEquals("", solution.antiShuffle("")),
                () -> assertEquals("  ab  cd ", solution.antiShuffle("  ba  dc ")),
                () -> assertEquals("a  b   c", solution.antiShuffle("a  b   c"))
        );
    }
}
