package studymate;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.StudyMateGroupsPage;
import pages.StudyMateLoginPage;
import utilities.ApplicationFlow;
import utilities.Config;
import utilities.Driver;

public class StudyMateTests {

    @BeforeMethod
    public void setup(){
        Driver.getDriver().get(Config.getValue("studymateURL"));
    }

    @AfterMethod
    public void cleanUp(){
        Driver.quit();
    }
    @Test
    public void login(){
        StudyMateLoginPage studyMateLoginPage = new StudyMateLoginPage();
        studyMateLoginPage.emailInput.sendKeys(Config.getValue("studyMateEmail"));
        studyMateLoginPage.passwordInput.sendKeys(Config.getValue("studyMatePassword"));
        studyMateLoginPage.loginBtn.click();
        String expectedURL="https://codewise.studymate.us/admin/analytics";
        ApplicationFlow.pause(2000);
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), expectedURL);
        System.out.println(System.currentTimeMillis());
    }

    @Test
    public void createGroup(){
        StudyMateLoginPage studyMateLoginPage = new StudyMateLoginPage();
        StudyMateGroupsPage studyMateGroupsPage = new StudyMateGroupsPage();
        studyMateLoginPage.emailInput.sendKeys(Config.getValue("studyMateEmail"));
        studyMateLoginPage.passwordInput.sendKeys(Config.getValue("studyMatePassword"));
        studyMateLoginPage.loginBtn.click();
        studyMateLoginPage.sideMenuList.get(1).click();
        studyMateGroupsPage.createGroupBtn.click();
        String groupName = "Batch" + System.currentTimeMillis();
        studyMateGroupsPage.groupNameInput.sendKeys(groupName);
        studyMateGroupsPage.groupDateInput.click();
        studyMateGroupsPage.groupDateInput.sendKeys("06142023");
        studyMateGroupsPage.groupDescriptionInput.sendKeys("some description");
        ApplicationFlow.pause(2000);
        studyMateGroupsPage.createButton.click();
        String xpath = "//div[.='" + groupName + "']";
        WebElement createdGroup = Driver.getDriver().findElement(By.xpath(xpath));
        Assert.assertTrue(createdGroup.isDisplayed());
        ApplicationFlow.pause(2000);
    }



}
