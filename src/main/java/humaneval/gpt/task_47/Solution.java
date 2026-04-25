/* @Authors
 * Student Names: Barış Karaer, Melisa Güler, Yahya Yeşilyurt
 * Student IDs: 150230742, 820210315, 150210072
 */
package humaneval.gpt.task_47;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    /**
     * Return median of elements in the list l.
     * >>> median(Arrays.asList(3, 1, 2, 4, 5))
     * 3
     * >>> median(Arrays.asList(-10, 4, 6, 1000, 10, 20))
     * 8.0
     */
    public double median(List<Integer> l) {
        if (l == null || l.isEmpty()) {
            throw new IllegalArgumentException("List must not be null or empty");
        }

        List<Integer> sorted = new ArrayList<>(l);
        Collections.sort(sorted);

        int n = sorted.size();
        if (n % 2 == 1) {
            return sorted.get(n / 2);
        }

        long left = sorted.get(n / 2 - 1);
        long right = sorted.get(n / 2);
        return (left + right) / 2.0;
    }
}
