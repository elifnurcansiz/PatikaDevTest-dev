package stepDefinitions;

import Driver.driverSetup;
import io.cucumber.java.Before;
import Pages.dashboardPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.*;

public class searchSteps {
    WebDriver driver = driverSetup.getDriver();
    private Pages.dashboardPage dashboardPage;

    @Before
    public void setUp() {
        dashboardPage = new dashboardPage(driver);
    }

    @When("I click the time button")
    public void i_click_the_time_button() {
        dashboardPage.clickTimeButton();
    }

    @When("I enter search text")
    public void i_enter_search_text() {
        dashboardPage.searchOnTimeSheetPage("Virat Kohli");
    }

    @When("I click the View Button")
    public void i_click_the_view_button() {
        dashboardPage.clickTimeViewButton();

    }
    @Then("I see error message")
    public void i_see_error_message() {
        dashboardPage.assertErrorMessageForTime();
    }

    // search2:

    @When("I click the Admin button")
    public void i_click_admin_button() {
        dashboardPage.clickAdminButton();
    }

    @And("I enter search text in Admin Page")
    public void i_enter_search_text_in_admin_page() {
        dashboardPage.searchOnAdmin("Admin");
    }

    @When("I click the Search Button")
    public void i_click_search_button() {
        dashboardPage.clickAdminSearchButton();
    }

    @Then("I see search results")
    public void i_see_search_results() {
        String expectedName = "Admin";
        String actualName = dashboardPage.getResultsAdminPage();
        System.out.println(dashboardPage.getResultsAdminPage());
        assertEquals(expectedName, actualName);
    }

    // search3:

    @When("I search for {string}")
    public void i_search_for (String searchTerm) {
        dashboardPage.searchBoxOnSidePanel(searchTerm);
    }

    @Then("I should see {int} results")
    public void i_should_see_results_containing_search_text (int expectedCount) {
        int actualCount = dashboardPage.getCountFromSidePanel();
        System.out.println(actualCount);
        assertEquals(expectedCount, actualCount);
    }

    // search4:

    @Then("I should see the {string}")
    public void i_should_see_the_search_results(String expectedResult) {
        String actualResult = dashboardPage.getSearchResultsSideMenu();
        System.out.println(actualResult);
        assertEquals(expectedResult, actualResult);

    }

    // search5:

    @When("I click Directory Button")
    public void i_click_directory_button() {
        dashboardPage.clickDirectoryButton();
    }

    @And("I choose an option from the dropdown menu and click Search Button")
    public void i_choose_option_from_dropdown_and_click_search_button() {
        dashboardPage.clickSearchButtonOnDirectoryPage();
    }

    @Then("I should see results")
    public void i_should_see_search_results() {
        //String expectedName = "";
        String directoryResultsTitle = dashboardPage.getDirectoryResultsHead();
        System.out.println(directoryResultsTitle);
        assertTrue(directoryResultsTitle.contains("28"));
    }

    // search6:

    @When("I click the Recruitment button")
    public void i_click_recruitment_button() {
        dashboardPage.clickRecruitmentButton();
    }

    @And("I enter keyword {string} on Recruitment Page")
    public void i_enter_keyword_text_in_recruitment_page(String keyword) {
        dashboardPage.searchOnRecruitmentPage(keyword);
    }

    @When("I click the Recruitment Search Button")
    public void i_click_recruitment_search_button() {
        dashboardPage.clickRecruitmentSearchButton();
    }

    @Then("I see the Recruitment search results")
    public void i_see_recruitment_search_results() {
        String recruitmentResultsTitle = dashboardPage.getRecruitmentsResultsHead();
        System.out.println(recruitmentResultsTitle);
        assertTrue(recruitmentResultsTitle.contains("8"));
    }

    // search7:

    @When("I click the PIM button")
    public void i_click_pim_button() {
        dashboardPage.click_pim_Button();
    }

    @And("I enter ID {string} on PIM Page")
    public void i_enter_id_text_on_pim_page(String employeeID) {
        dashboardPage.searchEmployeeOnpimPage(employeeID);
    }

    @When("I click the Employee Search Button")
    public void i_click_employee_search_button() {
        dashboardPage.clickEmployeeSearchButton();
    }

    @Then("I see the PIM search results")
    public void i_see_pim_search_results() {
        String employeePIMResultsContent = dashboardPage.getResultsOnpimPage();
        System.out.println(dashboardPage.getResultsOnpimPage());
        assertFalse(employeePIMResultsContent.contains("0408"));
    }

}
