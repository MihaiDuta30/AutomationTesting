package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testConfig.BasePage;
import org.apache.commons.lang3.RandomStringUtils;

public class RegisterPage extends BasePage {
    public RegisterPage(WebDriver webDriver)
    {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(css = ".input-field input[id='first-name']")
    private WebElement firstNameField;

    @FindBy(css = ".input-field input[id='last-name']")
    private WebElement lastNameField;

    @FindBy(css = ".input-field input[id='email']")
    private WebElement emailField;

    @FindBy(css = ".input-field input[id='password']")
    private WebElement passwordField;

    @FindBy(css = ".input-field input[id='confirm-password']")
    private WebElement confirmPasswordField;

    @FindBy(css = ".card-body button")
    private WebElement registerButton;

    @FindBy(css = ".login-card .registerLink")
    private WebElement singupButton;

    @FindBy(css = ".card-body .card-title")
    private WebElement registerTitle;

    public boolean isRegisterPage() {return driver.getCurrentUrl().endsWith("/register"); }
    public boolean firstNameField() {return firstNameField.isDisplayed(); }
    public boolean lastNameField() {return lastNameField.isDisplayed(); }
    public boolean emailField() {return emailField.isDisplayed(); }
    public boolean passwordField() {return passwordField.isDisplayed(); }
    public boolean confirmPasswordField() {return confirmPasswordField.isDisplayed(); }
    public boolean registerButton() { return registerButton.isDisplayed(); }
    public boolean singupButton() { return singupButton.isDisplayed();}
    public boolean registerTitle() {return registerTitle.isDisplayed(); }
    public void registerToApp() {
        firstNameField();
        firstNameField.click();
        firstNameField.sendKeys("Test");

        lastNameField();
        lastNameField.click();
        lastNameField.sendKeys("Auto");

        emailField();
        emailField.click();
        emailField.sendKeys(emailGenerator());

        passwordField();
        passwordField.click();
        passwordField.sendKeys("TestAuto123");

        confirmPasswordField();
        confirmPasswordField.click();
        confirmPasswordField.sendKeys("TestAuto123");
    }

    public void clickOnRegister() {
        registerButton();
        registerButton.click();
    }

    public void clickOnSignup() {
        singupButton();
        singupButton.click();
    }

    public CharSequence emailGenerator() {
        String generatedString = RandomStringUtils.randomAlphabetic(12);
        return generatedString + "@testauto.com";
    }
}
