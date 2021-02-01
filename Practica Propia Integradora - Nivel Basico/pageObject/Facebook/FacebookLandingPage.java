package Clase16.pageObject.Facebook;

import Clase16.BaseUITest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FacebookLandingPage extends BaseUITest {
    public FacebookLandingPage(WebDriver remoteDriver){
        driver = remoteDriver;

    }
    public FacebookRegistrationPage clickCrearCuentaNuevaButton(){
        driver.findElement(By.xpath("//*[@ajaxify='/reg/spotlight/']")).click();
        FacebookRegistrationPage cuentaNuevaPage = new FacebookRegistrationPage(driver);
        return cuentaNuevaPage;

    }
}
