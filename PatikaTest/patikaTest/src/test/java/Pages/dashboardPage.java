package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import static org.junit.Assert.assertTrue;

public class dashboardPage {
    private WebDriver driver;
    private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    //private String searchTerm;
    //private WebDriverWait wait; // WebDriverWait instance başlat

    // search1 locators
    private By dasboardTitle = By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']"); 
    private By timeSheetButton = By.xpath("//span[text()='Time']");
    private By inputTimeSheet = By.xpath("//input[@placeholder='Type for hints...']");
    @FindBy(xpath = "//span[text()='Invalid']")
    WebElement TimeSheetErrorMessage;
    private By TimeSheetViewButton = By.xpath("//button[@type='submit']");

    // search2 locators 
    private By adminButton = By.xpath("//span[text()='Admin']");
    //private By searchBoxInAdminPage = By.xpath("(//input[@data-v-1f99f73c and contains(@class, 'oxd-input oxd-input--active')])[2]");
    private By inputAdminPage = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
    private By adminPageSearchButton = By.xpath("(//button[@type='submit'])[1]");
    private By getNameFromResults = By.xpath("(//div[@data-v-6c07a142])[1]");

    // search3 locators
    private By sideMenuInput = By.xpath("//input[@placeholder='Search']");
    private By resultsInSidePanel = By.xpath("//div[@class='oxd-sidepanel-body']//li[contains(translate(normalize-space(.), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'a')]");
    // search4 locators
    private By searchResultSidePanel = By.xpath("//div[@class='oxd-sidepanel-body']");

    // search5 locators
    private By directoryButton = By.xpath("//span[text()='Directory']");
    private By locationButton = By.xpath("(//div[@class='oxd-select-wrapper'])[2]");
    private By locationOption = By.xpath("//span[text()='New York Sales Office']");
    private By searchDirectoryButton = By.xpath("//button[contains(@class, 'oxd-button') and contains(@class, 'oxd-button--secondary') and contains(@class, 'orangehrm-left-space')]");
    private By searchResultOnDirectoryPage = By.xpath("//span[@class='oxd-text oxd-text--span']");

  
    // search6 locators
    private By recruitmentButton = By.xpath("//span[text()='Recruitment']");
    private By searchBoxOnRecruitmentPage = By.xpath("//input[@placeholder='Enter comma seperated words...']");
    private By recruitmentSearchButton = By.xpath("(//button[@type='submit'])[1]");

    //private By titleFromRecruitmentSearchResults = By.xpath("//span[@class='oxd-text oxd-text--span']");
    private By recruitmentSearchResult = By.xpath("//span[@class='oxd-text oxd-text--span']");
    // search7 locators
    private By pimButton = By.xpath("//span[text()='PIM']");
    private By searchBoxOnPIMPage = By.xpath("(//input[@data-v-1f99f73c='' and @class='oxd-input oxd-input--active'])[2]");
    private By pimSearchButton = By.xpath("(//button[@type='submit'])[1]");
    private By pimSearchResults = By.xpath("//div[@class='orangehrm-container']");

    // dashboard page
    public dashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        //wait = new WebDriverWait(driver, Duration.ofSeconds(3)); // 3 saniye bekleme süresi
    }
    public String getDasboardHead() {
        return driver.findElement(dasboardTitle).getText();
    }

    public void clickTimeButton() {
        driver.findElement(timeSheetButton).click();
    }

    public void searchOnTimeSheetPage(String nameForTimeSheet) {
        driver.findElement(inputTimeSheet).sendKeys(nameForTimeSheet);
    }

    public void clickTimeViewButton() {
        driver.findElement(TimeSheetViewButton).click();
    }
    public void assertErrorMessageForTime(){
        assertTrue(TimeSheetErrorMessage.getText().contains("Invalid"));
        System.out.println(TimeSheetErrorMessage.getText());
    }

    // admin search:
    public void clickAdminButton() {
        driver.findElement(adminButton).click();
    }

    public void searchOnAdmin(String nameForAdmin) {
        driver.findElement(inputAdminPage).sendKeys(nameForAdmin);
    }
    public void clickAdminSearchButton() {
        driver.findElement(adminPageSearchButton).click();
    }

    public String getResultsAdminPage() {
        return driver.findElement(getNameFromResults).getText();
    }

    // search count:
    public void searchBoxOnSidePanel(String searchTerm){
        driver.findElement(sideMenuInput).sendKeys(searchTerm);
    }

    public int getCountFromSidePanel() {
        List<WebElement> searchResults = driver.findElements(resultsInSidePanel);
        return searchResults.size();
    }
    // search 4:
    public String getSearchResultsSideMenu() {
        return driver.findElement(searchResultSidePanel).getText();
    }


    // search 5:

    public void clickDirectoryButton() {
        driver.findElement(directoryButton).click();
    }

    public void clickSearchButtonOnDirectoryPage() {
        driver.findElement(locationButton).click();
        //wait.until(ExpectedConditions.elementToBeClickable(dropdownOption);
        driver.findElement(locationOption).click();
        driver.findElement(searchDirectoryButton).click();
    }

    public String getDirectoryResultsHead() {
        return driver.findElement(searchResultOnDirectoryPage).getText();
    }


    // search 6:

    public void clickRecruitmentButton() {
        driver.findElement(recruitmentButton).click();
    }
    public void searchOnRecruitmentPage(String keyword) {
        driver.findElement(searchBoxOnRecruitmentPage).sendKeys(keyword);
    }
    public void clickRecruitmentSearchButton() {
        driver.findElement(recruitmentSearchButton).click();
    }
    public String getRecruitmentsResultsHead() {
        return driver.findElement(recruitmentSearchResult).getText();
    }

    // search 7:

    public void click_pim_Button() {
        driver.findElement(pimButton).click();
    }
    public void searchEmployeeOnpimPage(String keyword) {
        driver.findElement(searchBoxOnPIMPage).sendKeys(keyword);
    }
    public void clickEmployeeSearchButton() {
        driver.findElement(pimSearchButton).click();
    }
    public String getResultsOnpimPage() {
        return driver.findElement(pimSearchResults).getText();
    }

}

