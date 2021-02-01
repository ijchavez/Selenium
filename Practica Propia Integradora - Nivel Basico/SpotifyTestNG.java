package Clase16;

import Clase16.DataFactoryFaker.DataFactoryFaker;
import Clase16.BaseUITest;
import Clase16.DataProvider.DataProviderSpotify;
import Clase16.pageObject.Spotify.SpotifyLandingPage;
import Clase16.pageObject.Spotify.SpotifyRegistrationPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class SpotifyTestNG extends BaseTest {
    public static final String SPOTIFY_URL = "https://www.spotify.com/ar/";
    //WebDriver driver;

    @BeforeMethod
    public void setSpotifyUrl(){
        // para ejecutar la factory los habilito sino me dice this.driver is null
        //System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        //driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(SPOTIFY_URL);

    }

    @Test (priority = 0, groups = {"successTest"})
    public void verifySpotifyTitleTest(){

        BaseUITest baseUITest = new BaseUITest(driver);

        String actualTitle = baseUITest.getTitle();
        System.out.println(">>> " + actualTitle);

        Assert.assertEquals(actualTitle,"Escuchar es todo - Spotify");

    }
    @Test (priority = 2,groups = {"successTest"})
    public void verifySignUpUrlTest(){
        SpotifyLandingPage spotifyLandingPage = new SpotifyLandingPage(driver);
        SpotifyRegistrationPage spotifyRegistrationPage = spotifyLandingPage.clickOnSignUpButton();

        BaseUITest baseUITest = new BaseUITest(driver);
        String currentUrl = baseUITest.getCurrentUrl();
        System.out.println(currentUrl);
        //Valida que sea cierto que la url actual contenga la palabra signup
        Assert.assertTrue(currentUrl.contains("signup"));

    }
    @Test (priority = 1,groups = {"successTest"},
            dataProvider = "forInvalidMailTest",dataProviderClass = DataProviderSpotify.class)
    public void invalidMailTest(String mail, String confirmMail){
        SpotifyLandingPage spotifyLandingPage = new SpotifyLandingPage(driver);
        SpotifyRegistrationPage spotifyRegistrationPage = spotifyLandingPage.clickOnSignUpButton();

        spotifyRegistrationPage.fillingEmailConfEmail(mail,confirmMail);

        WebElement emailErrorMsg = spotifyRegistrationPage.getInvalidMailErrMsg();
        Assert.assertEquals(emailErrorMsg.getText(),"Este correo electrónico no es válido. Asegúrate de que tenga un formato como este: ejemplo@email.com");


    }

    @Test (priority = 1,groups = {"successTest"},
            dataProvider = "forRepeatedMailTest",dataProviderClass = DataProviderSpotify.class)
    public void validatingExistingMail(String mail, String confirmMail){
        SpotifyLandingPage spotifyLandingPage = new SpotifyLandingPage(driver);
        SpotifyRegistrationPage spotifyRegistrationPage = spotifyLandingPage.clickOnSignUpButton();

        spotifyRegistrationPage.fillingEmailConfEmail(mail,confirmMail);

        spotifyRegistrationPage.clickOnRegisterButton();

        WebElement emailExist = spotifyRegistrationPage.getExistingMailErrMsg();
        String textExiEmail = emailExist.getText();

        System.out.println("Cartel: " + textExiEmail);
        Assert.assertEquals(textExiEmail,"");

    }
    @Test(priority = 1,groups = {"successTest"})
    public void completeDataFakerRegistrationForm(){
        SpotifyLandingPage spotifyLandingPage = new SpotifyLandingPage(driver);
        SpotifyRegistrationPage spotifyRegistrationPage = spotifyLandingPage.clickOnSignUpButton();

        String unEmail = DataFactoryFaker.getEmail();
        String unConfirmEmail = unEmail;
        String unPassword = DataFactoryFaker.getPassword();
        String unName = DataFactoryFaker.getFirstName();

        spotifyRegistrationPage.completeDataFakerFillForm(unEmail,unConfirmEmail,unPassword,unName);

        spotifyRegistrationPage.clickOnRegisterButton();

        WebElement sexErrMsg = spotifyRegistrationPage.getSexErrMsg();
        String sexErrMsgText = sexErrMsg.getText();
        boolean isSexErrMsg = false;

        if (sexErrMsgText.equals("Selecciona tu sexo.")){
            isSexErrMsg = true;
        }

        System.out.println(sexErrMsgText);

        Assert.assertEquals(sexErrMsgText,"Selecciona tu sexo.");
        Assert.assertTrue(isSexErrMsg);

    }



}
