package utilities;


import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.asserts.SoftAssert;
import pageObjects.paraBank.*;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class Base {
    //General
    protected static WebDriverWait wait;
    protected static SoftAssert softAssert;
    protected static Screen screen;
    protected static Actions action;
    protected static String platform;

    //Web & Electron
    protected static WebDriver driver;
    protected static ChromeOptions opt;

    //Mobile
    protected static AppiumDriver mobileDriver;
    protected static DesiredCapabilities dc = new DesiredCapabilities();

    //RestAPI
    protected static RequestSpecification httpRequest;
    protected static Response response;
    protected static JSONObject params = new JSONObject();
    protected static JsonPath jp;

    //Page objects - Web
    protected static HomePage paraBankHomePage;
    protected static LoginPanel paraBankLogin;
    protected static RegisterPage paraBankRegister;
    protected static pageObjects.paraBank.MainPage paraBankMain;
    protected static AccountServices paraAccountServices;
    protected static ApplyForLoan paraApplyForLoan;
    protected static HeaderPanel paraBankHeaderPanel;
    protected static CustomerCarePage paraBankCustomerCare;
    protected static AdminPage paraBankAdminPage;

    //Page objects - Mobile
    protected static pageObjects.mortgage.MainPage mortgageMain;
    protected static pageObjects.mortgage.SavedCalculations mortgageSaved;

    //Page objects - Electron
    protected static pageObjects.todo.MainPage todoMain;

    //Page objects - Desktop
    protected static pageObjects.calculator.MainPage calcMain;

    //Database
    protected static Connection con;
    protected static Statement stmt;
    protected static ResultSet rs;




}
