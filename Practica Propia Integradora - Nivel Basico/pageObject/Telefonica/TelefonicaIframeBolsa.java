package Clase16.pageObject.Telefonica;

import Clase16.BaseUITest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TelefonicaIframeBolsa extends BaseUITest {
    public WebDriver driver;

    public TelefonicaIframeBolsa(WebDriver remoteDriver){
        driver = remoteDriver;

    }
    public void telefonicaIframeCotizaciones(){
        WebElement iFrameCotizaciones = driver.findElement(By.id("euroland-ticker-es"));
        driver.switchTo().frame(iFrameCotizaciones);

    }
    public List<WebElement> elementoTabsfind(){
        List<WebElement> elementTabs = driver.findElements(By.className("Tab"));
        return elementTabs;

    }
    public WebElement activeTabsfind(){
        WebElement activeTab = driver.findElement(By.className("Tab_Active"));
        return activeTab;

    }
    public List<WebElement> elementoDataItemsfind(){
        List<WebElement> dataItems = driver.findElements(By.className("DataItem"));
        return dataItems;

    }

    public List<WebElement> elementoDataValuesfind(){
        List<WebElement> dataValues = driver.findElements(By.className("DataValue"));
        return dataValues;

    }
}
