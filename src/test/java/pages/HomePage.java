package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    // ===== Locators =====
    private By signupLoginBtn = By.cssSelector("a[href='/login']");
    private By logoutBtn = By.xpath("//a[@href='/logout']");
    private By headerLoginText = By.xpath("//h2[text()='Login to your account']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // ===== Actions =====
    public void clickSignupLogin() {
        driver.findElement(signupLoginBtn).click();
    }

    public void clickLogout() {
        driver.findElement(logoutBtn).click();
    }

    public boolean isRedirectedToLogin() {
        return driver.getCurrentUrl().contains("login");
    }

    public String getLoginHeaderText() {
        return driver.findElement(headerLoginText).getText();
    }

    public boolean isLogoutVisible() {
        return !driver.findElements(logoutBtn).isEmpty();
    }
}