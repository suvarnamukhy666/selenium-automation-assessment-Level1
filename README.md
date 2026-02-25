QA Automation Candidate Assessment – Quick Guide

🔹 Overview
This project covers Login, Signup, Products, Cart, and Navigation modules on Automation Exercise

Objective:
Complete the TODOs in test classes. Focus on functional correctness, validations, best practices, and maintainable automation code.

1️⃣ Login Tests (Challenge1_LoginTest) -2TC'S
2️⃣ Signup Tests (Challenge2_SignupTest) -3TC's
3️⃣ Products Tests (Challenge3_ProductsTest) -6TC's
4️⃣ Cart Tests (Challenge4_CartTest) -3TC's
5️⃣ Navigation Tests (Challenge5_NavigationTest)-2TC's

Detailed description:
1️⃣ Challenge1_LoginTest 

Move invalid login credentials to test data file (TestDataReader) and use @DataProvider.

Add assertion for mandatory field messages for empty login and print messages in console.

2️⃣ Challenge2_SignupTest

Convert signup tests to use @DataProvider for multiple datasets.

Assert duplicate email error text.

Validate inline messages for empty name/email fields.

3️⃣ Challenge3_ProductsTest

Add assertion for "All Products" heading visibility.

Add assertion for page title containing “Products”.

Convert hard assertions to SoftAssert for product count & details.

Validate product image, name, and price for first product.

Move add-to-cart logic to ProductsPage (POM improvement).

Assert product is successfully added to cart.

4️⃣ Challenge4_CartTest

Make addProducts() dynamic instead of hardcoded count.

Implement functional check to verify “Load More” button appears after scroll.

Count all products on page while scrolling to bottom.

Verify subtotal updates correctly after removing an item.

5️⃣ Challenge5_NavigationTest

Assert login page header text after logout.

Capture screenshot on logout success.




Instructions :

Focus only on test classes (tests/), do not modify page classes.
Make tests runnable with TestNG.
Implement TODOs with functional validations, not just assertions.
Keep code clean, maintainable, and reusable.
Print console outputs for validations where applicable.
