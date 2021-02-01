package Clase16.pageObject.Spotify;

import Clase16.BaseUITest;
import Clase16.DataFactoryFaker.DataFactoryFaker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SpotifyRegistrationPage extends BaseUITest {

    public SpotifyRegistrationPage(WebDriver remoteDriver){
        driver = remoteDriver;

    }
    public void fillingEmailConfEmail(String unMail, String unConfirmMail){

        driver.findElement(By.id("email")).sendKeys(unMail);
        driver.findElement(By.id("confirm")).sendKeys(unConfirmMail);
    }
    public void completeDataFakerFillForm(String unEmail, String unConfirmEmail, String unPassword, String unName){

        fillingEmailConfEmail(unEmail,unConfirmEmail);

        driver.findElement(By.id("password")).sendKeys(unPassword);
        driver.findElement(By.id("displayname")).sendKeys(unName);

        setBirthdate(driver,"14","Enero","1968");

    }
    private void setBirthdate(WebDriver driver, String unDia, String unMes, String unAño){

        driver.findElement(By.id("day")).sendKeys(unDia);


        WebElement elementoMeses = driver.findElement(By.id("month"));
        Select comboMeses = new Select(elementoMeses);
        comboMeses.selectByVisibleText(unMes);

        driver.findElement(By.id("year")).sendKeys(unAño);


    }
    public WebElement getInvalidMailErrMsg(){
        String xpathCont = "//*[contains(text(),'Este correo electrónico no es válido. Asegúrate de que tenga un formato como este: ejemplo@email.com')]";
        WebElement emailErrorMsg = driver.findElement(By.xpath(xpathCont));

        return emailErrorMsg;
    }
    public WebElement getExistingMailErrMsg(){
        String xpathExist = "//*[contains(text(),'Este correo electrónico ya está conectado a una cuenta')]";
        WebElement emailExist = driver.findElement(By.xpath(xpathExist));

        return emailExist;
    }
    public void clickOnRegisterButton(){
        driver.findElement(By.xpath("//*[contains(text(),'Registrarte')][@type='submit']")).click();

    }
    public WebElement getSexErrMsg(){
        return driver.findElement(By.xpath("//*[contains(text(),'Selecciona tu sexo.')]"));

    }
}
