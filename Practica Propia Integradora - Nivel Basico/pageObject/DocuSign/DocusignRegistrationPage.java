package Clase16.pageObject.DocuSign;

import Clase16.BaseUITest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DocusignRegistrationPage extends BaseUITest {

    public DocusignRegistrationPage(WebDriver remoteDriver){
        driver = remoteDriver;

    }

    public void fillingRegistrationFields(String unNombre, String unApellido, String unEmail){
        driver.findElement(By.name("first_name")).sendKeys(unNombre);
        driver.findElement(By.name("last_name")).sendKeys(unApellido);
        driver.findElement(By.name("email")).sendKeys(unEmail);

    }
    public void clickOnComenzarBtn(){
        driver.findElement(By.id("submitMainText_0")).click();

    }
}
