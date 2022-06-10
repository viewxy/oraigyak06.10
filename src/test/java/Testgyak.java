import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.Date;

public class Testgyak {
    WebDriver driver;
    IndexPage indexpage;


    @BeforeEach
    public void Setup() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-extensions");
        //options.addArguments("--headless");
        options.addArguments("--window-size=1920,1080");
        //options.addArguments("start-maximized");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        indexpage = new IndexPage(driver);
    }

    @Test
    public void signInTestFail() {
        indexpage.navigate();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        CreateAccountPage createAccountPage = indexpage.clickSignIn();
        createAccountPage.fillEmail("aars");
        createAccountPage.clickRandom();
        boolean actual = createAccountPage.checkValidation();

        Assertions.assertFalse(actual);
    }

    @Test
    public void signInTest() {
        indexpage.navigate();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        CreateAccountPage createAccountPage = indexpage.clickSignIn();
        createAccountPage.fillEmail("tatefi2079@game4hr.com");
        createAccountPage.clickRandom();
        boolean actual = createAccountPage.checkValidation();

        Assertions.assertTrue(actual);

        AuthenticationPage authenticationPage = createAccountPage.clickCreateAccountButton();

        authenticationPage.chooseGender(Gender.FEMALE);

        authenticationPage.selectDate(new Date());

    }


}
