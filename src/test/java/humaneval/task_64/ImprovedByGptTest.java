package humaneval.task_64;

import humaneval.gpt.task_64.Solution;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ImprovedByGptTest {

    private final Solution solution = new Solution();

    @Test
    void countsStandardVowelsCaseInsensitively() {
        assertAll(
                () -> assertEquals(2, solution.vowelsCount("abcde")),
                () -> assertEquals(3, solution.vowelsCount("Alone")),
                () -> assertEquals(3, solution.vowelsCount("AEon"))
        );
    }

    @Test
    void countsYOnlyWhenItIsTheLastCharacter() {
        assertAll(
                () -> assertEquals(2, solution.vowelsCount("key")),
                () -> assertEquals(2, solution.vowelsCount("keY")),
                () -> assertEquals(3, solution.vowelsCount("ACEDY")),
                () -> assertEquals(2, solution.vowelsCount("yellow")),
                () -> assertEquals(0, solution.vowelsCount("rhythm"))
        );
    }

    @Test
    void doesNotCountConsonantsAsVowels() {
        assertAll(
                () -> assertEquals(1, solution.vowelsCount("bye")),
                () -> assertEquals(1, solution.vowelsCount("bYe")),
                () -> assertEquals(0, solution.vowelsCount("bcdfg")),
                () -> assertEquals(0, solution.vowelsCount(""))
        );
    }
}
