package Clase16;

import Clase16.DataFactoryFaker.DataFactoryFaker;
import Clase16.DataProvider.DataProviderFacebook;
import Clase16.pageObject.Facebook.FacebookLandingPage;
import Clase16.pageObject.Facebook.FacebookRegistrationPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class FacebookTest extends BaseTest {
    public static final String FACEBOOK_URL = "https://www.facebook.com";

    @BeforeTest(groups = {"dataProviderTest","fakeTest"})
    public void setSalesforceUrl() {
        driver.get(FACEBOOK_URL);

    }

    @Test
    public void checkTitleUrlTest(){

        BaseUITest baseUITest = new BaseUITest(driver);
        String titulo = baseUITest.getTitle();
        String url = baseUITest.getCurrentUrl();

        System.out.println("*****Titulos y página princial*****");
        System.out.println(">>> " + titulo);
        System.out.println(">>> " + url);

        Assert.assertEquals(titulo,"Facebook - Inicia sesión o regístrate");
        Assert.assertEquals(url,"https://www.facebook.com/");



    }
    @Test(dependsOnMethods = "checkTitleUrlTest")
    public void completeRegistrationFormCellPhoneTest(){

        FacebookLandingPage facebookLandingPage = new FacebookLandingPage(driver);
        FacebookRegistrationPage facebookRegistrationPage = facebookLandingPage.clickCrearCuentaNuevaButton();


        facebookRegistrationPage.clickCrearCuentaNuevaButton();

        String name = DataFactoryFaker.getFirstName();
        String lastName = DataFactoryFaker.getLastName();
        String cellPhone = DataFactoryFaker.getCellPhone();
        String password = DataFactoryFaker.getPassword();

        facebookRegistrationPage.fillingForm(name,lastName,cellPhone,password);

        facebookRegistrationPage.clickCrearCuentaNuevaButton();

        WebElement genderErrorMsg = facebookRegistrationPage.getGenderErrMsg();
        String genderErrormsgText = genderErrorMsg.getText();

        Assert.assertEquals(genderErrormsgText,"Elige un género. Podrás cambiar quién puede verlo más tarde.");
    }
    @Test(dependsOnMethods = "checkTitleUrlTest")
    public void completeRegistrationEmailTest(){

        FacebookLandingPage facebookLandingPage = new FacebookLandingPage(driver);
        FacebookRegistrationPage facebookRegistrationPage = facebookLandingPage.clickCrearCuentaNuevaButton();


        facebookRegistrationPage.clickCrearCuentaNuevaButton();

        String name = DataFactoryFaker.getFirstName();
        String lastName = DataFactoryFaker.getLastName();
        String mail = DataFactoryFaker.getEmail();
        String mailConfirm = DataFactoryFaker.getEmail();
        String password = DataFactoryFaker.getPassword();

        facebookRegistrationPage.fillingForm(name,lastName,mail,mailConfirm,password);

        facebookRegistrationPage.clickCrearCuentaNuevaButton();

        WebElement getMailConfirmErrorMsg = facebookRegistrationPage.getMailConfirmErrMsg();
        String mailConfirmErrorMsgText = getMailConfirmErrorMsg.getText();

        Assert.assertEquals(mailConfirmErrorMsgText,"Tus direcciones de correo no coinciden. Inténtalo de nuevo.");


    }
    @Test(dependsOnMethods = "checkTitleUrlTest",
            dataProvider = "registerFacebookData",dataProviderClass = DataProviderFacebook.class)
    public void completeRegistrationEmailWithDataProviderTest(String unName,String unLastname, String unMail, String unMailConfirm, String unPassword){

        FacebookLandingPage facebookLandingPage = new FacebookLandingPage(driver);
        FacebookRegistrationPage facebookRegistrationPage = facebookLandingPage.clickCrearCuentaNuevaButton();

        facebookRegistrationPage.fillingForm(unName,unLastname,unMail, unMailConfirm,unPassword);

        facebookRegistrationPage.clickCrearCuentaNuevaButton();

        WebElement confirmMailErrMsg = facebookRegistrationPage.getConfirmMailErrMsg();
        String confirmMailErrMsgErrorMsgText = confirmMailErrMsg.getText();

        Assert.assertEquals(confirmMailErrMsgErrorMsgText,"Vuelve a escribir tu dirección de correo electrónico.");


    }

}
