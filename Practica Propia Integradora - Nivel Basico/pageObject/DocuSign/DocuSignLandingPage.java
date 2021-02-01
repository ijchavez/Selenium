package Clase16.pageObject.DocuSign;

import Clase16.BaseUITest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DocuSignLandingPage extends BaseUITest {

    public DocuSignLandingPage(WebDriver remoteDriver){
        driver = remoteDriver;

    }

    public DocusignRegistrationPage clickPruebaGratuitaBtn(){
        driver.findElement(By.xpath("//*[@href='https://go.docusign.com.es/o/trial/']")).click();
        return new DocusignRegistrationPage(driver);

    }
}
