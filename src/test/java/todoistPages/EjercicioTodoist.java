package todoistPages;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import session.Session;

public class EjercicioTodoist {
    MainPage mainPage = new MainPage();
    LoginPage loginPage = new LoginPage();

    WorkspacePage workspacePage = new WorkspacePage();

    AccountSettingsPage settingsPage = new AccountSettingsPage();

    String email = "sawova4461@ibtrades.com";
    String password = "Contra12345";//Pass12345
    String newPassword = "Pass12345";//Contra12345

    @AfterEach
    public void close(){
        Session.getInstance().closeSession();
    }

    @BeforeEach
    public void open(){
        Session.getInstance().getBrowser().get("https://todoist.com/");
    }
    @Test
    public void loginTesting() throws InterruptedException {
        mainPage.loginButton.click();
        Thread.sleep(3000);
        loginPage.emailTextBox.setText(email);
        loginPage.passwordTextBox.setText(password);
        loginPage.loginButton.click();
        Thread.sleep(5000);
        Assertions.assertTrue(workspacePage.profileButton.isControlDisplayed(), "ERROR no se pudo iniciar sesion");

        workspacePage.profileButton.click();
        workspacePage.settingsButton.click();

        Thread.sleep(2000);
        settingsPage.changePassButton.click();

        Thread.sleep(2000);
        settingsPage.actualPass.setText(password);
        settingsPage.newPass.setText(newPassword);
        settingsPage.newPassRepeat.setText(newPassword);
        settingsPage.submitButton.click();
        Thread.sleep(1000);
        Thread.sleep(4000);
        settingsPage.closeButton.click();
        Thread.sleep(1000);
        workspacePage.profileButton.click();
        workspacePage.logoutButton.click();

        Thread.sleep(2000);

        mainPage.loginButton.click();
        Thread.sleep(3000);
        loginPage.emailTextBox.setText(email);
        loginPage.passwordTextBox.setText(newPassword);
        loginPage.loginButton.click();

        Thread.sleep(3000);

        Assertions.assertTrue(workspacePage.profileButton.isControlDisplayed(), "ERROR no se pudo iniciar sesion" +
                "la contrasena no se pudo cambiar");



    }
}
