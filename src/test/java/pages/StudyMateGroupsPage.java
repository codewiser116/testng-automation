package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class StudyMateGroupsPage {

    public StudyMateGroupsPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//h2/../button")
    public WebElement createGroupBtn;

    @FindBy(name = "name")
    public WebElement groupNameInput;

    @FindBy(xpath = "//input[@placeholder='MM/DD/YYYY']")
    public WebElement groupDateInput;

    @FindBy(xpath = "//textarea[@type='text']")
    public WebElement groupDescriptionInput;

    @FindBy(xpath = "//button[.='Create']")
    public WebElement createButton;

}
