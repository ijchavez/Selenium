package Clase16.pageObject.Spotify;

import Clase16.BaseUITest;
import Clase16.pageObject.Shopify.ShopifyPricingPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SpotifyLandingPage extends BaseUITest {

    public SpotifyLandingPage(WebDriver remoteDriver){
        driver = remoteDriver;

    }
    public SpotifyRegistrationPage clickOnSignUpButton() {
        String unId = "generic-btn-premium";
        driver.findElement(By.id(unId)).click();

        SpotifyRegistrationPage nextPage = new SpotifyRegistrationPage(driver);
        return nextPage;

    }


}
