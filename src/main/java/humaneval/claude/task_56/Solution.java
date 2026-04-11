package humaneval.claude.task_56;

import java.util.*;
import java.lang.*;

public class Solution {
    /**
    brackets is a string of "<" and ">".
    return True if every opening bracket has a corresponding closing bracket.
    
    >>> correctBracketing("<")
    false
    >>> correctBracketing("<>")
    true
    >>> correctBracketing("<<><>>")
    true
    >>> correctBracketing("><<>")
    false
     */
    public boolean correctBracketing(String brackets) {
        int depth = 0;
        for (int i = 0; i < brackets.length(); i++) {
            char c = brackets.charAt(i);
            if (c == '<') {
                depth++;
            } else if (c == '>') {
                depth--;
                if (depth < 0) return false;
            }
        }
        return depth == 0;
    }
}
