package pageObjects.mortgage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class SavedCalculations {
    private AppiumDriver mobileDriverSC;

    public SavedCalculations(AppiumDriver mobileDriver){
        this.mobileDriverSC = mobileDriver;
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriverSC), this);
    }
    @AndroidFindBy(id = "tvRepayment")
    public AndroidElement txt_savedRepayment;

    @AndroidFindBy(id = "btnDel")
    public AndroidElement btn_delete;

    @AndroidFindBy(id = "button1")
    public AndroidElement btn_approveDeletion;

}
