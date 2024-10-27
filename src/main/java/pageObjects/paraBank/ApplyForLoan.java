package pageObjects.paraBank;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ApplyForLoan {

    @FindBy(id = "amount")
    public WebElement txt_loanAmount;

    @FindBy(id = "downPayment")
    public WebElement txt_downPayment;

    @FindBy(xpath = "/html/body/div[1]/div[3]/div[2]/div/div[1]/form/table/tbody/tr[4]/td[2]/input")
    public WebElement btn_applyNow;

    @FindBy(id = "loanStatus")
    public WebElement txt_approvalStatus;

    @FindBy(xpath = "/html/body/div[1]/div[3]/div[2]/div/div[2]/div[2]/p[1]")
    public WebElement txt_loanApproveText;
}
