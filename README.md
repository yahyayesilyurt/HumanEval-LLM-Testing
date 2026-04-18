# HumanEval LLM Testing — BLG 475E

## How we picked the 30 prompts

### 1. Complexity analysis

For every one of the 164 tasks in the CodeGeeX HumanEval-X Java dataset we
compute four metrics on the canonical solution:

| Metric | Weight |
|---|---:|
| Cyclomatic complexity (McCabe) | 0.40 |
| Lines of code (comments stripped) | 0.25 |
| Maximum nesting depth | 0.20 |
| Branching factor (`if`/`for`/`while`/`switch`) | 0.15 |

Each metric is min-max normalised across all 164 tasks, then weighted into
a single composite score. Tasks are bucketed into four difficulty tiers by
quartile cut on the score: **Easy** (bottom 25%), **Medium** (25–50%),
**Hard** (50–75%), **Very Hard** (top 25%).

### 2. Balanced pull

From those four tiers we draw 30 prompts as **8 Easy / 7 Medium / 9 Hard /
6 Very Hard**, subject to:

- Tasks `Java/18`, `Java/23`, `Java/27` are forced in (required by Phase 2).
- Within each tier we prefer category diversity (string, math, list,
  parsing, 2D, sorting, recursion) over picking similar problems.
- One-line trivial canonical solutions in Easy are skipped where possible.
- Near-duplicate problems (e.g. two `sortArray` variants) are de-duplicated.

`★` marks the Phase 2 tasks.

| Tier | task_id | Method |
|---|---|---|
| Easy | `Java/14` | `allPrefixes` |
| Easy | `Java/16` | `countDistinctCharacters` |
| Easy | `Java/23` ★ | `strlen` |
| Easy | `Java/26` | `removeDuplicates` |
| Easy | `Java/49` | `modp` |
| Easy | `Java/57` | `monotonic` |
| Easy | `Java/100` | `makeAPile` |
| Easy | `Java/120` | `maximum` |
| Medium | `Java/3` | `belowZero` |
| Medium | `Java/4` | `meanAbsoluteDeviation` |
| Medium | `Java/18` ★ | `howManyTimes` |
| Medium | `Java/47` | `median` |
| Medium | `Java/66` | `digitSum` |
| Medium | `Java/76` | `isSimplePower` |
| Medium | `Java/86` | `antiShuffle` |
| Hard | `Java/0` | `hasCloseElements` |
| Hard | `Java/9` | `rollingMax` |
| Hard | `Java/13` | `greatestCommonDivisor` |
| Hard | `Java/27` ★ | `flipCase` |
| Hard | `Java/31` | `isPrime` |
| Hard | `Java/56` | `correctBracketing` |
| Hard | `Java/64` | `vowelsCount` |
| Hard | `Java/87` | `getRow` |
| Hard | `Java/156` | `intToMiniRoman` |
| Very Hard | `Java/19` | `sortNumbers` |
| Very Hard | `Java/81` | `numericalLetterGrade` |
| Very Hard | `Java/93` | `encode` |
| Very Hard | `Java/124` | `validDate` |
| Very Hard | `Java/129` | `minPath` |
| Very Hard | `Java/160` | `doAlgebra` |

## Pipeline

1. Each prompt sent verbatim to **Claude Opus 4.6** → `logs/claude.md`
2. Same prompts sent verbatim to **GPT-5.4**  → `logs/gpt.md`
3. Code extracted (minimal changes were needed like adding a class around the code, no code body or semantics is changed) from the logs → `src/main/java/humaneval/{claude,gpt}/task_<N>/Solution.java`
4. Dataset's base tests ported to JUnit 6, one unified class per task → `src/test/java/humaneval/task_<N>/SolutionTest.java`
5. `mvn test` runs both LLMs side-by-side via `@Test claude()` and `@Test gpt()`

## Results — base tests

`Tests run: 60, Failures: 0, Errors: 0` — both LLMs produced first-attempt-passing code on all 30 tasks.

JaCoCo coverage on the LLM-generated classes:

| Metric | Claude Opus 4.6 | GPT-5.4 |
|---|---:|---:|
| Instructions | 97.7% | 98.5% |
| Branches | 92.3% | 92.4% |
| Lines | 97.2% | 99.1% |
| Methods | 100% | 100% |
| Classes | 100% | 100% |

## Step 5 — Test Improvement

Each LLM was asked to improve its own base test method using the JNose smell report and the per-task JaCoCo branch-coverage gaps as inputs. Output: `ImprovedByClaudeTest.java` and `ImprovedByGptTest.java` per task, alongside the original `SolutionTest.java`.

Post-improvement: **621 tests, 1 failure**. Branch coverage jumped to Claude **99.0%** (the 2 uncovered branches are unreachable code in Claude's Solutions — a `switch` `default:` guarded out by a prior range check, and an `else if` fall-through unreachable for in-spec inputs) / GPT **100%**.

### LLM test-authoring errors (6, all fixed)

The improved tests surfaced 6 assertions where the LLM wrote **incorrect expected values** — the Solution is correct, the test's expectation is wrong. We edited these in place (spec-allowed "minor modifications to base tests") and document them here because they are a real finding about LLMs as test authors.

| Task | Improver | Method | Error |
|---|---|---|---|
| Java/9 | Claude | `plateauOfMaximumStaysAtMaximum` | Expected `[1,3,3,3,3,2,3,3]` for `rollingMax`, which is impossible — rolling max is monotonically non-decreasing. |
| Java/120 | Claude | `handlesAllNegativeArray` | Expected top-2 of `[-5,-3,-1,-7,-2]` to be `[-3,-1]`; the actual top-2 largest are `[-2,-1]`. |
| Java/160 | Claude | `floorDivisionFloorsTowardNegativeInfinity` | Expected `1 - 10/3 = -3`. Python floors (`-3`), Java truncates (`-2`). Renamed to `integerDivisionTruncatesTowardZero`. |
| Java/160 | GPT | `handlesFloorDivisionAndZeroExponent` | Same Python-floor-vs-Java-truncation confusion. |
| Java/64 | GPT | `countsStandardVowelsCaseInsensitively` | `"AEon"` has 3 vowels (A,E,o), expected 2. |
| Java/64 | GPT | `countsYOnlyWhenItIsTheLastCharacter` | `"yellow"` was expected 0 but has 2 vowels (e,o); `"rhythm"` was expected 1 but has 0 vowels. LLM thought the function counts *only* y-at-end, ignoring standard a/e/i/o/u. |

Cross-LLM breakdown: **Claude 3 errors, GPT 3 errors**. The Python-vs-Java floor confusion appears in both LLMs independently, suggesting it stems from multi-language training rather than a model-specific quirk.

### Solution bugs uncovered by the improved tests (1, pending Step 7)

| Task | LLM | Bug |
|---|---|---|
| Java/47 `median` | GPT | `(MAX_VALUE + MAX_VALUE) / 2` integer-overflows, returning `-1` instead of the correct `MAX_VALUE`. The dataset's base tests never exercised extreme inputs; the improved test `avoidsIntegerOverflowWhenAveragingMiddleElements` does. Queued for Step 7 (Refactoring). |

This is the intended outcome of Step 5: LLM-improved tests, driven by smell/coverage feedback, find real bugs that the benchmark's minimal base suite missed.

### Coverage after Step 5

| Metric | Claude — before | Claude — after | GPT — before | GPT — after |
|---|---:|---:|---:|---:|
| Instructions | 97.7% | **99.9%** | 98.5% | **100%** |
| Branches | 92.3% | **99.0%** | 92.4% | **100%** |
| Lines | 97.2% | **99.7%** | 99.1% | **100%** |
