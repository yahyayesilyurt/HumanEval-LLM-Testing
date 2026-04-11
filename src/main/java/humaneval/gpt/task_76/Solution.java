package humaneval.gpt.task_76;

import java.util.*;
import java.lang.*;

public class Solution {
    /**
    Your task is to write a function that returns true if a number x is a simple
    power of n and false in other cases.
    x is a simple power of n if n**int=x
    For example:
    isSimplePower(1, 4) => true
    isSimplePower(2, 2) => true
    isSimplePower(8, 2) => true
    isSimplePower(3, 2) => false
    isSimplePower(3, 1) => false
    isSimplePower(5, 3) => false
     */
    public boolean isSimplePower(int x, int n) {
    if (x == 1) {
        return true;
    }
    if (x <= 0 || n <= 1) {
        return false;
    }

    while (x > 1) {
        if (x % n != 0) {
            return false;
        }
        x /= n;
    }

    return true;
}
}
