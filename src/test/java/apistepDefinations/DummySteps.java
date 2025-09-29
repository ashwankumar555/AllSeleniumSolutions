package apistepDefinations;

import io.cucumber.java.en.Given;

public class DummySteps {
    @Given("I print hello")
    public void i_print_hello() {
        System.out.println("Hello from Cucumber!");
    }
}