package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    By loginLink = By.xpath("//a[@href='/login']");
    By email = By.cssSelector("input[data-qa='login-email']");
    By password = By.cssSelector("input[data-qa='login-password']");
    By loginBtn = By.cssSelector("button[data-qa='login-button']");
    By errorMsg = By.xpath("//p[contains(text(),'incorrect')]");

    public void openLogin() {
        driver.findElement(loginLink).click();
    }

    public void login(String user, String pass) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(email)).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginBtn).click();
    }

    public boolean isErrorDisplayed() {
        return driver.findElement(errorMsg).isDisplayed();
    }
}