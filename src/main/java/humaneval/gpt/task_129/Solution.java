package humaneval.gpt.task_129;

import java.util.*;
import java.lang.*;

public class Solution {
    public List<Integer> minPath(List<List<Integer>> grid, int k) {
        int n = grid.size();
        int r = -1, c = -1;

        // Find the cell containing 1.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    r = i;
                    c = j;
                    break;
                }
            }
            if (r != -1) break;
        }

        List<Integer> ans = new ArrayList<>(k);
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int step = 0; step < k; step++) {
            ans.add(grid.get(r).get(c));
            if (step == k - 1) break;

            int bestR = -1, bestC = -1;
            int bestVal = Integer.MAX_VALUE;

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                    int val = grid.get(nr).get(nc);
                    if (val < bestVal) {
                        bestVal = val;
                        bestR = nr;
                        bestC = nc;
                    }
                }
            }

            r = bestR;
            c = bestC;
        }

        return ans;
    }
}
