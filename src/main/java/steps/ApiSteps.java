package steps;

import methods.Methods;
import io.qameta.allure.Step;
import pojo.Authorize;
import pojo.User;

public class ApiSteps {

    @Step("Удалить тестового пользователя")
    public static void deleteUser(String email, String password) {
        Authorize auth = new Authorize(email, password);
        String token = Methods.postLoginUser(auth)
                .statusCode(200)
                .extract().path("accessToken").toString();

        Methods.deleteUser(token)
                .statusCode(202);
    }

    @Step("Создать тестового пользователя")
    public static void createUser(User user) {
        Methods.postCreateUser(user)
                .statusCode(200);
    }
}
