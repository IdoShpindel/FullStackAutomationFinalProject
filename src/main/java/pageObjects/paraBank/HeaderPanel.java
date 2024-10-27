package pageObjects.paraBank;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HeaderPanel {
    @FindBy(xpath = "/html/body/div[1]/div[2]/ul[2]/li[3]/a")
    public WebElement link_customerCare;

    @FindBy(className = "logo")
    public WebElement link_logo;

    @FindBy(xpath = "//div/ul[@class='leftmenu']/li")
    public List<WebElement> list_leftMenu;

    @FindBy(xpath = "/html/body/div[1]/div[2]/ul[1]/li[6]/a")
    public WebElement link_admin;


}
