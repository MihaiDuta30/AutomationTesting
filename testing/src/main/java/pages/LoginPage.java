package pages;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testConfig.BasePage;
import org.json.simple.JSONObject;

import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(css = ".login-form__input-field input[type='email']")
    private WebElement usernameField;

    @FindBy(css = ".login-form__input-field input[type='password']")
    private WebElement passwordField;

    @FindBy(css = ".login-card button")
    private WebElement loginButton;

    @FindBy(css = ".login-description .login-description__logo")
    private WebElement pageLogo;

    public boolean isLoginPage() {
        return driver.getCurrentUrl().endsWith("/login");
    }

    public boolean usernameField() {
        return usernameField.isDisplayed();
    }

    public boolean passwordField() {
        return passwordField.isDisplayed();
    }

    public boolean loginButton() {
        return loginButton.isDisplayed();
    }

    public void loginToApp(String user) throws IOException, ParseException {

        Object obj = new JSONParser().parse(new FileReader("src/main/java/utils/users.json"));
        JSONObject jasonObj = (JSONObject) obj;

        Map userID = ((Map)jasonObj.get(user));


        usernameField();
        usernameField.click();
        usernameField.sendKeys((CharSequence) userID.get("username"));

        passwordField();
        passwordField.click();
        passwordField.sendKeys((CharSequence) userID.get("password"));
    }

    public void clickOnLogin() {
        loginButton();
        loginButton.click();
    }

    public boolean verifyLogoIsDisplayed() {
        return pageLogo.isDisplayed();
    }

}
