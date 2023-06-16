package cashwise;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CashwiseDashboardPage;
import pages.CashwiseHomePage;
import utilities.Config;
import utilities.Driver;

public class CashwiseDashboardTests {

    @BeforeMethod
    public void setup(){
        Driver.getDriver().get(Config.getValue("cashwiseURL"));
    }
    @Test
    public void sideMenu(){
        CashwiseDashboardPage cashwiseDashboardPage = new CashwiseDashboardPage();
        CashwiseHomePage cashwiseHomePage = new CashwiseHomePage();
        cashwiseHomePage.login("codewise@gmail.com", "123456");
        Assert.assertEquals(cashwiseDashboardPage.infographicsMenu.getText(), "Infographics");
        Assert.assertEquals(cashwiseDashboardPage.menuList.size(), 3);
        Assert.assertEquals(cashwiseDashboardPage.menuList.get(0).getText(), "Sales");
        Assert.assertEquals(cashwiseDashboardPage.menuList.get(1).getText(), "Expenses");
        Assert.assertEquals(cashwiseDashboardPage.menuList.get(2).getText(), "Reports");
    }
}
