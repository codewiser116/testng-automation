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


    @Test
    public void contactUs(){
        CashwiseHomePage cashwiseHomePage = new CashwiseHomePage();

        cashwiseHomePage.contactNameInput.sendKeys(faker.name().fullName());
        cashwiseHomePage.contactPhoneInput.sendKeys(faker.phoneNumber().subscriberNumber(9));
        cashwiseHomePage.contactEmailInput.sendKeys(faker.internet().emailAddress());
        ApplicationFlow.pause(3000);
        cashwiseHomePage.sendBtn.click();
        Assert.assertTrue(cashwiseHomePage.contactSubmittedPopup.isDisplayed());
    }

    @Test
    public void languageOptionsTest(){
        CashwiseHomePage cashwiseHomePage = new CashwiseHomePage();

        cashwiseHomePage.languageOptionsBtn.click();
        for (WebElement option: cashwiseHomePage.languageOptions){
            System.out.println(option.getText());
        }
        Assert.assertEquals(cashwiseHomePage.languageOptions.size(), 2);
    }

    @Test
    public void frame(){
        Random random = new Random();
        System.out.println(random.nextInt(22));
    }

    @AfterMethod
    public void cleanUp(){
        Driver.quit();
    }
}
