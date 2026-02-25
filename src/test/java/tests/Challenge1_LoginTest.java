package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.BaseTest;
import utils.TestDataReader;

public class Challenge1_LoginTest extends BaseTest {

        @Test
        public void validLoginTest() {
                LoginPage lp = new LoginPage(driver, wait);
                lp.openLogin();

                lp.login(
                        TestDataReader.getValidUsername(),
                        TestDataReader.getValidPassword()
                );
        }

        @Test
        public void invalidLoginTest() {
                LoginPage lp = new LoginPage(driver, wait);
                lp.openLogin();
                // TODO: Move hardcoded credentials to test data file, Use @Dataprovider for invalid login test

        }

        @Test
        public void emptyLoginTest() {
                LoginPage lp = new LoginPage(driver, wait);
                lp.openLogin();

                // TODO: Add assertion for mandatory field validation message and print in console

                lp.login("", "");
                Assert.assertTrue(driver.getCurrentUrl().contains("login"));
        }
}