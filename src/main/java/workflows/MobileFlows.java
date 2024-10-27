package workflows;

import extensions.MobileActions;
import io.qameta.allure.Step;
import utilities.CommonOps;

import static extensions.MobileActions.Direction.LEFT;
import static extensions.MobileActions.Direction.RIGHT;

public class MobileFlows extends CommonOps {
    @Step("Calculate mortgage")
    public static void calculate(String amount, String term, String rate){
        MobileActions.updateText(mortgageMain.txt_amount, amount);
        MobileActions.updateText(mortgageMain.txt_term, term);
        MobileActions.updateText(mortgageMain.txt_rate, rate);
        MobileActions.tap(mortgageMain.btn_calculate);

    }

    @Step("Save mortgage calculation")
    public static void saveCalculation(){
        MobileActions.tap(mortgageMain.btn_save);

    }

    @Step("Delete mortgage calculation")
    public static void deleteCalculation() {
        MobileActions.tap(mortgageSaved.btn_delete);
        MobileActions.tap(mortgageSaved.btn_approveDeletion);
    }

    @Step("View list of saved calculations")
    public static void viewSavedCalculationList(){
        MobileActions.swipe(LEFT,800);
    }

    @Step("Return to the main page from the list of saved calculations")
    public static void returnToMainPage(){
        MobileActions.swipe(RIGHT,250);
    }



}
