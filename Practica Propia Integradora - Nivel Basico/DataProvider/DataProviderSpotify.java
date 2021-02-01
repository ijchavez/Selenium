package Clase16.DataProvider;

import org.testng.annotations.DataProvider;

public class DataProviderSpotify {
    @DataProvider(name="forInvalidMailTest")
    public Object[][] spotifyMailTest() {
        return new Object[][]{
                {"test.com","test.com"},

        };
    }
    @DataProvider(name="forRepeatedMailTest")
    public Object[][] SpotifyMailTest() {
        return new Object[][]{
                {"test@test.com","test@test.com"},

        };
    }
}
