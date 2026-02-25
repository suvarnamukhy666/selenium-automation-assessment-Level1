package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.SignupPage;
import utils.BaseTest;

public class Challenge2_SignupTest extends BaseTest {

    @BeforeMethod
    public void openSignupPage() {
        driver.get("https://automationexercise.com");
        HomePage home = new HomePage(driver);
        home.clickSignupLogin(); // 🔥 REQUIRED FOR ALL TESTS
    }

    @Test
    public void validSignupTest() {
        SignupPage sp = new SignupPage(driver, wait);
        String email = "qa" + System.currentTimeMillis() + "@mail.com";

        // TODO: Convert signup tests to use @DataProvider for multiple datasets

        sp.signup("QA User", email);
        Assert.assertTrue(sp.isAccountInfoPageDisplayed());
    }

    @Test
    public void duplicateEmailTest() {
        SignupPage sp = new SignupPage(driver, wait);

// TODO: Validate exact duplicate email error message text

        sp.signup("QA", "existing@mail.com");
    }

    @Test
    public void emptySignupTest() {
        SignupPage sp = new SignupPage(driver, wait);
        sp.signup("", "");

        // TODO: Assert inline validation messages for empty name and email

        Assert.assertTrue(sp.isSignupButtonStillVisible());
    }
}