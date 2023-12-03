# gauge-parallel-example
Test for gauge parallel execution performance.
## purpose
- Gaugeの並列実行の仕組みを理解する
- Gaugeでテストケースの長さに応じて動的に実行対象を変更してくれるのかを調査する
  - by default, execution strategy is lazy so this is expected behavior
- gaugeのマルチスレッド機能の仕様を理解する
  - スレッドセーフなコード、そうでないコードを用意する
  - マルチスレッドとそうでない場合をそれぞれ検証する
## how to test
1. prepare 2 groups of scenarios
   1. So long thread sleeping code(e.g. Thread.sleep(10_000))
   2. Nothing but several so fast steps(e.g. println())
2. gauge run specs -n 2 --parallel
    - make sure to one group is occupied by so long scenario
## misc
### Run specs before parallel execution¶
- 並列実行する前に、特定のシナリオを直列実行してくれるらしい
  - `gauge run specs --parallel --only "parallelizable"`
- 確認すべきポイント
  - parallelizable が何を指すのか（おそらく並列実行したいシナリオのタグ）