import com.thoughtworks.gauge.Step

class Sleep {

    @Step("Sleep for <seconds> seconds.")
    fun sleepFor(seconds: Int) {
        Thread.sleep(seconds * 1000L)
    }
}