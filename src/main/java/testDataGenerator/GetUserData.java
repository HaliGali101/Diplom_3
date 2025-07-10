package testDataGenerator;

import com.github.javafaker.Faker;
import pojo.User;

public class GetUserData {

    private static final Faker faker = new Faker();
    private static String email;
    private static String password;
    private static String name;

    public static User getUser() {
        email = faker.internet().emailAddress();
        password = faker.internet().password();
        name = faker.name().username();

        return new User(email, password, name);
    }

}
