package humaneval.gpt.task_124;

import java.util.*;
import java.lang.*;

public class Solution {
    public boolean validDate(String date) {
        if (date == null || date.isEmpty()) {
            return false;
        }

        if (!date.matches("\\d{2}-\\d{2}-\\d{4}")) {
            return false;
        }

        String[] parts = date.split("-");
        int month = Integer.parseInt(parts[0]);
        int day = Integer.parseInt(parts[1]);

        if (month < 1 || month > 12) {
            return false;
        }

        int[] daysInMonth = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        return day >= 1 && day <= daysInMonth[month - 1];
    }
}
