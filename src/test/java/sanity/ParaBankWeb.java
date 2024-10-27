package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.WebFlows;

@Listeners(utilities.Listeners.class)
public class ParaBankWeb extends CommonOps {


    @Test(description = "Test01 - Verify successful register")
    @Description("This test register new customer and verifies that his account was created successfully")
    public void test01_verifySuccessfulRegister() {
        WebFlows.clearDB();
        WebFlows.register("Haim", "Ganan", "Vered 1", "Rehovot", "Israel", "1234567", "123456789", "HaimG", "PWD123", "PWD123");
        String test01ActualResult = paraBankMain.head_success.getText();
        WebFlows.logout();
        Verifications.verifyString(test01ActualResult, "Your account was created successfully. You are now logged in.");

    }

    @Test(description = "Test02 - Verify loan request approval")
    @Description("This test register new customer, then request new loan and verifies that the loan request created and approved")
    public void test02_verifyLoanRequestApproval() {
        WebFlows.clearDB();
        WebFlows.register("Eric", "Hoffman", "Vered 1", "Rehovot", "Israel", "1234567", "123456755", "EHoffman3", "123456", "123456");
        WebFlows.newLoan("1000", "200");
        String test02actualResult = paraApplyForLoan.txt_loanApproveText.getAttribute("textContent");
        WebFlows.logout();
        Verifications.verifyString(test02actualResult, "Congratulations, your loan has been approved.");

    }

    @Test(description = "Test03 - Verify 'Latest News' link")
    @Description("This test checks that the 'Latest News' link works properly")
    public void test03_verifyLatestNewsLink() {
        WebFlows.viewLatestNews();
        Verifications.verifyTextInElement(paraBankHomePage.header_latestNews, "ParaBank News");
    }

    @Test(description = "Test04 - Verify if logged in", dataProvider = "data-provider-users", dataProviderClass = utilities.MangeDDT.class)
    @Description("This test checks that login behavior and failed login behavior are correct(Using Data driven testing)")
    public void test04_VerifyIfLoggedIn(String username, String password, String shouldExist) {
        WebFlows.navigateHome();
        WebFlows.loginVerification(username, password, shouldExist);
    }

    @Test(description = "Test05 - Verify left menu items")
    @Description("This test verifies that when clicking the logo link, all items on the left menu are loaded (Using soft assertion)")
    public void test05_verifyLeftMenuItems() {
        WebFlows.navigateHome();
        Verifications.visibilityOfElements(paraBankHeaderPanel.list_leftMenu);
    }

    @Test(description = "Test06 - Verify 'About' icon")
    @Description("This test verifies that when clicking the logo link, the correct 'About' button icon is displayed (Using Sikuli tool)")
    public void test06_verifyAboutIcon() {
        WebFlows.navigateHome();
        Verifications.visualElement("ParaBankAbout");

    }
}
