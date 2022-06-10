import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IndexPage {

    WebDriver driver;

    public IndexPage(WebDriver driver) {
        this.driver = driver;
    }

    private final String url = "https://automationpractice.com/";
    private final By signIn = By.className("login");

    public void navigate() {
        driver.navigate().to(url);
    }

    public CreateAccountPage clickSignIn() {
        driver.findElement(signIn).click();
        return new CreateAccountPage(driver);
    }

}
