package Clase16.pageObject.Shopify;

import Clase16.BaseUITest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ShopifyPricingPage extends BaseUITest {

    //Haciendo el extends donde esta el driver se borra
    //WebDriver driver;

    public ShopifyPricingPage(WebDriver remoteDriver){
        driver = remoteDriver;

    }
    public List<WebElement> getH1s(){
        return driver.findElements(By.tagName("h1"));

    }
}
