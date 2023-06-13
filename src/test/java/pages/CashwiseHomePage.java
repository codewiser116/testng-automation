package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class CashwiseHomePage {

    public CashwiseHomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//button)[1]")
    public WebElement signInBtn;

    @FindBy(xpath = "(//button)[2]")
    public WebElement signUpBtn;

    @FindBy(xpath = "(//button)[4]")
    public WebElement sendBtn;

    @FindBy(name = "name")
    public WebElement contactNameInput;

    @FindBy(name = "phone")
    public WebElement contactPhoneInput;

    @FindBy(name= "email")
    public WebElement contactEmailInput;

    @FindBy(xpath = "//div[@type='MINI']//h2")
    public WebElement contactSubmittedPopup;

    @FindBy(xpath = "//div[@class='App']/div[1]/div[1]/div[2]/div")
    public WebElement languageOptionsBtn;

    @FindBy(xpath = "//ul/li")
    public List<WebElement> languageOptions;
}
