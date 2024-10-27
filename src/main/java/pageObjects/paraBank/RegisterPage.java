package pageObjects.paraBank;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage {


    @FindBy(id = "customer.firstName")
    public WebElement txt_firstName;

    @FindBy(id = "customer.lastName")
    public WebElement txt_lastName;

    @FindBy(id = "customer.address.street")
    public WebElement txt_address;

    @FindBy(id = "customer.address.city")
    public WebElement txt_city;

    @FindBy(id = "customer.address.state")
    public WebElement txt_state;

    @FindBy(id = "customer.address.zipCode")
    public WebElement txt_zipCode;

    @FindBy(id = "customer.phoneNumber")
    public WebElement txt_phoneNumber;

    @FindBy(id = "customer.ssn")
    public WebElement txt_ssn;

    @FindBy(id = "customer.username")
    public WebElement txt_newUN;

    @FindBy(id = "customer.password")
    public WebElement txt_newPWD;

    @FindBy(id = "repeatedPassword")
    public WebElement txt_repeatPWD;

    @FindBy(xpath = "/html/body/div[1]/div[3]/div[2]/form/table/tbody/tr[13]/td[2]/input")
    public WebElement btn_register;
}
