package workflows;

import extensions.APIActions;
import extensions.Verifications;
import io.qameta.allure.Step;
import utilities.CommonOps;

public class APIFlows extends CommonOps {

    @Step("Business Flow: Get a user's property")
    public static String getUserProperty(String jPath) {
        response = APIActions.get("/api/users");
        return APIActions.extractFromJSON(response, jPath);
    }

    @Step("Business Flow: Create new user")
    public static void postUser(String name, String job) {
        params.put("name", name);
        params.put("job", job);
        APIActions.post(params, "/api/users");

    }

    @Step("Business Flow: Update existing user")
    public static void updateUser(String name, String job, String id) {
        params.put("name", name);
        params.put("job", job);
        APIActions.put(params, "/api/user/" + id);

    }

    @Step("Business Flow: Delete existing user")
    public static void deleteUser(String id) {
        APIActions.delete(id);
    }
}
