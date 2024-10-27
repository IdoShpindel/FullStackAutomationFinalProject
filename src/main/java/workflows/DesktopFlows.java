package workflows;

import extensions.UIActions;
import io.qameta.allure.Step;
import utilities.CommonOps;

public class DesktopFlows extends CommonOps {
    @Step("Calculate Addition 1+8")
    public static void calculateAddition(){
        UIActions.click(calcMain.btn_clear);
        UIActions.click(calcMain.btn_one);
        UIActions.click(calcMain.btn_plus);
        UIActions.click(calcMain.btn_eight);
        UIActions.click(calcMain.btn_equal);
    }

    @Step("Calculate subtraction 39-24")
    public static void calculateSubtraction(){
        UIActions.click(calcMain.btn_clear);
        UIActions.click(calcMain.btn_three);
        UIActions.click(calcMain.btn_nine);
        UIActions.click(calcMain.btn_minus);
        UIActions.click(calcMain.btn_two);
        UIActions.click(calcMain.btn_four);
        UIActions.click(calcMain.btn_equal);
    }

    @Step("Calculate multiplication 5*6")
    public static void calculateMultiplication(){
        UIActions.click(calcMain.btn_clear);
        UIActions.click(calcMain.btn_five);
        UIActions.click(calcMain.btn_multiply);
        UIActions.click(calcMain.btn_six);
        UIActions.click(calcMain.btn_equal);
    }

    @Step("Calculate division 7/2")
    public static void calculateDivision(){
        UIActions.click(calcMain.btn_clear);
        UIActions.click(calcMain.btn_seven);
        UIActions.click(calcMain.btn_divide);
        UIActions.click(calcMain.btn_two);
        UIActions.click(calcMain.btn_equal);
    }


}
