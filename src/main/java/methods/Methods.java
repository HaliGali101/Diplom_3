package methods;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import pojo.Authorize;
import pojo.User;

import static io.restassured.RestAssured.given;

public class Methods {

    private static final String updateUserPath = "/api/auth/user";
    private static final String loginUserPath = "/api/auth/login";
    private static final String createUserPath = "/api/auth/register";

    @Step("Удалить пользователя")
    public static ValidatableResponse deleteUser(String accessToken) {

        return given()
                .header("Authorization", accessToken)
                .when()
                .log().all()
                .delete(updateUserPath)
                .then()
                .log().all();

    }

    @Step("Авторизовать пользователя")
    public static ValidatableResponse postLoginUser(Authorize auth) {

        return given()
                .header("Content-type", "application/json")
                .when()
                .body(auth)
                .log().all()
                .post(loginUserPath)
                .then()
                .log().all();

    }

    @Step("Создать тестового пользователя")
    public static ValidatableResponse postCreateUser(User user) {

        return given()
                .header("Content-type", "application/json")
                .when()
                .body(user)
                .log().all()
                .post(createUserPath)
                .then()
                .log().all();

    }


}
