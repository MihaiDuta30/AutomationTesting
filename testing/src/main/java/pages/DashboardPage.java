package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
    public DashboardPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(css = ".content h1")
    private WebElement pageTitle;
    @FindBy(css = ".navigation .logo")
    private WebElement pageLogo;
    @FindBy(css = ".navigation .logout")
    private WebElement logoutButton;
    @FindBy(css = ".card")
    private WebElement card;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div[1]/div/div/div[2]/div/div/p")
    private WebElement cardBudget;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/button")
    private WebElement addTripButton;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div[1]/div/div/div[1]/img")
    private WebElement coverPhoto;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div[1]/div/div/div[2]/p")
    private WebElement cardDestination;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div[1]/div/div/div[2]/div/p")
    private WebElement cardDate;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div[1]/div/div/div[2]/div/div")
    private WebElement cardPriceAndNotes;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div[1]/div/div/div[3]/button[1]")
    private WebElement cardEditButton;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div[1]/div/div/div[3]/button[2]")
    private WebElement cardDeleteButton;

    public boolean verifyDashboardPageDisplayed() {
        return pageTitle.isDisplayed();
    }

    public boolean verifyLogoIsDisplayed() {
        return pageLogo.getCssValue("justify-content").contains("space-between");
    }

    public boolean verifyLogoutButtonIsDisplayed() {
        return logoutButton.isDisplayed();
    }

    public boolean verifyCardIsDisplayed() {
        return card.isDisplayed();
    }

    public boolean verifyAddTripButtonIsDisplayed() {
        return addTripButton.isDisplayed();
    }


    public boolean verifyCoverPhotoIsDisplayed() {
        return coverPhoto.isDisplayed();
    }


    public boolean verifyCardDestination() {
        return cardDestination.isDisplayed();
    }

    public boolean verifyCardDate() {
        if (cardDate.isDisplayed()) {
            return cardDate.getText().contains("to");
        } else {
            return false;
        }
    }

    public boolean verifyCardPriceAndNotes() {
        if (cardPriceAndNotes.isDisplayed()) {
            return Integer.parseInt(cardBudget.getText()) > 0 && cardPriceAndNotes.getText().contains("Notes");
        }else {
            return false;
        }

    }

    public boolean verifyCardEditButton () {
        return cardEditButton.isDisplayed();
    }

    public boolean verifyCardDeleteButton () {
        return cardDeleteButton.isDisplayed();
    }

//    public boolean verifyRecordedTravels(){
////        call the API at localhost:8080/
//    }

    }
