package factoryBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Edge implements IBrowser{
    EdgeDriver edgeDriver;
    @Override
    public WebDriver create() {
        System.setProperty("webdriver.edge.driver","src/test/resources/edge/msedgedriver.exe");
        edgeDriver = new EdgeDriver();
        return edgeDriver;
    }
}
