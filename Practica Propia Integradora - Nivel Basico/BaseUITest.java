package Clase16;

import org.openqa.selenium.WebDriver;

public class BaseUITest {
    public WebDriver driver;

    public BaseUITest(WebDriver remoteDriver){
        driver = remoteDriver;

    }
    public void fullScrrenPage(){
        driver.manage().window().fullscreen();

    }
    //Lo cree vacio porque sino me saltaba el error no valid constructor
    public BaseUITest(){

    }
    public String getTitle(){
        return driver.getTitle();

    }
    public String getCurrentUrl(){
        return driver.getCurrentUrl();

    }
}
