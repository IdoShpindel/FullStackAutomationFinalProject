package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.APIFlows;

@Listeners(utilities.Listeners.class)
public class ReqresAPI extends CommonOps {
    @Test(description = "Test01 - Verify user's email")
    @Description("GET API request of the users and checking one of the email address")
    public void test01_verifyUserEmail(){
        Verifications.verifyString(APIFlows.getUserProperty("data[1].email"),"janet.weaver@reqres.in");
    }

    @Test(description = "Test02 - Add user and verify")
    @Description("POST API request of creating user and checking the new user created")
    public void test02_addUserAndVerify(){
        APIFlows.postUser("Ricky", "Teacher");
        Verifications.verifyInteger(response.getStatusCode(),201);
    }

    @Test(description = "Test03 - Update user and verify")
    @Description("PUT API request of updating an existing user and checking the user updated")
    public void test03_updateUserAndVerify(){
        APIFlows.updateUser("Ricky", "Teacher", "1");
        Verifications.verifyInteger(response.getStatusCode(),200);

    }
    @Test(description = "Test04 - Delete user and verify")
    @Description("DELETE API request of deleting an existing user and checking the user deleted")
    public void test04_deleteUserAndVerify(){
        APIFlows.deleteUser("2");
        Verifications.verifyInteger(response.getStatusCode(),204);

    }
}
