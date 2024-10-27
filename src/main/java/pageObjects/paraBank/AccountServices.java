package pageObjects.paraBank;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountServices {
    @FindBy(xpath = "/html/body/div[1]/div[3]/div[1]/ul/li[1]/a")
    public WebElement link_openNewAccount;

    @FindBy(xpath = "/html/body/div[1]/div[3]/div[1]/ul/li[2]/a")
    public WebElement link_accountOverview;

    @FindBy(xpath = "/html/body/div[1]/div[3]/div[1]/ul/li[3]/a")
    public WebElement link_transferFunds;

    @FindBy(xpath = "/html/body/div[1]/div[3]/div[1]/ul/li[4]/a")
    public WebElement link_billPay;

    @FindBy(xpath = "/html/body/div[1]/div[3]/div[1]/ul/li[5]/a")
    public WebElement link_findTransactions;

    @FindBy(xpath = "/html/body/div[1]/div[3]/div[1]/ul/li[6]/a")
    public WebElement link_updateContactInfo;

    @FindBy(xpath = "/html/body/div[1]/div[3]/div[1]/ul/li[7]/a")
    public WebElement link_requestLoan;

    @FindBy(xpath = "/html/body/div[1]/div[3]/div[1]/ul/li[8]/a")
    public WebElement link_logOut;




}
