package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
    private WebDriver driver;
    private By usernameInput= By.xpath("//input[@name='username']");
    private By passwordInput= By.xpath("//input[contains(@class, 'oxd-input') and contains(@name, 'password')]");
    private By loginButton = By.xpath("//button[@type='submit']");
    @FindBy(xpath = "//p[contains(@class, 'oxd-alert-content-text')]")
    WebElement LoginInvalidMessage;

    public loginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void inputUsername(String username) {
        driver.findElement(usernameInput).sendKeys(username);
    }

    public void inputPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void assertLoginErrorMessage(){
        Assert.assertTrue(LoginInvalidMessage.getText().contains("Invalid credentials"));
        System.out.println(LoginInvalidMessage.getText());
    }
}