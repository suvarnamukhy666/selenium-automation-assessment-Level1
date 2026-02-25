package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupPage {

    WebDriver driver;
    WebDriverWait wait;

    public SignupPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    By name = By.cssSelector("input[data-qa='signup-name']");
    By email = By.cssSelector("input[data-qa='signup-email']");
    By signupBtn = By.cssSelector("button[data-qa='signup-button']");
    By duplicateError = By.xpath("//p[contains(text(),'Email Address already exist')]");
    By accountInfoHeading = By.xpath("//b[text()='Enter Account Information']");


    public void signup(String username, String userEmail) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(name)).sendKeys(username);
        driver.findElement(email).sendKeys(userEmail);
        driver.findElement(signupBtn).click();
    }

    public boolean isDuplicateEmailShown() {
        return driver.findElement(duplicateError).isDisplayed();
    }

    public boolean isSignupButtonStillVisible() {
        return driver.findElement(signupBtn).isDisplayed();
    }

    public boolean isAccountInfoPageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(accountInfoHeading)).isDisplayed();
    }
}