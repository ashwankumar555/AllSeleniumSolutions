package AllureReports.allure.definitions;

import org.junit.jupiter.api.DisplayName;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;




@Epic("All test cases")
public class MyCalculatorTest {

    double sum;  // shared instance variable

    @Given("Addition scenario")
    public void additionScenario() {
        System.out.println("Starting addition scenario");
    }

    @Feature("All calculations")
    @DisplayName("Calculate the sum")
    @Description("This method adds two numbers")
    @When("User enters n1 as {double} and n2 as {double}")
    public void user_enters_numbers(double n1, double n2) {
        sum = n1 + n2;
        System.out.println("Sum calculated: " + sum);
    }

    @Link("www.google.com")
    @Then("Addition result should be {double}")
    public void addition_should_be(double expectedSum) {
        Assert.assertEquals(expectedSum, sum, 0.001);
        System.out.println("Addition validated successfully");
    }
}
