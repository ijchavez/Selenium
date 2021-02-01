package Clase16.DataProvider;

import org.testng.annotations.DataProvider;

public class DataProviderFacebook {
    @DataProvider(name="registerFacebookData")
    public Object[][] loginInfo() {
        return new Object[][]{
                {"Gerardo", "Chavez", "mail@mail.com", "","password"},

        };

    }
}
