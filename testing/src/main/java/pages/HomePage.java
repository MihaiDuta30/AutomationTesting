package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public HomePage(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(css = ".content h1")
    private WebElement pageTitle;
    @FindBy(css = ".navigation .logo")
    private WebElement pageLogo;
    @FindBy(css = ".navigation .logout")
    private WebElement logoutButton;

    public boolean verifyHomePageDisplayed() {
        return pageTitle.isDisplayed();
    }

    public boolean verifyLogoIsDisplayed() {
        return pageLogo.isDisplayed();
    }

    public boolean verifyLogoutButtonIsDisplayed() {
        return logoutButton.isDisplayed();
    }

}

