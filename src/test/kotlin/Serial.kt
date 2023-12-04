import com.thoughtworks.gauge.Step

class Serial {

    @Step("Run first step.")
    fun serial() {
        println("Hello serial!")
    }
}