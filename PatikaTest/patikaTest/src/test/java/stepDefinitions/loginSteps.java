package stepDefinitions;

import Driver.driverSetup;
import Pages.loginPage;
import Pages.dashboardPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class loginSteps {
    //private WebDriver driver;
    private Pages.loginPage loginPage;
    private Pages.dashboardPage dashboardPage;
    WebDriver driver = driverSetup.getDriver();

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage = new loginPage(driver);
    }

    @When("I enter valid credentials")
    public void i_enter_valid_credentials() {
        loginPage.inputUsername("Admin");
        loginPage.inputPassword("admin123");
    }

    @When("I enter invalid credentials")
    public void i_enter_invalid_credentials() {
        loginPage.inputUsername("Admi");
        loginPage.inputPassword("admin1");
    }

    @And("I submit the login form")
    public void i_submit_the_login_form() {
        loginPage.clickLoginButton();
    }

    @Then("I should be redirected to the dashboard page")
    public void i_should_be_redirected_to_the_dashboard_page() {
        dashboardPage = new dashboardPage(driver);

        String expectedTitle = "Dashboard";
        String actualTitle = dashboardPage.getDasboardHead();
        System.out.println(dashboardPage.getDasboardHead());
        assertEquals(expectedTitle, actualTitle);
    }

    // login error:

    @Then("I see the error message")
    public void i_see_the_error_message() {
        loginPage.assertLoginErrorMessage();
    }

}