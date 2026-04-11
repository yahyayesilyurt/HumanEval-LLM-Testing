package humaneval.gpt.task_81;

import java.util.*;
import java.lang.*;

public class Solution {
    public List<String> numericalLetterGrade(List<Double> grades) {
        List<String> result = new ArrayList<>();

        for (double g : grades) {
            if (g == 4.0) result.add("A+");
            else if (g > 3.7) result.add("A");
            else if (g > 3.3) result.add("A-");
            else if (g > 3.0) result.add("B+");
            else if (g > 2.7) result.add("B");
            else if (g > 2.3) result.add("B-");
            else if (g > 2.0) result.add("C+");
            else if (g > 1.7) result.add("C");
            else if (g > 1.3) result.add("C-");
            else if (g > 1.0) result.add("D+");
            else if (g > 0.7) result.add("D");
            else if (g > 0.0) result.add("D-");
            else result.add("E");
        }

        return result;
    }
}
