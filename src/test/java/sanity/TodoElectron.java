package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.ElectronFlows;

@Listeners(utilities.Listeners.class)
public class TodoElectron extends CommonOps {

    @Test(description = "Test01 - Add and verify new task")
    @Description("This test adds a new task and verifies that it was created successfully")
    public void test01_addAndVerifyNewTask(){
        ElectronFlows.addNewTask("Go to sleep early");
        Verifications.verifyInteger(ElectronFlows.getNumberOfTasks(), 1);

    }

    @Test(description = "Test02 - Add and remove task")
    @Description("This test adds 2 new tasks and then removes the last task, verifies that it was removed successfully")
    public void test02_addAndRemoveNewTask(){
        ElectronFlows.RemoveTask();
        ElectronFlows.addNewTask("Don't Delete me");
        ElectronFlows.addNewTask("Delete me");
        ElectronFlows.RemoveTask();
        Verifications.verifyInteger(ElectronFlows.getNumberOfTasks(), 1);

    }


}
