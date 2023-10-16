package ejercicioParcial2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Date;

public class WebUI3 {
    ChromeDriver chrome;
    @BeforeEach
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/chrome/chromedriver.exe");
        chrome = new ChromeDriver();
        chrome.manage().window().maximize();
        // implicit
        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
        chrome.get("http://todo.ly/");
    }
    //  .basic("upbapi@upbapi.com", "12345")
    @Test
    public void createUpdateDeleteProject() throws InterruptedException {
        // click login button
        chrome.findElement(By.xpath("//img[@src=\"/Images/design/pagelogin.png\"]")).click();
        // set email
        chrome.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxEmail")).sendKeys("selenium@seleniumupb.com");
        // set password
        chrome.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxPassword")).sendKeys("12345");
        // click login
        chrome.findElement(By.id("ctl00_MainContent_LoginControl1_ButtonLogin")).click();
        // verificar si existe el control del logout

        String fullName = "NewFullName";
        //Acceder a Settings
        chrome.findElement(By.xpath("//a[contains(@href, 'OpenSettingsDialog()')]")).click();
        //Cambiar Nombre
        chrome.findElement(By.id("FullNameInput")).clear();
        chrome.findElement(By.id("FullNameInput")).sendKeys(fullName);
        chrome.findElement(By.xpath("//button[@class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only']\n")).click();
        Thread.sleep(2000);
        chrome.findElement(By.xpath("//a[contains(@href, 'OpenSettingsDialog()')]")).click();
        System.out.println(chrome.findElement(By.id("FullNameInput")).getText());
        Thread.sleep(5000);
        Assertions.assertEquals(fullName,chrome.findElement(By.id("FullNameInput")).getAttribute("value"),"No se cambio el nombre correctamente");
    }

    @AfterEach
    public void closeBrowser(){
        chrome.quit();
    }
}
