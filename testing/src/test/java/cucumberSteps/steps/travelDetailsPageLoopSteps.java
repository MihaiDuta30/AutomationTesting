package cucumberSteps.steps;

import cucumberSteps.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import java.util.List;
import pages.DashboardPage;
import pages.TravelDetailsPage;

import java.io.IOException;
public class travelDetailsPageLoopSteps {
    WebDriver driver = Hooks.getDriver();

    DashboardPage dashboard = new DashboardPage(driver);
    List<WebElement> travelCards = dashboard.getAllTravelCards();

    TravelDetailsPage travelDetailsPage = new TravelDetailsPage(driver);

    @And("they click on each Cover photo in the Travel Cards")
    public void compareCoverPhotos() {
        DashboardPage dashboard = new DashboardPage(driver);
        //List<WebElement> travelCards = dashboard.getAllTravelCards();

        System.out.println("Number of cards: " + travelCards.size());
        for (int i = 0; i < dashboard.getNumberOfCards(); i++) {
            // Get the updated list of cards
            List<WebElement> travelCards = dashboard.getAllTravelCards();

            // Get the current card
            WebElement card = travelCards.get(i);
            // Get the cover photo URL from the dashboard
            String dashboardCoverPhotoUrl = dashboard.getCoverPhotoUrl2(card);
            String dashboardDestinationName = dashboard.getDestinationName2(card);
            String dashboardCardDates = dashboard.getDates2(card);

            // Click the cover photo and navigate to the details page
            dashboard.clickCoverPhoto2(card);


            // Check if the logo is present
            Assert.assertTrue(travelDetailsPage.verifyLogoIsDisplayed());
            Assert.assertTrue(travelDetailsPage.verifyLogoAlignment());
            System.out.println("\nLogo Verified");

            // the page should have a Profile dropdown
            Assert.assertTrue(travelDetailsPage.verifyLogoutButtonIsDisplayed());
            System.out.println("Logout Button Verified");

            // the screen should display the breadcrumbs as Travels/[destination_name]
            travelDetailsPage.printBreadcrumbs();
            travelDetailsPage.verifyBreadcrumbsAreDisplayed();

            // the screen should have the destination name
            Assert.assertTrue(travelDetailsPage.verifyDestinationNameIsDisplayed());
            String travelDetailsDestinationName = travelDetailsPage.getDestinationName();
            Assert.assertEquals(travelDetailsDestinationName, dashboardDestinationName);
            System.out.println("Destination Name Verified");

            // the screen should have the start date and the end date
            Assert.assertTrue(travelDetailsPage.verifyDatesIsDisplayed());
            String travelDetailsDates = travelDetailsPage.getDates();
            // Compare the dates
            Assert.assertEquals(dashboardCardDates, travelDetailsDates);
            System.out.println("Dates Verified");

            // the screen should have the number of notes
            Assert.assertTrue(travelDetailsPage.verifyNumberOfNotesIsDisplayed());
            System.out.println("Notes Verified");

            // the screen should display the Cover photo from the Travel Card
            // Get the cover photo URL from the details page
            String detailsCoverPhotoUrl = travelDetailsPage.getCoverPhotoUrl();
            // Compare the URLs
            Assert.assertEquals(dashboardCoverPhotoUrl, detailsCoverPhotoUrl);
            System.out.println("Photos Verified");

            // the screen should have a description
            Assert.assertTrue(travelDetailsPage.verifyDescriptionIsDisplayed());
            System.out.println("Description Verified");

            // the screen should include a + New Note button
            Assert.assertTrue(travelDetailsPage.verifyNewNoteButtonIsDisplayed());
            System.out.println("New Note Button Verified");

            // a message indicating that ‘No notes are available yet’ should be displayed if there are 0 notes
            String NrOfNotes = travelDetailsPage.getNumberOfNotes();
            System.out.println("Number of Notes: " + NrOfNotes);
            if(travelDetailsPage.verifyNoNotesMessageIsDisplayed()){
                System.out.println("No Notes Message is Displayed");
                Assert.assertTrue(travelDetailsPage.verifyNoNotesMessageIsDisplayed());
                Assert.assertTrue(travelDetailsPage.verifyNumberOfNotesIsZero());
            }

            // Navigate back to the dashboard
            driver.navigate().back();
            System.out.println("Step finished");
        }
    }

}
