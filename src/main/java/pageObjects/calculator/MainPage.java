package pageObjects.calculator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {
    @FindBy(xpath = "//*[@AutomationId='num1Button']")
    public WebElement btn_one;
    @FindBy(xpath = "//*[@AutomationId='num2Button']")
    public WebElement btn_two;
    @FindBy(xpath = "//*[@AutomationId='num3Button']")
    public WebElement btn_three;
    @FindBy(xpath = "//*[@AutomationId='num4Button']")
    public WebElement btn_four;
    @FindBy(xpath = "//*[@AutomationId='num5Button']")
    public WebElement btn_five;
    @FindBy(xpath = "//*[@AutomationId='num6Button']")
    public WebElement btn_six;
    @FindBy(xpath = "//*[@AutomationId='num7Button']")
    public WebElement btn_seven;
    @FindBy(xpath = "//*[@AutomationId='num8Button']")
    public WebElement btn_eight;
    @FindBy(xpath = "//*[@AutomationId='num9Button']")
    public WebElement btn_nine;
    @FindBy(xpath = "//*[@AutomationId='num0Button']")
    public WebElement btn_zero;
    @FindBy(xpath = "//*[@AutomationId='plusButton']")
    public WebElement btn_plus;
    @FindBy(xpath = "//*[@AutomationId='minusButton']")
    public WebElement btn_minus;
    @FindBy(xpath = "//*[@AutomationId='multiplyButton']")
    public WebElement btn_multiply;
    @FindBy(xpath = "//*[@AutomationId='divideButton']")
    public WebElement btn_divide;
    @FindBy(xpath = "//*[@AutomationId='equalButton']")
    public WebElement btn_equal;
    @FindBy(xpath = "//*[@AutomationId='CalculatorResults']")
    public WebElement field_result;
    @FindBy(xpath = "//*[@AutomationId='clearButton']")
    public WebElement btn_clear;


}
