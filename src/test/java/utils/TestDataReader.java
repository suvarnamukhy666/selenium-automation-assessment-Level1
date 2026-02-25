package utils;
public class TestDataReader {

    // TODO: Move hardcoded credentials from LoginTest to this data reader
    // Used by: Challenge1_LoginTest
    public static String getValidUsername() {
        return "assessmentQA@gmail.com";
    }

    // Externalize password to properties / env variable (security)
    // Used by: Challenge1_LoginTest
    public static String getValidPassword() {
        return "Test@123";
    }

    // Added invalid credential combinations for negative login tests
    // Used by: invalidLoginTest
    public static Object[][] getInvalidLoginData() {
        return new Object[][]{
                {"wrong@mail.com", "wrong"},
                {"admin' OR '1'='1", "test"},
                {"", ""}
        };
    }

    // TODO: Generate unique email dynamically instead of inline logic in test
    // Used by: Challenge2_SignupTest
    public static String generateUniqueEmail() {
        return "qa" + System.currentTimeMillis() + "@mail.com";
    }

    // TODO: Centralize duplicate email for reuse across tests
    // Used by: duplicateEmailTest
    public static String getExistingEmail() {
        return "existing@mail.com";
    }

    // TODO: Add product search keywords from data layer (avoid hardcoding)
    // Used by: Challenge4_CartTest
    public static String getSearchKeyword() {
        return "allen solly";
    }

    // TODO: Read product names from JSON/Excel instead of static values
    // Used by: Cart & Product tests
    public static String[] getProductNames() {
        return new String[]{"Tshirt", "Jeans", "Dress"};
    }
}