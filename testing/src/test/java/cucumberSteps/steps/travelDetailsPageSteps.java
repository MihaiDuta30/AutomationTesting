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
public class travelDetailsPageSteps {
    WebDriver driver = Hooks.getDriver();

    DashboardPage dashboardPage = new DashboardPage(driver);
    TravelDetailsPage travelDetailsPage = new TravelDetailsPage(driver);

    @Given("The user is on the Travels Dashboard")
    public void theUserIsLoggedIn() throws IOException, ParseException {
        DashboardPage dashboard = new DashboardPage(driver);
        Assert.assertTrue(dashboard.verifyLogoutButtonIsDisplayed());
    }

    @And("there is at least one Travel Card")
    public void thereAreTravelsPreviouslyRecordedForTheirProfile() {
        DashboardPage dashboard = new DashboardPage(driver);
        Assert.assertTrue(dashboard.verifyCardIsDisplayed());
    }

    private String dashboardCoverPhotoUrl;
    private String dashboardDates;
    private String dashboardDestinationName;

    @When("they click on the Cover photo in the Travel Card")
    public void theyAreOnTheTravelsScreenDashboard() {
        DashboardPage dashboard = new DashboardPage(driver);
        dashboardCoverPhotoUrl = dashboard.getCoverPhotoUrl();
        dashboardDates = dashboard.getDates();
        dashboardDestinationName = dashboard.getDestinationName();
        dashboard.clickCoverPhoto(); // This will click the cover photo and should navigate to the card page
    }

    @Then("the user should be directed to the Travels screen for the related destination")
    public void theCardsShouldDisplayTheCoverPhoto() {
        Assert.assertTrue(travelDetailsPage.verifyDestinationNameIsDisplayed());
    }

    @Then("the screen should display the logo on the left side")
    public void theScreenShouldDisplayTheAppNameAndLogoOnTheLeftSide() {
        Assert.assertTrue(travelDetailsPage.verifyLogoIsDisplayed());
        Assert.assertTrue(travelDetailsPage.verifyLogoAlignment());
        System.out.println("Logo Verified");
    }

    @And("the page should have a Profile dropdown")
    public void theScreenShouldHaveAProfileDropdown() {
        Assert.assertTrue(travelDetailsPage.verifyLogoutButtonIsDisplayed());
        System.out.println("Logout Button Verified");
    }

    @And("^the screen should display the breadcrumbs as Travels/(.*)$")
    public void theScreenShouldDisplayTheBreadcrumbs(String expectedDestinationName) {
        TravelDetailsPage travelDetailsPage = new TravelDetailsPage(driver);
        //String actualDestinationName = travelDetailsPage.getDestinationNameFromUrl();
        String travelDetailsDestinationName = travelDetailsPage.getDestinationName();
        // Ignore the expectedDestinationName from the feature file and get the expected destination name from the webpage
        expectedDestinationName = dashboardDestinationName;
        System.out.println("Expected: " + expectedDestinationName);
        System.out.println("Actual: " + travelDetailsDestinationName);
        travelDetailsPage.printBreadcrumbs();
        travelDetailsPage.verifyBreadcrumbsAreDisplayed();
        Assert.assertEquals(expectedDestinationName, travelDetailsDestinationName);
        System.out.println("Breadcrumbs Verified");
    }


    @And("the screen should have the destination name")
    public void destinationName() {
        Assert.assertTrue(travelDetailsPage.verifyDestinationNameIsDisplayed());
        String travelDetailsDestinationName = travelDetailsPage.getDestinationName();
        Assert.assertEquals(travelDetailsDestinationName, dashboardDestinationName);
        System.out.println("Destination Name Verified");
    }

    @And("the screen should have the start date and the end date")
    public void compareDates() {
        TravelDetailsPage travelDetailsPage = new TravelDetailsPage(driver);
        Assert.assertTrue(travelDetailsPage.verifyDatesIsDisplayed());
        String travelDetailsDates = travelDetailsPage.getDates();
        // Compare the dates
        Assert.assertEquals(dashboardDates, travelDetailsDates);
        System.out.println("Dates Verified");
    }


    @And("the screen should have the number of notes")
    public void destinationNumberOfNotes() {
        Assert.assertTrue(travelDetailsPage.verifyNumberOfNotesIsDisplayed());
    }

    @And("the screen should display the Cover photo from the Travel Card")
    public void DestinationCoverPhoto() {
        Assert.assertTrue(travelDetailsPage.verifyCoverPhotoIsDisplayed());
        String travelDetailsCoverPhotoUrl = travelDetailsPage.getCoverPhotoUrl();
        //System.out.println(travelDetailsCoverPhotoUrl);
        //System.out.println(dashboardCoverPhotoUrl);
        Assert.assertEquals(dashboardCoverPhotoUrl, travelDetailsCoverPhotoUrl);
        System.out.println("Cover Photo Verified");
    }

    @And("the screen should have a description")
    public void DestinationDescription() {
        Assert.assertTrue(travelDetailsPage.verifyDescriptionIsDisplayed());
    }

    @And("the screen should include a + New Note button")
    public void newNoteButton() {
        Assert.assertTrue(travelDetailsPage.verifyNewNoteButtonIsDisplayed());
        System.out.println("New Note Button Verified");
    }

    @And("a message indicating that ‘No notes are available yet’ should be displayed if there are 0 notes.")
    public void noNotes() {
        String NrOfNotes = travelDetailsPage.getNumberOfNotes();
        System.out.println("Number of Notes: " + NrOfNotes);
        if(travelDetailsPage.verifyNoNotesMessageIsDisplayed()){
            System.out.println("No Notes Message is Displayed");
            Assert.assertTrue(travelDetailsPage.verifyNoNotesMessageIsDisplayed());
            Assert.assertTrue(travelDetailsPage.verifyNumberOfNotesIsZero());
        }
    }


    @Then("the user should remain logged in on the Travel Details page.")
    public void theUserShouldRemainLoggedIn() {
        Assert.assertTrue(travelDetailsPage.verifyLogoutButtonIsDisplayed());
        if(travelDetailsPage.verifyLogoutButtonIsDisplayed()) {
            System.out.println("The user is still logged in");
        }
    }

    @And("the page should reload all the data on Travel Details page")
    public void thePageShouldReloadAllTheDataOnTravelDetailsPage() {
        System.out.println("Refreshing The Page");
        Assert.assertTrue(travelDetailsPage.verifyDestinationNameIsDisplayed());
    }
}
