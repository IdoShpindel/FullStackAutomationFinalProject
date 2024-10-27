package sanity;

import com.google.common.util.concurrent.Uninterruptibles;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.MobileFlows;
import workflows.WebFlows;

import java.util.concurrent.TimeUnit;

@Listeners(utilities.Listeners.class)
public class MortgageCalculatorMobile extends CommonOps {
    @Test(description = "Test01 - Verify mortgage calculation")
    @Description("This test fill the mortgage fields and calculate repayment")
    public void test01_verifyMortgageCalculation() {
        MobileFlows.calculate("700000","10", "7");
        Verifications.verifyTextInElement(mortgageMain.txt_repayment, "£8305.35");

    }

    @Test(description = "Test02 - Verify saved mortgage calculation")
    @Description("This test will save calculate repayment and verify it added to the saved mortgage calculations list")
    public void test02_verifySavedMortgageCalculation() {
        MobileFlows.calculate("200000","10", "3");
        MobileFlows.saveCalculation();
        MobileFlows.viewSavedCalculationList();
        String actualResult = mortgageSaved.txt_savedRepayment.getText();
        MobileFlows.deleteCalculation();
        MobileFlows.returnToMainPage();
        Verifications.verifyString(actualResult, "£1953.84");

    }

}
