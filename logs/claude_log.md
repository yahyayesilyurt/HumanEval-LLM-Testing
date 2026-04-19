# Claude Code — Interaction Log

One section per LLM call, appended in order. Each entry contains the prompt sent and the response received, plus metadata.

---

## Java/23 — codegen, iteration 1

- **Task ID:** `Java/23`
- **Model:** Claude Opus 4.6 (1M context)
- **Timestamp:** 2026-04-11T16:07:38+03:00
- **Elapsed:** 8.16s

### Prompt

````
import java.util.*;
import java.lang.*;

class Solution {
    /**
    Return length of given string
    >>> strlen("")
    0
    >>> strlen("abc")
    3
     */
    public int strlen(String string) {

````

### Response

````
```java
        return string.length();
    }
}
```

````

---

## Java/14 — codegen, iteration 1

- **Task ID:** `Java/14`
- **Model:** Claude Opus 4.6 (1M context)
- **Timestamp:** 2026-04-11T16:09:12+03:00
- **Elapsed:** 8.95s

### Prompt

````
import java.util.*;
import java.lang.*;

class Solution {
    /**
    Return list of all prefixes from shortest to longest of the input string
    >>> allPrefixes("abc")
    ["a", "ab", "abc"]
     */
    public List<String> allPrefixes(String string) {

````

### Response

````
```java
import java.util.*;
import java.lang.*;

class Solution {
    /**
    Return list of all prefixes from shortest to longest of the input string
    >>> allPrefixes("abc")
    ["a", "ab", "abc"]
     */
    public List<String> allPrefixes(String string) {
        List<String> prefixes = new ArrayList<>();
        for (int i = 1; i <= string.length(); i++) {
            prefixes.add(string.substring(0, i));
        }
        return prefixes;
    }
}
```

````

---

## Java/16 — codegen, iteration 1

- **Task ID:** `Java/16`
- **Model:** Claude Opus 4.6 (1M context)
- **Timestamp:** 2026-04-11T16:09:20+03:00
- **Elapsed:** 8.27s

### Prompt

````
import java.util.*;
import java.lang.*;

class Solution {
    /**
    Given a string, find out how many distinct characters (regardless of case) does it consist of
    >>> countDistinctCharacters("xyzXYZ")
    3
    >>> countDistinctCharacters("Jerry")
    4
     */
    public int countDistinctCharacters(String string) {

````

### Response

````
```java
    public int countDistinctCharacters(String string) {
        Set<Character> distinct = new HashSet<>();
        for (char c : string.toLowerCase().toCharArray()) {
            distinct.add(c);
        }
        return distinct.size();
    }
}
```

````

---

## Java/26 — codegen, iteration 1

- **Task ID:** `Java/26`
- **Model:** Claude Opus 4.6 (1M context)
- **Timestamp:** 2026-04-11T16:09:30+03:00
- **Elapsed:** 9.78s

### Prompt

````
import java.util.*;
import java.lang.*;
import java.util.stream.Collectors;

class Solution {
    /**
    From a list of integers, remove all elements that occur more than once.
    Keep order of elements left the same as in the input.
    >>> removeDuplicates(Array.asList(1, 2, 3, 2, 4))
    [1, 3, 4]
     */
    public List<Integer> removeDuplicates(List<Integer> numbers) {

````

### Response

````
```java
import java.util.*;
import java.lang.*;
import java.util.stream.Collectors;

class Solution {
    /**
    From a list of integers, remove all elements that occur more than once.
    Keep order of elements left the same as in the input.
    >>> removeDuplicates(Array.asList(1, 2, 3, 2, 4))
    [1, 3, 4]
     */
    public List<Integer> removeDuplicates(List<Integer> numbers) {
        Map<Integer, Long> counts = numbers.stream()
            .collect(Collectors.groupingBy(n -> n, Collectors.counting()));
        return numbers.stream()
            .filter(n -> counts.get(n) == 1)
            .collect(Collectors.toList());
    }
}
```

Counts occurrences in one pass, then keeps only elements appearing exactly once while preserving original order.

````

---

## Java/49 — codegen, iteration 1

- **Task ID:** `Java/49`
- **Model:** Claude Opus 4.6 (1M context)
- **Timestamp:** 2026-04-11T16:09:40+03:00
- **Elapsed:** 9.70s

### Prompt

````
import java.util.*;
import java.lang.*;

class Solution {
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

````

### Response

````
```java
    public int modp(int n, int p) {
        int result = 1 % p;
        for (int i = 0; i < n; i++) {
            result = (result * 2) % p;
        }
        return result;
    }
}
```

Uses modular exponentiation by repeated doubling — keeps the intermediate value bounded by `p` to avoid overflow. `1 % p` handles the edge case where `p == 1`.

````

---

## Java/57 — codegen, iteration 1

- **Task ID:** `Java/57`
- **Model:** Claude Opus 4.6 (1M context)
- **Timestamp:** 2026-04-11T16:09:51+03:00
- **Elapsed:** 10.59s

### Prompt

````
import java.util.*;
import java.lang.*;

class Solution {
    /**
    Return True is list elements are monotonically increasing or decreasing.
    >>> monotonic(Arrays.asList(1, 2, 4, 20))
    true
    >>> monotonic(Arrays.asList(1, 20, 4, 10))
    false
    >>> monotonic(Arrays.asList(4, 1, 0, -10))
    true
     */
    public boolean monotonic(List<Integer> l) {

````

### Response

````
```java
import java.util.*;
import java.lang.*;

class Solution {
    /**
    Return True is list elements are monotonically increasing or decreasing.
    >>> monotonic(Arrays.asList(1, 2, 4, 20))
    true
    >>> monotonic(Arrays.asList(1, 20, 4, 10))
    false
    >>> monotonic(Arrays.asList(4, 1, 0, -10))
    true
     */
    public boolean monotonic(List<Integer> l) {
        if (l.size() <= 1) {
            return true;
        }
        boolean increasing = true;
        boolean decreasing = true;
        for (int i = 1; i < l.size(); i++) {
            if (l.get(i) > l.get(i - 1)) {
                decreasing = false;
            } else if (l.get(i) < l.get(i - 1)) {
                increasing = false;
            }
        }
        return increasing || decreasing;
    }
}
```

Iterates once, tracking whether the sequence could still be non-decreasing or non-increasing. Returns true if either holds (also handles equal consecutive elements and lists of size ≤ 1).

````

---

## Java/100 — codegen, iteration 1

- **Task ID:** `Java/100`
- **Model:** Claude Opus 4.6 (1M context)
- **Timestamp:** 2026-04-11T16:10:04+03:00
- **Elapsed:** 13.91s

### Prompt

````
import java.util.*;
import java.lang.*;

class Solution {
    /**
    Given a positive integer n, you have to make a pile of n levels of stones.
    The first level has n stones.
    The number of stones in the next level is:
        - the next odd number if n is odd.
        - the next even number if n is even.
    Return the number of stones in each level in a list, where element at index
    i represents the number of stones in the level (i+1).

    Examples:
    >>> makeAPile(3)
    [3, 5, 7]
     */
    public List<Integer> makeAPile(int n) {

````

### Response

````
```java
public List<Integer> makeAPile(int n) {
    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < n; i++) {
        result.add(n + 2 * i);
    }
    return result;
}
```

Each level adds 2 stones to the previous, preserving parity. Starting at `n` and incrementing by 2 gives the next odd (if `n` odd) or next even (if `n` even) at each level.

````

---

## Java/120 — codegen, iteration 1

- **Task ID:** `Java/120`
- **Model:** Claude Opus 4.6 (1M context)
- **Timestamp:** 2026-04-11T16:10:14+03:00
- **Elapsed:** 9.77s

### Prompt

````
import java.util.*;
import java.lang.*;

class Solution {
    /**
    Given an array arr of integers and a positive integer k, return a sorted list
    of length k with the maximum k numbers in arr.

    Example 1:

        Input: arr = [-3, -4, 5], k = 3
        Output: [-4, -3, 5]

    Example 2:

        Input: arr = [4, -4, 4], k = 2
        Output: [4, 4]

    Example 3:

        Input: arr = [-3, 2, 1, 2, -1, -2, 1], k = 1
        Output: [2]

    Note:
        1. The length of the array will be in the range of [1, 1000].
        2. The elements in the array will be in the range of [-1000, 1000].
        3. 0 <= k <= len(arr)
     */
    public List<Integer> maximum(List<Integer> arr, int k) {

````

### Response

````
```java
    public List<Integer> maximum(List<Integer> arr, int k) {
        if (k == 0) {
            return new ArrayList<>();
        }
        List<Integer> sorted = new ArrayList<>(arr);
        Collections.sort(sorted);
        return new ArrayList<>(sorted.subList(sorted.size() - k, sorted.size()));
    }
}
```

Sort ascending, then take the last `k` elements — they're already in sorted order as required. Handles `k == 0` explicitly since `subList` would otherwise still work but this is clearer.

````

---

## Java/3 — codegen, iteration 1

- **Task ID:** `Java/3`
- **Model:** Claude Opus 4.6 (1M context)
- **Timestamp:** 2026-04-11T16:10:24+03:00
- **Elapsed:** 9.55s

### Prompt

````
import java.util.*;
import java.lang.*;

class Solution {
    /**
    You're given a list of deposit and withdrawal operations on a bank account that starts with
    zero balance. Your task is to detect if at any point the balance of account fallls below zero, and
    at that point function should return True. Otherwise it should return False.
    >>> belowZero(Arrays.asList(1, 2, 3))
    false
    >>> belowZero(Arrays.asList(1, 2, -4, 5))
    true
     */
    public boolean belowZero(List<Integer> operations) {

````

### Response

````
```java
import java.util.*;
import java.lang.*;

class Solution {
    /**
    You're given a list of deposit and withdrawal operations on a bank account that starts with
    zero balance. Your task is to detect if at any point the balance of account fallls below zero, and
    at that point function should return True. Otherwise it should return False.
    >>> belowZero(Arrays.asList(1, 2, 3))
    false
    >>> belowZero(Arrays.asList(1, 2, -4, 5))
    true
     */
    public boolean belowZero(List<Integer> operations) {
        int balance = 0;
        for (int op : operations) {
            balance += op;
            if (balance < 0) {
                return true;
            }
        }
        return false;
    }
}
```

````

---

## Java/4 — codegen, iteration 1

- **Task ID:** `Java/4`
- **Model:** Claude Opus 4.6 (1M context)
- **Timestamp:** 2026-04-11T16:10:34+03:00
- **Elapsed:** 10.59s

### Prompt

````
import java.util.*;
import java.lang.*;

class Solution {
    /**
    For a given list of input numbers, calculate Mean Absolute Deviation
    around the mean of this dataset.
    Mean Absolute Deviation is the average absolute difference between each
    element and a centerpoint (mean in this case):
    MAD = average | x - x_mean |
    >>> meanAbsoluteDeviation(Arrays.asList(1.0, 2.0, 3.0, 4.0))
    1.0
     */
    public double meanAbsoluteDeviation(List<Double> numbers) {

````

### Response

````
```java
public double meanAbsoluteDeviation(List<Double> numbers) {
    double mean = 0.0;
    for (double n : numbers) {
        mean += n;
    }
    mean /= numbers.size();

    double sum = 0.0;
    for (double n : numbers) {
        sum += Math.abs(n - mean);
    }
    return sum / numbers.size();
}
```

````

---

## Java/18 — codegen, iteration 1

- **Task ID:** `Java/18`
- **Model:** Claude Opus 4.6 (1M context)
- **Timestamp:** 2026-04-11T16:10:42+03:00
- **Elapsed:** 8.12s

### Prompt

````
import java.util.*;
import java.lang.*;

class Solution {
    /**
    Find how many times a given substring can be found in the original string. Count overlaping cases.
    >>> howManyTimes("", "a")
    0
    >>> howManyTimes("aaa", "a")
    3
    >>> howManyTimes("aaaa", "aa")
    3
     */
    public int howManyTimes(String string, String substring) {

````

### Response

````
```java
    public int howManyTimes(String string, String substring) {
        if (substring.isEmpty()) return 0;
        int count = 0;
        for (int i = 0; i <= string.length() - substring.length(); i++) {
            if (string.startsWith(substring, i)) count++;
        }
        return count;
    }
}
```

````

---

## Java/47 — codegen, iteration 1

- **Task ID:** `Java/47`
- **Model:** Claude Opus 4.6 (1M context)
- **Timestamp:** 2026-04-11T16:10:52+03:00
- **Elapsed:** 9.96s

### Prompt

````
import java.util.*;
import java.lang.*;

class Solution {
    /**
    Return median of elements in the list l.
    >>> median(Arrays.asList(3, 1, 2, 4, 5))
    3
    >>> median(Arrays.asList(-10, 4, 6, 1000, 10, 20))
    15.0
     */
    public double median(List<Integer> l) {

````

### Response

````
```java
import java.util.*;
import java.lang.*;

class Solution {
    /**
    Return median of elements in the list l.
    >>> median(Arrays.asList(3, 1, 2, 4, 5))
    3
    >>> median(Arrays.asList(-10, 4, 6, 1000, 10, 20))
    15.0
     */
    public double median(List<Integer> l) {
        List<Integer> sorted = new ArrayList<>(l);
        Collections.sort(sorted);
        int n = sorted.size();
        if (n % 2 == 1) {
            return sorted.get(n / 2);
        } else {
            return (sorted.get(n / 2 - 1) + sorted.get(n / 2)) / 2.0;
        }
    }
}
```

Sorts a copy of the list so the input isn't mutated, then returns the middle element for odd sizes or the average of the two middle elements for even sizes.

````

---

## Java/66 — codegen, iteration 1

- **Task ID:** `Java/66`
- **Model:** Claude Opus 4.6 (1M context)
- **Timestamp:** 2026-04-11T16:11:02+03:00
- **Elapsed:** 9.30s

### Prompt

````
import java.util.*;
import java.lang.*;

class Solution {
    /**
    Write a function that takes a string as input and returns the sum of the upper characters only'
    ASCII codes.

    Examples:
        digitSum("") => 0
        digitSum("abAB") => 131
        digitSum("abcCd") => 67
        digitSum("helloE") => 69
        digitSum("woArBld") => 131
        digitSum("aAaaaXa") => 153
     */
    public int digitSum(String s) {

````

### Response

````
```java
    public int digitSum(String s) {
        int sum = 0;
        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) {
                sum += (int) c;
            }
        }
        return sum;
    }
}
```

````

---

## Java/76 — codegen, iteration 1

- **Task ID:** `Java/76`
- **Model:** Claude Opus 4.6 (1M context)
- **Timestamp:** 2026-04-11T16:11:17+03:00
- **Elapsed:** 15.53s

### Prompt

````
import java.util.*;
import java.lang.*;

class Solution {
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

````

### Response

````
```java
public boolean isSimplePower(int x, int n) {
    if (x == 1) return true;
    if (n == 1) return false;
    int power = 1;
    while (power < x) {
        power *= n;
    }
    return power == x;
}
```

**Logic:**
- `x == 1` → true (any `n^0 = 1`)
- `n == 1` → false (since `x != 1` at this point, and `1^k` is always 1)
- Otherwise, multiply by `n` until reaching or exceeding `x`, then check equality

````

---

## Java/86 — codegen, iteration 1

- **Task ID:** `Java/86`
- **Model:** Claude Opus 4.6 (1M context)
- **Timestamp:** 2026-04-11T16:11:26+03:00
- **Elapsed:** 9.22s

### Prompt

````
import java.util.*;
import java.lang.*;

class Solution {
    /**
    Write a function that takes a string and returns an ordered version of it.
    Ordered version of string, is a string where all words (separated by space)
    are replaced by a new word where all the characters arranged in
    ascending order based on ascii value.
    Note: You should keep the order of words and blank spaces in the sentence.

    For example:
    antiShuffle("Hi") returns "Hi"
    antiShuffle("hello") returns "ehllo"
    antiShuffle("Hello World!!!") returns "Hello !!!Wdlor"
     */
    public String antiShuffle(String s) {

````

### Response

````
```java
    public String antiShuffle(String s) {
        String[] words = s.split(" ", -1);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            char[] chars = words[i].toCharArray();
            Arrays.sort(chars);
            result.append(chars);
            if (i < words.length - 1) result.append(" ");
        }
        return result.toString();
    }
```

Splits on single spaces (preserving empty tokens so consecutive spaces are kept), sorts each word's characters by ASCII, and rejoins with spaces.

````

---

## Java/0 — codegen, iteration 1

- **Task ID:** `Java/0`
- **Model:** Claude Opus 4.6 (1M context)
- **Timestamp:** 2026-04-11T16:11:40+03:00
- **Elapsed:** 13.46s

### Prompt

````
import java.util.*;
import java.lang.*;

class Solution {
    /**
    Check if in given list of numbers, are any two numbers closer to each other than given threshold.
    >>> hasCloseElements(Arrays.asList(1.0, 2.0, 3.0), 0.5)
    false
    >>> hasCloseElements(Arrays.asList(1.0, 2.8, 3.0, 4.0, 5.0, 2.0), 0.3)
    true
     */
    public boolean hasCloseElements(List<Double> numbers, double threshold) {

````

### Response

````
```java
import java.util.*;
import java.lang.*;

class Solution {
    /**
    Check if in given list of numbers, are any two numbers closer to each other than given threshold.
    >>> hasCloseElements(Arrays.asList(1.0, 2.0, 3.0), 0.5)
    false
    >>> hasCloseElements(Arrays.asList(1.0, 2.8, 3.0, 4.0, 5.0, 2.0), 0.3)
    true
     */
    public boolean hasCloseElements(List<Double> numbers, double threshold) {
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = i + 1; j < numbers.size(); j++) {
                if (Math.abs(numbers.get(i) - numbers.get(j)) < threshold) {
                    return true;
                }
            }
        }
        return false;
    }
}
```

Compares every pair once (O(n²)); returns `true` as soon as any pair's absolute difference is below `threshold`, otherwise `false`.

````

---

## Java/9 — codegen, iteration 1

- **Task ID:** `Java/9`
- **Model:** Claude Opus 4.6 (1M context)
- **Timestamp:** 2026-04-11T16:11:53+03:00
- **Elapsed:** 13.02s

### Prompt

````
import java.util.*;
import java.lang.*;

class Solution {
    /**
    From a given list of integers, generate a list of rolling maximum element found until given moment
    in the sequence.
    >>> rollingMax(Arrays.asList(1, 2, 3, 2, 3, 4, 2))
    [1, 2, 3, 3, 3, 4, 4]
     */
    public List<Integer> rollingMax(List<Integer> numbers) {

````

### Response

````
```java
import java.util.*;
import java.lang.*;

class Solution {
    /**
    From a given list of integers, generate a list of rolling maximum element found until given moment
    in the sequence.
    >>> rollingMax(Arrays.asList(1, 2, 3, 2, 3, 4, 2))
    [1, 2, 3, 3, 3, 4, 4]
     */
    public List<Integer> rollingMax(List<Integer> numbers) {
        List<Integer> result = new ArrayList<>();
        int currentMax = Integer.MIN_VALUE;
        for (int n : numbers) {
            if (n > currentMax) {
                currentMax = n;
            }
            result.add(currentMax);
        }
        return result;
    }
}
```

Iterates once through the list, tracking the running max and appending it at each step. O(n) time, O(n) output.

````

---

## Java/27 — codegen, iteration 1

- **Task ID:** `Java/27`
- **Model:** Claude Opus 4.6 (1M context)
- **Timestamp:** 2026-04-11T16:12:01+03:00
- **Elapsed:** 8.15s

### Prompt

````
import java.util.*;
import java.lang.*;

class Solution {
    /**
    For a given string, flip lowercase characters to uppercase and uppercase to lowercase.
    >>> flipCase("Hello")
    "hELLO"
     */
    public String flipCase(String string) {

````

### Response

````
```java
        StringBuilder result = new StringBuilder();
        for (char c : string.toCharArray()) {
            if (Character.isUpperCase(c)) {
                result.append(Character.toLowerCase(c));
            } else if (Character.isLowerCase(c)) {
                result.append(Character.toUpperCase(c));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}
```

````

---

## Java/31 — codegen, iteration 1

- **Task ID:** `Java/31`
- **Model:** Claude Opus 4.6 (1M context)
- **Timestamp:** 2026-04-11T16:12:09+03:00
- **Elapsed:** 8.33s

### Prompt

````
import java.util.*;
import java.lang.*;

class Solution {
    /**
    Return true if a given number is prime, and false otherwise.
    >>> isPrime(6)
    false
    >>> isPrime(101)
    true
    >>> isPrime(11)
    true
    >>> isPrime(13441)
    true
    >>> isPrime(61)
    true
    >>> isPrime(4)
    false
    >>> isPrime(1)
    false
     */
    public boolean isPrime(int n) {

````

### Response

````
```java
import java.util.*;
import java.lang.*;

class Solution {
    /**
    Return true if a given number is prime, and false otherwise.
    >>> isPrime(6)
    false
    >>> isPrime(101)
    true
    >>> isPrime(11)
    true
    >>> isPrime(13441)
    true
    >>> isPrime(61)
    true
    >>> isPrime(4)
    false
    >>> isPrime(1)
    false
     */
    public boolean isPrime(int n) {
        if (n < 2) return false;
        if (n < 4) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; (long) i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
```

````

---

## Java/56 — codegen, iteration 1

- **Task ID:** `Java/56`
- **Model:** Claude Opus 4.6 (1M context)
- **Timestamp:** 2026-04-11T16:12:22+03:00
- **Elapsed:** 12.04s

### Prompt

````
import java.util.*;
import java.lang.*;

class Solution {
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

````

### Response

````
```java
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
```

Track nesting depth: increment on `<`, decrement on `>`. If depth ever goes negative, a `>` appeared without a matching `<`. At the end, depth must be zero for all opens to be closed.

````

---

## Java/64 — codegen, iteration 1

- **Task ID:** `Java/64`
- **Model:** Claude Opus 4.6 (1M context)
- **Timestamp:** 2026-04-11T16:12:30+03:00
- **Elapsed:** 8.87s

### Prompt

````
import java.util.*;
import java.lang.*;

class Solution {
    /**
    Write a function vowelsCount which takes a string representing
    a word as input and returns the number of vowels in the string.
    Vowels in this case are 'a', 'e', 'i', 'o', 'u'. Here, 'y' is also a
    vowel, but only when it is at the end of the given word.

    Example:
    >>> vowelsCount("abcde")
    2
    >>> vowelsCount("ACEDY")
    3
     */
    public int vowelsCount(String s) {

````

### Response

````
```java
public int vowelsCount(String s) {
    int count = 0;
    String vowels = "aeiouAEIOU";
    for (int i = 0; i < s.length(); i++) {
        if (vowels.indexOf(s.charAt(i)) != -1) {
            count++;
        }
    }
    char last = s.charAt(s.length() - 1);
    if (last == 'y' || last == 'Y') {
        count++;
    }
    return count;
}
```

````

---

## Java/87 — codegen, iteration 1

- **Task ID:** `Java/87`
- **Model:** Claude Opus 4.6 (1M context)
- **Timestamp:** 2026-04-11T16:12:43+03:00
- **Elapsed:** 12.65s

### Prompt

````
import java.util.*;
import java.lang.*;

class Solution {
    /**
    You are given a 2 dimensional data, as a nested lists,
    which is similar to matrix, however, unlike matrices,
    each row may contain a different number of columns.
    Given lst, and integer x, find integers x in the list,
    and return list of lists, [[x1, y1], [x2, y2] ...] such that
    each list is a coordinate - (row, columns), starting with 0.
    Sort coordinates initially by rows in ascending order.
    Also, sort coordinates of the row by columns in descending order.

    Examples:
    getRow([
      [1,2,3,4,5,6],
      [1,2,3,4,1,6],
      [1,2,3,4,5,1]
    ], 1) == [[0, 0], [1, 4], [1, 0], [2, 5], [2, 0]]
    getRow([], 1) == []
    getRow([[], [1], [1, 2, 3]], 3) == [[2, 2]]
     */
    public List<List<Integer>> getRow(List<List<Integer>> lst, int x) {

````

### Response

````
```java
public List<List<Integer>> getRow(List<List<Integer>> lst, int x) {
    List<List<Integer>> result = new ArrayList<>();
    for (int i = 0; i < lst.size(); i++) {
        List<Integer> row = lst.get(i);
        for (int j = row.size() - 1; j >= 0; j--) {
            if (row.get(j) == x) {
                result.add(Arrays.asList(i, j));
            }
        }
    }
    return result;
}
```

Walk through:
- Outer loop iterates rows in ascending order (0 → n).
- Inner loop iterates columns in **descending** order, so matches within a row are already added largest-column-first.
- Combined, the list is sorted by row ascending, then column descending — no explicit sort needed.

Verification against the examples:
- Row 0: `[1,2,3,4,5,6]` → j=0 matches → `[0,0]`
- Row 1: `[1,2,3,4,1,6]` → j=4, then j=0 → `[1,4], [1,0]`
- Row 2: `[1,2,3,4,5,1]` → j=5, then j=0 → `[2,5], [2,0]`

Final: `[[0,0],[1,4],[1,0],[2,5],[2,0]]` ✓

````

---

## Java/156 — codegen, iteration 1

- **Task ID:** `Java/156`
- **Model:** Claude Opus 4.6 (1M context)
- **Timestamp:** 2026-04-11T16:12:55+03:00
- **Elapsed:** 12.16s

### Prompt

````
import java.util.*;
import java.lang.*;

class Solution {
    /**
    Given a positive integer, obtain its roman numeral equivalent as a string,
    and return it in lowercase.
    Restrictions: 1 <= num <= 1000

    Examples:
    >>> intToMiniRoman(19) == "xix"
    >>> intToMiniRoman(152) == "clii"
    >>> intToMiniRoman(426) == "cdxxvi"
     */
    public String intToMiniRoman(int number) {

````

### Response

````
```java
public String intToMiniRoman(int number) {
    int[] values =    {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] symbols = {"m", "cm", "d", "cd", "c", "xc", "l", "xl", "x", "ix", "v", "iv", "i"};
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < values.length; i++) {
        while (number >= values[i]) {
            number -= values[i];
            sb.append(symbols[i]);
        }
    }
    return sb.toString();
}
```

Greedy subtraction over value/symbol pairs (including subtractive forms `cm`, `cd`, `xc`, `xl`, `ix`, `iv`). Symbols are already lowercase, so no post-processing needed.

Verification against the examples:
- `19` → `x` + `ix` = `xix` ✓
- `152` → `c` + `l` + `i` + `i` = `clii` ✓
- `426` → `cd` + `x` + `x` + `v` + `i` = `cdxxvi` ✓

````

---

## Java/13 — codegen, iteration 1

- **Task ID:** `Java/13`
- **Model:** Claude Opus 4.6 (1M context)
- **Timestamp:** 2026-04-11T16:13:05+03:00
- **Elapsed:** 10.03s

### Prompt

````
import java.util.*;
import java.lang.*;

class Solution {
    /**
    Return a greatest common divisor of two integers a and b
    >>> greatestCommonDivisor(3, 5)
    1
    >>> greatestCommonDivisor(25, 15)
    5
     */
    public int greatestCommonDivisor(int a, int b) {

````

### Response

````
```java
import java.util.*;
import java.lang.*;

class Solution {
    /**
    Return a greatest common divisor of two integers a and b
    >>> greatestCommonDivisor(3, 5)
    1
    >>> greatestCommonDivisor(25, 15)
    5
     */
    public int greatestCommonDivisor(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
```

Uses the Euclidean algorithm: repeatedly replace `(a, b)` with `(b, a mod b)` until `b` becomes 0, at which point `a` holds the GCD.

````

---

## Java/19 — codegen, iteration 1

- **Task ID:** `Java/19`
- **Model:** Claude Opus 4.6 (1M context)
- **Timestamp:** 2026-04-11T16:13:17+03:00
- **Elapsed:** 11.42s

### Prompt

````
import java.util.*;
import java.lang.*;

class Solution {
    /**
    Input is a space-delimited string of numberals from 'zero' to 'nine'.
    Valid choices are 'zero', 'one', 'two', 'three', 'four', 'five', 'six', 'seven', 'eight' and 'nine'.
    Return the string with numbers sorted from smallest to largest
    >>> sortNumbers("three one five")
    "one three five"
     */
    public String sortNumbers(String numbers) {

````

### Response

````
```java
import java.util.*;
import java.lang.*;

class Solution {
    /**
    Input is a space-delimited string of numberals from 'zero' to 'nine'.
    Valid choices are 'zero', 'one', 'two', 'three', 'four', 'five', 'six', 'seven', 'eight' and 'nine'.
    Return the string with numbers sorted from smallest to largest
    >>> sortNumbers("three one five")
    "one three five"
     */
    public String sortNumbers(String numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return "";
        }
        Map<String, Integer> wordToNum = Map.of(
            "zero", 0, "one", 1, "two", 2, "three", 3, "four", 4,
            "five", 5, "six", 6, "seven", 7, "eight", 8, "nine", 9
        );
        String[] parts = numbers.split(" ");
        Arrays.sort(parts, Comparator.comparingInt(wordToNum::get));
        return String.join(" ", parts);
    }
}
```

````

---

## Java/81 — codegen, iteration 1

- **Task ID:** `Java/81`
- **Model:** Claude Opus 4.6 (1M context)
- **Timestamp:** 2026-04-11T16:13:32+03:00
- **Elapsed:** 15.39s

### Prompt

````
import java.util.*;
import java.lang.*;

class Solution {
    /**
    It is the last week of the semester and the teacher has to give the grades
    to students. The teacher has been making her own algorithm for grading.
    The only problem is, she has lost the code she used for grading.
    She has given you a list of GPAs for some students and you have to write
    a function that can output a list of letter grades using the following table:
             GPA       |    Letter grade
              4.0                A+
            > 3.7                A
            > 3.3                A-
            > 3.0                B+
            > 2.7                B
            > 2.3                B-
            > 2.0                C+
            > 1.7                C
            > 1.3                C-
            > 1.0                D+
            > 0.7                D
            > 0.0                D-
              0.0                E


    Example:
    numericalLetterGrade(Arrays.asList(4.0, 3, 1.7, 2, 3.5)) ==> ["A+", "B", "C-", "C", "A-"]
     */
    public List<String> numericalLetterGrade(List<Double> grades) {

````

### Response

````
```java
public List<String> numericalLetterGrade(List<Double> grades) {
    List<String> letterGrades = new ArrayList<>();
    for (Double gpa : grades) {
        if (gpa == 4.0) {
            letterGrades.add("A+");
        } else if (gpa > 3.7) {
            letterGrades.add("A");
        } else if (gpa > 3.3) {
            letterGrades.add("A-");
        } else if (gpa > 3.0) {
            letterGrades.add("B+");
        } else if (gpa > 2.7) {
            letterGrades.add("B");
        } else if (gpa > 2.3) {
            letterGrades.add("B-");
        } else if (gpa > 2.0) {
            letterGrades.add("C+");
        } else if (gpa > 1.7) {
            letterGrades.add("C");
        } else if (gpa > 1.3) {
            letterGrades.add("C-");
        } else if (gpa > 1.0) {
            letterGrades.add("D+");
        } else if (gpa > 0.7) {
            letterGrades.add("D");
        } else if (gpa > 0.0) {
            letterGrades.add("D-");
        } else {
            letterGrades.add("E");
        }
    }
    return letterGrades;
}
```

Straightforward descending cascade — each `>` threshold matches the spec exactly, with `== 4.0` handled first and `0.0` falling through to `E`.

````

---

## Java/93 — codegen, iteration 1

- **Task ID:** `Java/93`
- **Model:** Claude Opus 4.6 (1M context)
- **Timestamp:** 2026-04-11T16:14:05+03:00
- **Elapsed:** 32.61s

### Prompt

````
import java.util.*;
import java.lang.*;

class Solution {
    /**
    Write a function that takes a message, and encodes in such a
    way that it swaps case of all letters, replaces all vowels in
    the message with the letter that appears 2 places ahead of that
    vowel in the english alphabet.
    Assume only letters.

    Examples:
    >>> encode("test")
    "TGST"
    >>> encode("This is a message")
    "tHKS KS C MGSSCGG"
     */
    public String encode(String message) {

````

### Response

````
```java
public String encode(String message) {
    StringBuilder result = new StringBuilder();
    String vowels = "aeiouAEIOU";
    for (char c : message.toCharArray()) {
        char swapped;
        if (Character.isUpperCase(c)) {
            swapped = Character.toLowerCase(c);
        } else if (Character.isLowerCase(c)) {
            swapped = Character.toUpperCase(c);
        } else {
            swapped = c;
        }
        if (vowels.indexOf(c) >= 0) {
            swapped = (char) (swapped + 2);
        }
        result.append(swapped);
    }
    return result.toString();
}
```

How it works:
1. For each character, swap case (upper↔lower).
2. If the original character was a vowel (`aeiouAEIOU`), shift the case-swapped letter +2 in the alphabet. Since vowels a/e/i/o/u are followed by consonants c/g/k/q/w, no wraparound is needed.

Traces:
- `"test"` → `t→T`, `e→E→G`, `s→S`, `t→T` = `"TGST"` ✓
- `"This is a message"` → `tHKS KS C MGSSCGG` ✓

````

---

## Java/124 — codegen, iteration 1

- **Task ID:** `Java/124`
- **Model:** Claude Opus 4.6 (1M context)
- **Timestamp:** 2026-04-11T16:14:16+03:00
- **Elapsed:** 11.31s

### Prompt

````
import java.util.*;
import java.lang.*;

class Solution {
    /**
    You have to write a function which validates a given date string and
    returns true if the date is valid otherwise false.
    The date is valid if all of the following rules are satisfied:
    1. The date string is not empty.
    2. The number of days is not less than 1 or higher than 31 days for months 1,3,5,7,8,10,12. And the number of days is not less than 1 or higher than 30 days for months 4,6,9,11. And, the number of days is not less than 1 or higher than 29 for the month 2.
    3. The months should not be less than 1 or higher than 12.
    4. The date should be in the format: mm-dd-yyyy

    for example:
    validDate("03-11-2000") => true
    validDate("15-01-2012") => false
    validDate("04-0-2040") => false
    validDate("06-04-2020") => true
    validDate("06/04/2020") => false
     */
    public boolean validDate(String date) {

````

### Response

````
```java
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
        int year = Integer.parseInt(parts[2]);

        if (month < 1 || month > 12) {
            return false;
        }
        if (day < 1) {
            return false;
        }
        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return day <= 31;
            case 4: case 6: case 9: case 11:
                return day <= 30;
            case 2:
                return day <= 29;
            default:
                return false;
        }
    }
}
```

Key checks:
1. Non-empty and strict `mm-dd-yyyy` format via regex.
2. Month range 1–12.
3. Day ≥ 1 and ≤ max days per month (31/30/29 for Feb per the spec).

````

---

## Java/129 — codegen, iteration 1

- **Task ID:** `Java/129`
- **Model:** Claude Opus 4.6 (1M context)
- **Timestamp:** 2026-04-11T16:14:34+03:00
- **Elapsed:** 18.54s

### Prompt

````
import java.util.*;
import java.lang.*;

class Solution {
    /**
    Given a grid with N rows and N columns (N >= 2) and a positive integer k,
    each cell of the grid contains a value. Every integer in the range [1, N * N]
    inclusive appears exactly once on the cells of the grid.

    You have to find the minimum path of length k in the grid. You can start
    from any cell, and in each step you can move to any of the neighbor cells,
    in other words, you can go to cells which share an edge with you current
    cell.
    Please note that a path of length k means visiting exactly k cells (not
    necessarily distinct).
    You CANNOT go off the grid.
    A path A (of length k) is considered less than a path B (of length k) if
    after making the ordered lists of the values on the cells that A and B go
    through (let's call them lst_A and lst_B), lst_A is lexicographically less
    than lst_B, in other words, there exist an integer index i (1 <= i <= k)
    such that lst_A[i] < lst_B[i] and for any j (1 <= j < i) we have
    lst_A[j] = lst_B[j].
    It is guaranteed that the answer is unique.
    Return an ordered list of the values on the cells that the minimum path go through.

    Examples:

        Input: grid = [ [1,2,3], [4,5,6], [7,8,9]], k = 3
        Output: [1, 2, 1]

        Input: grid = [ [5,9,3], [4,1,6], [7,8,2]], k = 1
        Output: [1]
     */
    public List<Integer> minPath(List<List<Integer>> grid, int k) {

````

### Response

````
```java
public List<Integer> minPath(List<List<Integer>> grid, int k) {
    int n = grid.size();
    int r = 0, c = 0;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (grid.get(i).get(j) == 1) {
                r = i;
                c = j;
            }
        }
    }

    int minNeighbor = Integer.MAX_VALUE;
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    for (int d = 0; d < 4; d++) {
        int nr = r + dr[d], nc = c + dc[d];
        if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
            minNeighbor = Math.min(minNeighbor, grid.get(nr).get(nc));
        }
    }

    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < k; i++) {
        result.add(i % 2 == 0 ? 1 : minNeighbor);
    }
    return result;
}
```

**Reasoning:** Since `1` is the smallest value and appears exactly once, the lexicographically smallest path must start at `1`. To keep each subsequent position minimal, bounce between `1` and its smallest-valued neighbor — any other move would place a larger value earlier in the sequence. The result alternates `1, minNeighbor, 1, minNeighbor, …` for `k` elements.

````

---

## Java/160 — codegen, iteration 1

- **Task ID:** `Java/160`
- **Model:** Claude Opus 4.6 (1M context)
- **Timestamp:** 2026-04-11T16:14:55+03:00
- **Elapsed:** 20.98s

### Prompt

````
import java.util.*;
import java.lang.*;

class Solution {
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

````

### Response

````
```java
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
```

Three precedence passes: `**` first (right-associative), then `*`/`/`, then `+`/`-`. Each pass collapses the matched operator and its operands into the left slot.

````

---

## Java/14 — improve, iteration 1

- **Task ID:** `Java/14`
- **Model:** Claude Opus 4.6 (1M context)
- **Timestamp:** 2026-04-18T19:58:25+03:00
- **Elapsed:** 12.39s

### Prompt

````
Improve this JUnit 6 test method.

Package: `humaneval.task_14`
Solution under test: `humaneval.claude.task_14.Solution`
Target class name: `ImprovedByClaudeTest`

Solution:
````java
package humaneval.claude.task_14;

import java.util.*;
import java.lang.*;

public class Solution {
    /**
    Return list of all prefixes from shortest to longest of the input string
    >>> allPrefixes("abc")
    ["a", "ab", "abc"]
     */
    public List<String> allPrefixes(String string) {
        List<String> prefixes = new ArrayList<>();
        for (int i = 1; i <= string.length(); i++) {
            prefixes.add(string.substring(0, i));
        }
        return prefixes;
    }
}
````

Current test method:
````java
@Test
    void claude() {
        var s = new humaneval.claude.task_14.Solution();
        List<Boolean> correct = Arrays.asList(
                s.allPrefixes("").equals(List.of()),
                s.allPrefixes("asdfgh").equals(Arrays.asList("a", "as", "asd", "asdf", "asdfg", "asdfgh")),
                s.allPrefixes("WWW").equals(Arrays.asList("W", "WW", "WWW"))
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    
    }
````

Test smells (JNose):
  - Unknown Test (line 8-20)
  - Conditional Test Logic (line 16-18)

Branches of the Solution not covered by the current test (JaCoCo):
  (all branches covered)

Output a single ```java ... ``` fenced block containing the complete
improved test class. No prose outside the fence.

````

### Response

````
```java
package humaneval.task_14;

import humaneval.claude.task_14.Solution;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ImprovedByClaudeTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    @DisplayName("empty string returns empty list")
    void emptyStringReturnsEmptyList() {
        assertEquals(Collections.emptyList(), solution.allPrefixes(""));
    }

    @Test
    @DisplayName("prefixes of a multi-character string are ordered shortest to longest")
    void prefixesOfMultiCharacterString() {
        assertEquals(
                Arrays.asList("a", "as", "asd", "asdf", "asdfg", "asdfgh"),
                solution.allPrefixes("asdfgh")
        );
    }

    @Test
    @DisplayName("prefixes of a string with repeated characters preserve each character")
    void prefixesOfRepeatedCharacterString() {
        assertEquals(
                Arrays.asList("W", "WW", "WWW"),
                solution.allPrefixes("WWW")
        );
    }

    @Test
    @DisplayName("single character string returns a single prefix")
    void singleCharacterString() {
        assertEquals(Collections.singletonList("x"), solution.allPrefixes("x"));
    }
}
```
````

---

## Java/16 — improve, iteration 1

- **Task ID:** `Java/16`
- **Model:** Claude Opus 4.6 (1M context)
- **Timestamp:** 2026-04-18T19:58:41+03:00
- **Elapsed:** 15.88s

### Prompt

````
Improve this JUnit 6 test method.

Package: `humaneval.task_16`
Solution under test: `humaneval.claude.task_16.Solution`
Target class name: `ImprovedByClaudeTest`

Solution:
````java
package humaneval.claude.task_16;

import java.util.*;
import java.lang.*;

public class Solution {
    /**
    Given a string, find out how many distinct characters (regardless of case) does it consist of
    >>> countDistinctCharacters("xyzXYZ")
    3
    >>> countDistinctCharacters("Jerry")
    4
     */
    public int countDistinctCharacters(String string) {
        Set<Character> distinct = new HashSet<>();
        for (char c : string.toLowerCase().toCharArray()) {
            distinct.add(c);
        }
        return distinct.size();
    }
}
````

Current test method:
````java
@Test
    void claude() {
        var s = new humaneval.claude.task_16.Solution();
        List<Boolean> correct = Arrays.asList(
                s.countDistinctCharacters("") == 0,
                s.countDistinctCharacters("abcde") == 5,
                s.countDistinctCharacters("abcde" + "cade" + "CADE") == 5,
                s.countDistinctCharacters("aaaaAAAAaaaa") == 1,
                s.countDistinctCharacters("Jerry jERRY JeRRRY") == 5
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    
    }
````

Test smells (JNose):
  - Unknown Test (line 8-22)
  - Conditional Test Logic (line 18-20)

Branches of the Solution not covered by the current test (JaCoCo):
  (all branches covered)

Output a single ```java ... ``` fenced block containing the complete
improved test class. No prose outside the fence.

````

### Response

````
```java
package humaneval.task_16;

import humaneval.claude.task_16.Solution;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ImprovedByClaudeTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    @DisplayName("Empty string has zero distinct characters")
    void emptyStringReturnsZero() {
        assertEquals(0, solution.countDistinctCharacters(""));
    }

    @Test
    @DisplayName("All unique lowercase characters counted correctly")
    void allUniqueLowercaseCharacters() {
        assertEquals(5, solution.countDistinctCharacters("abcde"));
    }

    @Test
    @DisplayName("Mixed case duplicates counted as same character")
    void mixedCaseDuplicatesTreatedAsSame() {
        assertEquals(5, solution.countDistinctCharacters("abcdecadeCADE"));
    }

    @Test
    @DisplayName("Single repeated character regardless of case returns one")
    void singleRepeatedCharacterRegardlessOfCase() {
        assertEquals(1, solution.countDistinctCharacters("aaaaAAAAaaaa"));
    }

    @Test
    @DisplayName("Word with mixed case and spaces counts distinct characters")
    void wordWithMixedCaseAndSpaces() {
        assertEquals(5, solution.countDistinctCharacters("Jerry jERRY JeRRRY"));
    }

    @Test
    @DisplayName("Single character string returns one")
    void singleCharacterReturnsOne() {
        assertEquals(1, solution.countDistinctCharacters("a"));
    }

    @Test
    @DisplayName("String with digits and symbols counts each distinctly")
    void digitsAndSymbolsCountedDistinctly() {
        assertEquals(6, solution.countDistinctCharacters("1!2@3#"));
    }

    @Test
    @DisplayName("Whitespace characters are counted as distinct characters")
    void whitespaceCountedAsCharacter() {
        assertEquals(2, solution.countDistinctCharacters("a a a"));
    }

    @Test
    @DisplayName("Uppercase-only string counted by lowercased characters")
    void uppercaseOnlyStringCountedByLowercase() {
        assertEquals(3, solution.countDistinctCharacters("XYZ"));
    }

    @Test
    @DisplayName("Unicode characters counted distinctly")
    void unicodeCharactersCountedDistinctly() {
        assertEquals(3, solution.countDistinctCharacters("äöüÄÖÜ"));
    }
}
```
````

---

## Java/23 — improve, iteration 1

- **Task ID:** `Java/23`
- **Model:** Claude Opus 4.6 (1M context)
- **Timestamp:** 2026-04-18T19:58:57+03:00
- **Elapsed:** 16.17s

### Prompt

````
Improve this JUnit 6 test method.

Package: `humaneval.task_23`
Solution under test: `humaneval.claude.task_23.Solution`
Target class name: `ImprovedByClaudeTest`

Solution:
````java
package humaneval.claude.task_23;

import java.util.*;
import java.lang.*;

public class Solution {
    /**
    Return length of given string
    >>> strlen("")
    0
    >>> strlen("abc")
    3
     */
    public int strlen(String string) {
        return string.length();
    }
}
````

Current test method:
````java
@Test
    void claude() {
        var s = new humaneval.claude.task_23.Solution();
        List<Boolean> correct = Arrays.asList(
                s.strlen("") == 0,
                s.strlen("x") == 1,
                s.strlen("asdasnakj") == 9
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    
    }
````

Test smells (JNose):
  - Unknown Test (line 8-20)
  - Conditional Test Logic (line 16-18)

Branches of the Solution not covered by the current test (JaCoCo):
  (all branches covered)

Output a single ```java ... ``` fenced block containing the complete
improved test class. No prose outside the fence.

````

### Response

````
```java
package humaneval.task_23;

import humaneval.claude.task_23.Solution;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ImprovedByClaudeTest {

    @Test
    void strlenOfEmptyStringIsZero() {
        Solution s = new Solution();
        assertEquals(0, s.strlen(""));
    }

    @Test
    void strlenOfSingleCharacterIsOne() {
        Solution s = new Solution();
        assertEquals(1, s.strlen("x"));
    }

    @Test
    void strlenOfMultiCharacterString() {
        Solution s = new Solution();
        assertEquals(9, s.strlen("asdasnakj"));
    }

    @Test
    void strlenOfExampleFromDocstring() {
        Solution s = new Solution();
        assertEquals(3, s.strlen("abc"));
    }

    @Test
    void strlenCountsWhitespaceCharacters() {
        Solution s = new Solution();
        assertEquals(5, s.strlen("a b c"));
    }
}
```
````

---

## Java/26 — improve, iteration 1

- **Task ID:** `Java/26`
- **Model:** Claude Opus 4.6 (1M context)
- **Timestamp:** 2026-04-18T19:59:12+03:00
- **Elapsed:** 14.70s

### Prompt

````
Improve this JUnit 6 test method.

Package: `humaneval.task_26`
Solution under test: `humaneval.claude.task_26.Solution`
Target class name: `ImprovedByClaudeTest`

Solution:
````java
package humaneval.claude.task_26;

import java.util.*;
import java.lang.*;
import java.util.stream.Collectors;

public class Solution {
    /**
    From a list of integers, remove all elements that occur more than once.
    Keep order of elements left the same as in the input.
    >>> removeDuplicates(Array.asList(1, 2, 3, 2, 4))
    [1, 3, 4]
     */
    public List<Integer> removeDuplicates(List<Integer> numbers) {
        Map<Integer, Long> counts = numbers.stream()
            .collect(Collectors.groupingBy(n -> n, Collectors.counting()));
        return numbers.stream()
            .filter(n -> counts.get(n) == 1)
            .collect(Collectors.toList());
    }
}
````

Current test method:
````java
@Test
    void claude() {
        var s = new humaneval.claude.task_26.Solution();
        List<Boolean> correct = Arrays.asList(
                s.removeDuplicates(new ArrayList<>(List.of())).equals(List.of()),
                s.removeDuplicates(new ArrayList<>(Arrays.asList(1, 2, 3, 4))).equals(Arrays.asList(1, 2, 3, 4)),
                s.removeDuplicates(new ArrayList<>(Arrays.asList(1, 2, 3, 2, 4, 3, 5))).equals(Arrays.asList(1, 4, 5))
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    
    }
````

Test smells (JNose):
  - Unknown Test (line 8-20)
  - Conditional Test Logic (line 16-18)

Branches of the Solution not covered by the current test (JaCoCo):
  (all branches covered)

Output a single ```java ... ``` fenced block containing the complete
improved test class. No prose outside the fence.

````

### Response

````
```java
package humaneval.task_26;

import humaneval.claude.task_26.Solution;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ImprovedByClaudeTest {

    private final Solution solution = new Solution();

    @Test
    @DisplayName("empty list returns empty list")
    void emptyListReturnsEmpty() {
        assertEquals(Collections.emptyList(), solution.removeDuplicates(Collections.emptyList()));
    }

    @Test
    @DisplayName("list with all unique elements is unchanged")
    void allUniqueElementsUnchanged() {
        assertEquals(Arrays.asList(1, 2, 3, 4),
                solution.removeDuplicates(Arrays.asList(1, 2, 3, 4)));
    }

    @Test
    @DisplayName("elements occurring more than once are removed, order preserved")
    void duplicatesRemovedPreservingOrder() {
        assertEquals(Arrays.asList(1, 4, 5),
                solution.removeDuplicates(Arrays.asList(1, 2, 3, 2, 4, 3, 5)));
    }

    @Test
    @DisplayName("all elements duplicated produces empty list")
    void allDuplicatesProduceEmpty() {
        assertEquals(Collections.emptyList(),
                solution.removeDuplicates(Arrays.asList(1, 1, 2, 2, 3, 3)));
    }

    @Test
    @DisplayName("single element list is unchanged")
    void singleElementUnchanged() {
        assertEquals(List.of(42), solution.removeDuplicates(List.of(42)));
    }

    @Test
    @DisplayName("element occurring three times is removed")
    void tripleOccurrenceRemoved() {
        assertEquals(Arrays.asList(1, 3),
                solution.removeDuplicates(Arrays.asList(1, 2, 2, 2, 3)));
    }

    @Test
    @DisplayName("negative numbers are handled correctly")
    void negativeNumbersHandled() {
        assertEquals(Arrays.asList(-1, -3),
                solution.removeDuplicates(Arrays.asList(-1, -2, -2, -3)));
    }

    @Test
    @DisplayName("input list is not mutated")
    void inputListNotMutated() {
        List<Integer> input = Arrays.asList(1, 2, 2, 3);
        List<Integer> snapshot = Arrays.asList(1, 2, 2, 3);
        solution.removeDuplicates(input);
        assertEquals(snapshot, input);
    }
}
```
````

---

## Java/49 — improve, iteration 1

- **Task ID:** `Java/49`
- **Model:** Claude Opus 4.6 (1M context)
- **Timestamp:** 2026-04-18T19:59:29+03:00
- **Elapsed:** 17.38s

### Prompt

````
Improve this JUnit 6 test method.

Package: `humaneval.task_49`
Solution under test: `humaneval.claude.task_49.Solution`
Target class name: `ImprovedByClaudeTest`

Solution:
````java
package humaneval.claude.task_49;

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
        int result = 1 % p;
        for (int i = 0; i < n; i++) {
            result = (result * 2) % p;
        }
        return result;
    }
}
````

Current test method:
````java
@Test
    void claude() {
        var s = new humaneval.claude.task_49.Solution();
        List<Boolean> correct = Arrays.asList(
                s.modp(3, 5) == 3,
                s.modp(1101, 101) == 2,
                s.modp(0, 101) == 1,
                s.modp(3, 11) == 8,
                s.modp(100, 101) == 1,
                s.modp(30, 5) == 4,
                s.modp(31, 5) == 3
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    
    }
````

Test smells (JNose):
  - Unknown Test (line 8-24)
  - Conditional Test Logic (line 20-22)

Branches of the Solution not covered by the current test (JaCoCo):
  (all branches covered)

Output a single ```java ... ``` fenced block containing the complete
improved test class. No prose outside the fence.

````

### Response

````
```java
package humaneval.task_49;

import humaneval.claude.task_49.Solution;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ImprovedByClaudeTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    @DisplayName("modp(3, 5) returns 2^3 mod 5 = 3")
    void modpReturnsThreeForBaseCase() {
        assertEquals(3, solution.modp(3, 5));
    }

    @Test
    @DisplayName("modp(1101, 101) returns 2^1101 mod 101 = 2")
    void modpHandlesLargeExponent() {
        assertEquals(2, solution.modp(1101, 101));
    }

    @Test
    @DisplayName("modp(0, 101) returns 2^0 mod 101 = 1")
    void modpReturnsOneWhenExponentIsZero() {
        assertEquals(1, solution.modp(0, 101));
    }

    @Test
    @DisplayName("modp(3, 11) returns 2^3 mod 11 = 8")
    void modpReturnsEightForSmallModulus() {
        assertEquals(8, solution.modp(3, 11));
    }

    @Test
    @DisplayName("modp(100, 101) returns 2^100 mod 101 = 1 (Fermat's little theorem)")
    void modpSatisfiesFermatLittleTheorem() {
        assertEquals(1, solution.modp(100, 101));
    }

    @Test
    @DisplayName("modp(30, 5) returns 2^30 mod 5 = 4")
    void modpReturnsFourForExponentThirty() {
        assertEquals(4, solution.modp(30, 5));
    }

    @Test
    @DisplayName("modp(31, 5) returns 2^31 mod 5 = 3")
    void modpReturnsThreeForExponentThirtyOne() {
        assertEquals(3, solution.modp(31, 5));
    }

    @Test
    @DisplayName("modp(n, 1) always returns 0 since anything mod 1 is 0")
    void modpReturnsZeroWhenModulusIsOne() {
        assertEquals(0, solution.modp(0, 1));
        assertEquals(0, solution.modp(5, 1));
        assertEquals(0, solution.modp(1000, 1));
    }

    @Test
    @DisplayName("modp(1, p) returns 2 when p > 2")
    void modpReturnsTwoForExponentOne() {
        assertEquals(2, solution.modp(1, 7));
        assertEquals(2, solution.modp(1, 101));
    }

    @Test
    @DisplayName("modp(2, p) returns 4 when p > 4")
    void modpReturnsFourForExponentTwo() {
        assertEquals(4, solution.modp(2, 7));
        assertEquals(4, solution.modp(2, 101));
    }

    @Test
    @DisplayName("modp(1, 2) returns 0 since 2 mod 2 = 0")
    void modpReturnsZeroWhenPowerEqualsModulus() {
        assertEquals(0, solution.modp(1, 2));
    }

    @Test
    @DisplayName("modp(10, 1024) returns 0 since 2^10 = 1024")
    void modpReturnsZeroWhenExactDivisor() {
        assertEquals(0, solution.modp(10, 1024));
    }

    @Test
    @DisplayName("modp(10, 1023) returns 1 since 2^10 mod 1023 = 1")
    void modpReturnsOneJustAboveDivisor() {
        assertEquals(1, solution.modp(10, 1023));
    }
}
```
````

---

## Java/57 — improve, iteration 1

- **Task ID:** `Java/57`
- **Model:** Claude Opus 4.6 (1M context)
- **Timestamp:** 2026-04-18T19:59:53+03:00
- **Elapsed:** 24.12s

### Prompt

````
Improve this JUnit 6 test method.

Package: `humaneval.task_57`
Solution under test: `humaneval.claude.task_57.Solution`
Target class name: `ImprovedByClaudeTest`

Solution:
````java
package humaneval.claude.task_57;

import java.util.*;
import java.lang.*;

public class Solution {
    /**
    Return True is list elements are monotonically increasing or decreasing.
    >>> monotonic(Arrays.asList(1, 2, 4, 20))
    true
    >>> monotonic(Arrays.asList(1, 20, 4, 10))
    false
    >>> monotonic(Arrays.asList(4, 1, 0, -10))
    true
     */
    public boolean monotonic(List<Integer> l) {
        if (l.size() <= 1) {
            return true;
        }
        boolean increasing = true;
        boolean decreasing = true;
        for (int i = 1; i < l.size(); i++) {
            if (l.get(i) > l.get(i - 1)) {
                decreasing = false;
            } else if (l.get(i) < l.get(i - 1)) {
                increasing = false;
            }
        }
        return increasing || decreasing;
    }
}
````

Current test method:
````java
@Test
    void claude() {
        var s = new humaneval.claude.task_57.Solution();
        List<Boolean> correct = Arrays.asList(
                s.monotonic(new ArrayList<>(Arrays.asList(1, 2, 4, 10))),
                s.monotonic(new ArrayList<>(Arrays.asList(1, 2, 4, 20))),
                !s.monotonic(new ArrayList<>(Arrays.asList(1, 20, 4, 10))),
                s.monotonic(new ArrayList<>(Arrays.asList(4, 1, 0, -10))),
                s.monotonic(new ArrayList<>(Arrays.asList(4, 1, 1, 0))),
                !s.monotonic(new ArrayList<>(Arrays.asList(1, 2, 3, 2, 5, 60))),
                s.monotonic(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 60))),
                s.monotonic(new ArrayList<>(Arrays.asList(9, 9, 9, 9)))
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    
    }
````

Test smells (JNose):
  - Unknown Test (line 8-25)
  - Conditional Test Logic (line 21-23)

Branches of the Solution not covered by the current test (JaCoCo):
  - line 17: 1 of 2 branches missed

Output a single ```java ... ``` fenced block containing the complete
improved test class. No prose outside the fence.

````

### Response

````
```java
package humaneval.task_57;

import humaneval.claude.task_57.Solution;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ImprovedByClaudeTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    @DisplayName("Empty list is trivially monotonic")
    void emptyListIsMonotonic() {
        assertTrue(solution.monotonic(Collections.emptyList()));
    }

    @Test
    @DisplayName("Single-element list is trivially monotonic")
    void singleElementListIsMonotonic() {
        assertTrue(solution.monotonic(Collections.singletonList(42)));
    }

    @Test
    @DisplayName("Two-element strictly increasing list is monotonic")
    void twoElementIncreasingIsMonotonic() {
        assertTrue(solution.monotonic(Arrays.asList(1, 2)));
    }

    @Test
    @DisplayName("Two-element strictly decreasing list is monotonic")
    void twoElementDecreasingIsMonotonic() {
        assertTrue(solution.monotonic(Arrays.asList(2, 1)));
    }

    @Test
    @DisplayName("Strictly increasing list is monotonic")
    void strictlyIncreasingIsMonotonic() {
        assertTrue(solution.monotonic(Arrays.asList(1, 2, 4, 10)));
    }

    @Test
    @DisplayName("Another strictly increasing list is monotonic")
    void anotherStrictlyIncreasingIsMonotonic() {
        assertTrue(solution.monotonic(Arrays.asList(1, 2, 4, 20)));
    }

    @Test
    @DisplayName("Fully increasing sequence to large value is monotonic")
    void longIncreasingSequenceIsMonotonic() {
        assertTrue(solution.monotonic(Arrays.asList(1, 2, 3, 4, 5, 60)));
    }

    @Test
    @DisplayName("Strictly decreasing list with negative values is monotonic")
    void strictlyDecreasingWithNegativesIsMonotonic() {
        assertTrue(solution.monotonic(Arrays.asList(4, 1, 0, -10)));
    }

    @Test
    @DisplayName("Non-strictly decreasing list with duplicates is monotonic")
    void nonStrictlyDecreasingWithDuplicatesIsMonotonic() {
        assertTrue(solution.monotonic(Arrays.asList(4, 1, 1, 0)));
    }

    @Test
    @DisplayName("All-equal list is monotonic (both increasing and decreasing vacuously)")
    void allEqualListIsMonotonic() {
        assertTrue(solution.monotonic(Arrays.asList(9, 9, 9, 9)));
    }

    @Test
    @DisplayName("All-equal two-element list is monotonic")
    void twoEqualElementsAreMonotonic() {
        assertTrue(solution.monotonic(Arrays.asList(5, 5)));
    }

    @Test
    @DisplayName("Non-strictly increasing list with duplicates is monotonic")
    void nonStrictlyIncreasingWithDuplicatesIsMonotonic() {
        assertTrue(solution.monotonic(Arrays.asList(1, 1, 2, 3)));
    }

    @Test
    @DisplayName("List with a single dip is not monotonic")
    void listWithDipIsNotMonotonic() {
        assertFalse(solution.monotonic(Arrays.asList(1, 20, 4, 10)));
    }

    @Test
    @DisplayName("List that rises then dips then rises is not monotonic")
    void riseDipRiseIsNotMonotonic() {
        assertFalse(solution.monotonic(Arrays.asList(1, 2, 3, 2, 5, 60)));
    }

    @Test
    @DisplayName("List that decreases then increases is not monotonic")
    void decreaseThenIncreaseIsNotMonotonic() {
        assertFalse(solution.monotonic(Arrays.asList(5, 3, 1, 2)));
    }

    @Test
    @DisplayName("List that increases then decreases is not monotonic")
    void increaseThenDecreaseIsNotMonotonic() {
        assertFalse(solution.monotonic(Arrays.asList(1, 3, 5, 2)));
    }

    @Test
    @DisplayName("Negative-only strictly increasing list is monotonic")
    void negativeStrictlyIncreasingIsMonotonic() {
        assertTrue(solution.monotonic(Arrays.asList(-10, -5, -1, 0)));
    }

    @Test
    @DisplayName("List mixing positives and negatives decreasing is monotonic")
    void mixedSignsDecreasingIsMonotonic() {
        assertTrue(solution.monotonic(Arrays.asList(10, 5, -1, -100)));
    }
}
```
````

---

## Java/100 — improve, iteration 1

- **Task ID:** `Java/100`
- **Model:** Claude Opus 4.6 (1M context)
- **Timestamp:** 2026-04-18T20:00:05+03:00
- **Elapsed:** 12.01s

### Prompt

````
Improve this JUnit 6 test method.

Package: `humaneval.task_100`
Solution under test: `humaneval.claude.task_100.Solution`
Target class name: `ImprovedByClaudeTest`

Solution:
````java
package humaneval.claude.task_100;

import java.util.*;
import java.lang.*;

public class Solution {
    /**
    Given a positive integer n, you have to make a pile of n levels of stones.
    The first level has n stones.
    The number of stones in the next level is:
        - the next odd number if n is odd.
        - the next even number if n is even.
    Return the number of stones in each level in a list, where element at index
    i represents the number of stones in the level (i+1).

    Examples:
    >>> makeAPile(3)
    [3, 5, 7]
     */
    public List<Integer> makeAPile(int n) {
    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < n; i++) {
        result.add(n + 2 * i);
    }
    return result;
}
}
````

Current test method:
````java
@Test
    void claude() {
        var s = new humaneval.claude.task_100.Solution();
        List<Boolean> correct = Arrays.asList(
                s.makeAPile(3).equals(Arrays.asList(3, 5, 7)),
                s.makeAPile(4).equals(Arrays.asList(4, 6, 8, 10)),
                s.makeAPile(5).equals(Arrays.asList(5, 7, 9, 11, 13)),
                s.makeAPile(6).equals(Arrays.asList(6, 8, 10, 12, 14, 16)),
                s.makeAPile(8).equals(Arrays.asList(8, 10, 12, 14, 16, 18, 20, 22))
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    
    }
````

Test smells (JNose):
  - Unknown Test (line 8-22)
  - Conditional Test Logic (line 18-20)

Branches of the Solution not covered by the current test (JaCoCo):
  (all branches covered)

Output a single ```java ... ``` fenced block containing the complete
improved test class. No prose outside the fence.

````

### Response

````
```java
package humaneval.task_100;

import humaneval.claude.task_100.Solution;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ImprovedByClaudeTest {

    @Test
    void makeAPile_oddStart_returnsOddProgression() {
        Solution s = new Solution();
        assertEquals(Arrays.asList(3, 5, 7), s.makeAPile(3));
    }

    @Test
    void makeAPile_evenStart_returnsEvenProgression() {
        Solution s = new Solution();
        assertEquals(Arrays.asList(4, 6, 8, 10), s.makeAPile(4));
    }

    @Test
    void makeAPile_oddFive_returnsFiveLevels() {
        Solution s = new Solution();
        assertEquals(Arrays.asList(5, 7, 9, 11, 13), s.makeAPile(5));
    }

    @Test
    void makeAPile_evenSix_returnsSixLevels() {
        Solution s = new Solution();
        assertEquals(Arrays.asList(6, 8, 10, 12, 14, 16), s.makeAPile(6));
    }

    @Test
    void makeAPile_evenEight_returnsEightLevels() {
        Solution s = new Solution();
        assertEquals(Arrays.asList(8, 10, 12, 14, 16, 18, 20, 22), s.makeAPile(8));
    }

    @Test
    void makeAPile_one_returnsSingleLevel() {
        Solution s = new Solution();
        assertEquals(Collections.singletonList(1), s.makeAPile(1));
    }

    @Test
    void makeAPile_two_returnsTwoLevels() {
        Solution s = new Solution();
        assertEquals(Arrays.asList(2, 4), s.makeAPile(2));
    }

    @Test
    void makeAPile_resultSizeMatchesInput() {
        Solution s = new Solution();
        assertEquals(10, s.makeAPile(10).size());
    }
}
```
````

---

## Java/120 — improve, iteration 1

- **Task ID:** `Java/120`
- **Model:** Claude Opus 4.6 (1M context)
- **Timestamp:** 2026-04-18T20:00:41+03:00
- **Elapsed:** 35.55s

### Prompt

````
Improve this JUnit 6 test method.

Package: `humaneval.task_120`
Solution under test: `humaneval.claude.task_120.Solution`
Target class name: `ImprovedByClaudeTest`

Solution:
````java
package humaneval.claude.task_120;

import java.util.*;
import java.lang.*;

public class Solution {
    /**
    Given an array arr of integers and a positive integer k, return a sorted list
    of length k with the maximum k numbers in arr.

    Example 1:

        Input: arr = [-3, -4, 5], k = 3
        Output: [-4, -3, 5]

    Example 2:

        Input: arr = [4, -4, 4], k = 2
        Output: [4, 4]

    Example 3:

        Input: arr = [-3, 2, 1, 2, -1, -2, 1], k = 1
        Output: [2]

    Note:
        1. The length of the array will be in the range of [1, 1000].
        2. The elements in the array will be in the range of [-1000, 1000].
        3. 0 <= k <= len(arr)
     */
    public List<Integer> maximum(List<Integer> arr, int k) {
        if (k == 0) {
            return new ArrayList<>();
        }
        List<Integer> sorted = new ArrayList<>(arr);
        Collections.sort(sorted);
        return new ArrayList<>(sorted.subList(sorted.size() - k, sorted.size()));
    }
}
````

Current test method:
````java
@Test
    void claude() {
        var s = new humaneval.claude.task_120.Solution();
        List<Boolean> correct = Arrays.asList(
                s.maximum(new ArrayList<>(Arrays.asList(-3, -4, 5)), 3).equals(Arrays.asList(-4, -3, 5)),
                s.maximum(new ArrayList<>(Arrays.asList(4, -4, 4)), 2).equals(Arrays.asList(4, 4)),
                s.maximum(new ArrayList<>(Arrays.asList(-3, 2, 1, 2, -1, -2, 1)), 1).equals(List.of(2)),
                s.maximum(new ArrayList<>(Arrays.asList(123, -123, 20, 0 , 1, 2, -3)), 3).equals(Arrays.asList(2, 20, 123)),
                s.maximum(new ArrayList<>(Arrays.asList(-123, 20, 0 , 1, 2, -3)), 4).equals(Arrays.asList(0, 1, 2, 20)),
                s.maximum(new ArrayList<>(Arrays.asList(5, 15, 0, 3, -13, -8, 0)), 7).equals(Arrays.asList(-13, -8, 0, 0, 3, 5, 15)),
                s.maximum(new ArrayList<>(Arrays.asList(-1, 0, 2, 5, 3, -10)), 2).equals(Arrays.asList(3, 5)),
                s.maximum(new ArrayList<>(Arrays.asList(1, 0, 5, -7)), 1).equals(List.of(5)),
                s.maximum(new ArrayList<>(Arrays.asList(4, -4)), 2).equals(Arrays.asList(-4, 4)),
                s.maximum(new ArrayList<>(Arrays.asList(-10, 10)), 2).equals(Arrays.asList(-10, 10))
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    
    }
````

Test smells (JNose):
  - Unknown Test (line 8-27)
  - Conditional Test Logic (line 23-25)

Branches of the Solution not covered by the current test (JaCoCo):
  - line 32: 1 of 2 branches missed

Output a single ```java ... ``` fenced block containing the complete
improved test class. No prose outside the fence.

````

### Response

````
```java
package humaneval.task_120;

import humaneval.claude.task_120.Solution;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ImprovedByClaudeTest {

    private final Solution solution = new Solution();

    @Test
    @DisplayName("Example 1: mixed negatives and positive with k equal to array length")
    void returnsAllElementsSortedWhenKEqualsArrayLength() {
        assertEquals(Arrays.asList(-4, -3, 5),
                solution.maximum(new ArrayList<>(Arrays.asList(-3, -4, 5)), 3));
    }

    @Test
    @DisplayName("Example 2: duplicates are preserved in the result")
    void preservesDuplicatesInResult() {
        assertEquals(Arrays.asList(4, 4),
                solution.maximum(new ArrayList<>(Arrays.asList(4, -4, 4)), 2));
    }

    @Test
    @DisplayName("Example 3: single maximum element when k is 1")
    void returnsSingleMaximumWhenKIsOne() {
        assertEquals(List.of(2),
                solution.maximum(new ArrayList<>(Arrays.asList(-3, 2, 1, 2, -1, -2, 1)), 1));
    }

    @Test
    @DisplayName("Returns top three largest in ascending order from mixed array")
    void returnsTopThreeLargestInAscendingOrder() {
        assertEquals(Arrays.asList(2, 20, 123),
                solution.maximum(new ArrayList<>(Arrays.asList(123, -123, 20, 0, 1, 2, -3)), 3));
    }

    @Test
    @DisplayName("Returns top four largest in ascending order")
    void returnsTopFourLargestInAscendingOrder() {
        assertEquals(Arrays.asList(0, 1, 2, 20),
                solution.maximum(new ArrayList<>(Arrays.asList(-123, 20, 0, 1, 2, -3)), 4));
    }

    @Test
    @DisplayName("Returns entire array sorted when k equals array length with zeros")
    void returnsAllElementsSortedIncludingZeros() {
        assertEquals(Arrays.asList(-13, -8, 0, 0, 3, 5, 15),
                solution.maximum(new ArrayList<>(Arrays.asList(5, 15, 0, 3, -13, -8, 0)), 7));
    }

    @Test
    @DisplayName("Returns top two when array has both negatives and positives")
    void returnsTopTwoFromMixedArray() {
        assertEquals(Arrays.asList(3, 5),
                solution.maximum(new ArrayList<>(Arrays.asList(-1, 0, 2, 5, 3, -10)), 2));
    }

    @Test
    @DisplayName("Returns single maximum from small positive-leaning array")
    void returnsSingleMaximumFromSmallArray() {
        assertEquals(List.of(5),
                solution.maximum(new ArrayList<>(Arrays.asList(1, 0, 5, -7)), 1));
    }

    @Test
    @DisplayName("Returns both elements sorted when array has exactly two elements")
    void returnsBothElementsSortedForTwoElementArray() {
        assertEquals(Arrays.asList(-4, 4),
                solution.maximum(new ArrayList<>(Arrays.asList(4, -4)), 2));
    }

    @Test
    @DisplayName("Returns both elements sorted for array of two already-ordered elements")
    void returnsBothElementsSortedWhenAlreadyOrdered() {
        assertEquals(Arrays.asList(-10, 10),
                solution.maximum(new ArrayList<>(Arrays.asList(-10, 10)), 2));
    }

    @Test
    @DisplayName("Returns empty list when k is zero (covers k==0 branch)")
    void returnsEmptyListWhenKIsZero() {
        List<Integer> result = solution.maximum(
                new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)), 0);
        assertEquals(Collections.emptyList(), result);
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("Returns empty list when k is zero and input array is empty")
    void returnsEmptyListWhenKIsZeroAndArrayIsEmpty() {
        assertEquals(Collections.emptyList(),
                solution.maximum(new ArrayList<>(), 0));
    }

    @Test
    @DisplayName("Does not mutate the input list")
    void doesNotMutateInputList() {
        List<Integer> input = new ArrayList<>(Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6));
        List<Integer> snapshot = new ArrayList<>(input);
        solution.maximum(input, 3);
        assertEquals(snapshot, input);
    }

    @Test
    @DisplayName("Returns a new list instance, not the input")
    void returnsNewListInstance() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> result = solution.maximum(input, 2);
        assertNotSame(input, result);
    }

    @Test
    @DisplayName("Handles all-negative array returning top negatives")
    void handlesAllNegativeArray() {
        assertEquals(Arrays.asList(-3, -1),
                solution.maximum(new ArrayList<>(Arrays.asList(-5, -3, -1, -7, -2)), 2)
                        .stream().sorted().toList().equals(Arrays.asList(-3, -1))
                        ? Arrays.asList(-3, -1)
                        : solution.maximum(new ArrayList<>(Arrays.asList(-5, -3, -1, -7, -2)), 2));
    }

    @Test
    @DisplayName("Handles single-element array with k=1")
    void handlesSingleElementArray() {
        assertEquals(List.of(42),
                solution.maximum(new ArrayList<>(List.of(42)), 1));
    }

    @Test
    @DisplayName("Handles single-element array with k=0")
    void handlesSingleElementArrayWithKZero() {
        assertEquals(Collections.emptyList(),
                solution.maximum(new ArrayList<>(List.of(42)), 0));
    }
}
```
````

---

## Java/3 — improve, iteration 1

- **Task ID:** `Java/3`
- **Model:** Claude Opus 4.6 (1M context)
- **Timestamp:** 2026-04-18T20:00:58+03:00
- **Elapsed:** 16.52s

### Prompt

````
Improve this JUnit 6 test method.

Package: `humaneval.task_3`
Solution under test: `humaneval.claude.task_3.Solution`
Target class name: `ImprovedByClaudeTest`

Solution:
````java
package humaneval.claude.task_3;

import java.util.*;
import java.lang.*;

public class Solution {
    /**
    You're given a list of deposit and withdrawal operations on a bank account that starts with
    zero balance. Your task is to detect if at any point the balance of account fallls below zero, and
    at that point function should return True. Otherwise it should return False.
    >>> belowZero(Arrays.asList(1, 2, 3))
    false
    >>> belowZero(Arrays.asList(1, 2, -4, 5))
    true
     */
    public boolean belowZero(List<Integer> operations) {
        int balance = 0;
        for (int op : operations) {
            balance += op;
            if (balance < 0) {
                return true;
            }
        }
        return false;
    }
}
````

Current test method:
````java
@Test
    void claude() {
        var s = new humaneval.claude.task_3.Solution();
        List<Boolean> correct = Arrays.asList(
                !s.belowZero(new ArrayList<>(Arrays.asList())),
                !s.belowZero(new ArrayList<>(Arrays.asList(1, 2, -3, 1, 2, -3))),
                s.belowZero(new ArrayList<>(Arrays.asList(1, 2, -4, 5, 6))),
                !s.belowZero(new ArrayList<>(Arrays.asList(1, -1, 2, -2, 5, -5, 4, -4))),
                s.belowZero(new ArrayList<>(Arrays.asList(1, -1, 2, -2, 5, -5, 4, -5))),
                s.belowZero(new ArrayList<>(Arrays.asList(1, -2, 2, -2, 5, -5, 4, -4)))
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    
    }
````

Test smells (JNose):
  - Unknown Test (line 8-23)
  - Conditional Test Logic (line 19-21)

Branches of the Solution not covered by the current test (JaCoCo):
  (all branches covered)

Output a single ```java ... ``` fenced block containing the complete
improved test class. No prose outside the fence.

````

### Response

````
```java
package humaneval.task_3;

import humaneval.claude.task_3.Solution;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ImprovedByClaudeTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    @DisplayName("Empty operations list never goes below zero")
    void emptyOperationsReturnsFalse() {
        assertFalse(solution.belowZero(Collections.emptyList()));
    }

    @Test
    @DisplayName("All positive operations stay above zero")
    void allPositiveOperationsReturnsFalse() {
        assertFalse(solution.belowZero(Arrays.asList(1, 2, 3)));
    }

    @Test
    @DisplayName("Balance returning to zero but never negative returns false")
    void balanceReturnsToZeroWithoutGoingNegativeReturnsFalse() {
        assertFalse(solution.belowZero(Arrays.asList(1, 2, -3, 1, 2, -3)));
    }

    @Test
    @DisplayName("Net-zero alternating deposits and withdrawals returns false")
    void alternatingDepositsAndWithdrawalsReturnsFalse() {
        assertFalse(solution.belowZero(Arrays.asList(1, -1, 2, -2, 5, -5, 4, -4)));
    }

    @Test
    @DisplayName("Balance dips below zero mid-sequence returns true")
    void balanceDipsBelowZeroMidSequenceReturnsTrue() {
        assertTrue(solution.belowZero(Arrays.asList(1, 2, -4, 5, 6)));
    }

    @Test
    @DisplayName("Balance goes below zero only on final operation returns true")
    void balanceBelowZeroOnFinalOperationReturnsTrue() {
        assertTrue(solution.belowZero(Arrays.asList(1, -1, 2, -2, 5, -5, 4, -5)));
    }

    @Test
    @DisplayName("Balance goes below zero early then recovers still returns true")
    void balanceBelowZeroEarlyThenRecoversReturnsTrue() {
        assertTrue(solution.belowZero(Arrays.asList(1, -2, 2, -2, 5, -5, 4, -4)));
    }

    @Test
    @DisplayName("Single negative operation from zero returns true")
    void singleNegativeOperationReturnsTrue() {
        assertTrue(solution.belowZero(Collections.singletonList(-1)));
    }

    @Test
    @DisplayName("Single zero operation returns false")
    void singleZeroOperationReturnsFalse() {
        assertFalse(solution.belowZero(Collections.singletonList(0)));
    }

    @Test
    @DisplayName("First operation drives balance negative returns true")
    void firstOperationNegativeReturnsTrue() {
        assertTrue(solution.belowZero(Arrays.asList(-5, 10, 20)));
    }
}
```
````

---

## Java/4 — improve, iteration 1

- **Task ID:** `Java/4`
- **Model:** Claude Opus 4.6 (1M context)
- **Timestamp:** 2026-04-18T20:01:34+03:00
- **Elapsed:** 36.41s

### Prompt

````
Improve this JUnit 6 test method.

Package: `humaneval.task_4`
Solution under test: `humaneval.claude.task_4.Solution`
Target class name: `ImprovedByClaudeTest`

Solution:
````java
package humaneval.claude.task_4;

import java.util.*;
import java.lang.*;

public class Solution {
    /**
    For a given list of input numbers, calculate Mean Absolute Deviation
    around the mean of this dataset.
    Mean Absolute Deviation is the average absolute difference between each
    element and a centerpoint (mean in this case):
    MAD = average | x - x_mean |
    >>> meanAbsoluteDeviation(Arrays.asList(1.0, 2.0, 3.0, 4.0))
    1.0
     */
    public double meanAbsoluteDeviation(List<Double> numbers) {
    double mean = 0.0;
    for (double n : numbers) {
        mean += n;
    }
    mean /= numbers.size();

    double sum = 0.0;
    for (double n : numbers) {
        sum += Math.abs(n - mean);
    }
    return sum / numbers.size();
}
}
````

Current test method:
````java
@Test
    void claude() {
        var s = new humaneval.claude.task_4.Solution();
        List<Boolean> correct = Arrays.asList(
                Math.abs(s.meanAbsoluteDeviation(new ArrayList<>(Arrays.asList(1.0, 2.0, 3.0))) - 2.0/3.0) < 1e-6,
                Math.abs(s.meanAbsoluteDeviation(new ArrayList<>(Arrays.asList(1.0, 2.0, 3.0, 4.0))) - 1.0) < 1e-6,
                Math.abs(s.meanAbsoluteDeviation(new ArrayList<>(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0))) - 6.0/5.0) < 1e-6
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    
    }
````

Test smells (JNose):
  - Unknown Test (line 8-20)
  - Conditional Test Logic (line 16-18)

Branches of the Solution not covered by the current test (JaCoCo):
  (all branches covered)

Output a single ```java ... ``` fenced block containing the complete
improved test class. No prose outside the fence.

````

### Response

````
```java
package humaneval.task_4;

import humaneval.claude.task_4.Solution;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ImprovedByClaudeTest {

    private static final double EPS = 1e-6;

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    @DisplayName("MAD of [1.0, 2.0, 3.0] equals 2/3")
    void madOfThreeConsecutiveIntegers() {
        double result = solution.meanAbsoluteDeviation(Arrays.asList(1.0, 2.0, 3.0));
        assertEquals(2.0 / 3.0, result, EPS);
    }

    @Test
    @DisplayName("MAD of [1.0, 2.0, 3.0, 4.0] equals 1.0 (docstring example)")
    void madOfFourConsecutiveIntegers() {
        double result = solution.meanAbsoluteDeviation(Arrays.asList(1.0, 2.0, 3.0, 4.0));
        assertEquals(1.0, result, EPS);
    }

    @Test
    @DisplayName("MAD of [1.0, 2.0, 3.0, 4.0, 5.0] equals 6/5")
    void madOfFiveConsecutiveIntegers() {
        double result = solution.meanAbsoluteDeviation(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0));
        assertEquals(6.0 / 5.0, result, EPS);
    }

    @Test
    @DisplayName("MAD of a single-element list is zero")
    void madOfSingletonIsZero() {
        double result = solution.meanAbsoluteDeviation(Collections.singletonList(42.0));
        assertEquals(0.0, result, EPS);
    }

    @Test
    @DisplayName("MAD of identical elements is zero")
    void madOfIdenticalElementsIsZero() {
        double result = solution.meanAbsoluteDeviation(Arrays.asList(7.0, 7.0, 7.0, 7.0));
        assertEquals(0.0, result, EPS);
    }

    @Test
    @DisplayName("MAD handles negative numbers")
    void madOfNegativeNumbers() {
        double result = solution.meanAbsoluteDeviation(Arrays.asList(-1.0, -2.0, -3.0, -4.0));
        assertEquals(1.0, result, EPS);
    }

    @Test
    @DisplayName("MAD handles mixed positive and negative numbers symmetric around zero")
    void madOfSymmetricRange() {
        double result = solution.meanAbsoluteDeviation(Arrays.asList(-2.0, -1.0, 1.0, 2.0));
        assertEquals(1.5, result, EPS);
    }

    @Test
    @DisplayName("MAD is translation-invariant: shifting all values by a constant does not change MAD")
    void madIsTranslationInvariant() {
        List<Double> base = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0);
        List<Double> shifted = Arrays.asList(101.0, 102.0, 103.0, 104.0, 105.0);
        assertEquals(
                solution.meanAbsoluteDeviation(base),
                solution.meanAbsoluteDeviation(shifted),
                EPS
        );
    }

    @Test
    @DisplayName("MAD scales linearly with uniform multiplication of all values")
    void madScalesLinearly() {
        List<Double> base = Arrays.asList(1.0, 2.0, 3.0, 4.0);
        List<Double> scaled = Arrays.asList(3.0, 6.0, 9.0, 12.0);
        assertEquals(
                3.0 * solution.meanAbsoluteDeviation(base),
                solution.meanAbsoluteDeviation(scaled),
                EPS
        );
    }

    @Test
    @DisplayName("MAD of two-element list equals half the absolute difference")
    void madOfTwoElements() {
        double result = solution.meanAbsoluteDeviation(Arrays.asList(10.0, 20.0));
        assertEquals(5.0, result, EPS);
    }

    @Test
    @DisplayName("MAD handles fractional values")
    void madOfFractionalValues() {
        double result = solution.meanAbsoluteDeviation(Arrays.asList(0.5, 1.5, 2.5, 3.5));
        assertEquals(1.0, result, EPS);
    }

    @ParameterizedTest(name = "MAD({0}) == {1}")
    @MethodSource("madCases")
    void madMatchesExpected(List<Double> input, double expected) {
        assertEquals(expected, solution.meanAbsoluteDeviation(input), EPS);
    }

    static Stream<Arguments> madCases() {
        return Stream.of(
                Arguments.of(Arrays.asList(1.0, 2.0, 3.0), 2.0 / 3.0),
                Arguments.of(Arrays.asList(1.0, 2.0, 3.0, 4.0), 1.0),
                Arguments.of(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0), 6.0 / 5.0),
                Arguments.of(Collections.singletonList(5.0), 0.0),
                Arguments.of(Arrays.asList(0.0, 0.0, 0.0), 0.0),
                Arguments.of(Arrays.asList(-5.0, 5.0), 5.0)
        );
    }
}
```
````

---

## Java/18 — improve, iteration 1

- **Task ID:** `Java/18`
- **Model:** Claude Opus 4.6 (1M context)
- **Timestamp:** 2026-04-18T20:01:50+03:00
- **Elapsed:** 15.67s

### Prompt

````
Improve this JUnit 6 test method.

Package: `humaneval.task_18`
Solution under test: `humaneval.claude.task_18.Solution`
Target class name: `ImprovedByClaudeTest`

Solution:
````java
package humaneval.claude.task_18;

import java.util.*;
import java.lang.*;

public class Solution {
    /**
    Find how many times a given substring can be found in the original string. Count overlaping cases.
    >>> howManyTimes("", "a")
    0
    >>> howManyTimes("aaa", "a")
    3
    >>> howManyTimes("aaaa", "aa")
    3
     */
    public int howManyTimes(String string, String substring) {
        if (substring.isEmpty()) return 0;
        int count = 0;
        for (int i = 0; i <= string.length() - substring.length(); i++) {
            if (string.startsWith(substring, i)) count++;
        }
        return count;
    }
}
````

Current test method:
````java
@Test
    void claude() {
        var s = new humaneval.claude.task_18.Solution();
        List<Boolean> correct = Arrays.asList(
                s.howManyTimes("", "x") == 0,
                s.howManyTimes("xyxyxyx", "x") == 4,
                s.howManyTimes("cacacacac", "cac") == 4,
                s.howManyTimes("john doe", "john") == 1
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    
    }
````

Test smells (JNose):
  - Unknown Test (line 8-21)
  - Conditional Test Logic (line 17-19)

Branches of the Solution not covered by the current test (JaCoCo):
  - line 17: 1 of 2 branches missed

Output a single ```java ... ``` fenced block containing the complete
improved test class. No prose outside the fence.

````

### Response

````
```java
package humaneval.task_18;

import humaneval.claude.task_18.Solution;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ImprovedByClaudeTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void emptyStringReturnsZero() {
        assertEquals(0, solution.howManyTimes("", "x"));
    }

    @Test
    void emptySubstringReturnsZero() {
        assertEquals(0, solution.howManyTimes("abc", ""));
    }

    @Test
    void bothEmptyReturnsZero() {
        assertEquals(0, solution.howManyTimes("", ""));
    }

    @Test
    void countsNonOverlappingSingleCharOccurrences() {
        assertEquals(4, solution.howManyTimes("xyxyxyx", "x"));
    }

    @Test
    void countsOverlappingOccurrences() {
        assertEquals(4, solution.howManyTimes("cacacacac", "cac"));
    }

    @Test
    void countsSingleWordOccurrence() {
        assertEquals(1, solution.howManyTimes("john doe", "john"));
    }

    @Test
    void returnsZeroWhenSubstringNotPresent() {
        assertEquals(0, solution.howManyTimes("hello world", "xyz"));
    }

    @Test
    void returnsZeroWhenSubstringLongerThanString() {
        assertEquals(0, solution.howManyTimes("ab", "abcd"));
    }

    @Test
    void countsWhenSubstringEqualsString() {
        assertEquals(1, solution.howManyTimes("abc", "abc"));
    }

    @Test
    void countsAllOverlappingPairs() {
        assertEquals(3, solution.howManyTimes("aaaa", "aa"));
    }

    @Test
    void countsAllSingleChars() {
        assertEquals(3, solution.howManyTimes("aaa", "a"));
    }
}
```
````

---

## Java/47 — improve, iteration 1

- **Task ID:** `Java/47`
- **Model:** Claude Opus 4.6 (1M context)
- **Timestamp:** 2026-04-18T20:02:11+03:00
- **Elapsed:** 21.14s

### Prompt

````
Improve this JUnit 6 test method.

Package: `humaneval.task_47`
Solution under test: `humaneval.claude.task_47.Solution`
Target class name: `ImprovedByClaudeTest`

Solution:
````java
package humaneval.claude.task_47;

import java.util.*;
import java.lang.*;

public class Solution {
    /**
    Return median of elements in the list l.
    >>> median(Arrays.asList(3, 1, 2, 4, 5))
    3
    >>> median(Arrays.asList(-10, 4, 6, 1000, 10, 20))
    15.0
     */
    public double median(List<Integer> l) {
        List<Integer> sorted = new ArrayList<>(l);
        Collections.sort(sorted);
        int n = sorted.size();
        if (n % 2 == 1) {
            return sorted.get(n / 2);
        } else {
            return (sorted.get(n / 2 - 1) + sorted.get(n / 2)) / 2.0;
        }
    }
}
````

Current test method:
````java
@Test
    void claude() {
        var s = new humaneval.claude.task_47.Solution();
        List<Boolean> correct = Arrays.asList(
                s.median(new ArrayList<>(Arrays.asList(3, 1, 2, 4, 5))) == 3,
                s.median(new ArrayList<>(Arrays.asList(-10, 4, 6, 1000, 10, 20))) == 8.0,
                s.median(new ArrayList<>(Arrays.asList(5))) == 5,
                s.median(new ArrayList<>(Arrays.asList(6, 5))) == 5.5
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    
    }
````

Test smells (JNose):
  - Unknown Test (line 8-21)
  - Conditional Test Logic (line 17-19)

Branches of the Solution not covered by the current test (JaCoCo):
  (all branches covered)

Output a single ```java ... ``` fenced block containing the complete
improved test class. No prose outside the fence.

````

### Response

````
```java
package humaneval.task_47;

import humaneval.claude.task_47.Solution;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ImprovedByClaudeTest {

    private final Solution solution = new Solution();

    @Test
    @DisplayName("median of odd-sized list returns the middle element")
    void medianOfOddSizedListReturnsMiddleElement() {
        assertEquals(3.0, solution.median(Arrays.asList(3, 1, 2, 4, 5)));
    }

    @Test
    @DisplayName("median of even-sized list returns average of two middle elements")
    void medianOfEvenSizedListReturnsAverageOfTwoMiddleElements() {
        assertEquals(8.0, solution.median(Arrays.asList(-10, 4, 6, 1000, 10, 20)));
    }

    @Test
    @DisplayName("median of single-element list returns that element")
    void medianOfSingleElementListReturnsThatElement() {
        assertEquals(5.0, solution.median(Arrays.asList(5)));
    }

    @Test
    @DisplayName("median of two-element list returns their average")
    void medianOfTwoElementListReturnsTheirAverage() {
        assertEquals(5.5, solution.median(Arrays.asList(6, 5)));
    }

    @Test
    @DisplayName("median of sorted list returns the middle element")
    void medianOfSortedListReturnsMiddleElement() {
        assertEquals(4.0, solution.median(Arrays.asList(1, 2, 3, 4, 5, 6, 7)));
    }

    @Test
    @DisplayName("median of list with all identical elements equals that element")
    void medianOfIdenticalElementsEqualsThatElement() {
        assertEquals(7.0, solution.median(Arrays.asList(7, 7, 7, 7, 7)));
    }

    @Test
    @DisplayName("median of all-negative list returns the middle value")
    void medianOfAllNegativeListReturnsMiddleValue() {
        assertEquals(-3.0, solution.median(Arrays.asList(-1, -2, -3, -4, -5)));
    }

    @Test
    @DisplayName("median of mixed-sign even list averages middle two")
    void medianOfMixedSignEvenListAveragesMiddleTwo() {
        assertEquals(0.5, solution.median(Arrays.asList(-3, -1, 2, 4)));
    }

    @Test
    @DisplayName("median where middle two sum is odd yields fractional result")
    void medianWithOddSumOfMiddleTwoYieldsFractionalResult() {
        assertEquals(2.5, solution.median(Arrays.asList(1, 2, 3, 4)));
    }

    @Test
    @DisplayName("median is independent of input order")
    void medianIsIndependentOfInputOrder() {
        List<Integer> unsorted = Arrays.asList(9, 3, 7, 1, 5);
        List<Integer> reversed = Arrays.asList(5, 1, 7, 3, 9);
        assertEquals(solution.median(unsorted), solution.median(reversed));
        assertEquals(5.0, solution.median(unsorted));
    }

    @Test
    @DisplayName("median does not mutate the input list")
    void medianDoesNotMutateInputList() {
        List<Integer> input = Arrays.asList(3, 1, 2, 4, 5);
        List<Integer> snapshot = new java.util.ArrayList<>(input);
        solution.median(input);
        assertEquals(snapshot, input);
    }

    @Test
    @DisplayName("median handles extreme integer values without overflow in average")
    void medianHandlesExtremeIntegerValues() {
        assertEquals(((double) Integer.MAX_VALUE + Integer.MIN_VALUE) / 2.0,
                solution.median(Arrays.asList(Integer.MIN_VALUE, Integer.MAX_VALUE)));
    }

    @Test
    @DisplayName("median of list containing zero is computed correctly")
    void medianOfListContainingZero() {
        assertEquals(0.0, solution.median(Arrays.asList(-2, -1, 0, 1, 2)));
    }

    @Test
    @DisplayName("median of duplicated values in even list")
    void medianOfDuplicatedValuesInEvenList() {
        assertEquals(3.0, solution.median(Arrays.asList(1, 3, 3, 5)));
    }

    @Test
    @DisplayName("median of reverse-sorted list matches sorted result")
    void medianOfReverseSortedList() {
        List<Integer> values = Arrays.asList(10, 8, 6, 4, 2);
        Collections.reverse(values);
        assertEquals(6.0, solution.median(values));
    }
}
```
````

---

## Java/66 — improve, iteration 1

- **Task ID:** `Java/66`
- **Model:** Claude Opus 4.6 (1M context)
- **Timestamp:** 2026-04-18T20:02:26+03:00
- **Elapsed:** 15.70s

### Prompt

````
Improve this JUnit 6 test method.

Package: `humaneval.task_66`
Solution under test: `humaneval.claude.task_66.Solution`
Target class name: `ImprovedByClaudeTest`

Solution:
````java
package humaneval.claude.task_66;

import java.util.*;
import java.lang.*;

public class Solution {
    /**
    Write a function that takes a string as input and returns the sum of the upper characters only'
    ASCII codes.

    Examples:
        digitSum("") => 0
        digitSum("abAB") => 131
        digitSum("abcCd") => 67
        digitSum("helloE") => 69
        digitSum("woArBld") => 131
        digitSum("aAaaaXa") => 153
     */
    public int digitSum(String s) {
        int sum = 0;
        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) {
                sum += (int) c;
            }
        }
        return sum;
    }
}
````

Current test method:
````java
@Test
    void claude() {
        var s = new humaneval.claude.task_66.Solution();
        List<Boolean> correct = Arrays.asList(
                s.digitSum("") == 0,
                s.digitSum("abAB") == 131,
                s.digitSum("abcCd") == 67,
                s.digitSum("helloE") == 69,
                s.digitSum("woArBld") == 131,
                s.digitSum("aAaaaXa") == 153,
                s.digitSum(" How are yOu?") == 151,
                s.digitSum("You arE Very Smart") == 327
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    
    }
````

Test smells (JNose):
  - Unknown Test (line 8-25)
  - Conditional Test Logic (line 21-23)

Branches of the Solution not covered by the current test (JaCoCo):
  (all branches covered)

Output a single ```java ... ``` fenced block containing the complete
improved test class. No prose outside the fence.

````

### Response

````
```java
package humaneval.task_66;

import humaneval.claude.task_66.Solution;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ImprovedByClaudeTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    @DisplayName("Empty string returns 0")
    void emptyStringReturnsZero() {
        assertEquals(0, solution.digitSum(""));
    }

    @Test
    @DisplayName("All lowercase string returns 0")
    void allLowercaseReturnsZero() {
        assertEquals(0, solution.digitSum("abcdef"));
    }

    @Test
    @DisplayName("Single uppercase character returns its ASCII code")
    void singleUppercaseReturnsAscii() {
        assertEquals(65, solution.digitSum("A"));
        assertEquals(90, solution.digitSum("Z"));
    }

    @Test
    @DisplayName("String with only uppercase letters sums all ASCII codes")
    void allUppercaseSumsAllAscii() {
        assertEquals(65 + 66 + 67, solution.digitSum("ABC"));
    }

    @Test
    @DisplayName("Digits and punctuation are ignored")
    void digitsAndPunctuationIgnored() {
        assertEquals(0, solution.digitSum("12345!?."));
        assertEquals(65, solution.digitSum("1A2?3"));
    }

    @Test
    @DisplayName("Whitespace characters are ignored")
    void whitespaceIgnored() {
        assertEquals(0, solution.digitSum("   \t\n"));
    }

    @ParameterizedTest(name = "digitSum(\"{0}\") == {1}")
    @CsvSource(delimiter = '|', value = {
            "''                  | 0",
            "abAB                | 131",
            "abcCd               | 67",
            "helloE              | 69",
            "woArBld             | 131",
            "aAaaaXa             | 153",
            "' How are yOu?'     | 151",
            "You arE Very Smart  | 327"
    })
    void specExamplesProduceExpectedSums(String input, int expected) {
        assertEquals(expected, solution.digitSum(input));
    }
}
```
````

---

## Java/76 — improve, iteration 1

- **Task ID:** `Java/76`
- **Model:** Claude Opus 4.6 (1M context)
- **Timestamp:** 2026-04-18T20:02:41+03:00
- **Elapsed:** 14.94s

### Prompt

````
Improve this JUnit 6 test method.

Package: `humaneval.task_76`
Solution under test: `humaneval.claude.task_76.Solution`
Target class name: `ImprovedByClaudeTest`

Solution:
````java
package humaneval.claude.task_76;

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
    if (x == 1) return true;
    if (n == 1) return false;
    int power = 1;
    while (power < x) {
        power *= n;
    }
    return power == x;
}
}
````

Current test method:
````java
@Test
    void claude() {
        var s = new humaneval.claude.task_76.Solution();
        List<Boolean> correct = Arrays.asList(
                s.isSimplePower(1, 4),
                s.isSimplePower(2, 2),
                s.isSimplePower(8, 2),
                !s.isSimplePower(3, 2),
                !s.isSimplePower(3, 1),
                !s.isSimplePower(5, 3),
                s.isSimplePower(16, 2),
                !s.isSimplePower(143214, 16),
                s.isSimplePower(4, 2),
                s.isSimplePower(9, 3),
                s.isSimplePower(16, 4),
                !s.isSimplePower(24, 2),
                !s.isSimplePower(128, 4),
                !s.isSimplePower(12, 6),
                s.isSimplePower(1, 1),
                s.isSimplePower(1, 12)
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    
    }
````

Test smells (JNose):
  - Unknown Test (line 8-33)
  - Conditional Test Logic (line 29-31)

Branches of the Solution not covered by the current test (JaCoCo):
  (all branches covered)

Output a single ```java ... ``` fenced block containing the complete
improved test class. No prose outside the fence.

````

### Response

````
```java
package humaneval.task_76;

import humaneval.claude.task_76.Solution;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ImprovedByClaudeTest {

    private final Solution solution = new Solution();

    @Test
    @DisplayName("1 is a simple power of any base")
    void oneIsSimplePowerOfAnyBase() {
        assertTrue(solution.isSimplePower(1, 4));
        assertTrue(solution.isSimplePower(1, 1));
        assertTrue(solution.isSimplePower(1, 12));
    }

    @Test
    @DisplayName("base itself is a simple power (n^1 = n)")
    void baseItselfIsSimplePower() {
        assertTrue(solution.isSimplePower(2, 2));
    }

    @Test
    @DisplayName("higher powers of 2 are detected")
    void higherPowersOfTwo() {
        assertTrue(solution.isSimplePower(4, 2));
        assertTrue(solution.isSimplePower(8, 2));
        assertTrue(solution.isSimplePower(16, 2));
    }

    @Test
    @DisplayName("powers of 3 and 4 are detected")
    void powersOfThreeAndFour() {
        assertTrue(solution.isSimplePower(9, 3));
        assertTrue(solution.isSimplePower(16, 4));
    }

    @Test
    @DisplayName("non-powers of 2 return false")
    void nonPowersOfTwo() {
        assertFalse(solution.isSimplePower(3, 2));
        assertFalse(solution.isSimplePower(24, 2));
    }

    @Test
    @DisplayName("values above any power of 1 other than 1 return false")
    void valuesGreaterThanOneAreNotPowersOfOne() {
        assertFalse(solution.isSimplePower(3, 1));
    }

    @Test
    @DisplayName("non-powers of 3, 4, and 6 return false")
    void nonPowersOfOtherBases() {
        assertFalse(solution.isSimplePower(5, 3));
        assertFalse(solution.isSimplePower(128, 4));
        assertFalse(solution.isSimplePower(12, 6));
    }

    @Test
    @DisplayName("large non-power of 16 returns false")
    void largeNonPowerOfSixteen() {
        assertFalse(solution.isSimplePower(143214, 16));
    }
}
```
````

---

## Java/86 — improve, iteration 1

- **Task ID:** `Java/86`
- **Model:** Claude Opus 4.6 (1M context)
- **Timestamp:** 2026-04-18T20:03:16+03:00
- **Elapsed:** 34.92s

### Prompt

````
Improve this JUnit 6 test method.

Package: `humaneval.task_86`
Solution under test: `humaneval.claude.task_86.Solution`
Target class name: `ImprovedByClaudeTest`

Solution:
````java
package humaneval.claude.task_86;

import java.util.*;
import java.lang.*;

public class Solution {
    /**
    Write a function that takes a string and returns an ordered version of it.
    Ordered version of string, is a string where all words (separated by space)
    are replaced by a new word where all the characters arranged in
    ascending order based on ascii value.
    Note: You should keep the order of words and blank spaces in the sentence.

    For example:
    antiShuffle("Hi") returns "Hi"
    antiShuffle("hello") returns "ehllo"
    antiShuffle("Hello World!!!") returns "Hello !!!Wdlor"
     */
    public String antiShuffle(String s) {
        String[] words = s.split(" ", -1);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            char[] chars = words[i].toCharArray();
            Arrays.sort(chars);
            result.append(chars);
            if (i < words.length - 1) result.append(" ");
        }
        return result.toString();
    }
}
````

Current test method:
````java
@Test
    void claude() {
        var s = new humaneval.claude.task_86.Solution();
        List<Boolean> correct = Arrays.asList(
                Objects.equals(s.antiShuffle("Hi"), "Hi"),
                Objects.equals(s.antiShuffle("hello"), "ehllo"),
                Objects.equals(s.antiShuffle("number"), "bemnru"),
                Objects.equals(s.antiShuffle("abcd"), "abcd"),
                Objects.equals(s.antiShuffle("Hello World!!!"), "Hello !!!Wdlor"),
                Objects.equals(s.antiShuffle(""), ""),
                Objects.equals(s.antiShuffle("Hi. My name is Mister Robot. How are you?"), ".Hi My aemn is Meirst .Rboot How aer ?ouy")
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    
    }
````

Test smells (JNose):
  - Unknown Test (line 8-24)
  - Conditional Test Logic (line 20-22)

Branches of the Solution not covered by the current test (JaCoCo):
  (all branches covered)

Output a single ```java ... ``` fenced block containing the complete
improved test class. No prose outside the fence.

````

### Response

````
```java
package humaneval.task_86;

import humaneval.claude.task_86.Solution;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ImprovedByClaudeTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    @DisplayName("empty string returns empty string")
    void emptyString() {
        assertEquals("", solution.antiShuffle(""));
    }

    @Test
    @DisplayName("single character is unchanged")
    void singleCharacter() {
        assertEquals("a", solution.antiShuffle("a"));
    }

    @Test
    @DisplayName("already-sorted single word is unchanged")
    void alreadySortedWord() {
        assertEquals("abcd", solution.antiShuffle("abcd"));
    }

    @Test
    @DisplayName("two-character word preserves its order when already sorted")
    void twoCharacterSortedWord() {
        assertEquals("Hi", solution.antiShuffle("Hi"));
    }

    @ParameterizedTest(name = "antiShuffle(\"{0}\") = \"{1}\"")
    @CsvSource(delimiter = '|', value = {
            "hello            | ehllo",
            "number           | bemnru",
            "world            | dlorw"
    })
    @DisplayName("single word is sorted by ASCII value")
    void singleWordIsSorted(String input, String expected) {
        assertEquals(expected, solution.antiShuffle(input));
    }

    @Test
    @DisplayName("uppercase letters sort before lowercase (ASCII order)")
    void asciiOrderingMixesCase() {
        assertEquals("Hello !!!Wdlor", solution.antiShuffle("Hello World!!!"));
    }

    @Test
    @DisplayName("punctuation is sorted along with letters by ASCII value")
    void punctuationIsSorted() {
        assertEquals(".Hi My aemn is Meirst .Rboot How aer ?ouy",
                solution.antiShuffle("Hi. My name is Mister Robot. How are you?"));
    }

    @Test
    @DisplayName("word order and single-space separators are preserved")
    void wordOrderPreserved() {
        assertEquals("abc def ghi", solution.antiShuffle("cba fed ihg"));
    }

    @Test
    @DisplayName("consecutive spaces produce empty sorted tokens, preserving spacing")
    void consecutiveSpacesPreserved() {
        assertEquals("abc  def", solution.antiShuffle("cba  fed"));
    }

    @Test
    @DisplayName("leading and trailing spaces are preserved")
    void leadingAndTrailingSpacesPreserved() {
        assertEquals(" abc def ", solution.antiShuffle(" cba fed "));
    }

    @Test
    @DisplayName("string containing only spaces is returned unchanged")
    void onlySpaces() {
        assertEquals("   ", solution.antiShuffle("   "));
    }

    @Test
    @DisplayName("digits are sorted by ASCII value within a word")
    void digitsAreSorted() {
        assertEquals("12345", solution.antiShuffle("53124"));
    }

    @Test
    @DisplayName("returned string has the same length as the input")
    void lengthIsPreserved() {
        String input = "The quick brown fox jumps over the lazy dog";
        assertEquals(input.length(), solution.antiShuffle(input).length());
    }
}
```
````

---

## Java/0 — improve, iteration 1

- **Task ID:** `Java/0`
- **Model:** Claude Opus 4.6 (1M context)
- **Timestamp:** 2026-04-18T20:03:46+03:00
- **Elapsed:** 29.62s

### Prompt

````
Improve this JUnit 6 test method.

Package: `humaneval.task_0`
Solution under test: `humaneval.claude.task_0.Solution`
Target class name: `ImprovedByClaudeTest`

Solution:
````java
package humaneval.claude.task_0;

import java.util.*;
import java.lang.*;

public class Solution {
    /**
    Check if in given list of numbers, are any two numbers closer to each other than given threshold.
    >>> hasCloseElements(Arrays.asList(1.0, 2.0, 3.0), 0.5)
    false
    >>> hasCloseElements(Arrays.asList(1.0, 2.8, 3.0, 4.0, 5.0, 2.0), 0.3)
    true
     */
    public boolean hasCloseElements(List<Double> numbers, double threshold) {
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = i + 1; j < numbers.size(); j++) {
                if (Math.abs(numbers.get(i) - numbers.get(j)) < threshold) {
                    return true;
                }
            }
        }
        return false;
    }
}
````

Current test method:
````java
@Test
    void claude() {
        var s = new humaneval.claude.task_0.Solution();
        List<Boolean> correct = Arrays.asList(
                s.hasCloseElements(new ArrayList<>(Arrays.asList(11.0, 2.0, 3.9, 4.0, 5.0, 2.2)), 0.3),
                !s.hasCloseElements(new ArrayList<>(Arrays.asList(1.0, 2.0, 3.9, 4.0, 5.0, 2.2)), 0.05),
                s.hasCloseElements(new ArrayList<>(Arrays.asList(1.0, 2.0, 5.9, 4.0, 5.0)), 0.95),
                !s.hasCloseElements(new ArrayList<>(Arrays.asList(1.0, 2.0, 5.9, 4.0, 5.0)), 0.8),
                s.hasCloseElements(new ArrayList<>(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0, 2.0)), 0.1),
                s.hasCloseElements(new ArrayList<>(Arrays.asList(1.1, 2.2, 3.1, 4.1, 5.1)), 1.0),
                !s.hasCloseElements(new ArrayList<>(Arrays.asList(1.1, 2.2, 3.1, 4.1, 5.1)), 0.5)
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    
    }
````

Test smells (JNose):
  - Unknown Test (line 8-24)
  - Conditional Test Logic (line 20-22)

Branches of the Solution not covered by the current test (JaCoCo):
  (all branches covered)

Output a single ```java ... ``` fenced block containing the complete
improved test class. No prose outside the fence.

````

### Response

````
```java
package humaneval.task_0;

import humaneval.claude.task_0.Solution;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ImprovedByClaudeTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Nested
    @DisplayName("when pairs are within the threshold")
    class CloseElementsPresent {

        @Test
        @DisplayName("returns true when a duplicate value exists and threshold is positive")
        void detectsDuplicateValuesAsClose() {
            assertTrue(solution.hasCloseElements(
                    Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0, 2.0), 0.1));
        }

        @Test
        @DisplayName("returns true when adjacent values differ by less than the threshold")
        void detectsNearbyValues() {
            assertTrue(solution.hasCloseElements(
                    Arrays.asList(11.0, 2.0, 3.9, 4.0, 5.0, 2.2), 0.3));
        }

        @Test
        @DisplayName("returns true when the gap equals just under a wider threshold")
        void detectsValuesWithinWideThreshold() {
            assertTrue(solution.hasCloseElements(
                    Arrays.asList(1.0, 2.0, 5.9, 4.0, 5.0), 0.95));
        }

        @Test
        @DisplayName("returns true when every consecutive pair is within threshold 1.0")
        void detectsEvenlySpacedValues() {
            assertTrue(solution.hasCloseElements(
                    Arrays.asList(1.1, 2.2, 3.1, 4.1, 5.1), 1.0));
        }

        @Test
        @DisplayName("returns true when only the last pair is close (exercises inner loop tail)")
        void detectsClosePairAtEnd() {
            assertTrue(solution.hasCloseElements(
                    Arrays.asList(10.0, 20.0, 30.0, 30.05), 0.1));
        }
    }

    @Nested
    @DisplayName("when no pair is within the threshold")
    class NoCloseElements {

        @Test
        @DisplayName("returns false when threshold is very small and values are distinct")
        void rejectsDistinctValuesWithTightThreshold() {
            assertFalse(solution.hasCloseElements(
                    Arrays.asList(1.0, 2.0, 3.9, 4.0, 5.0, 2.2), 0.05));
        }

        @Test
        @DisplayName("returns false when threshold is below minimum pairwise distance")
        void rejectsValuesBelowThreshold() {
            assertFalse(solution.hasCloseElements(
                    Arrays.asList(1.0, 2.0, 5.9, 4.0, 5.0), 0.8));
        }

        @Test
        @DisplayName("returns false when evenly spaced values exceed the threshold")
        void rejectsEvenlySpacedValues() {
            assertFalse(solution.hasCloseElements(
                    Arrays.asList(1.1, 2.2, 3.1, 4.1, 5.1), 0.5));
        }

        @Test
        @DisplayName("returns false for the strict-less-than comparison at the exact threshold")
        void rejectsDifferenceExactlyEqualToThreshold() {
            assertFalse(solution.hasCloseElements(
                    Arrays.asList(1.0, 2.0), 1.0));
        }
    }

    @Nested
    @DisplayName("edge cases")
    class EdgeCases {

        @Test
        @DisplayName("returns false for an empty list")
        void emptyListHasNoCloseElements() {
            assertFalse(solution.hasCloseElements(Collections.emptyList(), 1.0));
        }

        @Test
        @DisplayName("returns false for a single-element list")
        void singletonHasNoCloseElements() {
            assertFalse(solution.hasCloseElements(Collections.singletonList(42.0), 10.0));
        }

        @Test
        @DisplayName("returns false when threshold is zero and all values are distinct")
        void zeroThresholdWithDistinctValues() {
            assertFalse(solution.hasCloseElements(Arrays.asList(1.0, 2.0, 3.0), 0.0));
        }

        @Test
        @DisplayName("handles negative numbers using absolute distance")
        void handlesNegativeNumbers() {
            assertTrue(solution.hasCloseElements(
                    Arrays.asList(-5.0, -4.9, 10.0), 0.2));
        }
    }

    @ParameterizedTest(name = "[{index}] hasCloseElements({0}, {1}) == {2}")
    @MethodSource("humanEvalCases")
    @DisplayName("matches the original HumanEval expectations")
    void matchesHumanEvalExpectations(List<Double> numbers, double threshold, boolean expected) {
        if (expected) {
            assertTrue(solution.hasCloseElements(numbers, threshold));
        } else {
            assertFalse(solution.hasCloseElements(numbers, threshold));
        }
    }

    static Stream<Arguments> humanEvalCases() {
        return Stream.of(
                Arguments.of(Arrays.asList(11.0, 2.0, 3.9, 4.0, 5.0, 2.2), 0.3, true),
                Arguments.of(Arrays.asList(1.0, 2.0, 3.9, 4.0, 5.0, 2.2), 0.05, false),
                Arguments.of(Arrays.asList(1.0, 2.0, 5.9, 4.0, 5.0), 0.95, true),
                Arguments.of(Arrays.asList(1.0, 2.0, 5.9, 4.0, 5.0), 0.8, false),
                Arguments.of(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0, 2.0), 0.1, true),
                Arguments.of(Arrays.asList(1.1, 2.2, 3.1, 4.1, 5.1), 1.0, true),
                Arguments.of(Arrays.asList(1.1, 2.2, 3.1, 4.1, 5.1), 0.5, false)
        );
    }
}
```
````

---

## Java/9 — improve, iteration 1

- **Task ID:** `Java/9`
- **Model:** Claude Opus 4.6 (1M context)
- **Timestamp:** 2026-04-18T20:04:21+03:00
- **Elapsed:** 35.45s

### Prompt

````
Improve this JUnit 6 test method.

Package: `humaneval.task_9`
Solution under test: `humaneval.claude.task_9.Solution`
Target class name: `ImprovedByClaudeTest`

Solution:
````java
package humaneval.claude.task_9;

import java.util.*;
import java.lang.*;

public class Solution {
    /**
    From a given list of integers, generate a list of rolling maximum element found until given moment
    in the sequence.
    >>> rollingMax(Arrays.asList(1, 2, 3, 2, 3, 4, 2))
    [1, 2, 3, 3, 3, 4, 4]
     */
    public List<Integer> rollingMax(List<Integer> numbers) {
        List<Integer> result = new ArrayList<>();
        int currentMax = Integer.MIN_VALUE;
        for (int n : numbers) {
            if (n > currentMax) {
                currentMax = n;
            }
            result.add(currentMax);
        }
        return result;
    }
}
````

Current test method:
````java
@Test
    void claude() {
        var s = new humaneval.claude.task_9.Solution();
        List<Boolean> correct = Arrays.asList(
                s.rollingMax(new ArrayList<>(List.of())).equals(List.of()),
                s.rollingMax(new ArrayList<>(Arrays.asList(1, 2, 3, 4))).equals(Arrays.asList(1, 2, 3, 4)),
                s.rollingMax(new ArrayList<>(Arrays.asList(4, 3, 2, 1))).equals(Arrays.asList(4, 4, 4, 4)),
                s.rollingMax(new ArrayList<>(Arrays.asList(3, 2, 3, 100, 3))).equals(Arrays.asList(3, 3, 3, 100, 100))
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    
    }
````

Test smells (JNose):
  - Unknown Test (line 8-21)
  - Conditional Test Logic (line 17-19)

Branches of the Solution not covered by the current test (JaCoCo):
  (all branches covered)

Output a single ```java ... ``` fenced block containing the complete
improved test class. No prose outside the fence.

````

### Response

````
```java
package humaneval.task_9;

import humaneval.claude.task_9.Solution;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ImprovedByClaudeTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    @DisplayName("empty input returns empty list")
    void emptyInputReturnsEmptyList() {
        assertEquals(List.of(), solution.rollingMax(new ArrayList<>()));
    }

    @Test
    @DisplayName("strictly increasing sequence returns the same sequence")
    void strictlyIncreasingReturnsSame() {
        assertEquals(
                Arrays.asList(1, 2, 3, 4),
                solution.rollingMax(Arrays.asList(1, 2, 3, 4))
        );
    }

    @Test
    @DisplayName("strictly decreasing sequence returns the first element repeated")
    void strictlyDecreasingReturnsFirstRepeated() {
        assertEquals(
                Arrays.asList(4, 4, 4, 4),
                solution.rollingMax(Arrays.asList(4, 3, 2, 1))
        );
    }

    @Test
    @DisplayName("mixed sequence tracks running maximum correctly")
    void mixedSequenceTracksRunningMax() {
        assertEquals(
                Arrays.asList(3, 3, 3, 100, 100),
                solution.rollingMax(Arrays.asList(3, 2, 3, 100, 3))
        );
    }

    @Test
    @DisplayName("single element returns list containing that element")
    void singleElementReturnsSingletonList() {
        assertEquals(
                List.of(7),
                solution.rollingMax(List.of(7))
        );
    }

    @Test
    @DisplayName("all equal elements yields a constant sequence")
    void allEqualElementsYieldConstantSequence() {
        assertEquals(
                Arrays.asList(5, 5, 5, 5),
                solution.rollingMax(Arrays.asList(5, 5, 5, 5))
        );
    }

    @Test
    @DisplayName("handles negative numbers correctly")
    void handlesNegativeNumbers() {
        assertEquals(
                Arrays.asList(-5, -3, -3, -1, -1),
                solution.rollingMax(Arrays.asList(-5, -3, -4, -1, -2))
        );
    }

    @Test
    @DisplayName("handles mix of negative and positive numbers")
    void handlesNegativeAndPositiveNumbers() {
        assertEquals(
                Arrays.asList(-2, -1, 0, 0, 3, 3),
                solution.rollingMax(Arrays.asList(-2, -1, 0, -5, 3, 2))
        );
    }

    @Test
    @DisplayName("handles Integer.MIN_VALUE as the first element")
    void handlesIntegerMinValueAsFirstElement() {
        assertEquals(
                Arrays.asList(Integer.MIN_VALUE, 0, 0),
                solution.rollingMax(Arrays.asList(Integer.MIN_VALUE, 0, -10))
        );
    }

    @Test
    @DisplayName("handles Integer.MAX_VALUE anywhere in the sequence")
    void handlesIntegerMaxValue() {
        assertEquals(
                Arrays.asList(1, 1, Integer.MAX_VALUE, Integer.MAX_VALUE),
                solution.rollingMax(Arrays.asList(1, 1, Integer.MAX_VALUE, 42))
        );
    }

    @Test
    @DisplayName("plateau of the maximum stays at that maximum")
    void plateauOfMaximumStaysAtMaximum() {
        assertEquals(
                Arrays.asList(1, 3, 3, 3, 3, 2, 3, 3),
                solution.rollingMax(Arrays.asList(1, 3, 2, 3, 1, 2, 3, 3))
        );
    }

    @Test
    @DisplayName("result length always equals the input length")
    void resultLengthEqualsInputLength() {
        List<Integer> input = Arrays.asList(10, 20, 15, 25, 5, 30, 30, 1);
        List<Integer> result = solution.rollingMax(input);
        assertEquals(input.size(), result.size());
    }

    @Test
    @DisplayName("result is non-decreasing")
    void resultIsNonDecreasing() {
        List<Integer> input = Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5);
        List<Integer> result = solution.rollingMax(input);
        for (int i = 1; i < result.size(); i++) {
            assertTrue(
                    result.get(i) >= result.get(i - 1),
                    "rolling max must be non-decreasing at index " + i
            );
        }
    }

    @Test
    @DisplayName("final value equals the overall maximum of the input")
    void finalValueEqualsOverallMaximum() {
        List<Integer> input = Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5);
        List<Integer> result = solution.rollingMax(input);
        assertEquals(Collections.max(input), result.get(result.size() - 1));
    }

    @Test
    @DisplayName("each result element is the max of the input prefix up to that index")
    void eachElementIsMaxOfPrefix() {
        List<Integer> input = Arrays.asList(2, 7, 1, 7, 3, 8, 0);
        List<Integer> result = solution.rollingMax(input);
        for (int i = 0; i < input.size(); i++) {
            int expected = Collections.max(input.subList(0, i + 1));
            assertEquals(expected, result.get(i), "mismatch at index " + i);
        }
    }

    @Test
    @DisplayName("does not mutate the input list")
    void doesNotMutateInput() {
        List<Integer> input = new ArrayList<>(Arrays.asList(5, 3, 8, 1, 9, 2));
        List<Integer> snapshot = new ArrayList<>(input);
        solution.rollingMax(input);
        assertEquals(snapshot, input);
    }

    @Test
    @DisplayName("returns a new list instance distinct from the input")
    void returnsNewListInstance() {
        List<Integer> input = Arrays.asList(1, 2, 3);
        List<Integer> result = solution.rollingMax(input);
        assertNotSame(input, result);
    }

    @Nested
    @DisplayName("example from the specification")
    class SpecificationExample {

        @Test
        @DisplayName("rollingMax([1, 2, 3, 2, 3, 4, 2]) == [1, 2, 3, 3, 3, 4, 4]")
        void matchesDocstringExample() {
            assertEquals(
                    Arrays.asList(1, 2, 3, 3, 3, 4, 4),
                    solution.rollingMax(Arrays.asList(1, 2, 3, 2, 3, 4, 2))
            );
        }
    }
}
```
````

---

## Java/27 — improve, iteration 1

- **Task ID:** `Java/27`
- **Model:** Claude Opus 4.6 (1M context)
- **Timestamp:** 2026-04-18T20:04:36+03:00
- **Elapsed:** 14.78s

### Prompt

````
Improve this JUnit 6 test method.

Package: `humaneval.task_27`
Solution under test: `humaneval.claude.task_27.Solution`
Target class name: `ImprovedByClaudeTest`

Solution:
````java
package humaneval.claude.task_27;

import java.util.*;
import java.lang.*;

public class Solution {
    /**
    For a given string, flip lowercase characters to uppercase and uppercase to lowercase.
    >>> flipCase("Hello")
    "hELLO"
     */
    public String flipCase(String string) {
        StringBuilder result = new StringBuilder();
        for (char c : string.toCharArray()) {
            if (Character.isUpperCase(c)) {
                result.append(Character.toLowerCase(c));
            } else if (Character.isLowerCase(c)) {
                result.append(Character.toUpperCase(c));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}
````

Current test method:
````java
@Test
    void claude() {
        var s = new humaneval.claude.task_27.Solution();
        List<Boolean> correct = Arrays.asList(
                Objects.equals(s.flipCase(""), ""),
                Objects.equals(s.flipCase("Hello!"), "hELLO!"),
                Objects.equals(s.flipCase("These violent delights have violent ends"), "tHESE VIOLENT DELIGHTS HAVE VIOLENT ENDS")
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    
    }
````

Test smells (JNose):
  - Unknown Test (line 8-20)
  - Conditional Test Logic (line 16-18)

Branches of the Solution not covered by the current test (JaCoCo):
  (all branches covered)

Output a single ```java ... ``` fenced block containing the complete
improved test class. No prose outside the fence.

````

### Response

````
```java
package humaneval.task_27;

import humaneval.claude.task_27.Solution;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ImprovedByClaudeTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    @DisplayName("Empty string returns empty string")
    void flipCaseEmptyString() {
        assertEquals("", solution.flipCase(""));
    }

    @Test
    @DisplayName("Mixed case word with punctuation is flipped")
    void flipCaseMixedCaseWithPunctuation() {
        assertEquals("hELLO!", solution.flipCase("Hello!"));
    }

    @Test
    @DisplayName("Sentence with spaces has all letters flipped and spaces preserved")
    void flipCaseSentenceWithSpaces() {
        assertEquals(
                "tHESE VIOLENT DELIGHTS HAVE VIOLENT ENDS",
                solution.flipCase("These violent delights have violent ends")
        );
    }

    @Test
    @DisplayName("All lowercase becomes all uppercase")
    void flipCaseAllLowercase() {
        assertEquals("ABCXYZ", solution.flipCase("abcxyz"));
    }

    @Test
    @DisplayName("All uppercase becomes all lowercase")
    void flipCaseAllUppercase() {
        assertEquals("abcxyz", solution.flipCase("ABCXYZ"));
    }

    @Test
    @DisplayName("Digits and symbols are preserved unchanged")
    void flipCaseNonLetterCharactersUnchanged() {
        assertEquals("123 !@#_.", solution.flipCase("123 !@#_."));
    }

    @Test
    @DisplayName("Applying flipCase twice returns the original string (involution)")
    void flipCaseIsInvolution() {
        String original = "Hello, World! 42";
        assertEquals(original, solution.flipCase(solution.flipCase(original)));
    }

    @Test
    @DisplayName("Single lowercase character becomes uppercase")
    void flipCaseSingleLowercaseChar() {
        assertEquals("A", solution.flipCase("a"));
    }

    @Test
    @DisplayName("Single uppercase character becomes lowercase")
    void flipCaseSingleUppercaseChar() {
        assertEquals("a", solution.flipCase("A"));
    }

    @Test
    @DisplayName("Single non-letter character is preserved")
    void flipCaseSingleNonLetterChar() {
        assertEquals("5", solution.flipCase("5"));
    }
}
```
````

---

## Java/31 — improve, iteration 1

- **Task ID:** `Java/31`
- **Model:** Claude Opus 4.6 (1M context)
- **Timestamp:** 2026-04-18T20:05:04+03:00
- **Elapsed:** 27.70s

### Prompt

````
Improve this JUnit 6 test method.

Package: `humaneval.task_31`
Solution under test: `humaneval.claude.task_31.Solution`
Target class name: `ImprovedByClaudeTest`

Solution:
````java
package humaneval.claude.task_31;

import java.util.*;
import java.lang.*;

public class Solution {
    /**
    Return true if a given number is prime, and false otherwise.
    >>> isPrime(6)
    false
    >>> isPrime(101)
    true
    >>> isPrime(11)
    true
    >>> isPrime(13441)
    true
    >>> isPrime(61)
    true
    >>> isPrime(4)
    false
    >>> isPrime(1)
    false
     */
    public boolean isPrime(int n) {
        if (n < 2) return false;
        if (n < 4) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; (long) i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
````

Current test method:
````java
@Test
    void claude() {
        var s = new humaneval.claude.task_31.Solution();
        List<Boolean> correct = Arrays.asList(
                !s.isPrime(6),
                s.isPrime(101),
                s.isPrime(11),
                s.isPrime(13441),
                s.isPrime(61),
                !s.isPrime(4),
                !s.isPrime(1),
                s.isPrime(5),
                s.isPrime(11),
                s.isPrime(17),
                !s.isPrime(5 * 17),
                !s.isPrime(11 * 7),
                !s.isPrime(13441 * 19)
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    
    }
````

Test smells (JNose):
  - Unknown Test (line 8-30)
  - Conditional Test Logic (line 26-28)

Branches of the Solution not covered by the current test (JaCoCo):
  - line 26: 1 of 2 branches missed

Output a single ```java ... ``` fenced block containing the complete
improved test class. No prose outside the fence.

````

### Response

````
```java
package humaneval.task_31;

import humaneval.claude.task_31.Solution;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ImprovedByClaudeTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1})
    void returnsFalseForValuesBelowTwo(int n) {
        assertFalse(solution.isPrime(n));
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 3})
    void returnsTrueForSmallPrimesBelowFour(int n) {
        assertTrue(solution.isPrime(n));
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 6, 8, 100, 1000})
    void returnsFalseForEvenCompositesAtLeastFour(int n) {
        assertFalse(solution.isPrime(n));
    }

    @ParameterizedTest
    @ValueSource(ints = {9, 15, 25, 49, 77, 85, 121, 255379})
    void returnsFalseForOddComposites(int n) {
        assertFalse(solution.isPrime(n));
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 7, 11, 13, 17, 19, 61, 101, 13441})
    void returnsTrueForOddPrimes(int n) {
        assertTrue(solution.isPrime(n));
    }

    @Test
    void negativeNumberIsNotPrime() {
        assertFalse(solution.isPrime(-7));
    }
}
```
````

---

## Java/56 — improve, iteration 1

- **Task ID:** `Java/56`
- **Model:** Claude Opus 4.6 (1M context)
- **Timestamp:** 2026-04-18T20:05:32+03:00
- **Elapsed:** 27.62s

### Prompt

````
Improve this JUnit 6 test method.

Package: `humaneval.task_56`
Solution under test: `humaneval.claude.task_56.Solution`
Target class name: `ImprovedByClaudeTest`

Solution:
````java
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
````

Current test method:
````java
@Test
    void claude() {
        var s = new humaneval.claude.task_56.Solution();
        List<Boolean> correct = Arrays.asList(
                s.correctBracketing("<>"),
                s.correctBracketing("<<><>>"),
                s.correctBracketing("<><><<><>><>"),
                s.correctBracketing("<><><<<><><>><>><<><><<>>>"),
                !s.correctBracketing("<<<><>>>>"),
                !s.correctBracketing("><<>"),
                !s.correctBracketing("<"),
                !s.correctBracketing("<<<<"),
                !s.correctBracketing(">"),
                !s.correctBracketing("<<>"),
                !s.correctBracketing("<><><<><>><>><<>"),
                !s.correctBracketing("<><><<><>><>>><>")
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    
    }
````

Test smells (JNose):
  - Unknown Test (line 8-29)
  - Conditional Test Logic (line 25-27)

Branches of the Solution not covered by the current test (JaCoCo):
  - line 26: 1 of 2 branches missed

Output a single ```java ... ``` fenced block containing the complete
improved test class. No prose outside the fence.

````

### Response

````
```java
package humaneval.task_56;

import humaneval.claude.task_56.Solution;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ImprovedByClaudeTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void emptyStringIsBalanced() {
        assertTrue(solution.correctBracketing(""));
    }

    @Test
    void singleMatchedPairIsBalanced() {
        assertTrue(solution.correctBracketing("<>"));
    }

    @Test
    void singleOpeningBracketIsUnbalanced() {
        assertFalse(solution.correctBracketing("<"));
    }

    @Test
    void singleClosingBracketIsUnbalanced() {
        assertFalse(solution.correctBracketing(">"));
    }

    @Test
    void closingBeforeOpeningIsUnbalanced() {
        assertFalse(solution.correctBracketing("><<>"));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "<<><>>",
            "<><><<><>><>",
            "<><><<<><><>><>><<><><<>>>",
            "<<<><>>>",
            "<<<<>>>>"
    })
    void nestedAndSequentialBalancedStringsAreBalanced(String brackets) {
        assertTrue(solution.correctBracketing(brackets));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "<<<<",
            ">>>>",
            "<<>",
            "<>>",
            "<<<><>>>>",
            "<><><<><>><>><<>",
            "<><><<><>><>>><>"
    })
    void stringsWithMismatchedBracketsAreUnbalanced(String brackets) {
        assertFalse(solution.correctBracketing(brackets));
    }

    @Test
    void closingBracketDropsDepthBelowZeroEarly() {
        assertFalse(solution.correctBracketing("><><"));
    }

    @Test
    void excessOpeningBracketsLeaveDepthPositive() {
        assertFalse(solution.correctBracketing("<<>"));
    }
}
```
````

---

## Java/64 — improve, iteration 1

- **Task ID:** `Java/64`
- **Model:** Claude Opus 4.6 (1M context)
- **Timestamp:** 2026-04-18T20:05:50+03:00
- **Elapsed:** 18.08s

### Prompt

````
Improve this JUnit 6 test method.

Package: `humaneval.task_64`
Solution under test: `humaneval.claude.task_64.Solution`
Target class name: `ImprovedByClaudeTest`

Solution:
````java
package humaneval.claude.task_64;

import java.util.*;
import java.lang.*;

public class Solution {
    /**
    Write a function vowelsCount which takes a string representing
    a word as input and returns the number of vowels in the string.
    Vowels in this case are 'a', 'e', 'i', 'o', 'u'. Here, 'y' is also a
    vowel, but only when it is at the end of the given word.

    Example:
    >>> vowelsCount("abcde")
    2
    >>> vowelsCount("ACEDY")
    3
     */
    public int vowelsCount(String s) {
    int count = 0;
    String vowels = "aeiouAEIOU";
    for (int i = 0; i < s.length(); i++) {
        if (vowels.indexOf(s.charAt(i)) != -1) {
            count++;
        }
    }
    char last = s.charAt(s.length() - 1);
    if (last == 'y' || last == 'Y') {
        count++;
    }
    return count;
}
}
````

Current test method:
````java
@Test
    void claude() {
        var s = new humaneval.claude.task_64.Solution();
        List<Boolean> correct = Arrays.asList(
                s.vowelsCount("abcde") == 2,
                s.vowelsCount("Alone") == 3,
                s.vowelsCount("key") == 2,
                s.vowelsCount("bye") == 1,
                s.vowelsCount("keY") == 2,
                s.vowelsCount("bYe") == 1,
                s.vowelsCount("ACEDY") == 3
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    
    }
````

Test smells (JNose):
  - Unknown Test (line 8-24)
  - Conditional Test Logic (line 20-22)

Branches of the Solution not covered by the current test (JaCoCo):
  (all branches covered)

Output a single ```java ... ``` fenced block containing the complete
improved test class. No prose outside the fence.

````

### Response

````
```java
package humaneval.task_64;

import humaneval.claude.task_64.Solution;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ImprovedByClaudeTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @ParameterizedTest(name = "vowelsCount(\"{0}\") == {1}")
    @CsvSource({
            "abcde, 2",
            "Alone, 3",
            "key, 2",
            "bye, 1",
            "keY, 2",
            "bYe, 1",
            "ACEDY, 3"
    })
    @DisplayName("Counts standard vowels and trailing y across sample words")
    void countsVowelsForSampleWords(String input, int expected) {
        assertEquals(expected, solution.vowelsCount(input));
    }

    @ParameterizedTest(name = "vowelsCount(\"{0}\") == 1")
    @ValueSource(strings = {"a", "E", "i", "O", "u"})
    @DisplayName("Single-letter vowels count as one")
    void singleVowelLettersCountAsOne(String input) {
        assertEquals(1, solution.vowelsCount(input));
    }

    @Test
    @DisplayName("Standalone y at end counts as a vowel")
    void standaloneYCountsAsVowel() {
        assertEquals(1, solution.vowelsCount("y"));
        assertEquals(1, solution.vowelsCount("Y"));
    }

    @Test
    @DisplayName("Y only counts when it is the last character")
    void yOnlyCountsAtEnd() {
        assertEquals(1, solution.vowelsCount("yba"));
        assertEquals(1, solution.vowelsCount("Yba"));
    }

    @Test
    @DisplayName("Words without vowels return zero")
    void wordWithoutVowelsReturnsZero() {
        assertEquals(0, solution.vowelsCount("bcdfg"));
        assertEquals(0, solution.vowelsCount("BCDFG"));
    }

    @Test
    @DisplayName("Trailing y adds exactly one to the vowel count")
    void trailingYAddsOneToVowelCount() {
        assertEquals(3, solution.vowelsCount("easy"));
        assertEquals(4, solution.vowelsCount("EASILY"));
    }

    @Test
    @DisplayName("Counts every vowel occurrence in a long word")
    void countsEveryVowelInLongWord() {
        assertEquals(5, solution.vowelsCount("education"));
    }

    @Test
    @DisplayName("Uppercase vowels are counted the same as lowercase")
    void uppercaseVowelsCountedSameAsLowercase() {
        assertEquals(solution.vowelsCount("education"), solution.vowelsCount("EDUCATION"));
    }
}
```
````

---

## Java/87 — improve, iteration 1

- **Task ID:** `Java/87`
- **Model:** Claude Opus 4.6 (1M context)
- **Timestamp:** 2026-04-18T20:06:22+03:00
- **Elapsed:** 32.68s

### Prompt

````
Improve this JUnit 6 test method.

Package: `humaneval.task_87`
Solution under test: `humaneval.claude.task_87.Solution`
Target class name: `ImprovedByClaudeTest`

Solution:
````java
package humaneval.claude.task_87;

import java.util.*;
import java.lang.*;

public class Solution {
    /**
    You are given a 2 dimensional data, as a nested lists,
    which is similar to matrix, however, unlike matrices,
    each row may contain a different number of columns.
    Given lst, and integer x, find integers x in the list,
    and return list of lists, [[x1, y1], [x2, y2] ...] such that
    each list is a coordinate - (row, columns), starting with 0.
    Sort coordinates initially by rows in ascending order.
    Also, sort coordinates of the row by columns in descending order.

    Examples:
    getRow([
      [1,2,3,4,5,6],
      [1,2,3,4,1,6],
      [1,2,3,4,5,1]
    ], 1) == [[0, 0], [1, 4], [1, 0], [2, 5], [2, 0]]
    getRow([], 1) == []
    getRow([[], [1], [1, 2, 3]], 3) == [[2, 2]]
     */
    public List<List<Integer>> getRow(List<List<Integer>> lst, int x) {
    List<List<Integer>> result = new ArrayList<>();
    for (int i = 0; i < lst.size(); i++) {
        List<Integer> row = lst.get(i);
        for (int j = row.size() - 1; j >= 0; j--) {
            if (row.get(j) == x) {
                result.add(Arrays.asList(i, j));
            }
        }
    }
    return result;
}
}
````

Current test method:
````java
@Test
    void claude() {
        var s = new humaneval.claude.task_87.Solution();
        List<Boolean> correct = Arrays.asList(
                s.getRow(Arrays.asList(
                        Arrays.asList(1, 2, 3, 4, 5, 6),
                        Arrays.asList(1, 2, 3, 4, 1, 6),
                        Arrays.asList(1, 2, 3, 4, 5, 1)
                ), 1).equals(Arrays.asList(Arrays.asList(0, 0), Arrays.asList(1, 4), Arrays.asList(1, 0), Arrays.asList(2, 5), Arrays.asList(2, 0))),
                s.getRow(Arrays.asList(
                        Arrays.asList(1, 2, 3, 4, 5, 6),
                        Arrays.asList(1, 2, 3, 4, 5, 6),
                        Arrays.asList(1, 2, 3, 4, 5, 6),
                        Arrays.asList(1, 2, 3, 4, 5, 6),
                        Arrays.asList(1, 2, 3, 4, 5, 6),
                        Arrays.asList(1, 2, 3, 4, 5, 6)
                ), 2).equals(Arrays.asList(Arrays.asList(0, 1), Arrays.asList(1, 1), Arrays.asList(2, 1), Arrays.asList(3, 1), Arrays.asList(4, 1), Arrays.asList(5, 1))),
                s.getRow(Arrays.asList(
                        Arrays.asList(1, 2, 3, 4, 5, 6),
                        Arrays.asList(1, 2, 3, 4, 5, 6),
                        Arrays.asList(1, 1, 3, 4, 5, 6),
                        Arrays.asList(1, 2, 1, 4, 5, 6),
                        Arrays.asList(1, 2, 3, 1, 5, 6),
                        Arrays.asList(1, 2, 3, 4, 1, 6),
                        Arrays.asList(1, 2, 3, 4, 5, 1)
                ), 1).equals(Arrays.asList(Arrays.asList(0, 0), Arrays.asList(1, 0), Arrays.asList(2, 1), Arrays.asList(2, 0), Arrays.asList(3, 2), Arrays.asList(3, 0), Arrays.asList(4, 3), Arrays.asList(4, 0), Arrays.asList(5, 4), Arrays.asList(5, 0), Arrays.asList(6, 5), Arrays.asList(6, 0))),
                s.getRow(List.of(), 1).equals(List.of()),
                s.getRow(List.of(List.of(1)), 2).equals(List.of()),
                s.getRow(Arrays.asList(List.of(), List.of(1), Arrays.asList(1, 2, 3)), 3).equals(List.of(Arrays.asList(2, 2)))
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    
    }
````

Test smells (JNose):
  - Unknown Test (line 8-42)
  - Verbose Test (line 8-42)
  - Conditional Test Logic (line 38-40)

Branches of the Solution not covered by the current test (JaCoCo):
  (all branches covered)

Output a single ```java ... ``` fenced block containing the complete
improved test class. No prose outside the fence.

````

### Response

````
```java
package humaneval.task_87;

import humaneval.claude.task_87.Solution;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ImprovedByClaudeTest {

    private final Solution solution = new Solution();

    @Test
    void example1_findsOnesWithColumnsDescendingWithinRow() {
        List<List<Integer>> input = Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5, 6),
                Arrays.asList(1, 2, 3, 4, 1, 6),
                Arrays.asList(1, 2, 3, 4, 5, 1)
        );
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(0, 0),
                Arrays.asList(1, 4),
                Arrays.asList(1, 0),
                Arrays.asList(2, 5),
                Arrays.asList(2, 0)
        );
        assertEquals(expected, solution.getRow(input, 1));
    }

    @Test
    void example2_sameValueAtSameColumnAcrossAllRows() {
        List<List<Integer>> input = Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5, 6),
                Arrays.asList(1, 2, 3, 4, 5, 6),
                Arrays.asList(1, 2, 3, 4, 5, 6),
                Arrays.asList(1, 2, 3, 4, 5, 6),
                Arrays.asList(1, 2, 3, 4, 5, 6),
                Arrays.asList(1, 2, 3, 4, 5, 6)
        );
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(0, 1),
                Arrays.asList(1, 1),
                Arrays.asList(2, 1),
                Arrays.asList(3, 1),
                Arrays.asList(4, 1),
                Arrays.asList(5, 1)
        );
        assertEquals(expected, solution.getRow(input, 2));
    }

    @Test
    void example3_multipleMatchesPerRowDescendingColumns() {
        List<List<Integer>> input = Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5, 6),
                Arrays.asList(1, 2, 3, 4, 5, 6),
                Arrays.asList(1, 1, 3, 4, 5, 6),
                Arrays.asList(1, 2, 1, 4, 5, 6),
                Arrays.asList(1, 2, 3, 1, 5, 6),
                Arrays.asList(1, 2, 3, 4, 1, 6),
                Arrays.asList(1, 2, 3, 4, 5, 1)
        );
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(0, 0),
                Arrays.asList(1, 0),
                Arrays.asList(2, 1),
                Arrays.asList(2, 0),
                Arrays.asList(3, 2),
                Arrays.asList(3, 0),
                Arrays.asList(4, 3),
                Arrays.asList(4, 0),
                Arrays.asList(5, 4),
                Arrays.asList(5, 0),
                Arrays.asList(6, 5),
                Arrays.asList(6, 0)
        );
        assertEquals(expected, solution.getRow(input, 1));
    }

    @Test
    void emptyOuterListReturnsEmpty() {
        assertEquals(Collections.emptyList(), solution.getRow(List.of(), 1));
    }

    @Test
    void singleRowWithoutMatchReturnsEmpty() {
        assertEquals(Collections.emptyList(), solution.getRow(List.of(List.of(1)), 2));
    }

    @Test
    void raggedRowsWithEmptyRowAndSingletonRow() {
        List<List<Integer>> input = Arrays.asList(
                List.of(),
                List.of(1),
                Arrays.asList(1, 2, 3)
        );
        assertEquals(List.of(Arrays.asList(2, 2)), solution.getRow(input, 3));
    }

    @Test
    void noMatchInAnyRowReturnsEmpty() {
        List<List<Integer>> input = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6)
        );
        assertEquals(Collections.emptyList(), solution.getRow(input, 99));
    }

    @Test
    void repeatedValueInSingleRowOrderedByColumnDescending() {
        List<List<Integer>> input = List.of(Arrays.asList(7, 7, 7, 7));
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(0, 3),
                Arrays.asList(0, 2),
                Arrays.asList(0, 1),
                Arrays.asList(0, 0)
        );
        assertEquals(expected, solution.getRow(input, 7));
    }

    @Test
    void handlesNegativeTargetValue() {
        List<List<Integer>> input = Arrays.asList(
                Arrays.asList(-1, 0, -1),
                Arrays.asList(0, -1, 0)
        );
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(0, 2),
                Arrays.asList(0, 0),
                Arrays.asList(1, 1)
        );
        assertEquals(expected, solution.getRow(input, -1));
    }

    @Test
    void handlesLargeIntegerValues() {
        int target = Integer.MAX_VALUE;
        List<List<Integer>> input = Arrays.asList(
                Arrays.asList(target, 1, target),
                Arrays.asList(1, 2, 3)
        );
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(0, 2),
                Arrays.asList(0, 0)
        );
        assertEquals(expected, solution.getRow(input, target));
    }
}
```
````

---

## Java/156 — improve, iteration 1

- **Task ID:** `Java/156`
- **Model:** Claude Opus 4.6 (1M context)
- **Timestamp:** 2026-04-18T20:06:41+03:00
- **Elapsed:** 18.25s

### Prompt

````
Improve this JUnit 6 test method.

Package: `humaneval.task_156`
Solution under test: `humaneval.claude.task_156.Solution`
Target class name: `ImprovedByClaudeTest`

Solution:
````java
package humaneval.claude.task_156;

import java.util.*;
import java.lang.*;

public class Solution {
    /**
    Given a positive integer, obtain its roman numeral equivalent as a string,
    and return it in lowercase.
    Restrictions: 1 <= num <= 1000

    Examples:
    >>> intToMiniRoman(19) == "xix"
    >>> intToMiniRoman(152) == "clii"
    >>> intToMiniRoman(426) == "cdxxvi"
     */
    public String intToMiniRoman(int number) {
    int[] values =    {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] symbols = {"m", "cm", "d", "cd", "c", "xc", "l", "xl", "x", "ix", "v", "iv", "i"};
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < values.length; i++) {
        while (number >= values[i]) {
            number -= values[i];
            sb.append(symbols[i]);
        }
    }
    return sb.toString();
}
}
````

Current test method:
````java
@Test
    void claude() {
        var s = new humaneval.claude.task_156.Solution();
        List<Boolean> correct = Arrays.asList(
                Objects.equals(s.intToMiniRoman(19), "xix"),
                Objects.equals(s.intToMiniRoman(152), "clii"),
                Objects.equals(s.intToMiniRoman(251), "ccli"),
                Objects.equals(s.intToMiniRoman(426), "cdxxvi"),
                Objects.equals(s.intToMiniRoman(500), "d"),
                Objects.equals(s.intToMiniRoman(1), "i"),
                Objects.equals(s.intToMiniRoman(4), "iv"),
                Objects.equals(s.intToMiniRoman(43), "xliii"),
                Objects.equals(s.intToMiniRoman(90), "xc"),
                Objects.equals(s.intToMiniRoman(94), "xciv"),
                Objects.equals(s.intToMiniRoman(532), "dxxxii"),
                Objects.equals(s.intToMiniRoman(900), "cm"),
                Objects.equals(s.intToMiniRoman(994), "cmxciv"),
                Objects.equals(s.intToMiniRoman(1000), "m")
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    
    }
````

Test smells (JNose):
  - Unknown Test (line 8-31)
  - Conditional Test Logic (line 27-29)

Branches of the Solution not covered by the current test (JaCoCo):
  (all branches covered)

Output a single ```java ... ``` fenced block containing the complete
improved test class. No prose outside the fence.

````

### Response

````
```java
package humaneval.task_156;

import humaneval.claude.task_156.Solution;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ImprovedByClaudeTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @ParameterizedTest(name = "intToMiniRoman({0}) == \"{1}\"")
    @CsvSource({
            "1, i",
            "4, iv",
            "5, v",
            "9, ix",
            "10, x",
            "19, xix",
            "40, xl",
            "43, xliii",
            "50, l",
            "90, xc",
            "94, xciv",
            "100, c",
            "152, clii",
            "251, ccli",
            "400, cd",
            "426, cdxxvi",
            "500, d",
            "532, dxxxii",
            "900, cm",
            "994, cmxciv",
            "1000, m"
    })
    void convertsNumberToLowercaseRomanNumeral(int number, String expected) {
        assertEquals(expected, solution.intToMiniRoman(number));
    }
}
```
````

---

## Java/13 — improve, iteration 1

- **Task ID:** `Java/13`
- **Model:** Claude Opus 4.6 (1M context)
- **Timestamp:** 2026-04-18T20:06:54+03:00
- **Elapsed:** 13.54s

### Prompt

````
Improve this JUnit 6 test method.

Package: `humaneval.task_13`
Solution under test: `humaneval.claude.task_13.Solution`
Target class name: `ImprovedByClaudeTest`

Solution:
````java
package humaneval.claude.task_13;

import java.util.*;
import java.lang.*;

public class Solution {
    /**
    Return a greatest common divisor of two integers a and b
    >>> greatestCommonDivisor(3, 5)
    1
    >>> greatestCommonDivisor(25, 15)
    5
     */
    public int greatestCommonDivisor(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
````

Current test method:
````java
@Test
    void claude() {
        var s = new humaneval.claude.task_13.Solution();
        List<Boolean> correct = Arrays.asList(
                s.greatestCommonDivisor(3, 7) == 1,
                s.greatestCommonDivisor(10, 15) == 5,
                s.greatestCommonDivisor(49, 14) == 7,
                s.greatestCommonDivisor(144, 60) == 12
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    
    }
````

Test smells (JNose):
  - Unknown Test (line 8-21)
  - Conditional Test Logic (line 17-19)

Branches of the Solution not covered by the current test (JaCoCo):
  (all branches covered)

Output a single ```java ... ``` fenced block containing the complete
improved test class. No prose outside the fence.

````

### Response

````
```java
package humaneval.task_13;

import humaneval.claude.task_13.Solution;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ImprovedByClaudeTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    @DisplayName("GCD of coprime integers is 1")
    void gcdOfCoprimeIntegersIsOne() {
        assertEquals(1, solution.greatestCommonDivisor(3, 7));
    }

    @Test
    @DisplayName("GCD where smaller divides larger returns the smaller")
    void gcdWhereSmallerDividesLarger() {
        assertEquals(5, solution.greatestCommonDivisor(10, 15));
    }

    @Test
    @DisplayName("GCD of 49 and 14 is 7")
    void gcdOfFortyNineAndFourteen() {
        assertEquals(7, solution.greatestCommonDivisor(49, 14));
    }

    @Test
    @DisplayName("GCD of 144 and 60 is 12")
    void gcdOfOneHundredFortyFourAndSixty() {
        assertEquals(12, solution.greatestCommonDivisor(144, 60));
    }

    @Test
    @DisplayName("GCD with zero as second argument returns the first argument")
    void gcdWithZeroSecondArgument() {
        assertEquals(9, solution.greatestCommonDivisor(9, 0));
    }

    @Test
    @DisplayName("GCD with zero as first argument returns the second argument")
    void gcdWithZeroFirstArgument() {
        assertEquals(9, solution.greatestCommonDivisor(0, 9));
    }

    @Test
    @DisplayName("GCD of two equal numbers is the number itself")
    void gcdOfEqualNumbers() {
        assertEquals(8, solution.greatestCommonDivisor(8, 8));
    }

    @Test
    @DisplayName("GCD with one returns one")
    void gcdWithOneReturnsOne() {
        assertEquals(1, solution.greatestCommonDivisor(1, 17));
    }
}
```
````

---

## Java/19 — improve, iteration 1

- **Task ID:** `Java/19`
- **Model:** Claude Opus 4.6 (1M context)
- **Timestamp:** 2026-04-18T20:07:10+03:00
- **Elapsed:** 15.44s

### Prompt

````
Improve this JUnit 6 test method.

Package: `humaneval.task_19`
Solution under test: `humaneval.claude.task_19.Solution`
Target class name: `ImprovedByClaudeTest`

Solution:
````java
package humaneval.claude.task_19;

import java.util.*;
import java.lang.*;

public class Solution {
    /**
    Input is a space-delimited string of numberals from 'zero' to 'nine'.
    Valid choices are 'zero', 'one', 'two', 'three', 'four', 'five', 'six', 'seven', 'eight' and 'nine'.
    Return the string with numbers sorted from smallest to largest
    >>> sortNumbers("three one five")
    "one three five"
     */
    public String sortNumbers(String numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return "";
        }
        Map<String, Integer> wordToNum = Map.of(
            "zero", 0, "one", 1, "two", 2, "three", 3, "four", 4,
            "five", 5, "six", 6, "seven", 7, "eight", 8, "nine", 9
        );
        String[] parts = numbers.split(" ");
        Arrays.sort(parts, Comparator.comparingInt(wordToNum::get));
        return String.join(" ", parts);
    }
}
````

Current test method:
````java
@Test
    void claude() {
        var s = new humaneval.claude.task_19.Solution();
        List<Boolean> correct = Arrays.asList(
                s.sortNumbers("").equals(""),
                s.sortNumbers("three").equals("three"),
                s.sortNumbers("three five nine").equals("three five nine"),
                s.sortNumbers("five zero four seven nine eight").equals("zero four five seven eight nine")
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    
    }
````

Test smells (JNose):
  - Unknown Test (line 8-21)
  - Conditional Test Logic (line 17-19)

Branches of the Solution not covered by the current test (JaCoCo):
  - line 15: 1 of 4 branches missed

Output a single ```java ... ``` fenced block containing the complete
improved test class. No prose outside the fence.

````

### Response

````
```java
package humaneval.task_19;

import humaneval.claude.task_19.Solution;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ImprovedByClaudeTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    @DisplayName("Empty string returns empty string")
    void sortNumbers_emptyString_returnsEmpty() {
        assertEquals("", solution.sortNumbers(""));
    }

    @Test
    @DisplayName("Null input returns empty string")
    void sortNumbers_nullInput_returnsEmpty() {
        assertEquals("", solution.sortNumbers(null));
    }

    @Test
    @DisplayName("Single numeral returns itself")
    void sortNumbers_singleNumeral_returnsItself() {
        assertEquals("three", solution.sortNumbers("three"));
    }

    @Test
    @DisplayName("Already sorted input is unchanged")
    void sortNumbers_alreadySorted_unchanged() {
        assertEquals("three five nine", solution.sortNumbers("three five nine"));
    }

    @Test
    @DisplayName("Mixed numerals are sorted ascending")
    void sortNumbers_mixedOrder_sortedAscending() {
        assertEquals(
                "zero four five seven eight nine",
                solution.sortNumbers("five zero four seven nine eight")
        );
    }

    @Test
    @DisplayName("Reverse sorted input is reordered ascending")
    void sortNumbers_reverseSorted_sortedAscending() {
        assertEquals(
                "zero one two three four five six seven eight nine",
                solution.sortNumbers("nine eight seven six five four three two one zero")
        );
    }

    @Test
    @DisplayName("All ten numerals in arbitrary order")
    void sortNumbers_allTenNumerals_sortedAscending() {
        assertEquals(
                "zero one two three four five six seven eight nine",
                solution.sortNumbers("six two nine zero five one eight three seven four")
        );
    }

    @Test
    @DisplayName("Duplicate numerals preserved")
    void sortNumbers_duplicates_allPreserved() {
        assertEquals("one one two two three", solution.sortNumbers("two one three two one"));
    }

    @Test
    @DisplayName("Two numerals smallest first")
    void sortNumbers_twoNumerals_smallestFirst() {
        assertEquals("zero nine", solution.sortNumbers("nine zero"));
    }

    @Test
    @DisplayName("Result is non-null for valid input")
    void sortNumbers_validInput_isNonNull() {
        assertNotNull(solution.sortNumbers("one"));
    }
}
```
````

---

## Java/81 — improve, iteration 1

- **Task ID:** `Java/81`
- **Model:** Claude Opus 4.6 (1M context)
- **Timestamp:** 2026-04-18T20:08:06+03:00
- **Elapsed:** 56.23s

### Prompt

````
Improve this JUnit 6 test method.

Package: `humaneval.task_81`
Solution under test: `humaneval.claude.task_81.Solution`
Target class name: `ImprovedByClaudeTest`

Solution:
````java
package humaneval.claude.task_81;

import java.util.*;
import java.lang.*;

public class Solution {
    /**
    It is the last week of the semester and the teacher has to give the grades
    to students. The teacher has been making her own algorithm for grading.
    The only problem is, she has lost the code she used for grading.
    She has given you a list of GPAs for some students and you have to write
    a function that can output a list of letter grades using the following table:
             GPA       |    Letter grade
              4.0                A+
            > 3.7                A
            > 3.3                A-
            > 3.0                B+
            > 2.7                B
            > 2.3                B-
            > 2.0                C+
            > 1.7                C
            > 1.3                C-
            > 1.0                D+
            > 0.7                D
            > 0.0                D-
              0.0                E


    Example:
    numericalLetterGrade(Arrays.asList(4.0, 3, 1.7, 2, 3.5)) ==> ["A+", "B", "C-", "C", "A-"]
     */
    public List<String> numericalLetterGrade(List<Double> grades) {
    List<String> letterGrades = new ArrayList<>();
    for (Double gpa : grades) {
        if (gpa == 4.0) {
            letterGrades.add("A+");
        } else if (gpa > 3.7) {
            letterGrades.add("A");
        } else if (gpa > 3.3) {
            letterGrades.add("A-");
        } else if (gpa > 3.0) {
            letterGrades.add("B+");
        } else if (gpa > 2.7) {
            letterGrades.add("B");
        } else if (gpa > 2.3) {
            letterGrades.add("B-");
        } else if (gpa > 2.0) {
            letterGrades.add("C+");
        } else if (gpa > 1.7) {
            letterGrades.add("C");
        } else if (gpa > 1.3) {
            letterGrades.add("C-");
        } else if (gpa > 1.0) {
            letterGrades.add("D+");
        } else if (gpa > 0.7) {
            letterGrades.add("D");
        } else if (gpa > 0.0) {
            letterGrades.add("D-");
        } else {
            letterGrades.add("E");
        }
    }
    return letterGrades;
}
}
````

Current test method:
````java
@Test
    void claude() {
        var s = new humaneval.claude.task_81.Solution();
        List<Boolean> correct = Arrays.asList(
                s.numericalLetterGrade(new ArrayList<>(Arrays.asList(4.0, 3.0, 1.7, 2.0, 3.5))).equals(Arrays.asList("A+", "B", "C-", "C", "A-")),
                s.numericalLetterGrade(new ArrayList<>(List.of(1.2))).equals(List.of("D+")),
                s.numericalLetterGrade(new ArrayList<>(List.of(0.5))).equals(List.of("D-")),
                s.numericalLetterGrade(new ArrayList<>(List.of(0.0))).equals(List.of("E")),
                s.numericalLetterGrade(new ArrayList<>(Arrays.asList(1.0, 0.3, 1.5, 2.8, 3.3))).equals(Arrays.asList("D", "D-", "C-", "B", "B+")),
                s.numericalLetterGrade(new ArrayList<>(Arrays.asList(0.0, 0.7))).equals(Arrays.asList("E", "D-"))
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    
    }
````

Test smells (JNose):
  - Unknown Test (line 8-23)
  - Conditional Test Logic (line 19-21)

Branches of the Solution not covered by the current test (JaCoCo):
  - line 37: 1 of 2 branches missed
  - line 45: 1 of 2 branches missed
  - line 47: 1 of 2 branches missed

Output a single ```java ... ``` fenced block containing the complete
improved test class. No prose outside the fence.

````

### Response

````
```java
package humaneval.task_81;

import humaneval.claude.task_81.Solution;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ImprovedByClaudeTest {

    private final Solution solution = new Solution();

    @Test
    void exampleFromDocstring() {
        assertEquals(
                Arrays.asList("A+", "B", "C-", "C", "A-"),
                solution.numericalLetterGrade(Arrays.asList(4.0, 3.0, 1.7, 2.0, 3.5))
        );
    }

    @Test
    void aPlusAtExactlyFour() {
        assertEquals(List.of("A+"), solution.numericalLetterGrade(List.of(4.0)));
    }

    @Test
    void aAboveThreePointSeven() {
        assertEquals(List.of("A"), solution.numericalLetterGrade(List.of(3.8)));
    }

    @Test
    void aMinusAboveThreePointThree() {
        assertEquals(List.of("A-"), solution.numericalLetterGrade(List.of(3.5)));
    }

    @Test
    void bPlusAboveThree() {
        assertEquals(List.of("B+"), solution.numericalLetterGrade(List.of(3.1)));
    }

    @Test
    void bAboveTwoPointSeven() {
        assertEquals(List.of("B"), solution.numericalLetterGrade(List.of(2.8)));
    }

    @Test
    void bMinusAboveTwoPointThree() {
        assertEquals(List.of("B-"), solution.numericalLetterGrade(List.of(2.4)));
    }

    @Test
    void cPlusAboveTwo() {
        assertEquals(List.of("C+"), solution.numericalLetterGrade(List.of(2.1)));
    }

    @Test
    void cAboveOnePointSeven() {
        assertEquals(List.of("C"), solution.numericalLetterGrade(List.of(1.8)));
    }

    @Test
    void cMinusAboveOnePointThree() {
        assertEquals(List.of("C-"), solution.numericalLetterGrade(List.of(1.5)));
    }

    @Test
    void dPlusAboveOne() {
        assertEquals(List.of("D+"), solution.numericalLetterGrade(List.of(1.2)));
    }

    @Test
    void dAboveZeroPointSeven() {
        assertEquals(List.of("D"), solution.numericalLetterGrade(List.of(0.9)));
    }

    @Test
    void dMinusAboveZero() {
        assertEquals(List.of("D-"), solution.numericalLetterGrade(List.of(0.5)));
    }

    @Test
    void eAtZero() {
        assertEquals(List.of("E"), solution.numericalLetterGrade(List.of(0.0)));
    }

    @Test
    void boundaryValuesTakeLowerGrade() {
        assertEquals(
                Arrays.asList("B+", "B", "B-", "C+", "C", "C-", "D+", "D", "D-"),
                solution.numericalLetterGrade(Arrays.asList(3.3, 3.0, 2.7, 2.3, 2.0, 1.7, 1.3, 1.0, 0.7))
        );
    }

    @Test
    void everyGradeInOneCall() {
        assertEquals(
                Arrays.asList("A+", "A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D", "D-", "E"),
                solution.numericalLetterGrade(Arrays.asList(4.0, 3.8, 3.5, 3.1, 2.8, 2.4, 2.1, 1.8, 1.5, 1.2, 0.9, 0.5, 0.0))
        );
    }

    @Test
    void emptyInputReturnsEmpty() {
        assertEquals(Collections.emptyList(), solution.numericalLetterGrade(Collections.emptyList()));
    }
}
```
````

---

## Java/93 — improve, iteration 1

- **Task ID:** `Java/93`
- **Model:** Claude Opus 4.6 (1M context)
- **Timestamp:** 2026-04-18T20:08:24+03:00
- **Elapsed:** 17.96s

### Prompt

````
Improve this JUnit 6 test method.

Package: `humaneval.task_93`
Solution under test: `humaneval.claude.task_93.Solution`
Target class name: `ImprovedByClaudeTest`

Solution:
````java
package humaneval.claude.task_93;

import java.util.*;
import java.lang.*;

public class Solution {
    /**
    Write a function that takes a message, and encodes in such a
    way that it swaps case of all letters, replaces all vowels in
    the message with the letter that appears 2 places ahead of that
    vowel in the english alphabet.
    Assume only letters.

    Examples:
    >>> encode("test")
    "TGST"
    >>> encode("This is a message")
    "tHKS KS C MGSSCGG"
     */
    public String encode(String message) {
    StringBuilder result = new StringBuilder();
    String vowels = "aeiouAEIOU";
    for (char c : message.toCharArray()) {
        char swapped;
        if (Character.isUpperCase(c)) {
            swapped = Character.toLowerCase(c);
        } else if (Character.isLowerCase(c)) {
            swapped = Character.toUpperCase(c);
        } else {
            swapped = c;
        }
        if (vowels.indexOf(c) >= 0) {
            swapped = (char) (swapped + 2);
        }
        result.append(swapped);
    }
    return result.toString();
}
}
````

Current test method:
````java
@Test
    void claude() {
        var s = new humaneval.claude.task_93.Solution();
        List<Boolean> correct = Arrays.asList(
                Objects.equals(s.encode("TEST"), "tgst"),
                Objects.equals(s.encode("Mudasir"), "mWDCSKR"),
                Objects.equals(s.encode("YES"), "ygs"),
                Objects.equals(s.encode("This is a message"), "tHKS KS C MGSSCGG"),
                Objects.equals(s.encode("I DoNt KnOw WhAt tO WrItE"), "k dQnT kNqW wHcT Tq wRkTg")
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    
    }
````

Test smells (JNose):
  - Unknown Test (line 8-22)
  - Conditional Test Logic (line 18-20)

Branches of the Solution not covered by the current test (JaCoCo):
  (all branches covered)

Output a single ```java ... ``` fenced block containing the complete
improved test class. No prose outside the fence.

````

### Response

````
```java
package humaneval.task_93;

import humaneval.claude.task_93.Solution;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ImprovedByClaudeTest {

    private final Solution solution = new Solution();

    @Test
    @DisplayName("encodes all-uppercase input by lowercasing and shifting vowels by 2")
    void encodesAllUppercaseInput() {
        assertEquals("tgst", solution.encode("TEST"));
    }

    @Test
    @DisplayName("encodes mixed-case input swapping case and shifting vowels")
    void encodesMixedCaseInput() {
        assertEquals("mWDCSKR", solution.encode("Mudasir"));
    }

    @Test
    @DisplayName("encodes another all-uppercase input")
    void encodesAnotherAllUppercaseInput() {
        assertEquals("ygs", solution.encode("YES"));
    }

    @Test
    @DisplayName("encodes sentence with spaces preserving whitespace")
    void encodesSentenceWithSpaces() {
        assertEquals("tHKS KS C MGSSCGG", solution.encode("This is a message"));
    }

    @Test
    @DisplayName("encodes long mixed-case sentence with all vowel variants")
    void encodesLongMixedCaseSentence() {
        assertEquals("k dQnT kNqW wHcT Tq wRkTg", solution.encode("I DoNt KnOw WhAt tO WrItE"));
    }

    @Test
    @DisplayName("returns empty string for empty input")
    void returnsEmptyStringForEmptyInput() {
        assertEquals("", solution.encode(""));
    }

    @Test
    @DisplayName("shifts lowercase vowel a to uppercase C")
    void shiftsLowercaseVowelA() {
        assertEquals("C", solution.encode("a"));
    }

    @Test
    @DisplayName("shifts lowercase vowel e to uppercase G")
    void shiftsLowercaseVowelE() {
        assertEquals("G", solution.encode("e"));
    }

    @Test
    @DisplayName("shifts lowercase vowel i to uppercase K")
    void shiftsLowercaseVowelI() {
        assertEquals("K", solution.encode("i"));
    }

    @Test
    @DisplayName("shifts lowercase vowel o to uppercase Q")
    void shiftsLowercaseVowelO() {
        assertEquals("Q", solution.encode("o"));
    }

    @Test
    @DisplayName("shifts lowercase vowel u to uppercase W")
    void shiftsLowercaseVowelU() {
        assertEquals("W", solution.encode("u"));
    }

    @Test
    @DisplayName("shifts uppercase vowel A to lowercase c")
    void shiftsUppercaseVowelA() {
        assertEquals("c", solution.encode("A"));
    }

    @Test
    @DisplayName("shifts uppercase vowel E to lowercase g")
    void shiftsUppercaseVowelE() {
        assertEquals("g", solution.encode("E"));
    }

    @Test
    @DisplayName("shifts uppercase vowel I to lowercase k")
    void shiftsUppercaseVowelI() {
        assertEquals("k", solution.encode("I"));
    }

    @Test
    @DisplayName("shifts uppercase vowel O to lowercase q")
    void shiftsUppercaseVowelO() {
        assertEquals("q", solution.encode("O"));
    }

    @Test
    @DisplayName("shifts uppercase vowel U to lowercase w")
    void shiftsUppercaseVowelU() {
        assertEquals("w", solution.encode("U"));
    }

    @Test
    @DisplayName("swaps case of consonant without shifting")
    void swapsCaseOfLowercaseConsonant() {
        assertEquals("B", solution.encode("b"));
    }

    @Test
    @DisplayName("swaps case of uppercase consonant without shifting")
    void swapsCaseOfUppercaseConsonant() {
        assertEquals("z", solution.encode("Z"));
    }
}
```
````

---

## Java/124 — improve, iteration 1

- **Task ID:** `Java/124`
- **Model:** Claude Opus 4.6 (1M context)
- **Timestamp:** 2026-04-18T20:09:14+03:00
- **Elapsed:** 49.70s

### Prompt

````
Improve this JUnit 6 test method.

Package: `humaneval.task_124`
Solution under test: `humaneval.claude.task_124.Solution`
Target class name: `ImprovedByClaudeTest`

Solution:
````java
package humaneval.claude.task_124;

import java.util.*;
import java.lang.*;

public class Solution {
    /**
    You have to write a function which validates a given date string and
    returns true if the date is valid otherwise false.
    The date is valid if all of the following rules are satisfied:
    1. The date string is not empty.
    2. The number of days is not less than 1 or higher than 31 days for months 1,3,5,7,8,10,12. And the number of days is not less than 1 or higher than 30 days for months 4,6,9,11. And, the number of days is not less than 1 or higher than 29 for the month 2.
    3. The months should not be less than 1 or higher than 12.
    4. The date should be in the format: mm-dd-yyyy

    for example:
    validDate("03-11-2000") => true
    validDate("15-01-2012") => false
    validDate("04-0-2040") => false
    validDate("06-04-2020") => true
    validDate("06/04/2020") => false
     */
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
        int year = Integer.parseInt(parts[2]);

        if (month < 1 || month > 12) {
            return false;
        }
        if (day < 1) {
            return false;
        }
        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return day <= 31;
            case 4: case 6: case 9: case 11:
                return day <= 30;
            case 2:
                return day <= 29;
            default:
                return false;
        }
    }
}
````

Current test method:
````java
@Test
    void claude() {
        var s = new humaneval.claude.task_124.Solution();
        List<Boolean> correct = Arrays.asList(
                s.validDate("03-11-2000" ) == true,
                s.validDate("15-01-2012" ) == false,
                s.validDate("04-0-2040" ) == false,
                s.validDate("06-04-2020" ) == true,
                s.validDate("01-01-2007" ) == true,
                s.validDate("03-32-2011" ) == false,
                s.validDate("" ) == false,
                s.validDate("04-31-3000" ) == false,
                s.validDate("06-06-2005" ) == true,
                s.validDate("21-31-2000" ) == false,
                s.validDate("04-12-2003" ) == true,
                s.validDate("04122003" ) == false,
                s.validDate("20030412" ) == false,
                s.validDate("2003-04" ) == false,
                s.validDate("2003-04-12" ) == false,
                s.validDate("04-2003" ) == false
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    
    }
````

Test smells (JNose):
  - Unknown Test (line 8-33)
  - Conditional Test Logic (line 29-31)

Branches of the Solution not covered by the current test (JaCoCo):
  - line 24: 1 of 4 branches missed
  - line 35: 1 of 4 branches missed
  - line 38: 1 of 2 branches missed
  - line 41: 2 of 4 branches missed
  - line 47: 2 of 2 branches missed

Output a single ```java ... ``` fenced block containing the complete
improved test class. No prose outside the fence.

````

### Response

````
```java
package humaneval.task_124;

import humaneval.claude.task_124.Solution;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ImprovedByClaudeTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    @DisplayName("accepts a standard valid date in March")
    void acceptsValidMarchDate() {
        assertTrue(solution.validDate("03-11-2000"));
    }

    @Test
    @DisplayName("accepts a standard valid date in June")
    void acceptsValidJuneDate() {
        assertTrue(solution.validDate("06-04-2020"));
    }

    @Test
    @DisplayName("accepts first day of January")
    void acceptsFirstOfJanuary() {
        assertTrue(solution.validDate("01-01-2007"));
    }

    @Test
    @DisplayName("rejects null input")
    void rejectsNull() {
        assertFalse(solution.validDate(null));
    }

    @Test
    @DisplayName("rejects empty string")
    void rejectsEmptyString() {
        assertFalse(solution.validDate(""));
    }

    @Test
    @DisplayName("rejects slash delimiters instead of dashes")
    void rejectsSlashDelimiters() {
        assertFalse(solution.validDate("06/04/2020"));
    }

    @Test
    @DisplayName("rejects dates with no delimiters")
    void rejectsNoDelimiters() {
        assertFalse(solution.validDate("04122003"));
    }

    @Test
    @DisplayName("rejects compact yyyymmdd form")
    void rejectsCompactReverseForm() {
        assertFalse(solution.validDate("20030412"));
    }

    @Test
    @DisplayName("rejects date missing day component")
    void rejectsMissingDay() {
        assertFalse(solution.validDate("2003-04"));
    }

    @Test
    @DisplayName("rejects yyyy-mm-dd ordering")
    void rejectsYearFirstOrdering() {
        assertFalse(solution.validDate("2003-04-12"));
    }

    @Test
    @DisplayName("rejects date missing month component")
    void rejectsMissingMonth() {
        assertFalse(solution.validDate("04-2003"));
    }

    @Test
    @DisplayName("rejects non-digit characters in date parts")
    void rejectsNonDigitCharacters() {
        assertFalse(solution.validDate("aa-bb-cccc"));
    }

    @Test
    @DisplayName("rejects single-digit month/day form")
    void rejectsSingleDigitParts() {
        assertFalse(solution.validDate("4-12-2003"));
    }

    @Test
    @DisplayName("rejects month 0 as below valid range")
    void rejectsMonthZero() {
        assertFalse(solution.validDate("00-15-2020"));
    }

    @Test
    @DisplayName("rejects month 13 as above valid range")
    void rejectsMonthThirteen() {
        assertFalse(solution.validDate("13-10-2020"));
    }

    @Test
    @DisplayName("rejects month 15 as above valid range")
    void rejectsMonthFifteen() {
        assertFalse(solution.validDate("15-01-2012"));
    }

    @Test
    @DisplayName("rejects invalid month with invalid day")
    void rejectsInvalidMonthAndDay() {
        assertFalse(solution.validDate("21-31-2000"));
    }

    @Test
    @DisplayName("rejects day 0")
    void rejectsDayZero() {
        assertFalse(solution.validDate("04-0-2040"));
    }

    @Test
    @DisplayName("rejects day below 1 for valid month")
    void rejectsDayZeroForValidMonth() {
        assertFalse(solution.validDate("01-00-2020"));
    }

    @ParameterizedTest(name = "accepts day 31 for 31-day month: {0}")
    @ValueSource(strings = {
            "01-31-2020",
            "03-31-2020",
            "05-31-2020",
            "07-31-2020",
            "08-31-2020",
            "10-31-2020",
            "12-31-2020"
    })
    void accepts31ForLongMonths(String date) {
        assertTrue(solution.validDate(date));
    }

    @ParameterizedTest(name = "rejects day 32 for 31-day month: {0}")
    @ValueSource(strings = {
            "01-32-2020",
            "03-32-2011",
            "05-32-2020",
            "07-32-2020",
            "08-32-2020",
            "10-32-2020",
            "12-32-2020"
    })
    void rejects32ForLongMonths(String date) {
        assertFalse(solution.validDate(date));
    }

    @ParameterizedTest(name = "accepts day 30 for 30-day month: {0}")
    @ValueSource(strings = {
            "04-30-2020",
            "06-30-2020",
            "09-30-2020",
            "11-30-2020"
    })
    void accepts30For30DayMonths(String date) {
        assertTrue(solution.validDate(date));
    }

    @ParameterizedTest(name = "rejects day 31 for 30-day month: {0}")
    @ValueSource(strings = {
            "04-31-3000",
            "06-31-2020",
            "09-31-2020",
            "11-31-2020"
    })
    void rejects31For30DayMonths(String date) {
        assertFalse(solution.validDate(date));
    }

    @Test
    @DisplayName("February accepts day 29")
    void februaryAcceptsDay29() {
        assertTrue(solution.validDate("02-29-2020"));
    }

    @Test
    @DisplayName("February accepts day 1")
    void februaryAcceptsDay1() {
        assertTrue(solution.validDate("02-01-2020"));
    }

    @Test
    @DisplayName("February rejects day 30")
    void februaryRejectsDay30() {
        assertFalse(solution.validDate("02-30-2020"));
    }
}
```
````

---

## Java/129 — improve, iteration 1

- **Task ID:** `Java/129`
- **Model:** Claude Opus 4.6 (1M context)
- **Timestamp:** 2026-04-18T20:09:41+03:00
- **Elapsed:** 27.55s

### Prompt

````
Improve this JUnit 6 test method.

Package: `humaneval.task_129`
Solution under test: `humaneval.claude.task_129.Solution`
Target class name: `ImprovedByClaudeTest`

Solution:
````java
package humaneval.claude.task_129;

import java.util.*;
import java.lang.*;

public class Solution {
    /**
    Given a grid with N rows and N columns (N >= 2) and a positive integer k,
    each cell of the grid contains a value. Every integer in the range [1, N * N]
    inclusive appears exactly once on the cells of the grid.

    You have to find the minimum path of length k in the grid. You can start
    from any cell, and in each step you can move to any of the neighbor cells,
    in other words, you can go to cells which share an edge with you current
    cell.
    Please note that a path of length k means visiting exactly k cells (not
    necessarily distinct).
    You CANNOT go off the grid.
    A path A (of length k) is considered less than a path B (of length k) if
    after making the ordered lists of the values on the cells that A and B go
    through (let's call them lst_A and lst_B), lst_A is lexicographically less
    than lst_B, in other words, there exist an integer index i (1 <= i <= k)
    such that lst_A[i] < lst_B[i] and for any j (1 <= j < i) we have
    lst_A[j] = lst_B[j].
    It is guaranteed that the answer is unique.
    Return an ordered list of the values on the cells that the minimum path go through.

    Examples:

        Input: grid = [ [1,2,3], [4,5,6], [7,8,9]], k = 3
        Output: [1, 2, 1]

        Input: grid = [ [5,9,3], [4,1,6], [7,8,2]], k = 1
        Output: [1]
     */
    public List<Integer> minPath(List<List<Integer>> grid, int k) {
    int n = grid.size();
    int r = 0, c = 0;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (grid.get(i).get(j) == 1) {
                r = i;
                c = j;
            }
        }
    }

    int minNeighbor = Integer.MAX_VALUE;
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    for (int d = 0; d < 4; d++) {
        int nr = r + dr[d], nc = c + dc[d];
        if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
            minNeighbor = Math.min(minNeighbor, grid.get(nr).get(nc));
        }
    }

    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < k; i++) {
        result.add(i % 2 == 0 ? 1 : minNeighbor);
    }
    return result;
}
}
````

Current test method:
````java
@Test
    void claude() {
        var s = new humaneval.claude.task_129.Solution();
        List<Boolean> correct = Arrays.asList(
                s.minPath(Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), Arrays.asList(7, 8, 9)), 3).equals(Arrays.asList(1, 2, 1)),
                s.minPath(Arrays.asList(Arrays.asList(5, 9, 3), Arrays.asList(4, 1, 6), Arrays.asList(7, 8, 2)), 1).equals(List.of(1)),
                s.minPath(Arrays.asList(Arrays.asList(1, 2, 3, 4), Arrays.asList(5, 6, 7, 8), Arrays.asList(9, 10, 11, 12), Arrays.asList(13, 14, 15, 16)), 4).equals(Arrays.asList(1, 2, 1, 2)),
                s.minPath(Arrays.asList(Arrays.asList(6, 4, 13, 10), Arrays.asList(5, 7, 12, 1), Arrays.asList(3, 16, 11, 15), Arrays.asList(8, 14, 9, 2)), 7).equals(Arrays.asList(1, 10, 1, 10, 1, 10, 1)),
                s.minPath(Arrays.asList(Arrays.asList(8, 14, 9, 2), Arrays.asList(6, 4, 13, 15), Arrays.asList(5, 7, 1, 12), Arrays.asList(3, 10, 11, 16)), 5).equals(Arrays.asList(1, 7, 1, 7, 1)),
                s.minPath(Arrays.asList(Arrays.asList(11, 8, 7, 2), Arrays.asList(5, 16, 14, 4), Arrays.asList(9, 3, 15, 6), Arrays.asList(12, 13, 10, 1)), 9).equals(Arrays.asList(1, 6, 1, 6, 1, 6, 1, 6, 1)),
                s.minPath(Arrays.asList(Arrays.asList(12, 13, 10, 1), Arrays.asList(9, 3, 15, 6), Arrays.asList(5, 16, 14, 4), Arrays.asList(11, 8, 7, 2)), 12).equals(Arrays.asList(1, 6, 1, 6, 1, 6, 1, 6, 1, 6, 1, 6)),
                s.minPath(Arrays.asList(Arrays.asList(2, 7, 4), Arrays.asList(3, 1, 5), Arrays.asList(6, 8, 9)), 8).equals(Arrays.asList(1, 3, 1, 3, 1, 3, 1, 3)),
                s.minPath(Arrays.asList(Arrays.asList(6, 1, 5), Arrays.asList(3, 8, 9), Arrays.asList(2, 7, 4)), 8).equals(Arrays.asList(1, 5, 1, 5, 1, 5, 1, 5)),
                s.minPath(Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4)), 10).equals(Arrays.asList(1, 2, 1, 2, 1, 2, 1, 2, 1, 2)),
                s.minPath(Arrays.asList(Arrays.asList(1, 3), Arrays.asList(3, 2)), 10).equals(Arrays.asList(1, 3, 1, 3, 1, 3, 1, 3, 1, 3))
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    
    }
````

Test smells (JNose):
  - Unknown Test (line 8-28)
  - Conditional Test Logic (line 24-26)

Branches of the Solution not covered by the current test (JaCoCo):
  (all branches covered)

Output a single ```java ... ``` fenced block containing the complete
improved test class. No prose outside the fence.

````

### Response

````
```java
package humaneval.task_129;

import humaneval.claude.task_129.Solution;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ImprovedByClaudeTest {

    private final Solution solution = new Solution();

    @Test
    @DisplayName("3x3 sequential grid with k=3 returns [1,2,1]")
    void threeByThreeSequentialK3() {
        List<List<Integer>> grid = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9));
        assertEquals(Arrays.asList(1, 2, 1), solution.minPath(grid, 3));
    }

    @Test
    @DisplayName("Scrambled 3x3 grid with k=1 returns singleton [1]")
    void scrambled3x3K1() {
        List<List<Integer>> grid = Arrays.asList(
                Arrays.asList(5, 9, 3),
                Arrays.asList(4, 1, 6),
                Arrays.asList(7, 8, 2));
        assertEquals(List.of(1), solution.minPath(grid, 1));
    }

    @Test
    @DisplayName("4x4 sequential grid with k=4 alternates between 1 and its min neighbor 2")
    void fourByFourSequentialK4() {
        List<List<Integer>> grid = Arrays.asList(
                Arrays.asList(1, 2, 3, 4),
                Arrays.asList(5, 6, 7, 8),
                Arrays.asList(9, 10, 11, 12),
                Arrays.asList(13, 14, 15, 16));
        assertEquals(Arrays.asList(1, 2, 1, 2), solution.minPath(grid, 4));
    }

    @Test
    @DisplayName("4x4 scrambled grid with 1 on right edge; min neighbor is 10, k=7")
    void scrambled4x4MinNeighborTenK7() {
        List<List<Integer>> grid = Arrays.asList(
                Arrays.asList(6, 4, 13, 10),
                Arrays.asList(5, 7, 12, 1),
                Arrays.asList(3, 16, 11, 15),
                Arrays.asList(8, 14, 9, 2));
        assertEquals(Arrays.asList(1, 10, 1, 10, 1, 10, 1), solution.minPath(grid, 7));
    }

    @Test
    @DisplayName("4x4 scrambled grid with 1 in interior; min neighbor is 7, k=5")
    void scrambled4x4MinNeighborSevenK5() {
        List<List<Integer>> grid = Arrays.asList(
                Arrays.asList(8, 14, 9, 2),
                Arrays.asList(6, 4, 13, 15),
                Arrays.asList(5, 7, 1, 12),
                Arrays.asList(3, 10, 11, 16));
        assertEquals(Arrays.asList(1, 7, 1, 7, 1), solution.minPath(grid, 5));
    }

    @Test
    @DisplayName("4x4 scrambled grid with 1 in bottom-right corner; min neighbor is 6, k=9")
    void scrambled4x4BottomRightCornerK9() {
        List<List<Integer>> grid = Arrays.asList(
                Arrays.asList(11, 8, 7, 2),
                Arrays.asList(5, 16, 14, 4),
                Arrays.asList(9, 3, 15, 6),
                Arrays.asList(12, 13, 10, 1));
        assertEquals(Arrays.asList(1, 6, 1, 6, 1, 6, 1, 6, 1), solution.minPath(grid, 9));
    }

    @Test
    @DisplayName("4x4 scrambled grid with 1 in top-right corner; min neighbor is 6, k=12")
    void scrambled4x4TopRightCornerK12() {
        List<List<Integer>> grid = Arrays.asList(
                Arrays.asList(12, 13, 10, 1),
                Arrays.asList(9, 3, 15, 6),
                Arrays.asList(5, 16, 14, 4),
                Arrays.asList(11, 8, 7, 2));
        assertEquals(Arrays.asList(1, 6, 1, 6, 1, 6, 1, 6, 1, 6, 1, 6), solution.minPath(grid, 12));
    }

    @Test
    @DisplayName("3x3 grid with 1 at center; min neighbor is 3, even k=8")
    void threeByThreeCenterOneEvenK() {
        List<List<Integer>> grid = Arrays.asList(
                Arrays.asList(2, 7, 4),
                Arrays.asList(3, 1, 5),
                Arrays.asList(6, 8, 9));
        assertEquals(Arrays.asList(1, 3, 1, 3, 1, 3, 1, 3), solution.minPath(grid, 8));
    }

    @Test
    @DisplayName("3x3 grid with 1 on top edge; min neighbor is 5, even k=8")
    void threeByThreeTopEdgeOneEvenK() {
        List<List<Integer>> grid = Arrays.asList(
                Arrays.asList(6, 1, 5),
                Arrays.asList(3, 8, 9),
                Arrays.asList(2, 7, 4));
        assertEquals(Arrays.asList(1, 5, 1, 5, 1, 5, 1, 5), solution.minPath(grid, 8));
    }

    @Test
    @DisplayName("Minimum-size 2x2 grid with k=10 alternates [1,2]")
    void minimumSize2x2K10() {
        List<List<Integer>> grid = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(3, 4));
        assertEquals(Arrays.asList(1, 2, 1, 2, 1, 2, 1, 2, 1, 2), solution.minPath(grid, 10));
    }

    @Test
    @DisplayName("2x2 grid where min neighbor equals 3 (both neighbors are 3), k=10")
    void twoByTwoMinNeighborThreeK10() {
        List<List<Integer>> grid = Arrays.asList(
                Arrays.asList(1, 3),
                Arrays.asList(3, 2));
        assertEquals(Arrays.asList(1, 3, 1, 3, 1, 3, 1, 3, 1, 3), solution.minPath(grid, 10));
    }
}
```
````

---

## Java/160 — improve, iteration 1

- **Task ID:** `Java/160`
- **Model:** Claude Opus 4.6 (1M context)
- **Timestamp:** 2026-04-18T20:10:03+03:00
- **Elapsed:** 21.67s

### Prompt

````
Improve this JUnit 6 test method.

Package: `humaneval.task_160`
Solution under test: `humaneval.claude.task_160.Solution`
Target class name: `ImprovedByClaudeTest`

Solution:
````java
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
````

Current test method:
````java
@Test
    void claude() {
        var s = new humaneval.claude.task_160.Solution();
        List<Boolean> correct = Arrays.asList(
                s.doAlgebra(new ArrayList<>(Arrays.asList("**", "*", "+")), new ArrayList<>(Arrays.asList(2, 3, 4, 5))) == 37,
                s.doAlgebra(new ArrayList<>(Arrays.asList("+", "*", "-")), new ArrayList<>(Arrays.asList(2, 3, 4, 5))) == 9,
                s.doAlgebra(new ArrayList<>(Arrays.asList("/", "*")), new ArrayList<>(Arrays.asList(7, 3, 4))) == 8,
                s.doAlgebra(new ArrayList<>(Arrays.asList("+", "**", "**")), new ArrayList<>(Arrays.asList(7, 5, 3, 2))) == 1953132
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    
    }
````

Test smells (JNose):
  - Unknown Test (line 8-21)
  - Conditional Test Logic (line 17-19)

Branches of the Solution not covered by the current test (JaCoCo):
  (all branches covered)

Output a single ```java ... ``` fenced block containing the complete
improved test class. No prose outside the fence.

````

### Response

````
```java
package humaneval.task_160;

import humaneval.claude.task_160.Solution;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ImprovedByClaudeTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    @DisplayName("Evaluates expression with exponentiation, multiplication and addition: 2**3*4+5 = 37")
    void evaluatesExpressionWithExponentiationMultiplicationAndAddition() {
        int result = solution.doAlgebra(
                Arrays.asList("**", "*", "+"),
                Arrays.asList(2, 3, 4, 5));

        assertEquals(37, result);
    }

    @Test
    @DisplayName("Evaluates expression honoring operator precedence: 2+3*4-5 = 9")
    void evaluatesExpressionHonoringOperatorPrecedence() {
        int result = solution.doAlgebra(
                Arrays.asList("+", "*", "-"),
                Arrays.asList(2, 3, 4, 5));

        assertEquals(9, result);
    }

    @Test
    @DisplayName("Evaluates expression with floor division and multiplication left-to-right: 7/3*4 = 8")
    void evaluatesExpressionWithFloorDivisionAndMultiplication() {
        int result = solution.doAlgebra(
                Arrays.asList("/", "*"),
                Arrays.asList(7, 3, 4));

        assertEquals(8, result);
    }

    @Test
    @DisplayName("Evaluates right-associative chained exponentiation: 7 + 5**3**2 = 1953132")
    void evaluatesRightAssociativeChainedExponentiation() {
        int result = solution.doAlgebra(
                Arrays.asList("+", "**", "**"),
                Arrays.asList(7, 5, 3, 2));

        assertEquals(1953132, result);
    }

    @Test
    @DisplayName("Evaluates single-operator addition: 2 + 3 = 5")
    void evaluatesSingleOperatorAddition() {
        int result = solution.doAlgebra(
                List.of("+"),
                Arrays.asList(2, 3));

        assertEquals(5, result);
    }

    @Test
    @DisplayName("Evaluates single-operator subtraction producing negative result: 3 - 10 = -7")
    void evaluatesSingleOperatorSubtractionProducingNegativeResult() {
        int result = solution.doAlgebra(
                List.of("-"),
                Arrays.asList(3, 10));

        assertEquals(-7, result);
    }

    @Test
    @DisplayName("Floor division floors toward negative infinity when intermediate result is negative")
    void floorDivisionFloorsTowardNegativeInfinity() {
        int result = solution.doAlgebra(
                Arrays.asList("-", "/"),
                Arrays.asList(1, 10, 3));

        assertEquals(-3, result);
    }

    @Test
    @DisplayName("Evaluates expression containing a zero operand: 5 * 0 + 7 = 7")
    void evaluatesExpressionContainingZeroOperand() {
        int result = solution.doAlgebra(
                Arrays.asList("*", "+"),
                Arrays.asList(5, 0, 7));

        assertEquals(7, result);
    }

    @Test
    @DisplayName("Exponentiation to zero power yields 1: 2 + 5**0 = 3")
    void exponentiationToZeroPowerYieldsOne() {
        int result = solution.doAlgebra(
                Arrays.asList("+", "**"),
                Arrays.asList(2, 5, 0));

        assertEquals(3, result);
    }

    @Test
    @DisplayName("Does not mutate the caller's operator and operand lists")
    void doesNotMutateInputLists() {
        List<String> operators = Arrays.asList("+", "*", "-");
        List<Integer> operands = Arrays.asList(2, 3, 4, 5);
        List<String> operatorsCopy = List.copyOf(operators);
        List<Integer> operandsCopy = List.copyOf(operands);

        solution.doAlgebra(operators, operands);

        assertEquals(operatorsCopy, operators);
        assertEquals(operandsCopy, operands);
    }
}
```
````
