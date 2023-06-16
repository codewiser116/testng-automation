package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class CashwiseDashboardPage {

    public CashwiseDashboardPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//aside//li")
    public List<WebElement> menuList;

    @FindBy(id = "active")
    public WebElement infographicsMenu;
}
