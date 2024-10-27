package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.WebFlows;

@Listeners(utilities.Listeners.class)
public class ParaBankWebDB extends CommonOps {
    @Test(description = "Test01 - verify message sent text")
    @Description("this test fills the customer message form with data from DB and send it")
    public void test01_verifyMessageSentText(){
        WebFlows.customerMessageDB();
        Verifications.verifyTextInElement(paraBankCustomerCare.txt_success, "A Customer Care Representative will be contacting you.");
    }

}

