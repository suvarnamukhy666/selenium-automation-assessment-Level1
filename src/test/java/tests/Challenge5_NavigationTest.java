package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.BaseTest;

public class Challenge5_NavigationTest extends BaseTest {

    @Test
    public void logoutValidationTest() {

        driver.get("https://automationexercise.com/login");

        // Step 1: Login
        LoginPage lp = new LoginPage(driver, wait);
        lp.login("assessmentQA@gmail.com", "Test@123");

        HomePage hp = new HomePage(driver);

        // Step 2: Wait until logout visible (login success validation)
        wait.until(d -> hp.isLogoutVisible());

        // Step 3: Logout
        hp.clickLogout();

        // Step 4: Validate redirected to login
        wait.until(d -> hp.isRedirectedToLogin());

        // TODO: Add assertion for login page header text after logout
        // TODO: Add screenshot capture on logout success

        System.out.println("Logout successful, redirected to: " + driver.getCurrentUrl());
        Assert.assertTrue(hp.isRedirectedToLogin());
    }
}