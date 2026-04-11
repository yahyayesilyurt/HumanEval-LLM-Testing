package humaneval.gpt.task_160;

import java.util.*;
import java.lang.*;

public class Solution {
    public int doAlgebra(List<String> operator, List<Integer> operand) {
        Deque<Long> values = new ArrayDeque<>();
        Deque<String> ops = new ArrayDeque<>();

        values.push((long) operand.get(0));

        for (int i = 0; i < operator.size(); i++) {
            String curOp = operator.get(i);
            long nextValue = operand.get(i + 1);

            while (!ops.isEmpty() && shouldApplyFirst(ops.peek(), curOp)) {
                applyTop(values, ops);
            }

            ops.push(curOp);
            values.push(nextValue);
        }

        while (!ops.isEmpty()) {
            applyTop(values, ops);
        }

        return values.pop().intValue();
    }

    private boolean shouldApplyFirst(String top, String current) {
        int pTop = precedence(top);
        int pCur = precedence(current);

        if (pTop > pCur) return true;
        if (pTop < pCur) return false;

        // '**' is right-associative, others are left-associative
        return !current.equals("**");
    }

    private int precedence(String op) {
        if (op.equals("**")) return 3;
        if (op.equals("*") || op.equals("/")) return 2;
        return 1; // + or -
    }

    private void applyTop(Deque<Long> values, Deque<String> ops) {
        long b = values.pop();
        long a = values.pop();
        String op = ops.pop();

        if (op.equals("+")) values.push(a + b);
        else if (op.equals("-")) values.push(a - b);
        else if (op.equals("*")) values.push(a * b);
        else if (op.equals("/")) values.push((long) Math.floorDiv((int) a, (int) b));
        else if (op.equals("**")) values.push(pow(a, b));
    }

    private long pow(long base, long exp) {
        long result = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) result *= base;
            base *= base;
            exp >>= 1;
        }
        return result;
    }
}
