package Clase16.pageObject.Salesforce;

import Clase16.BaseUITest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SalesForceLoginPage extends BaseUITest {

    public SalesForceLoginPage(WebDriver remoteDriver){
        driver = remoteDriver;

    }
    public void clickOnStartMyFreeTrialButton(){
        driver.findElement(By.name("Start my free trial")).click();

    }
    public List<WebElement> getErrMsg(){
        return driver.findElements(By.className("error-msg"));

    }
    public WebElement getMasterSuscAgrCheckBoxError(){
        return driver.findElement(By.xpath
                ("//*[contains(text(),'Please read and agree to the Master Subscription Agreement')]"));

    }

    public void fakerCompleteFields(String unName, String unLastName, String unTitle, String unEmail, String unPhone){
        driver.findElement(By.name("UserFirstName")).sendKeys(unName);
        driver.findElement(By.name("UserLastName")).sendKeys(unLastName);
        driver.findElement(By.name("UserTitle")).sendKeys(unTitle);
        driver.findElement(By.name("UserEmail")).sendKeys(unEmail);
        driver.findElement(By.name("UserPhone")).sendKeys(unPhone);

    }
    public void dataProviderCompleteFields(String unName, String unLastName, String unTitle, String unEmail, String unPhone){
        driver.findElement(By.name("UserFirstName")).sendKeys(unName);
        driver.findElement(By.name("UserLastName")).sendKeys(unLastName);
        driver.findElement(By.name("UserTitle")).sendKeys(unTitle);
        driver.findElement(By.name("UserEmail")).sendKeys(unEmail);
        driver.findElement(By.name("UserPhone")).sendKeys(unPhone);

    }
    public void dataProviderCompleteFields(String unName, String unLastName, String unTitle, String unEmail, String unPhone, String unCompanyName){
        driver.findElement(By.name("UserFirstName")).sendKeys(unName);
        driver.findElement(By.name("UserLastName")).sendKeys(unLastName);
        driver.findElement(By.name("UserTitle")).sendKeys(unTitle);
        driver.findElement(By.name("UserEmail")).sendKeys(unEmail);
        driver.findElement(By.name("UserPhone")).sendKeys(unPhone);
        driver.findElement(By.name("CompanyName")).sendKeys(unCompanyName);

        Select selEmployeeQty = new Select(driver.findElement(By.name("CompanyEmployees")));
        selEmployeeQty.selectByValue("50");

        Select selLanguage = new Select(driver.findElement(By.name("CompanyLanguage")));
        selLanguage.selectByValue("es");



    }

}
