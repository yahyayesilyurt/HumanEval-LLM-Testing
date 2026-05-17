# Phase 2 — BookScan Integration Testing Analysis

Extension: Integration Testing (spec §1.2). `BookScan` is generated **by the LLM
agents** (Claude Opus 4.6, GPT-5.4 — pinned to the Phase-1 models). Its purpose:
determine how many times words of a given length appear in a text and on which
lines they appear, reusing tasks #18 `howManyTimes`, #23 `strlen`, #27
`flipCase` from the Phase-1 dataset.

Two prompt approaches are compared, each sent to both LLMs (4 generations):

- **unmodified & combined** — the three verbatim Phase-1 HumanEval stub prompts
  for #18/#23/#27 concatenated, plus a single framing line stating they form
  one `BookScan` class with the word-length-scan purpose. No prompt engineering.
- **edited & combined** — the same task, rewritten in the *same dataset/stub
  idiom* (one `BookScan` class, `>>>` doctests) but improved: explicit
  signatures for all five methods, the integration contract
  (`wordsOfLength` / `countWordsOfLength`, 1-based lines, word = split on
  `\s+`, length via `strlen`), and edge cases stated in the class docstring.

Full prompts and every LLM interaction (prompt + response + usage note) are in
`logs/claude_log.md` and `logs/gpt_log.md` (sections beginning
`## Phase2 BookScan`). Generated sources:
`src/main/java/bookscan/<llm>/<variant>/BookScan.java`. Self-authored
integration tests: `src/test/java/bookscan/<llm>/<variant>/BookScanIntegrationTest.java`.

## 1. Generated code — qualitative comparison

| Aspect | claude/unmodified | claude/edited | gpt/unmodified | gpt/edited |
|---|---|---|---|---|
| Compiles | ✅ | ✅ | ✅ | ✅ |
| 3 required methods present | ✅ | ✅ | ✅ | ✅ |
| Integration feature | custom `scan(text,len) → Map<String,List<Integer>>` (word→lines) | spec contract | **stateful**: ctor `BookScan(String text)`, `ScanResult` inner class, `scanWordsOfLength(int)` | spec contract |
| Matches the asked contract | ❌ own API | ✅ | ❌ own API | ✅ |
| API surface | small | small | large (ctor + getters + `ScanResult`) | small |

The unmodified prompt let each model invent an **incompatible API** (Claude a
stateless word→lines map; GPT a stateful object with an inner result class).
The edited prompt made **both models converge on the exact specified
contract**. This is the central prompt-engineering finding: a lazy combined
prompt yields divergent, hard-to-integrate designs; a precise prompt yields a
uniform, testable one.

> Note: the first faithful unmodified run made Claude return an *unimplemented
> skeleton* (all method bodies empty). Adding "complete, fully-implemented …
> write a working body for every method" to the single framing line (stubs
> left verbatim) fixed it. This is itself a finding about minimal prompts.

## 2. Test effectiveness — same approaches as Phase 1

### 2.1 Coverage (JaCoCo) + agent test-generation results

The integration-test prompt explicitly applies the **Phase-1 black-box +
white-box methodology**: equivalence-class partitioning, boundary-value
analysis, and branch-coverage targeting (mirroring Phase 1 Steps 5–6).
Measured with `mvn test -Dtest='BookScanIntegrationTest'
-Dmaven.test.failure.ignore=true` (failure-ignore is a measurement flag so the
JaCoCo report still generates; no code is modified). Each suite is **self-
authored** by the same LLM that wrote the class, tests the class *as generated*.

| Variant | Tests | Failing | Pass rate | Instr | Branch | Line | Method |
|---|--:|--:|--:|--:|--:|--:|--:|
| claude/unmodified | 47 | 2 | 95.7% | 100% | 100% | 100% | 100% |
| claude/edited | 68 | 4 | 94.1% | 100% | 100% | 100% | 100% |
| gpt/unmodified | 12 | 0 | **100%** | 100% | 100% | 100% | 100% |
| gpt/edited | 12 | 0 | **100%** | 100% | 100% | 100% | 100% |

Findings:

1. **The EC/boundary/branch-coverage prompt drove every variant to 100%
   instruction, branch and line coverage** (vs 91–99% with the earlier
   informal edge-case prompt). This is the headline test-effectiveness
   result: instructing the agent in Phase-1 black-box terms — not just "cover
   edge cases" — yields complete branch coverage for *all four* variants
   regardless of LLM or prompt variant.
2. Because coverage is now saturated for all, the **prompt-variant difference
   no longer shows in coverage** — it shows in code design (§1: unmodified
   produces non-contract APIs) and in test-oracle accuracy. A coverage/EC-
   driven test prompt equalizes coverage; prompt quality differentiates the
   *code*, not the test thoroughness.
3. **Claude: verbose but error-prone test author** — 47 / 68 tests vs GPT's
   12 / 12, but with failing oracles. **GPT: terse but precise** — both GPT
   suites are fully green.

Agent test-generation error rate (wrong oracles / tests):
Claude unmodified 2/47 (4.3%), Claude edited 4/68 (5.9%),
GPT unmodified 0/12 (0%), GPT edited 0/12 (0%). Failing tests are agent
oracle errors, not code bugs; per the spec's "success/error rates in test
generation" they are **kept as generated and reported as the error rate**,
not hand-corrected.

### 2.2 Test smells (JNose)

JNose-Test 0.8.6 (`br.ufba.jnose`, same tool as Phase 1) was run over the four
`BookScanIntegrationTest` suites with all 21 detectors enabled and
`maxStatements=30`. Raw output: `analysis/phase2_jnose_smells.csv`.

| Variant | Tests | Total smells | Smells/test | Breakdown |
|---|--:|--:|--:|---|
| claude/unmodified | 47 | 51 | 1.1 | 51 Magic Number Test |
| claude/edited | 68 | 69 | 1.0 | 69 Magic Number Test |
| gpt/unmodified | 12 | 37 | 3.1 | 37 Magic Number Test |
| gpt/edited | 12 | **19** | **1.6** | 19 Magic Number Test |

Findings:

1. **Magic Number Test is the only smell detected** — across all 21 detectors,
   the EC/boundary-driven suites contain *exclusively* Magic Number Test
   (hard-coded expected literals). Zero Assertion Roulette, Eager Test,
   Conditional Logic, Verbose Test, etc. — the generated suites are
   structurally clean; the single weakness is un-named test data.
2. **GPT is the most literal-dense per test** (3.1 / 1.6 smells per test) but
   writes far fewer tests; Claude spreads literals over many small tests
   (~1.0 per test). Absolute smell count tracks verbosity (Claude 47/68
   tests) but per-test density favours Claude.
3. The EC/boundary/branch-coverage prompt did **not** introduce structural
   smells while pushing coverage to 100% — coverage gains came without
   test-smell regressions (only magic numbers, unchanged in kind from the
   earlier prompt).

## 3. Summary

| Question | Answer |
|---|---|
| Does editing the *code* prompt help? | Yes — unmodified yields non-contract APIs (Claude stateless `scan`, GPT stateful `ScanResult`); edited makes both contract-compliant (0/2 vs 2/2). |
| Does the EC/coverage *test* prompt help? | Decisively — all 4 variants reach **100% instruction/branch/line** coverage vs 91–99% under an informal "cover edge cases" prompt. The Phase-1 black-box framing is what unlocks full coverage. |
| Which LLM writes better tests? | GPT — terse (12 tests) but **0% oracle error**; Claude thorough (47/68 tests) but 4.3–5.9% oracle-error rate. |
| Test smells | Only Magic Number Test appears anywhere; suites are otherwise structurally clean. Coverage gains introduced no new smells. |
| Failure mode of integration-testing this class | Never the code's coverage (saturable) — it is the *agent's test oracles* (miscounted word lengths), which we report as an error rate rather than fix. |
