package pageObjects.todo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class MainPage {
    @FindBy(css = "input[placeholder='Create a task']")
    public WebElement txt_createTask;

    @FindBy(className = "view_2Ow90")
    public List<WebElement> list_tasks;

    @FindBy (className = "destroy_19w1q")
    public WebElement btn_delete;


}

