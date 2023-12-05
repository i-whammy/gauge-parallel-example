# gauge-parallel-example
Test for gauge parallel execution performance.
## case 1: default parallel behavior
- when you run the following, you can run the tests in N number of parallel streams.
  - `gauge run -p(--parallel) -n N specs`
    - Note that the maximum number of streams depends on CPU core numbers of your machine/environment.
- the specs are dynamically separated into N streams.(mode = Lazy)
### example
```shell
$ gauge run -p -n 2 specs
Executing in 2 parallel streams.
[runner: 2] # Serial spec
[runner: 1] # Long delay spec
[runner: 1]   ## Sleep for 10 seconds
[runner: 2]   ## First step
Hello serial!
[runner: 2] 
[runner: 2] # Short delay spec
[runner: 2]   ## Sleep for 1 second
[runner: 2]   ## Sleep for 2 seconds
[runner: 2]   ## Sleep for 3 seconds
[runner: 2] 
[runner: 1] 

Specifications:	3 executed	3 passed	0 failed	0 skipped
Scenarios:	5 executed	5 passed	0 failed	0 skipped

Total time taken: 14.28s
```

## case 1-b: default parallel behavior with multi-threads
- when you set enable_multithreading variable in properties file as true, you can execute the tests with multi threads
- the specs are dynamically separated into N streams.(mode = Lazy)
### example
```shell
$ gauge run -p -n 2 specs // with multithreading
Executing in 2 parallel streams.
[runner: 2] # Serial spec
[runner: 1] # Long delay spec
[runner: 1]   ## Sleep for 10 seconds
[runner: 2]   ## First step
Hello serial!
[runner: 2] 
[runner: 2] # Short delay spec
[runner: 2]   ## Sleep for 1 second
[runner: 2]   ## Sleep for 2 seconds
[runner: 2]   ## Sleep for 3 seconds
[runner: 2] 
[runner: 1] 

Specifications:	3 executed	3 passed	0 failed	0 skipped
Scenarios:	5 executed	5 passed	0 failed	0 skipped

Total time taken: 10.323s
```

## case 2: eager mode behavior
- when you run the following, you can run the tests in N number of parallel streams.
- the specs are dynamically separated into N streams.(mode = Lazy)
    - `gauge run -p --strategy=eager -n N specs`

## case 3: -p --only behavior
- Only specified tags will be executed after remaining specs are executed.
  - `gauge run -p specs --only "parallelizable"`
### example
```shell
$ gauge run -p -n 2 specs --only "parallel"
Executing 1 specs in serial.
[runner: 1] # Serial spec
[runner: 1]   ## First step
Hello serial!
[runner: 1] 
Executing in 2 parallel streams.
[runner: 1] # Long delay spec
[runner: 2] # Short delay spec
[runner: 1]   ## Sleep for 10 seconds
[runner: 2]   ## Sleep for 1 second
[runner: 2]   ## Sleep for 2 seconds
[runner: 2]   ## Sleep for 3 seconds
[runner: 2] 
[runner: 1] 

Specifications:	3 executed	3 passed	0 failed	0 skipped
Scenarios:	5 executed	5 passed	0 failed	0 skipped

Total time taken: 13.624s
```
