package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class DashboardPage {
    public DashboardPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(css = ".content h1")
    private WebElement pageTitle;
    @FindBy(xpath = "//*[@id=\"root\"]/nav/a/img")
    private WebElement pageLogo;
    @FindBy(css = ".navigation")
    private WebElement navigation;
    @FindBy(css = ".navigation .logout")
    private WebElement logoutButton;
    @FindBy(css = ".card")
    private WebElement card;
    @FindBy(css = ".card")
    private List<WebElement> cards;

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
        return pageLogo.isDisplayed();
    }

    public boolean verifyLogoAlignment() {
        return navigation.getCssValue("justify-content").contains("space-between");

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

    public boolean verifyCardOrder() {
        if (cards.isEmpty()) {
            return false;
        }

        WebElement firstCard = cards.get(0);
        LocalDate firstCardDate = convertStrToDate(cardDate.getText());

        for (int i = 1; i < cards.size(); i++) {
            WebElement card = cards.get(i);
            String xpath = String.format("//*[@id=\"root\"]/div/div/div[2]/div[%d]/div/div/div[2]/div/p", i);
            String cardDateStr = card.findElement(By.xpath(xpath)).getText();
            LocalDate cardDate = convertStrToDate(cardDateStr);

            if (firstCardDate.isBefore(cardDate)) {
                return false;
            }
        }

        return true;
    }

    private LocalDate convertStrToDate(String dateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, d MMMM yyyy", new Locale("ro", "RO"));
        return LocalDate.parse(dateStr, formatter);
    }

    public boolean verifyCardCorespondsToTravels() throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/travel-journal/travels"))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(response.body());

        return jsonObject.size() == cards.size();
    }
        

//    public boolean verifyRecordedTravels(){
////        call the API at localhost:8080/
//    }

    }
