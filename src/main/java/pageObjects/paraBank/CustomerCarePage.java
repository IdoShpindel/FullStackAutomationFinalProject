package pageObjects.paraBank;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomerCarePage {
    @FindBy(id = "name")
    public WebElement txt_nameCC;

    @FindBy(id = "email")
    public WebElement txt_emailCC;

    @FindBy(id = "phone")
    public WebElement txt_phoneCC;

    @FindBy(id = "message")
    public WebElement txt_messageCC;

    @FindBy(xpath = "/html/body/div[1]/div[3]/div[2]/form/table/tbody/tr[5]/td[2]/input")
    public WebElement btn_sendToCC;

    @FindBy(xpath = "/html/body/div[1]/div[3]/div[2]/p[2]")
    public WebElement txt_success;
}
