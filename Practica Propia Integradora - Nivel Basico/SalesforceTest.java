package Clase16;

import Clase16.DataFactoryFaker.DataFactoryFaker;
import Clase16.DataProvider.DataProviderSalesForce;
import Clase16.pageObject.Salesforce.SalesForceLoginPage;
import Clase16.pageObject.Salesforce.SalesforceLandingPage;
import Clase16.pageObject.Shopify.ShopifyLoginPage;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SalesforceTest extends BaseTest {

    public static final String SALESFORCE_URL = "https://login.salesforce.com/?locale=eu";

    @BeforeTest(groups = {"dataProviderTest","fakeTest"})
    public void setSalesforceUrl() {
       driver.get(SALESFORCE_URL);

    }
    @Test(groups = {"dataProviderTest","fakeTest"})
    public void TestingErrorMessages(){
        BaseUITest baseUITest = new BaseUITest(driver);
        String titulo = baseUITest.getTitle();
        String url = baseUITest.getCurrentUrl();

        System.out.println("*****Titulos y página princial*****");
        System.out.println(">>> " + titulo);
        System.out.println(">>> " + url);

        Assert.assertEquals(titulo,"Login | Salesforce");
        Assert.assertEquals(url,"https://login.salesforce.com/?locale=eu");

        SalesforceLandingPage salesforceLandingPage = new SalesforceLandingPage(driver);

        //driver.findElement(By.id("signup_link")).click();
        //Me aparece un boton de declaracion de aceptacion de privacidad
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        SalesForceLoginPage salesForceLoginPageSUB = salesforceLandingPage.clickOnSignUpButton();

        SalesForceLoginPage salesForceLoginPageAC = salesforceLandingPage.clickOnPrivacyHandlerButton();

        //driver.findElement(By.id("onetrust-accept-btn-handler")).click();

        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        salesForceLoginPageAC.clickOnStartMyFreeTrialButton();
        //driver.findElement(By.name("Start my free trial")).click();
        //Intente por inspector encontrar por el ID pero no lo encuentra Selenium
        //WebElement webElName = driver.findElement(By.id("UserLastName-yQaf-errMsg"));

        List<WebElement> errMessList = salesForceLoginPageSUB.getErrMsg();

        checkErrorMessages(errMessList);

    }
    public void checkErrorMessages(List<WebElement> anErrorMessList){
        Boolean fNameError = false;
        Boolean lNameError = false;
        Boolean titleError = false;
        Boolean emailAddressError = false;
        Boolean phoneError = false;
        Boolean companyNameError = false;
        Boolean numberOfEmployessError = false;
        Boolean companyLanguageError = false;

        for (WebElement element : anErrorMessList){
            String elementText = element.getText();
            System.out.println(elementText);

            if (elementText.equals("Enter your first name")){
                fNameError = true;

            }
            if (elementText.equals("Enter your last name")){
                lNameError = true;

            }
            if (elementText.equals("Enter your title")){
                titleError = true;

            }
            if (elementText.equals("Enter a valid email address")){
                emailAddressError = true;

            }
            if (elementText.equals("Enter a valid phone number")){
                phoneError = true;

            }
            if (elementText.equals("Enter your company name")){
                companyNameError = true;

            }
            if (elementText.equals("Select the number of employees")){
                numberOfEmployessError = true;

            }
            if (elementText.equals("Select company language")){
                companyLanguageError = true;

            }


        }
        Assert.assertTrue(fNameError);
        Assert.assertTrue(lNameError);
        Assert.assertTrue(emailAddressError);
        Assert.assertTrue(titleError);
        Assert.assertTrue(phoneError);
        Assert.assertTrue(companyNameError);
        Assert.assertTrue(numberOfEmployessError);
        Assert.assertTrue(companyLanguageError);
    }

   @Test (dependsOnMethods = "TestingErrorMessages",
            dataProvider = "registerData",dataProviderClass = DataProviderSalesForce.class,
            groups = {"dataProviderTest"} )
    public void completarCampos(String unName, String unLastName, String unTitle,
            String unEmail, String unPhone){

       SalesForceLoginPage salesForceLoginPage = new SalesForceLoginPage(driver);
       salesForceLoginPage.dataProviderCompleteFields(unName,unLastName,unTitle,unEmail,unPhone);

        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        List<WebElement> errMessList = salesForceLoginPage.getErrMsg();
        Boolean emailAddressError = true;

        for (WebElement element : errMessList) {
            String elementText = element.getText();
            System.out.println(elementText);
            if (elementText.equals("Enter a valid email address")){
                emailAddressError = false;

            }

        }
        Assert.assertTrue(emailAddressError);

    }

    @Test (dependsOnMethods = "TestingErrorMessages", groups = {"fakeTest"} )
    public void completarCamposDataFaker(){

        String unName = DataFactoryFaker.getFirstName();
        String unLastName = DataFactoryFaker.getLastName();
        String unTitle = DataFactoryFaker.getTitle();
        String unEmail = DataFactoryFaker.getEmail();
        String unPhone = DataFactoryFaker.getCellPhone();

        SalesForceLoginPage salesForceLoginPage = new SalesForceLoginPage(driver);

        salesForceLoginPage.fakerCompleteFields(unName,unLastName,unTitle,unEmail,unPhone);


        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        List<WebElement> errMessList = salesForceLoginPage.getErrMsg();
        Boolean emailAddressError = false;

        for (WebElement element : errMessList) {
            String elementText = element.getText();
            System.out.println(elementText);
            if (elementText.equals("Enter a valid email address")){
                emailAddressError = true;

            }

        }
        Assert.assertFalse(emailAddressError);

    }
    @Test (dependsOnMethods = "TestingErrorMessages",
            dataProvider = "forCompleteSalesForceformTest",dataProviderClass = DataProviderSalesForce.class,
            groups = {"dataProviderTest"} )
    public void completeSalesforceFormTest(String unName, String unLastName, String unTitle,
                                String unEmail, String unPhone, String unCompanyName) {

        SalesForceLoginPage salesForceLoginPage = new SalesForceLoginPage(driver);
        salesForceLoginPage.dataProviderCompleteFields(unName,unLastName,unTitle,unEmail,unPhone,unCompanyName);



        WebElement errMessageAgreement = salesForceLoginPage.getMasterSuscAgrCheckBoxError();
        String textErrMessage = errMessageAgreement.getText();
        System.out.println(textErrMessage);
        Assert.assertEquals(textErrMessage,"Please read and agree to the Master Subscription Agreement");

        chequeoAsserts(unName,unLastName,unTitle,unEmail,unPhone,unCompanyName);



    }
    public void chequeoAsserts(String aName, String aLastName, String aTitle,
                               String anEmail, String aPhone, String aCompanyName ){
        String name = "John";
        String lastName = "Smith";
        String title = "Tester";
        String email = "test@test.com";
        String phone = "1234123412";
        String cny = "FakeCny";

        Assert.assertEquals(name,aName);
        Assert.assertEquals(lastName,aLastName);
        Assert.assertEquals(title,aTitle);
        Assert.assertEquals(email,anEmail);
        Assert.assertEquals(phone,aPhone);
        Assert.assertEquals(cny,aCompanyName);

    }

}
