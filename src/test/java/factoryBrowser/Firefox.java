package factoryBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox implements IBrowser{
    FirefoxDriver firefoxDriver;

    @Override
    public WebDriver create() {
        System.setProperty("webdriver.gecko.driver","src/test/resources/firefox/geckodriver.exe");
        firefoxDriver = new FirefoxDriver();
        return firefoxDriver;
    }
}
