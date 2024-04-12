package cucumberSteps.steps;

import cucumberSteps.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;
import pages.DashboardPage;

public class then {
    WebDriver driver = Hooks.getDriver();

    DashboardPage dashboardPage = new DashboardPage(driver);

    HomePage homePage = new HomePage(driver);
    LoginPage loginPage = new LoginPage(driver);

    @Then("The user should be directed to the travels screen")
    public void homePageIsLoaded() {
        Assert.assertTrue(homePage.verifyHomePageDisplayed());
    }

    @Then("^Verify if logo(?: and logout button are)? visible on ([^\\”]*)$")
    public void verifyLogoAndButton(String page) {
        switch (page) {
            case "HomePage":
                Assert.assertTrue(homePage.verifyLogoIsDisplayed());
                Assert.assertTrue(homePage.verifyLogoutButtonIsDisplayed());
                break;
            case "LoginPage":
                Assert.assertTrue(loginPage.verifyLogoIsDisplayed());
                break;
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
}
