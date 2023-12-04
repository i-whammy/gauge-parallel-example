# gauge-parallel-example
Test for gauge parallel execution performance.
## case 1: default parallel behavior
- when you run the following, you can run the tests in N number of parallel streams.
  - gauge run --parallel -n N specs
- the specs are dynamically separated into N streams.(mode = Lazy)

## case 1-b: default parallel behavior with multi-threads
- when you set enable_multithreading variable in properties file as true, you can execute the tests with multi threads
- the specs are dynamically separated into N streams.(mode = Lazy)

## case 2: eager mode behavior
- when you run the following, you can run the tests in N number of parallel streams.
- the specs are dynamically separated into N streams.(mode = Lazy)
    - gauge run --parallel --strategy=eager -n N specs

## case 3: --parallel --only behavior
- 並列実行する前に、特定のシナリオを直列実行してくれるらしい
  - `gauge run specs --parallel --only "parallelizable"`
- 確認すべきポイント
  - parallelizable が何を指すのか（おそらく並列実行したいシナリオのタグ）