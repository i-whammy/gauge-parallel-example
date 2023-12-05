package parallel;

import com.thoughtworks.gauge.Step;

public class SleepJava {

    @Step("Sleep for <seconds> seconds.")
    public void sleepFor(Integer seconds) {
        try {
            for (int i = 0; i < seconds; i++) {
                Thread.sleep(1000L);
                System.out.println(Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}