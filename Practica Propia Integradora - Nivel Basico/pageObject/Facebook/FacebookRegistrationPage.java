package Clase16.pageObject.Facebook;

import Clase16.BaseUITest;
import org.junit.experimental.theories.Theories;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FacebookRegistrationPage extends BaseUITest {

    public FacebookRegistrationPage(WebDriver remoteDriver){
        driver = remoteDriver;

    }
    public void fillingForm(String nombre, String apellido, String email, String mailconfirm, String password){

        driver.findElement(By.name("firstname")).sendKeys(nombre);
        driver.findElement(By.name("lastname")).sendKeys(apellido);
        driver.findElement(By.name("reg_email__")).sendKeys(email);

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("reg_email__"))));


        driver.findElement(By.name("reg_email_confirmation__")).sendKeys(mailconfirm);
        driver.findElement(By.id("password_step_input")).sendKeys(password);
        driver.findElement(By.xpath("//*[@name='sex'][@value='2']")).click();

        setBirthdate(driver,"29","jun","1986");



    }
    public void fillingForm(String nombre, String apellido, String CellPhoneNumber, String password){

        driver.findElement(By.name("firstname")).sendKeys(nombre);
        driver.findElement(By.name("lastname")).sendKeys(apellido);
        driver.findElement(By.name("reg_email__")).sendKeys(CellPhoneNumber);

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("reg_email__"))));

        driver.findElement(By.id("password_step_input")).sendKeys(password);


        setBirthdate(driver,"29","jun","1986");



    }
    private void setBirthdate(WebDriver driver, String unDia, String unMes, String unAño){

        WebElement elementoDias = driver.findElement(By.id("day"));
        Select comboDias = new Select(elementoDias);
        comboDias.selectByVisibleText(unDia);

        WebElement elementoMeses = driver.findElement(By.id("month"));
        Select comboMeses = new Select(elementoMeses);
        comboMeses.selectByVisibleText(unMes);

        WebElement elementoAños = driver.findElement(By.id("year"));
        Select comboAños = new Select(elementoAños);
        comboAños.selectByVisibleText(unAño);

    }
    public void clickCrearCuentaNuevaButton(){
        driver.findElement(By.name("websubmit")).click();

    }
    public WebElement getGenderErrMsg(){
        return driver.findElement(By.xpath("//*[contains(text(),'Elige un género. Podrás cambiar quién puede verlo más tarde.')]"));

    }
    public WebElement getMailConfirmErrMsg(){
        return driver.findElement(By.xpath("//*[contains(text(),'Tus direcciones de correo no coinciden. Inténtalo de nuevo.')]"));

    }
    public WebElement getConfirmMailErrMsg(){
        return driver.findElement(By.xpath("//*[contains(text(),'Vuelve a escribir tu dirección de correo electrónico.')]"));

    }

}
