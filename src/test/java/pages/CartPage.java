package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CartPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public CartPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    // ===== Locators =====
    private By searchBox = By.id("search_product");
    private By searchBtn = By.id("submit_search");
    private By searchedHeader = By.xpath("//h2[text()='Searched Products']");
    private By menPlusIcon = By.xpath("//a[@href='#Men']");
    private By tshirtsLink = By.xpath("//a[contains(@href,'/category_products/3')]");
    private By addToCartBtns = By.xpath("//a[contains(text(),'Add to cart')]");
    private By continueBtn = By.xpath("//button[text()='Continue Shopping']");
    private By cartRows = By.xpath("//tr[contains(@id,'product')]");
    private By viewCart = By.xpath("//a[@href='/view_cart']");
    private By deleteBtn = By.xpath("(//a[@class='cart_quantity_delete'])[1]");
    private By modal = By.xpath("//div[contains(@class,'modal') and contains(@class,'show')]");

    // ===== Actions =====
    public void searchProduct(String product) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox)).clear();
        driver.findElement(searchBox).sendKeys(product);
        clickUsingJS(searchBtn);
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchedHeader));
    }

    public void expandMenCategory() {
        driver.findElement(menPlusIcon).click();
    }

    public void clickTshirts() {
        wait.until(ExpectedConditions.elementToBeClickable(tshirtsLink)).click();
    }

    public void addProducts(int count) {
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(addToCartBtns, 2));
        List<WebElement> products = driver.findElements(addToCartBtns);

        int itemsToAdd = Math.min(count, products.size());
        for (int i = 0; i < itemsToAdd; i++) {
            clickUsingJS(products.get(i));
            wait.until(ExpectedConditions.elementToBeClickable(continueBtn)).click();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(modal));
        }
    }

    public void goToCart() {
        driver.findElement(viewCart).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(cartRows));
    }

    public int getCartCount() {
        return driver.findElements(cartRows).size();
    }

    public void removeFirstItem() {
        wait.until(ExpectedConditions.elementToBeClickable(deleteBtn)).click();
    }

    // ===== Utilities =====
    private void clickUsingJS(By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    private void clickUsingJS(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
}