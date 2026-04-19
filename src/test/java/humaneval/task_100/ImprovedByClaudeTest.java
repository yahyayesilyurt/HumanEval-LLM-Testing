package humaneval.task_100;

import humaneval.claude.task_100.Solution;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ImprovedByClaudeTest {

    @Test
    void makeAPile_oddStart_returnsOddProgression() {
        Solution s = new Solution();
        assertEquals(Arrays.asList(3, 5, 7), s.makeAPile(3));
    }

    @Test
    void makeAPile_evenStart_returnsEvenProgression() {
        Solution s = new Solution();
        assertEquals(Arrays.asList(4, 6, 8, 10), s.makeAPile(4));
    }

    @Test
    void makeAPile_oddFive_returnsFiveLevels() {
        Solution s = new Solution();
        assertEquals(Arrays.asList(5, 7, 9, 11, 13), s.makeAPile(5));
    }

    @Test
    void makeAPile_evenSix_returnsSixLevels() {
        Solution s = new Solution();
        assertEquals(Arrays.asList(6, 8, 10, 12, 14, 16), s.makeAPile(6));
    }

    @Test
    void makeAPile_evenEight_returnsEightLevels() {
        Solution s = new Solution();
        assertEquals(Arrays.asList(8, 10, 12, 14, 16, 18, 20, 22), s.makeAPile(8));
    }

    @Test
    void makeAPile_one_returnsSingleLevel() {
        Solution s = new Solution();
        assertEquals(Collections.singletonList(1), s.makeAPile(1));
    }

    @Test
    void makeAPile_two_returnsTwoLevels() {
        Solution s = new Solution();
        assertEquals(Arrays.asList(2, 4), s.makeAPile(2));
    }

    @Test
    void makeAPile_resultSizeMatchesInput() {
        Solution s = new Solution();
        assertEquals(10, s.makeAPile(10).size());
    }
}
