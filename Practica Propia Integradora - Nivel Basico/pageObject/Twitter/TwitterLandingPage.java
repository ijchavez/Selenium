package Clase16.pageObject.Twitter;

import Clase16.pageObject.Twitter.TwitterRegistrationForm;
import Clase16.BaseUITest;
import Clase16.pageObject.DocuSign.DocusignRegistrationPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TwitterLandingPage extends BaseUITest {

    public TwitterLandingPage(WebDriver remoteDriver){
        driver = remoteDriver;

    }
    public TwitterRegistrationForm clickRegisterBtn(){
        driver.findElement(By.xpath("//*[@href='/i/flow/signup']")).click();
        return new TwitterRegistrationForm(driver);

    }

}

