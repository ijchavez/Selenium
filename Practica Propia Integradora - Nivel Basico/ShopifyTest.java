package Clase16;

import Clase16.pageObject.Shopify.ShopifyLandingPage;
import Clase16.pageObject.Shopify.ShopifyLoginPage;
import Clase16.pageObject.Shopify.ShopifyPricingPage;
import Clase16.pageObject.Twitter.TwitterLandingPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.util.List;

public class ShopifyTest extends BaseTest{

    public static final String SHOPIFY_URL = "https://www.shopify.com/";

    @BeforeMethod
    public void setShopifyUrl(){
        driver.get(SHOPIFY_URL);

    }

    @Test
    public void pricingTest(){

        BaseUITest baseUITest = new BaseUITest(driver);

        //lo puse como fullscreen porque sino me abre una pagina como si fuera responsible y el boton
        //pricing no aparece
        baseUITest.fullScrrenPage();

        String titulo = baseUITest.getTitle();
        System.out.println(">>> " + titulo);

        String url = baseUITest.getCurrentUrl();
        System.out.println(">>> " + url);

        Assert.assertEquals(titulo,"Start a Business, Grow Your Business - Shopify 14-Day Free Trial");
        Assert.assertEquals(url,"https://www.shopify.com/");

        ShopifyLandingPage shopifyLandingPage = new ShopifyLandingPage(driver);

        ShopifyPricingPage shopifyPricingPage = shopifyLandingPage.clickOnPricingButton();

        //con lo expuesto arriba comento lo siguiente:
        //driver.findElement(By.xpath("//*[@href= '/pricing']")).click();

        String tituloPricing = baseUITest.getTitle();
        System.out.println(">>> " + tituloPricing);

        String urlPricing = baseUITest.getCurrentUrl();
        System.out.println(">>> " + urlPricing);

        List<WebElement> h1List = shopifyPricingPage.getH1s();

        //con lo expuesto arriba comento lo siguiente:
        //List<WebElement> h1List = driver.findElements(By.tagName("h1"));

        boolean h1Found = false;

        // cambio el h1List por shopifyPricingPage.getH1s() o como se expone en el ejercicio
        // creo el List<WebElement> h1List y le paso shopifyPricingPage.getH1s() y en el
        // for dejo h1List

        //el for es parte del test porque no interactua con el driver
        for (WebElement h1 : h1List){
            String h1Text = h1.getText();
            System.out.println(">>> " + h1Text);
            if (h1Text.equals("Set up your store, pick a plan later")){
                h1Found = true;

            }

            Assert.assertEquals(urlPricing,"https://www.shopify.com/pricing");
            Assert.assertTrue(h1Found);

            Assert.assertEquals(h1Text, "Set up your store, pick a plan later");
            Assert.assertEquals(tituloPricing,"Shopify Pricing - Setup and Open Your Online Store Today – Free Trial");

            //hacer el Assert con contains
            Assert.assertTrue(tituloPricing.contains("Shopify Pricing"));

        }

    }
    @Test
    public void shopifyLoginTest(){
        BaseUITest baseUITest = new BaseUITest(driver);
        ShopifyLandingPage shopifyLandingPage = new ShopifyLandingPage(driver);

        ShopifyLoginPage shopifyLoginPage = shopifyLandingPage.clickOnLoginButton();


        String tituloLogin = baseUITest.getTitle();
        String urlLogin = baseUITest.getCurrentUrl();

        System.out.println(">>> " + tituloLogin);
        System.out.println(">>> " + urlLogin);

        Assert.assertEquals(tituloLogin,"Shopify - Iniciar sesión");
        Assert.assertEquals(urlLogin,"https://accounts.shopify.com/store-login");

        // al ponerlo en ShopifyLoginPage comento lo siguiente
        // driver.findElement(By.name("commit")).click();
        // voy al boton Siguente asi:
        shopifyLoginPage.clickOnSiguienteButton();

        WebElement errMsg = shopifyLoginPage.getErrMsg();
        String errMsgText = errMsg.getText();
        System.out.println(">>> " + errMsgText);

        Assert.assertEquals(errMsgText,"Dirección de tienda incorrecta. Una dirección de tienda válida termina en .myshopify.com, .com, u otra extensión de dominio.");
        Assert.assertTrue(errMsgText.contains("Dirección de tienda incorrecta"));

        //Ver cantidad de mensajes
        List<WebElement> errorMessageList = shopifyLoginPage.getErrMsgs();
        System.out.println("Cantidad de mensajes: " + errorMessageList.size());

        //como es un unico mensaje puedo hacer:
        System.out.println("Mismo mensaje de forma diferente: ");

        WebElement errMsgAlternativo = errorMessageList.get(0);
        String errMsgAlternativoText = errMsgAlternativo.getText();
        System.out.println(errMsgAlternativoText);

    }
    @Test
    public void getElementsTest() {
        ShopifyLandingPage shopifyLandingPage = new ShopifyLandingPage(driver);


        List<WebElement> listaDeH1s = shopifyLandingPage.getElementdByTagName("h1");
        System.out.println("La cantidad de elementos H1 es " + listaDeH1s.size());

        WebElement elementoH1 = listaDeH1s.get(0);
        String h1Text = elementoH1.getText();

        Assert.assertEquals(h1Text,"Anyone, anywhere, can start a business");

        boolean h1NotEmpty = false;
        if (listaDeH1s.size() > 0){
            h1NotEmpty = true;

        }
        Assert.assertTrue(h1NotEmpty);

        Assert.assertEquals(listaDeH1s.size(),1);

        for (WebElement element : listaDeH1s) {
            System.out.println(element.getText());

        }
        System.out.println("*********");
        List<WebElement> listaDeH2s = shopifyLandingPage.getElementdByTagName("h2");

        System.out.println("La cantidad de elementos H2 es " + listaDeH2s.size());

        boolean h2NotEmpty = false;
        if (listaDeH2s.size() > 0){
            h2NotEmpty = true;

        }
        Assert.assertTrue(h2NotEmpty);

        WebElement unH2 = listaDeH2s.get(2);
        String h2Text = unH2.getText();
        Assert.assertEquals(h2Text,"With you wherever you’re going");
        Assert.assertEquals(listaDeH2s.size(),8);

        for (WebElement element : listaDeH2s) {
            System.out.println(element.getText());

        }
        System.out.println("*********");
        List<WebElement> listaParrafos = shopifyLandingPage.getElementdByTagName("p");

        System.out.println("La cantidad de parrafos es " + listaParrafos.size());

        boolean pNotEmpty = false;
        if (listaParrafos.size() > 0){
            pNotEmpty = true;

        }
        Assert.assertTrue(pNotEmpty);

        for (WebElement element : listaParrafos) {
                System.out.println("Parrafo: " + element.getText());

        }
        Assert.assertEquals(listaParrafos.size(),64);
        System.out.println("*********");
        List<WebElement> listaLinks = shopifyLandingPage.getElementdByTagName("a");

        System.out.println("La cantidad de Links es " + listaLinks.size());
        boolean aNotEmpty = false;

        if (listaLinks.size() > 0){
            aNotEmpty = true;

        }

        for (WebElement element : listaLinks) {
            System.out.println("Parrafo: " + element.getText());

        }
        if (listaLinks.size() > 0){
            aNotEmpty = true;

        }
        Assert.assertTrue(aNotEmpty);
        Assert.assertEquals(listaLinks.size(),188);

    }
}
