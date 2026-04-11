package humaneval.claude.task_160;

import java.util.*;
import java.lang.*;

public class Solution {
    /**
    Given two lists operator, and operand. The first list has basic algebra operations, and
    the second list is a list of integers. Use the two given lists to build the algebric
    expression and return the evaluation of this expression.

    The basic algebra operations:
    Addition ( + )
    Subtraction ( - )
    Multiplication ( * )
    Floor division ( / )
    Exponentiation ( ** )

    Example:
    operator["+", "*", "-"]
    array = [2, 3, 4, 5]
    result = 2 + 3 * 4 - 5
    => result = 9

    Note:
        The length of operator list is equal to the length of operand list minus one.
        Operand is a list of of non-negative integers.
        Operator list has at least one operator, and operand list has at least two operands.
     */
    public int doAlgebra(List<String> operator, List<Integer> operand) {
    List<Integer> nums = new ArrayList<>(operand);
    List<String> ops = new ArrayList<>(operator);

    // Pass 1: exponentiation (right-to-left)
    for (int i = ops.size() - 1; i >= 0; i--) {
        if (ops.get(i).equals("**")) {
            int val = (int) Math.pow(nums.get(i), nums.get(i + 1));
            nums.set(i, val);
            nums.remove(i + 1);
            ops.remove(i);
        }
    }

    // Pass 2: multiplication and floor division (left-to-right)
    for (int i = 0; i < ops.size(); ) {
        String op = ops.get(i);
        if (op.equals("*") || op.equals("/")) {
            int val = op.equals("*")
                    ? nums.get(i) * nums.get(i + 1)
                    : Math.floorDiv(nums.get(i), nums.get(i + 1));
            nums.set(i, val);
            nums.remove(i + 1);
            ops.remove(i);
        } else {
            i++;
        }
    }

    // Pass 3: addition and subtraction (left-to-right)
    int result = nums.get(0);
    for (int i = 0; i < ops.size(); i++) {
        if (ops.get(i).equals("+")) result += nums.get(i + 1);
        else result -= nums.get(i + 1);
    }
    return result;
}
}
