package parallel;

import com.thoughtworks.gauge.Step;

public class SampleJava {
    @Step("Hello world")
    public void sampleStep() {
        System.out.println("Hello world!");
    }
}