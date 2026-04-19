package humaneval.task_16;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ImprovedByGptTest {

    private final humaneval.gpt.task_16.Solution solution = new humaneval.gpt.task_16.Solution();

    @Test
    void returnsZeroForEmptyString() {
        assertEquals(0, solution.countDistinctCharacters(""));
    }

    @Test
    void countsEachUniqueLowercaseCharacterOnce() {
        assertEquals(5, solution.countDistinctCharacters("abcde"));
    }

    @Test
    void ignoresCaseWhenCountingDistinctLetters() {
        assertEquals(5, solution.countDistinctCharacters("abcdecadeCADE"));
    }

    @Test
    void countsRepeatedSameLetterAcrossCasesOnlyOnce() {
        assertEquals(1, solution.countDistinctCharacters("aaaaAAAAaaaa"));
    }

    @Test
    void treatsWhitespaceAsADistinctCharacter() {
        assertEquals(5, solution.countDistinctCharacters("Jerry jERRY JeRRRY"));
    }

    @Test
    void matchesExamplesFromProblemStatement() {
        assertEquals(3, solution.countDistinctCharacters("xyzXYZ"));
        assertEquals(4, solution.countDistinctCharacters("Jerry"));
    }
}
