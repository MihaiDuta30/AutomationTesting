package cucumberSteps.steps;

import cucumberSteps.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;

public class then {
    WebDriver driver = Hooks.getDriver();

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
}
