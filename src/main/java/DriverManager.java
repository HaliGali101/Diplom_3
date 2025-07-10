import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {

    public static WebDriver driver;

    public static WebDriver getDriver(String browserName) {
        switch (browserName) {
            case "chrome":
                driver =  new ChromeDriver();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless=new");
                return driver;
            case "yandex":
                System.setProperty("webdriver.chrome.driver","src/main/resources/yandexdriver/yandexdriver");
                ChromeOptions yandexOptions = new ChromeOptions();
                yandexOptions.setBinary("/Applications/Yandex.app/Contents/MacOS/Yandex");
                yandexOptions.addArguments("--headless=new");
                driver = new ChromeDriver(yandexOptions);
                return driver;
            default:
                throw new IllegalArgumentException("Конфигурация браузера не найдена.\n" +
                        "Доступные конфигурации: chrome, yandex");
        }
    }

}
