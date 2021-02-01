package Clase16.pageObject.Twitter;

import Clase16.BaseUITest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TwitterRegistrationForm extends BaseUITest {

    public TwitterRegistrationForm(WebDriver remoteDriver){
        driver = remoteDriver;

    }
    public void fillingForm(String unNombre, String unTelefono){
        driver.findElement(By.name("name")).sendKeys(unNombre);
        driver.findElement(By.name("phone_number")).sendKeys(unTelefono);

    }
    public WebElement getValidPhoneErrMst(){
        return driver.findElement(By.xpath("//*[contains(text(),'Introduce un número de teléfono válido.')]"));

    }

}
