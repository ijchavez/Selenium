package Clase16.pageObject.Salesforce;

import Clase16.BaseUITest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SalesforceLandingPage extends BaseUITest {

    public SalesforceLandingPage(WebDriver remoteDriver){
        driver = remoteDriver;

    }
    public SalesForceLoginPage clickOnSignUpButton(){
        driver.findElement(By.id("signup_link")).click();
        //Puedo poner los dos en uno?
        //driver.findElement(By.id("onetrust-accept-btn-handler")).click();

        SalesForceLoginPage signUpLink = new SalesForceLoginPage(driver);
        return signUpLink;

    }

    public SalesForceLoginPage clickOnPrivacyHandlerButton(){
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();

        SalesForceLoginPage privacyBtn = new SalesForceLoginPage(driver);
        return privacyBtn;

    }
}
