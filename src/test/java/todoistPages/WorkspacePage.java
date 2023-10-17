package todoistPages;

import controls.Button;
import org.openqa.selenium.By;

public class WorkspacePage {
    public Button profileButton = new Button(By.id(":r3:"));
    public Button settingsButton = new Button(By.id("user_menu_settings_menuitem"));
    public Button logoutButton = new Button(By.xpath("//span[contains(text(), 'Cerrar')]"));

}
