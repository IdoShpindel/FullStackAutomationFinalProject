package workflows;

import extensions.DBActions;
import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Step;
import utilities.CommonOps;

import java.util.List;

public class WebFlows extends CommonOps {
    @Step("Click on the logo to get to the homepage")
    public static void navigateHome(){
        UIActions.click(paraBankHeaderPanel.link_logo);
    }

    @Step("Business Flow: View the latest news page")
    public static void viewLatestNews(){
        UIActions.click(paraBankHomePage.link_latestNews);
    }

    @Step("Business Flow: Create new customer")
    public static void register(String firstName, String lastName, String address, String city, String state, String zipCode, String sSN, String userName, String passWord, String rePassWord) {
        UIActions.click(paraBankLogin.link_register);
        UIActions.updateText(paraBankRegister.txt_firstName, firstName);
        UIActions.updateText(paraBankRegister.txt_lastName, lastName);
        UIActions.updateText(paraBankRegister.txt_address, address);
        UIActions.updateText(paraBankRegister.txt_city, city);
        UIActions.updateText(paraBankRegister.txt_state, state);
        UIActions.updateText(paraBankRegister.txt_zipCode, zipCode);
        UIActions.updateText(paraBankRegister.txt_ssn, sSN);
        UIActions.updateText(paraBankRegister.txt_newUN, userName);
        UIActions.updateText(paraBankRegister.txt_newPWD, passWord);
        UIActions.updateText(paraBankRegister.txt_repeatPWD, rePassWord);
        UIActions.click(paraBankRegister.btn_register);

    }
    @Step("Business Flow: Login Verification")
    public static void loginVerification(String username, String password, String shouldExist){
        UIActions.updateText(paraBankLogin.txt_username, username);
        UIActions.updateText(paraBankLogin.txt_password, password);
        UIActions.click(paraBankLogin.btn_login);
        if (shouldExist.equalsIgnoreCase("not-exist")){
            Verifications.customerNotLoggedIn();
        } else if (shouldExist.equalsIgnoreCase("exists")){
            Verifications.customerLoggedIn();
        } else {
            throw new RuntimeException("Invalid expected output option in Data Driven Testing. Should be 'exist' or 'Not-exist'");
        }
    }

    @Step("Business Flow: Logout")
    public static void logout(){
        UIActions.click(paraAccountServices.link_logOut);
    }
    @Step("Business Flow: New loan")
    public static void newLoan(String loanAmount, String downPayment){
        UIActions.click(paraAccountServices.link_requestLoan);
        UIActions.updateText(paraApplyForLoan.txt_loanAmount, loanAmount);
        UIActions.updateText(paraApplyForLoan.txt_downPayment, downPayment);
        UIActions.click(paraApplyForLoan.btn_applyNow);
    }

    @Step("Clear DB")
    public static void clearDB(){
        UIActions.click(paraBankHeaderPanel.link_admin);
        UIActions.click(paraBankAdminPage.btn_cleanDB);
    }

    @Step("Business Flow: Send message via Customer Care with data from DB")
    public static void customerMessageDB(){
        String query = "SELECT name, email, phone, message FROM Customer_Care WHERE id='2'";
        List<String> msg = DBActions.getCustomerMessage(query);
        UIActions.click(paraBankHeaderPanel.link_customerCare);
        UIActions.updateText(paraBankCustomerCare.txt_nameCC, msg.get(0));
        UIActions.updateText(paraBankCustomerCare.txt_emailCC, msg.get(1));
        UIActions.updateText(paraBankCustomerCare.txt_phoneCC, msg.get(2));
        UIActions.updateText(paraBankCustomerCare.txt_messageCC, msg.get(3));
        UIActions.click(paraBankCustomerCare.btn_sendToCC);


    }






}
