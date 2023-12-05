package parallel;

import com.thoughtworks.gauge.Step;

public class SerialJava {

    @Step("Run first step.")
    public void serial() {
        System.out.println("Hello serial!");
    }
}