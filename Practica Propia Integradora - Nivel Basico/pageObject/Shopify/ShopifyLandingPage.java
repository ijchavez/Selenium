package Clase16.pageObject.Shopify;

import Clase16.BaseUITest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ShopifyLandingPage extends BaseUITest {
    //Haciendo el extends donde esta el driver se borra
    //WebDriver driver;

    public ShopifyLandingPage(WebDriver remoteDriver){
        driver = remoteDriver;

    }

    public ShopifyPricingPage clickOnPricingButton(){
        driver.findElement(By.xpath("//*[@href= '/pricing']")).click();

        /*
        Hasta aca nos lleva a la siguiente pagina y ahora la representamos
        cambiamos el void por la clase a la que vamos y creamos la variable
        de la clase a la que vamos y retornamos ese valor
        */
        ShopifyPricingPage nextPage = new ShopifyPricingPage(driver);
        return nextPage;

        /*
        luego en el test para llamarlo cambiamos:
        shopifyLandingPage.clickOnPricingButton();
        por: ShopifyLandingPage shopifyLandingPage = new ShopifyLandingPage(driver);
        indicando que shopifyPricingPage es igual a lo que me retorne shopifyLandingPage
        luego de haber hecho click en el boton Pricing
        */

    }

    public ShopifyLoginPage clickOnLoginButton(){
        driver.findElement(By.xpath("//*[@href= '/login']")).click();

        ShopifyLoginPage loginPage = new ShopifyLoginPage(driver);
        return loginPage;

    }
    public List<WebElement> getElementdByTagName(String element){
        return driver.findElements(By.tagName(element));

    }

}

