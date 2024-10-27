package workflows;

import extensions.UIActions;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import utilities.CommonOps;

public class ElectronFlows extends CommonOps {

    @Step("Add new task")
    public static void addNewTask(String taskName){
        UIActions.updateText(todoMain.txt_createTask, taskName);
        UIActions.insertKey(todoMain.txt_createTask, Keys.RETURN);
    }
    @Step("Count tasks in list")
    public static int getNumberOfTasks(){
        return todoMain.list_tasks.size();
    }
    @Step("Remove a task")
    public static void RemoveTask() {
        UIActions.mouseHover(todoMain.btn_delete);

    }

}
