package humaneval.task_100;

import humaneval.gpt.task_100.Solution;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ImprovedByGptTest {

    private final Solution solution = new Solution();

    @ParameterizedTest(name = "makeAPile({0}) should return {1}")
    @MethodSource("exampleCases")
    @DisplayName("makeAPile returns the expected pile for representative inputs")
    void makeAPile_returnsExpectedLists(int n, List<Integer> expected) {
        assertEquals(expected, solution.makeAPile(n));
    }

    private static Stream<org.junit.jupiter.params.provider.Arguments> exampleCases() {
        return Stream.of(
                org.junit.jupiter.params.provider.Arguments.of(3, List.of(3, 5, 7)),
                org.junit.jupiter.params.provider.Arguments.of(4, List.of(4, 6, 8, 10)),
                org.junit.jupiter.params.provider.Arguments.of(5, List.of(5, 7, 9, 11, 13)),
                org.junit.jupiter.params.provider.Arguments.of(6, List.of(6, 8, 10, 12, 14, 16)),
                org.junit.jupiter.params.provider.Arguments.of(8, List.of(8, 10, 12, 14, 16, 18, 20, 22))
        );
    }

    @Test
    @DisplayName("makeAPile creates exactly n levels and increases each level by 2")
    void makeAPile_followsRequiredProgression() {
        int n = 7;
        List<Integer> pile = solution.makeAPile(n);

        assertAll(
                () -> assertEquals(n, pile.size(), "The pile should contain exactly n levels"),
                () -> assertEquals(n, pile.get(0), "The first level should contain n stones"),
                () -> assertEquals(
                        IntStream.range(0, n).mapToObj(i -> n + 2 * i).toList(),
                        pile,
                        "Each next level should increase by 2 stones"
                )
        );
    }
}
