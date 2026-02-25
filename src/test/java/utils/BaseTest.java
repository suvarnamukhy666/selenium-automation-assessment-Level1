package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.List;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://automationexercise.com");
        handleUnexpectedPopup();
    }

    protected void handleUnexpectedPopup() {
        try {
            By[] popupLocators = {
                    By.xpath("//button[text()='Continue Shopping']"),
                    By.xpath("//button[text()='Close']"),
                    By.xpath("//button[contains(@class,'close')]"),
                    By.xpath("//button[text()='×']"),
                    By.xpath("//div[@role='dialog']//button")
            };

            for (By locator : popupLocators) {
                List<WebElement> elements = driver.findElements(locator);
                if (!elements.isEmpty() && elements.get(0).isDisplayed()) {
                    elements.get(0).click();
                    break;
                }
            }
        } catch (Exception ignored) {}
    }

    protected void jsScrollToBottom() {
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}