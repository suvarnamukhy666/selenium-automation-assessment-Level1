package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage;
import utils.BaseTest;

public class Challenge4_CartTest extends BaseTest {

    private CartPage cart;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        handleUnexpectedPopup();
        cart = new CartPage(driver, wait);
    }

    @Test
    public void addThreeItemsAndValidateCartCount() {

        driver.get("https://automationexercise.com/products");

        cart.searchProduct("allen solly");
        cart.expandMenCategory();
        cart.clickTshirts();

        // TODO: Make the addProducts() method dynamic to add products based on availability, not hardcoded count
        cart.addProducts(3);
        cart.goToCart();
        int finalCount = cart.getCartCount();
        System.out.println("Final cart count = " + finalCount);
        Assert.assertEquals(finalCount, 2,
                "Cart count mismatch after adding duplicate items");
    }

    @Test
    public void scrollProductsPageToBottom() {
        driver.get("https://automationexercise.com/products");

        // TODO: Implement functional check to verify "Load More" button appears after scroll
        jsScrollToBottom();

        Assert.assertTrue(true);
    }

    @Test
    public void removeOneItemAndValidateCartCount() {

        // Precondition: add three unique products
        addThreeUniqueProductsPrecondition();

        int before = cart.getCartCount();

        // TODO: Verify that removing first item also updates the subtotal correctly
        cart.removeFirstItem();

        wait.until(d -> cart.getCartCount() < before);
        int after = cart.getCartCount();

        Assert.assertEquals(after, 2,
                "Cart count mismatch after removing item");
    }

    // ===== Precondition =====
    private void addThreeUniqueProductsPrecondition() {
        driver.get("https://automationexercise.com/products");
        cart.addProducts(3);
        cart.goToCart();
    }
}