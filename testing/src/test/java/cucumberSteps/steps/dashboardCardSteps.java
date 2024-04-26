package cucumberSteps.steps;

import cucumberSteps.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import pages.TravelDetailsPage;

import java.io.IOException;

public class dashboardCardSteps {
    WebDriver driver = Hooks.getDriver();

    DashboardPage dashboardPage = new DashboardPage(driver);

    @Given("the user is logged in")
    public void theUserIsLoggedIn() throws IOException, ParseException {
        DashboardPage dashboard = new DashboardPage(driver);
        Assert.assertTrue(dashboard.verifyLogoutButtonIsDisplayed());

    }

    @And("there are travels previously recorded for their profile")
    public void thereAreTravelsPreviouslyRecordedForTheirProfile() {
        DashboardPage dashboard = new DashboardPage(driver);
        Assert.assertTrue(dashboard.verifyCardIsDisplayed());
    }

    @When("they are on the Travels screen \\(dashboard)")
    public void theyAreOnTheTravelsScreenDashboard() {
        DashboardPage dashboard = new DashboardPage(driver);
        dashboard.verifyCardIsDisplayed();
    }

    @Then("the cards should display the Cover Photo")
    public void theCardsShouldDisplayTheCoverPhoto() {
        Assert.assertTrue(dashboardPage.verifyCoverPhotoIsDisplayed());
    }

    @And("Destination Name")
    public void destinationName() {
        Assert.assertTrue(dashboardPage.verifyCardDestination());
    }

    @And("the date rage")
    public void theDateRage() {
        Assert.assertTrue(dashboardPage.verifyCardDate());
    }

    @And("Budget and number of notes")
    public void budgetAndNumberOfNotes() {
        Assert.assertTrue(dashboardPage.verifyCardPriceAndNotes());
    }

    @And("Edit and Delete options")
    public void editAndDeleteOptions() {
        Assert.assertTrue(dashboardPage.verifyCardEditButton());
        Assert.assertTrue(dashboardPage.verifyCardDeleteButton());
    }
}
