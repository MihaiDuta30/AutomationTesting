package cucumberSteps.steps;

import cucumberSteps.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;

public class dashboardRefreshSteps {

    WebDriver driver = Hooks.getDriver();
    DashboardPage dashboardPage = new DashboardPage(driver);

    @When("the user reloads the page")
    public void theUserReloadsThePage() {
        driver.navigate().refresh();
    }

    @Then("the user should remain logged in")
    public void theUserShouldRemainLoggedIn() {
        Assert.assertTrue(dashboardPage.verifyLogoutButtonIsDisplayed());
    }

    @And("the page should reload all the data on page")
    public void thePageShouldReloadAllTheDataOnPage() {
        Assert.assertTrue(dashboardPage.verifyCardIsDisplayed());
    }
}
