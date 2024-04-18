package cucumberSteps.steps;

import cucumberSteps.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;


public class dashboardPageSteps {

    WebDriver driver = Hooks.getDriver();

    DashboardPage dashboardPage = new DashboardPage(driver);



    @Then("the screen should display the app name and logo on the left side")
    public void theScreenShouldDisplayTheAppNameAndLogoOnTheLeftSide() {
        Assert.assertTrue(dashboardPage.verifyLogoIsDisplayed());
        Assert.assertTrue(dashboardPage.verifyLogoAlignment());
    }



    @And("the screen should have a screen title")
    public void theScreenShouldHaveAScreenTitle() {
        Assert.assertTrue(dashboardPage.verifyDashboardPageDisplayed());
    }

    @And("the screen should have a Profile dropdown")
    public void theScreenShouldHaveAProfileDropdown() {
        Assert.assertTrue(dashboardPage.verifyLogoutButtonIsDisplayed());
    }


    @And("the screen should have a New Travel button")
    public void theScreenShouldHaveANewTravelButton() {
        Assert.assertTrue(dashboardPage.verifyAddTripButtonIsDisplayed());
    }

    @And("the Travel cards are ordered based on date of travel starting from the most recent")
    public void theTravelCardsAreOrderedBasedOnDateOfTravelStartingFromTheMostRecent() {
        Assert.assertTrue(dashboardPage.verifyCardOrder());
    }

    @And("the screen should have a Travel card for each Travel recorded")
    public void theScreenShouldHaveATravelCardForEachTravelRecorded() throws Exception {
        Assert.assertTrue(dashboardPage.verifyCardCorespondsToTravels());
    }
}
