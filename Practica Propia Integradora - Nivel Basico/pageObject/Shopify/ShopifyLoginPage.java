package Clase16.pageObject.Shopify;

import Clase16.BaseUITest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ShopifyLoginPage extends BaseUITest {

    //Haciendo el extends donde esta el driver se borra
    //WebDriver driver;

    public ShopifyLoginPage(WebDriver remoteDriver){
        driver = remoteDriver;

    }
    public void clickOnSiguienteButton(){
        driver.findElement(By.name("commit")).click();

    }
    //como era uno solo lo pense de esta manera pero lo hice de ambas, buscandolo por lista tambien
    //para practicar
    public WebElement getErrMsg(){
        return driver.findElement(By.xpath("//*[contains(text(),'Dirección de tienda incorrecta')]"));

    }
    public List<WebElement> getErrMsgs(){
        return driver.findElements(By.className("validation-error__message"));

    }
}
