package todoistPages;

import controls.Button;
import controls.TextBox;
import org.openqa.selenium.By;

public class AccountSettingsPage {
    public Button changePassButton = new Button(By.xpath("//a[@class='_8313bd46 _54d56775 _5e45d59f _2a3b75a1 _56a651f6' and @href='/app/settings/account/password']"));
    public TextBox actualPass = new TextBox(By.id("element-8"));
    public TextBox newPass = new TextBox(By.id("element-11"));
    public TextBox newPassRepeat = new TextBox(By.id("element-14"));
    public Button submitButton = new Button(By.xpath("//button[@class='_8313bd46 _7a4dbd5f _5e45d59f _2a3b75a1 _56a651f6']"));

    public Button closeButton = new Button(By.xpath("//button[@class='dOAUdcnSj9gBY1w5ax6aQxa5xcA8ASxf']"));






}
