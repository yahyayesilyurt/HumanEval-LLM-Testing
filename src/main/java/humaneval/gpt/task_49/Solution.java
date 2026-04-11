package humaneval.gpt.task_49;

import java.util.*;
import java.lang.*;

public class Solution {
    /**
    Return 2^n modulo p (be aware of numerics).
    >>> modp(3, 5)
    3
    >>> modp(1101, 101)
    2
    >>> modp(0, 101)
    1
    >>> modp(3, 11)
    8
    >>> modp(100, 101)
    1
     */
    public int modp(int n, int p) {
    long result = 1 % p;
    long base = 2 % p;

    while (n > 0) {
        if ((n & 1) == 1) {
            result = (result * base) % p;
        }
        base = (base * base) % p;
        n >>= 1;
    }

    return (int) result;
}
}
