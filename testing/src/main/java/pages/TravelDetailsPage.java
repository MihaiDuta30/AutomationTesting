package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class TravelDetailsPage {
    WebDriver driver;

    @FindBy(css = ".logo")
    private WebElement pageLogo;

    @FindBy(css = ".navigation")
    private WebElement navigation;

    @FindBy(css = ".navigation .logout")
    private WebElement logoutButton;

    @FindBy(css = ".breadcrumb-link")
    private WebElement breadcrumb1;
    @FindBy(css = ".breadcrumb-text")
    private WebElement breadcrumb2;
    public void printBreadcrumbs() {
        System.out.println(breadcrumb1.getText() + "/" + breadcrumb2.getText());
    }

    @FindBy(css = ".city")
    private WebElement destinationName;

    @FindBy(css = ".dates")
    private WebElement dates;

    @FindBy(css = ".notes")
    private WebElement numberOfNotes;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div[2]/div[2]/img")
    private WebElement coverPhoto;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div[2]/div[3]/p")
    private WebElement description;

    @FindBy(css = ".new-note-button")
    private WebElement newNoteButton;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div[2]/div[4]/div[2]/div")
    private WebElement noNotesMessage;

    public boolean verifyLogoIsDisplayed() {
        return pageLogo.isDisplayed();
    }
    public boolean verifyLogoAlignment() {
        return navigation.getCssValue("justify-content").contains("space-between");

    }
    public boolean verifyLogoutButtonIsDisplayed() {
        return logoutButton.isDisplayed();
    }
    public boolean verifyBreadcrumbsAreDisplayed() {
        return (breadcrumb1.isDisplayed() && breadcrumb2.isDisplayed());
    }
    public boolean verifyDestinationNameIsDisplayed() {
        return destinationName.isDisplayed();
    }
    public boolean verifyDatesIsDisplayed() {
        return dates.isDisplayed();
    }
    public String getDates() {
        return dates.getText();
    }
    public boolean verifyNumberOfNotesIsDisplayed() {
        return numberOfNotes.isDisplayed();
    }
    public String getNumberOfNotes() {
        return numberOfNotes.getText();
    }
    public boolean verifyCoverPhotoIsDisplayed() {
        return coverPhoto.isDisplayed();
    }

    public String getCoverPhotoUrl() {
        return coverPhoto.getAttribute("src");
    }
    public boolean verifyDescriptionIsDisplayed() {
        return description.isDisplayed();
    }
    public boolean verifyNewNoteButtonIsDisplayed() {
        return newNoteButton.isDisplayed();
    }

    public boolean verifyNoNotesMessageIsDisplayed() {
        return noNotesMessage.isDisplayed();
    }
    public boolean verifyNumberOfNotesIsZero() {
        String notes = numberOfNotes.getText();
        if (notes.equals("0 Notes")) {
            return true;
        } else {
            throw new AssertionError("Error: Number of notes is not '0 notes'");
        }
    }

    public String getDestinationName() {
        return destinationName.getText();
    }
    public String getDestinationNameFromUrl() {
        String url = driver.getCurrentUrl();
        // Assuming the URL structure is something like "http://localhost:5173/travel-journal/1"
        return url.substring(url.indexOf("travel-journal") + "travel-journal/".length()); // This will give you "1" or whatever comes after "travel-journal/"
    }

    private LocalDate convertStrToDate(String dateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, d MMMM yyyy", new Locale("ro", "RO"));
        return LocalDate.parse(dateStr, formatter);
    }

    public TravelDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
