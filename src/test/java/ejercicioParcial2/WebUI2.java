package ejercicioParcial2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebUI2 {
    ChromeDriver chrome;
    //Correo: sawova4461@ibtrades.com
    //Password: Pass12345
    @BeforeEach
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/chrome/chromedriver.exe");
        chrome = new ChromeDriver();
        chrome.manage().window().maximize();
        chrome.get("https://todoist.com/es/");
    }
    @Test
    public void verifyLoginTest() throws InterruptedException {
        // click login button
        chrome.findElement(By.xpath("//a[@href='/auth/login']")).click();
        Thread.sleep(10000);
        // set email
        chrome.findElement(By.xpath("//input[@id='element-0' and @type='email']")).sendKeys("sawova4461@ibtrades.com");
        // set password
        chrome.findElement(By.xpath("//input[@id='element-3' and @type='password']")).sendKeys("Pass12345");
        // click login
        chrome.findElement(By.xpath("//button[@data-gtm-id='start-email-login']")).click();
        Thread.sleep(5000);
        // verificar si existe el control del logout

        Assertions.assertTrue((chrome.findElements(By.xpath("//button[@class='plus_add_button']")).size() == 1),
                "ERROR no se pudo ingresar a la sesion");

        Thread.sleep(5000);

    }

    @AfterEach
    public void closeBrowser() {
        chrome.quit();
    }
}
