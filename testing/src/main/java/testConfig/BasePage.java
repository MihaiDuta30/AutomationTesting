package testConfig;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static testConfig.PropertiesLoader.getPropertyValue;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    int timeoutSec = 10;

    public BasePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSec));

    }

    public void loadBaseUrl() {
        String url = getPropertyValue("url");
        driver.get(url);
    }

}
