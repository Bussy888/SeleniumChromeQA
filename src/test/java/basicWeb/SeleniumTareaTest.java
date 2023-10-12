package basicWeb;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTareaTest {
    ChromeDriver chrome;
    @BeforeEach
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/chrome/chromedriver.exe");
        chrome = new ChromeDriver();
        chrome.manage().window().maximize();
        chrome.get("http://todo.ly/");
    }
    //  .basic("upbapi@upbapi.com", "12345")
    @Test
    public void verifyCreateProjectTest() throws InterruptedException {
        // click login button
        chrome.findElement(By.xpath("//img[@src=\"/Images/design/pagelogin.png\"]")).click();
        // set email
        chrome.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxEmail")).sendKeys("upbapi@upbapi.com");
        // set password
        chrome.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxPassword")).sendKeys("12345");
        // click login
        chrome.findElement(By.id("ctl00_MainContent_LoginControl1_ButtonLogin")).click();


        //CREAR PROYECTO
        chrome.findElement(By.className("AddProjectLiDiv")).click();
        chrome.findElement(By.id("NewProjNameInput")).sendKeys("MateoMSelenium");
        chrome.findElement(By.id("NewProjNameButton")).click();

        Thread.sleep(5000);
        // verificar si existe el control del logout

        Assertions.assertTrue((chrome.findElements(By.xpath("//a[text()='Logout']")).size() == 1),
                "ERROR no se pudo ingresar a la sesion");

        Thread.sleep(5000);

    }
    @Test
    public void verifyUpdateProjectTest() throws InterruptedException {
        // click login button
        chrome.findElement(By.xpath("//img[@src=\"/Images/design/pagelogin.png\"]")).click();
        // set email
        chrome.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxEmail")).sendKeys("upbapi@upbapi.com");
        // set password
        chrome.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxPassword")).sendKeys("12345");
        // click login
        chrome.findElement(By.id("ctl00_MainContent_LoginControl1_ButtonLogin")).click();


        //EDITAR PROYECTO
        chrome.findElement(By.id("ItemId_4130009")).click();
        chrome.findElement(By.id("ItemId_4130009")).findElement(By.className("ItemIndicator")).click();
        chrome.findElement(By.id("projectContextMenu")).findElement(By.className("edit")).click();
        chrome.findElement(By.id("ItemId_4130009")).findElement(By.id("ItemEditTextbox")).sendKeys("2");
        chrome.findElement(By.id("ItemId_4130009")).findElement(By.id("ItemEditSubmit")).click();
        Thread.sleep(5000);
        // verificar si existe el control del logout

        Assertions.assertTrue((chrome.findElements(By.xpath("//a[text()='Logout']")).size() == 1),
                "ERROR no se pudo ingresar a la sesion");

        Thread.sleep(5000);

    }
    @AfterEach
    public void closeBrowser() {
        chrome.quit();
    }
}