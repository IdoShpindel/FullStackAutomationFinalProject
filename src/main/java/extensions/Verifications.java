package extensions;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.sikuli.script.FindFailed;
import utilities.CommonOps;

import java.util.List;

import static org.testng.Assert.*;
import static org.testng.AssertJUnit.fail;

public class Verifications extends CommonOps {

    @Step("Verify text in element")
    public static void verifyTextInElement(WebElement elem, String expected){
        wait.until(ExpectedConditions.visibilityOf(elem));
        assertEquals(elem.getText(), expected);
    }
    @Step("Verify text content in element")
    public static void verifyTextContentInElement(WebElement elem, String expected){
        wait.until(ExpectedConditions.visibilityOf(elem));
        assertEquals(elem.getAttribute("textContent"), expected);
    }

    @Step("Verify text with text")
    public static void verifyString(String actualResult, String expected){
        assertEquals(actualResult, expected);
    }

    @Step("Verify visibility of elements")
    public static void visibilityOfElements(List< WebElement> elems){
        for (WebElement elem:elems){
            softAssert.assertTrue(elem.isDisplayed(), "The " + elem.getText() + " does not display");
        }
        softAssert.assertAll("Some does not display");
    }

    @Step("Verify number of elements")
    public static void numberOfElements(List<WebElement> elems, int expected){
        wait.until(ExpectedConditions.visibilityOf(elems.get(elems.size()-1)));
        assertEquals(elems.size(), expected);

    }

    @Step("Verify visual element")
    public static void visualElement(String expectedImageName){
        try{
            screen.find(getData("imageRepo") + expectedImageName+".png");
        } catch (FindFailed findFailed){
            System.out.println("Error comparing image file " + findFailed);
            fail("Error comparing image file " + findFailed);
        }
    }

    @Step("Verify that customer logged in")
    public static void customerLoggedIn(){
        assertFalse(paraBankLogin.btn_login.isDisplayed());

    }

    @Step("Verify that customer not logged in")
    public static void customerNotLoggedIn(){
        assertTrue(paraBankLogin.btn_login.isDisplayed());

    }

    @Step("Verify number with number")
    public static void verifyInteger(int actualResult, int expectedResult){
        assertEquals(actualResult,expectedResult);

    }


    public static void expectEquals(String actual,String expected){
        softAssert.assertEquals(actual,expected);
    }
    public static void verifyExpectations(){
        softAssert.assertAll();
    }


}

