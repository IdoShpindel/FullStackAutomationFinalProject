package pageObjects.paraBank;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPanel {

    @FindBy(name = "username")
    public WebElement txt_username;

    @FindBy(name = "password")
    public WebElement txt_password;

    @FindBy(xpath = "//input[@class='button']")
    public WebElement btn_login;

    @FindBy(xpath = "/html/body/div[1]/div[3]/div[1]/div/p[2]/a")
    public WebElement link_register;

    @FindBy(className = "error")
    public WebElement txt_loginFailed;



}
