package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.DesktopFlows;

@Listeners(utilities.Listeners.class)
public class CalculatorDesktop extends CommonOps {
    @Test(description = "Test01 - Verify addition command")
    @Description("This test adding two numbers and verifying the result")
    public void test01_verifyAdditionCommand() {
        DesktopFlows.calculateAddition();
        Verifications.verifyTextInElement(calcMain.field_result, "Display is 9");
    }

    @Test(description = "Test02 - Verify subtraction command")
    @Description("This test is subtracting two numbers and verifying the result")
    public void test02_verifySubtractionCommand() {
        DesktopFlows.calculateSubtraction();
        Verifications.verifyTextInElement(calcMain.field_result, "Display is 15");
    }

    @Test(description = "Test03 - Verify multiplication command")
    @Description("This test multiplying two numbers and verifying the result")
    public void test03_verifyMultiplicationCommand() {
        DesktopFlows.calculateMultiplication();
        Verifications.verifyTextInElement(calcMain.field_result, "Display is 30");
    }

    @Test(description = "Test04 - Verify division command")
    @Description("This test dividing two numbers and verifying the result")
    public void test04_verifyDivisionCommand() {
        DesktopFlows.calculateDivision();
        Verifications.verifyTextInElement(calcMain.field_result, "Display is 3.5");
    }
}
