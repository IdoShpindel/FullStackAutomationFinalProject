package utilities;

import org.openqa.selenium.support.PageFactory;
import pageObjects.paraBank.*;
import pageObjects.mortgage.*;


public class ManagePages extends Base{

    public static void initParaBank(){
        paraBankLogin = PageFactory.initElements(driver, LoginPanel.class);
        paraBankRegister = PageFactory.initElements(driver, RegisterPage.class);
        paraBankMain = PageFactory.initElements(driver, pageObjects.paraBank.MainPage.class);
        paraAccountServices = PageFactory.initElements(driver, AccountServices.class);
        paraApplyForLoan = PageFactory.initElements(driver, ApplyForLoan.class);
        paraBankHeaderPanel = PageFactory.initElements(driver, HeaderPanel.class);
        paraBankCustomerCare = PageFactory.initElements(driver, CustomerCarePage.class);
        paraBankHomePage = PageFactory.initElements(driver, HomePage.class);
        paraBankAdminPage = PageFactory.initElements(driver, AdminPage.class);

    }

    public static void  initMortgage(){
        mortgageMain = new pageObjects.mortgage.MainPage(mobileDriver);
        mortgageSaved = new pageObjects.mortgage.SavedCalculations(mobileDriver);
        }

    public static void initTodo(){
        todoMain = PageFactory.initElements(driver, pageObjects.todo.MainPage.class);
    }
    public static void initCalculator(){
        calcMain = PageFactory.initElements(driver, pageObjects.calculator.MainPage.class);
    }
}
