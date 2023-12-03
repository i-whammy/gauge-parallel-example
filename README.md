# gauge-parallel-example
Test for gauge parallel execution performance.
## purpose
- Gaugeの並列実行の仕組みを理解する
- Gaugeでテストケースの長さに応じて動的に実行対象を変更してくれるのかを調査する
- gaugeのマルチスレッド機能の仕様を理解する
  - スレッドセーフなコード、そうでないコードを用意する
  - マルチスレッドとそうでない場合をそれぞれ検証する
## misc
### Run specs before parallel execution¶
- 並列実行する前に、特定のシナリオを直列実行してくれるらしい
  - `gauge run specs --parallel --only "parallelizable"`
- 確認すべきポイント
  - parallelizable が何を指すのか（おそらく並列実行したいシナリオのタグ）