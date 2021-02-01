package Clase16.pageObject.Telefonica;

import Clase16.BaseUITest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TelefonicaLandingPage extends BaseUITest {

        public WebDriver driver;

        public TelefonicaLandingPage(WebDriver remoteDriver){
            driver = remoteDriver;

        }
        public String telefonicaPageTitle(){
            return driver.getTitle();

        }
        public String telefonicaCurrentUrl(){
            return driver.getCurrentUrl();

        }


        public TelefonicaIframeBolsa clickPruebaGratuitaBtn(){
            driver.findElement(By.id("onetrust-accept-btn-handler")).click();
            return new TelefonicaIframeBolsa(driver);

        }
}
