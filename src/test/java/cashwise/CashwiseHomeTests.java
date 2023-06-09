package cashwise;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CashwiseHomePage;
import utilities.ApplicationFlow;
import utilities.Config;
import utilities.Driver;

import java.util.Random;

public class CashwiseHomeTests {
    Faker faker = new Faker();

    @BeforeMethod
    public void setup(){
        Driver.getDriver().get(Config.getValue("cashwiseURL"));
    }


    @Test(priority = 1)
    public void contactUs(){
        CashwiseHomePage cashwiseHomePage = new CashwiseHomePage();

        cashwiseHomePage.contactNameInput.sendKeys(faker.name().fullName());
        cashwiseHomePage.contactPhoneInput.sendKeys(faker.phoneNumber().subscriberNumber(9));
        cashwiseHomePage.contactEmailInput.sendKeys(faker.internet().emailAddress());
        ApplicationFlow.pause(3000);
        cashwiseHomePage.sendBtn.click();
        Assert.assertTrue(cashwiseHomePage.contactSubmittedPopup.isDisplayed());
    }

    @Test(priority = 3)
    public void languageOptionsTest(){
        CashwiseHomePage cashwiseHomePage = new CashwiseHomePage();

        cashwiseHomePage.languageOptionsBtn.click();
        for (WebElement option: cashwiseHomePage.languageOptions){
            System.out.println(option.getText());
        }
        Assert.assertEquals(cashwiseHomePage.languageOptions.size(), 2);
    }

    @Test(priority = 2, groups = {"smoke"})
    public void login(){
        CashwiseHomePage cashwiseHomePage = new CashwiseHomePage();
        cashwiseHomePage.login("codewise@gmail.com", "123456");
        ApplicationFlow.pause(4000);
        String expectedURL = "https://cashwise.us/dashboard/infographics";
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), expectedURL);
    }



    @AfterMethod
    public void cleanUp(){
        Driver.quit();
    }
}
