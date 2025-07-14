import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SetUp {

    protected RequestSpecification baseSpec;
    protected WebDriver driver;

    public SetUp() {
        baseSpec = baseSetUpSpec();
        driver = getDriver();
    }

    private RequestSpecification baseSetUpSpec() {
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site";

        return RestAssured.given()
                .filter(new AllureRestAssured()
                        .setRequestTemplate("http-request.ftl")
                        .setResponseTemplate("http-response.ftl"));
    }

    public WebDriver getDriver() {
        driver = DriverManager.getDriver(System.getProperty("browser"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }

}
