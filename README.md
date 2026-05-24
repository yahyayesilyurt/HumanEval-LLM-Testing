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

1. Each prompt sent verbatim to **Claude Opus 4.6** → `logs/claude_log.md`
2. Same prompts sent verbatim to **GPT-5.4**  → `logs/gpt_log.md`
3. Code extracted (minimal changes were needed like adding a class around the code, no code body or semantics is changed) from the logs → `src/main/java/humaneval/{claude,gpt}/task_<N>/Solution.java`
4. Dataset's base tests ported to JUnit 6, one unified class per task → `src/test/java/humaneval/task_<N>/SolutionTest.java`
5. `mvn test` runs both LLMs side-by-side via `@Test claude()` and `@Test gpt()`

## Results — base tests

Originally, each `SolutionTest.java` file contained two base-test methods, one
for Claude and one for GPT, for **60 base-test methods total**. After Step 6,
mutation-driven black-box tests were appended to the same `SolutionTest.java`
files, so the current `SolutionTest`-only Maven run contains more than the
original base tests.

Current `mvn clean -Dtest='*SolutionTest' test` result:

`Tests run: 121, Failures: 0, Errors: 0`

JaCoCo coverage from that current `SolutionTest`-only run:

| Metric | Claude Opus 4.6 | GPT-5.4 |
|---|---:|---:|
| Instructions | 97.8% | 98.2% |
| Branches | 92.5% | 91.7% |
| Lines | 97.3% | 98.8% |
| Methods | 100% | 100% |
| Classes | 100% | 100% |

## Step 5 — Test Improvement

Each LLM was asked to improve its own base test method using the JNose smell report and the per-task JaCoCo branch-coverage gaps as inputs. Output: `ImprovedByClaudeTest.java` and `ImprovedByGptTest.java` per task, alongside the original `SolutionTest.java`.

Current full-suite result after Step 5 improvements, Step 6 mutation-driven
black-box tests, and Step 7 refactoring:

`mvn clean test` → **682 tests, 0 failures, 0 errors**.

Full-suite branch coverage is Claude **99.1%** and GPT **99.2%**.

### LLM test-authoring errors (6, all fixed)

The improved tests surfaced 6 assertions where the LLM wrote **incorrect expected values** — the Solution is correct, the test's expectation is wrong. We edited these in place (spec-allowed "minor modifications to base tests") and document them here because they are a real finding about LLMs as test authors.

| Task | Improver | Method | Error |
|---|---|---|---|
| Java/9 | Claude | `plateauOfMaximumStaysAtMaximum` | Expected `[1,3,3,3,3,2,3,3]` for `rollingMax`, which is impossible — rolling max is monotonically non-decreasing. |
| Java/120 | Claude | `handlesAllNegativeArray` | Expected top-2 of `[-5,-3,-1,-7,-2]` to be `[-3,-1]`; the actual top-2 largest are `[-2,-1]`. |
| Java/160 | Claude | `floorDivisionFloorsTowardNegativeInfinity` | Expected `1 - 10/3 = -3`. Python floors (`-3`), Java truncates (`-2`). Renamed to `integerDivisionTruncatesTowardZero`. |
| Java/160 | GPT | `integerDivisionAndZeroExponent` | Same Python-floor-vs-Java-truncation confusion. Renamed from `handlesFloorDivisionAndZeroExponent`. |
| Java/64 | GPT | `countsStandardVowelsCaseInsensitively` | `"AEon"` has 3 vowels (A,E,o), expected 2. |
| Java/64 | GPT | `countsYOnlyWhenItIsTheLastCharacter` | `"yellow"` was expected 0 but has 2 vowels (e,o); `"rhythm"` was expected 1 but has 0 vowels. LLM thought the function counts *only* y-at-end, ignoring standard a/e/i/o/u. |

Cross-LLM breakdown: **Claude 3 errors, GPT 3 errors**. The Python-vs-Java floor confusion appears in both LLMs independently, suggesting it stems from multi-language training rather than a model-specific quirk.

### Solution bugs uncovered by the improved tests and refactored in Step 7

| Task | LLM | Bug |
|---|---|---|
| Java/47 `median` | GPT | `(MAX_VALUE + MAX_VALUE) / 2` integer-overflowed, returning `-1` instead of the correct `MAX_VALUE`. The dataset's base tests never exercised extreme inputs; the improved test `avoidsIntegerOverflowWhenAveragingMiddleElements` exposed it. Fixed in Step 7 by averaging with `long` arithmetic before converting to `double`. |
| Java/64 `vowelsCount` | Claude | Step 6 empty-string testing exposed a `StringIndexOutOfBoundsException` caused by reading the last character of an empty string. Fixed in Step 7 by returning `0` for empty input; null input remains an expected `NullPointerException`. |
| Java/160 `doAlgebra` | Claude | Step 6 invalid-operator testing exposed missing validation. Fixed in Step 7 by validating operators before evaluation and throwing `IllegalArgumentException` for unsupported operators. |

This is the intended outcome of the later testing steps: LLM-improved tests and
black-box mutation tests found bugs that the benchmark's minimal base suite
missed, and Step 7 refactored the affected generated solutions.

### Coverage after Step 5

| Metric | Claude — before | Claude — after | GPT — before | GPT — after |
|---|---:|---:|---:|---:|
| Instructions | 97.8% | **99.9%** | 98.2% | **99.7%** |
| Branches | 92.5% | **99.1%** | 91.7% | **99.2%** |
| Lines | 97.3% | **99.7%** | 98.8% | **99.7%** |

The "before" columns are recomputed from the current `SolutionTest`-only suite,
which includes Step 6 additions appended to `SolutionTest.java`; they are not a
pure snapshot of the original 60 base-test methods.

# Phase 2 — Integration Testing (BookScan)

Extension (spec §1.2). `BookScan` is generated **by the LLM agents** (same
pinned Phase-1 models: Claude Opus 4.6, GPT-5.4). Its purpose: determine how
many times words of a given length appear in a text and on which lines,
reusing tasks **#18 `howManyTimes`**, **#23 `strlen`**, **#27 `flipCase`**.

## Two prompt approaches × two LLMs → 4 variants

| Variant | Prompt |
|---|---|
| `bookscan/<llm>/unmodified` | the three verbatim Phase-1 stub prompts combined + one framing line (no engineering) |
| `bookscan/<llm>/edited` | same dataset/doctest idiom, improved: explicit signatures + integration contract + edge cases |

Sources: `src/main/java/bookscan/{claude,gpt}/{unmodified,edited}/BookScan.java`.
Self-authored integration tests: `src/test/java/bookscan/.../BookScanIntegrationTest.java`
(each LLM tests its own variant; the test prompt applies the Phase-1
black-box methodology — equivalence-class partitioning, boundary-value
analysis, branch-coverage targeting). Every prompt, response and usage note is
in `logs/{claude,gpt}_log.md` (`## Phase2 BookScan` sections).

## Results

| Variant | Tests | Failing | Instr | Branch | Line | JNose smells |
|---|--:|--:|--:|--:|--:|--:|
| claude/unmodified | 47 | 2 | 100% | 100% | 100% | 51 (Magic Number) |
| claude/edited | 68 | 4 | 100% | 100% | 100% | 69 (Magic Number) |
| gpt/unmodified | 12 | 0 | 100% | 100% | 100% | 37 (Magic Number) |
| gpt/edited | 12 | 0 | 100% | 100% | 100% | 19 (Magic Number) |

Coverage measured with `mvn test -Dtest='BookScanIntegrationTest'
-Dmaven.test.failure.ignore=true` (a measurement flag — no code modified).
JNose-Test 0.8.6, all 21 detectors.

## Findings

- **Code-prompt comparison:** the *unmodified* prompt makes each LLM invent an
  incompatible API (Claude a stateless `scan`, GPT a stateful class with a
  `ScanResult` inner type); the *edited* prompt makes both converge on the
  specified contract. The edited prompt's only measurable effect is API
  conformance — under a strong test prompt, coverage saturates (100%)
  regardless of variant, so prompt-editing the **code** prompt does not
  improve coverage or correctness; the **test** prompt is the dominant lever.
- **LLM as test author:** Claude is thorough (115 tests) but ~5% of its
  oracles are wrong (miscounted word lengths); GPT is terse (24 tests) with
  **0%** oracle errors. Failing tests are kept exactly as generated and
  reported as the agent's test-generation error rate (spec: "success/error
  rates in test generation") — the BookScan code is correct in every failure.
- **Smells:** only *Magic Number Test* appears across all detectors — the
  generated suites are otherwise structurally clean.

Full analysis + tables: `analysis/phase2_bookscan_analysis.md`. Because the 6
agent oracle errors are intentionally not hand-fixed, plain `mvn clean test`
fails on them by design (they are evidence, not defects in the code).

## Changes from the Phase 1 report

The final report combines the Phase 1 submission with Phase 2 additions, per
the spec ("Prepare a final report by combining the first report with your
second report"). What was added or modified relative to the Phase 1 PDF
submitted to Ninova:

| | Phase 1 report | Final report |
|---|---|---|
| Abstract | Phase 1 only (30 tasks, base→improved tests, JaCoCo/JNose, three bugs) | Rewritten to cover both phases; adds BookScan, two prompt approaches, 100% Phase-2 coverage, agent oracle accuracy (0% GPT, 4.3–5.9% Claude), and the "test prompt is the dominant lever" finding |
| References | 5 papers | Same 5 papers (no Phase-2-only citations added) |
| Methodology | LLM Selection / Prompt Selection / Code Generation Process / Test Generation and Improvement Process | Unchanged |
| Experimental Results — Phase 1 subsections | Code Generation Results / Base Test Results / Branch Coverage Analysis / Test Smell Analysis / Black-Box EC / Refactoring | Unchanged |
| Experimental Results — **new Phase 2 subsections** | — | **BookScan Class Generation** (+ Table: Public API of the 4 variants), **Integration Tests with the Models**, **Integration Coverage Results** (+ Table: 4-variant coverage/test outcomes), **Integration Test Smells (JNose)** (+ Table: per-suite smell counts) |
| Discussion | Comparison of LLMs / Limitations | Comparison expanded to mention Phase 2; Limitations updated to note BookScan is a 5-method utility class (not industrial scale) and that the agent-as-test-author framework treats the agent's own assertions as ground truth |
| Conclusion | Phase 1 findings + future-validation note | Two new paragraphs: Phase 2 BookScan results (100% coverage, prompt-comparison finding, Claude vs GPT oracle accuracy) and two guidelines for integration testing (specify the integration contract in the prompt; develop test prompts in black-box terms) |

In short: Phase 1 content is preserved as-is; Phase 2 adds four
experimental-results subsections (with three tables), a BookScan-aware
abstract, and two new conclusion paragraphs.
