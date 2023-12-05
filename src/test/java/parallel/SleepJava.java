package parallel;

import com.thoughtworks.gauge.Step;

public class SleepJava {

    @Step("Sleep for <seconds> seconds.")
    public void sleepFor(Integer seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}