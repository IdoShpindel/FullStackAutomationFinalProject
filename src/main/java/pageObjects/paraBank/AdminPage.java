package pageObjects.paraBank;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminPage {
    @FindBy(xpath = "/html/body/div[1]/div[3]/div[2]/table/tbody/tr/td[1]/form/table/tbody/tr/td[2]/button")
    public WebElement btn_cleanDB;
}
