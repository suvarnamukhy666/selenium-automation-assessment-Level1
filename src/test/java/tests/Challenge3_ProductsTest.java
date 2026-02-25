package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductsPage;
import utils.BaseTest;

public class Challenge3_ProductsTest extends BaseTest {

    @Test
    public void productPageLoadsTest() {

        ProductsPage productsPage = new ProductsPage(driver, wait);
        productsPage.openProductsPage();

        // TODO: Add assertion to validate "All Products" heading is visible

        // TODO: Add assertion to validate page title contains "Products"
    }

    @Test
    public void productCountTest() {

        ProductsPage productsPage = new ProductsPage(driver, wait);
        productsPage.openProductsPage();

        int productCount = productsPage.getProductCount();
        System.out.println("Total products displayed: " + productCount);

        // TODO: Convert this to SoftAssert
        // TODO: Validate product count is greater than 10
        // TODO: Validate product image, name & price are displayed for first product
    }

    @Test
    public void addFirstProductToCartTest() {

        ProductsPage productsPage = new ProductsPage(driver, wait);
        productsPage.openProductsPage();
        productsPage.addFirstProductToCart();

        // TODO: Validate product is added to cart (navigation + assertion)
    }
}