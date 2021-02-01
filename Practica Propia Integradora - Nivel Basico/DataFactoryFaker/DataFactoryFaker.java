package Clase16.DataFactoryFaker;

import com.github.javafaker.Faker;

import java.util.Date;
import java.util.Random;

public class DataFactoryFaker {

        public static Faker FAKER = new Faker();

        public static String getFirstName() {
            String firstName = FAKER.name().firstName();
            return firstName;

        }

        public static String getLastName() {
            String lastName = FAKER.name().lastName();
            return lastName;

        }

        public static String getEmail() {
            String email = FAKER.internet().emailAddress();
            return email;

        }
        public static String getTitle() {
        String email = FAKER.name().title();
        return email;

        }
        public static String getCellPhone() {
            Random cellPhone = new Random();
            //tuve que hacer que empiece con 11 asi facebook me lo tomaba como valido
            return String.valueOf(cellPhone.nextInt(1000000) + 1100000000);

        }
        public static String getPassword(){
            String password = FAKER.internet().password();
            return password;
        }


}
