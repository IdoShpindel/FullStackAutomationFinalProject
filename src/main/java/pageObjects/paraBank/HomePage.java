package pageObjects.paraBank;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

    @FindBy(xpath = "/html/body/div[1]/div[3]/div[2]/p[2]/a")
    public WebElement link_latestNews;

    @FindBy(className = "title")
    public WebElement header_latestNews;

}
