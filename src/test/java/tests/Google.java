package tests;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import utilities.Driver;

public class Google {

    @Test
    public void search(){
        Faker faker = new Faker();
        String testData = faker.lorem().word();
        Driver.getDriver().get("https://google.com");
        System.out.println("tetsing");
        Driver.quit();
    }

    @Test
    public void googleImage(){
        Driver.getDriver().get("https://google.com");
        System.out.println("Checking some images");
        Driver.quit();
    }
}
