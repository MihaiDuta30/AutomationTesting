package cucumberSteps.steps;

import cucumberSteps.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;
import pages.DashboardPage;
import pages.RegisterPage;

public class then {
    WebDriver driver = Hooks.getDriver();

    DashboardPage dashboardPage = new DashboardPage(driver);

    HomePage homePage = new HomePage(driver);
    LoginPage loginPage = new LoginPage(driver);

    RegisterPage registerPage = new RegisterPage(driver);

    @Then("The user should be directed to the travels screen")
    public void homePageIsLoaded() {
        Assert.assertTrue(homePage.verifyHomePageDisplayed());
    }

    @Then("^Verify if logo(?: and logout button are)? visible on ([^\\”]*)$")
    public void verifyLogoAndButton(String page) {
        switch (page) {
            case "HomePage" -> {
                Assert.assertTrue(homePage.verifyLogoIsDisplayed());
                Assert.assertTrue(homePage.verifyLogoutButtonIsDisplayed());
            }
            case "LoginPage" -> Assert.assertTrue(loginPage.verifyLogoIsDisplayed());
        }
    }

    @And("The login screen should have a screen title")
    public void theLoginScreenShouldHaveAScreenTitle() {
        Assert.assertEquals("Travel Journal", driver.getTitle());
    }

    @And("The login screen should have a form for entering Email address and Password")
    public void theLoginScreenShouldHaveAFormForEnteringEmailAddressAndPassword() {
        Assert.assertTrue(loginPage.usernameField());
        Assert.assertTrue(loginPage.passwordField());
    }

    @And("The login screen should have a Log In button")
    public void theLoginScreenShouldHaveALogInButton() {
        Assert.assertTrue(loginPage.loginButton());
    }

    @Then("Should be redirected to Register page")
    public void shouldBeRedirectedToRegisterPage() {

    }

    @And("Populate all the required fields")
    public void fillsAllTheRequiredFields() {
        Assert.assertTrue(registerPage.firstNameField());
        Assert.assertTrue(registerPage.lastNameField());
        Assert.assertTrue(registerPage.emailField());
        Assert.assertTrue(registerPage.passwordField());
        Assert.assertTrue(registerPage.confirmPasswordField());
        registerPage.registerToApp();
    }

    @Then("Should be redirected to {string} page")
    public void redirectToPage(String page) {
        switch (page) {
            case "Register" -> Assert.assertTrue(registerPage.registerTitle());
            case "LogIn" -> Assert.assertTrue(loginPage.loginTitle());
        }
    }
}
