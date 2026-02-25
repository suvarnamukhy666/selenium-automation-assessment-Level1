package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ProductsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public ProductsPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    private By productsLink = By.xpath("//a[@href='/products']");
    private By pageHeading = By.xpath("//h2[text()='All Products']");
    private By productCards = By.cssSelector(".product-image-wrapper");
    private By firstAddToCartBtn = By.xpath("(//a[contains(text(),'Add to cart')])[1]");
    private By continueBtn = By.xpath("//button[text()='Continue Shopping']");
    private By modal = By.xpath("//div[contains(@class,'modal')]");

    public void openProductsPage() {
        driver.findElement(productsLink).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageHeading));
    }

    public boolean isAllProductsHeadingVisible() {
        return driver.findElement(pageHeading).isDisplayed();
    }

    public int getProductCount() {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(productCards));
        return driver.findElements(productCards).size();
    }

    public void addFirstProductToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(firstAddToCartBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(continueBtn)).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(modal));
    }
}