package Clase16.Factory;

import Clase16.BaseTest;
import Clase16.BaseUITest;
import Clase16.TwitterTest;
import org.testng.annotations.Factory;

public class TwitterFactory extends BaseUITest {
    @Factory
    public Object[] facebookFactoryTest(){
        return new Object[]{
                new TwitterTest("Gerardo", "9934127981"),
                new TwitterTest("Fabiana", "9933317981")

        };
    }
}
