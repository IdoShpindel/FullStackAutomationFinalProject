package utilities;

import com.google.common.util.concurrent.Uninterruptibles;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.windows.WindowsDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.annotations.*;


import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.testng.asserts.SoftAssert;
import org.w3c.dom.Document;

import java.lang.reflect.Method;
import java.net.URL;
import java.util.concurrent.TimeUnit;



public class CommonOps extends Base {

    public static String getData(String nodeName) {
        DocumentBuilder dBuilder;
        Document doc = null;
        File fXmlFile = new File("./Configuration/DataConfig.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
        }
        catch(Exception e) {
            System.out.println("Exception in reading XML file: " + e);
        }
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(nodeName).item(0).getTextContent();
    }

    public void initBrowser(String browserType){
        if(browserType.equalsIgnoreCase("chrome"))
            driver = initChromeDriver();
        else if(browserType.equalsIgnoreCase("firefox"))
            driver = initFirefoxDriver();
        else if(browserType.equalsIgnoreCase("edge"))
            driver= initEdgeDriver();
        else throw new RuntimeException("Invalid browser type");
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("TimeOutSec")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,Long.parseLong(getData("TimeOutSec")));
        driver.manage().window().maximize();
        driver.get(getData("url"));
        ManagePages.initParaBank();
        action =new Actions(driver);

    }

    public static WebDriver initChromeDriver(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        return driver;
    }

    public static WebDriver initFirefoxDriver(){
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        return driver;
    }

    public static WebDriver initEdgeDriver(){
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        return driver;
    }
    public static void initMobile(){
        dc.setCapability(MobileCapabilityType.UDID, getData("UDID"));
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, getData("AppPackage"));
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, getData("AppActivity"));
        try {
            mobileDriver = new AndroidDriver(new URL(getData("AppiumServer")), dc);
        } catch (Exception e) {
            System.out.println("Cannot connect to Appium server, see details: " + e);
        }
        ManagePages.initMortgage();
        mobileDriver.manage().timeouts().implicitlyWait(Long.parseLong(getData("TimeOutSec")), TimeUnit.SECONDS);
        wait = new WebDriverWait(mobileDriver,Long.parseLong(getData("TimeOutSec")));

    }

    public static void initAPI(){
        RestAssured.baseURI = getData("urlAPI");
        httpRequest = RestAssured.given();
//                .auth().preemptive().basic(getData("APIUserName"), getData("APIPassword"));
    }

    public static void initElectron(){
        System.setProperty("webdriver.chrome.driver", getData("ElectronDriverPath"));
        opt = new ChromeOptions();
        opt.setBinary(getData("ElectronAppPath"));
        dc.setCapability("chromeOptions", opt);
        dc.setBrowserName("Chrome");
        driver = new ChromeDriver(dc);
        ManagePages.initTodo();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("TimeOutSec")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,Long.parseLong(getData("TimeOutSec")));
        action =new Actions(driver);
    }

    public static void initDesktop(){
        dc.setCapability("app", getData("CalculatorApp"));
        try {
            driver = new WindowsDriver(new URL(getData("AppiumServerDesktop")), dc);
        } catch (Exception e){
            System.out.println("Cannot connect to Appium server");
        }
        ManagePages.initCalculator();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("TimeOutSec")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,Long.parseLong(getData("TimeOutSec")));
    }


    @BeforeClass
    @Parameters({"PlatformName"})
    public void startSession(String PlatformName){
        platform=PlatformName;
        if(platform.equalsIgnoreCase("web"))
            initBrowser(getData("BrowserName"));
        else if(platform.equalsIgnoreCase("mobile"))
            initMobile();
        else if(platform.equalsIgnoreCase("api"))
            initAPI();
        else if(platform.equalsIgnoreCase("electron"))
            initElectron();
        else if(platform.equalsIgnoreCase("desktop"))
            initDesktop();
        else {
            throw new RuntimeException("Invalid platform name");}

        if(platform.equalsIgnoreCase("DB")) {

            ManageDB.openConnection(getData("DBURL"), getData("DBUserName"), getData("DBPassword"));
        }

        softAssert = new SoftAssert();
        screen = new Screen();

    }


    @AfterMethod
    public void afterMethod() {
        if (platform.equalsIgnoreCase("web")){
            driver.get(getData("url"));
        }
    }

    @BeforeMethod
    public void beforeMethod(Method method){
        if (!platform.equalsIgnoreCase("api")) {
            try {
                MonteScreenRecorder.startRecord(method.getName());

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }



    @AfterClass
    public void closeSession(){
        Uninterruptibles.sleepUninterruptibly(10, TimeUnit.SECONDS);
        if (!platform.equalsIgnoreCase("api")) {
            if (!platform.equalsIgnoreCase("mobile")) {

                ManageDB.closeConnection();
                driver.quit();
            } else {
                mobileDriver.quit();
            }
        }
    }





}
