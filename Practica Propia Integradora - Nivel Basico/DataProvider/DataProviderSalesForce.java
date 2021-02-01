package Clase16.DataProvider;

import org.testng.annotations.DataProvider;

public class DataProviderSalesForce {
    @DataProvider(name="registerData")
    public Object[][] loginInfo() {
        return new Object[][]{
                {"Gerardo", "Chavez", "Titulo", "mail@mail.com","44906893"},

        };

    }
    @DataProvider(name="forCompleteSalesForceformTest")
    public Object[][] salesForceformTest() {
        return new Object[][]{
                {"John", "Smith", "Tester", "test@test.com","1234123412","FakeCny"},

        };

    }
}
