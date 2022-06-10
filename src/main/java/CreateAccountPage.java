import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class CreateAccountPage {
    WebDriver driver;

    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By emailBox = By.xpath("//*[@id=\"email_create\"]");
    private final By createAccountButton = By.xpath("//*[@id=\"SubmitCreate\"]");
    private final By validEmailCheck = By.xpath("//*[@class=\"form-group form-ok\"]");
    private final By randomClick = By.xpath("//*[@id=\"create-account_form\"]");

    public void fillEmail(String emailAddress) {
        driver.findElement(emailBox).sendKeys(emailAddress, Keys.TAB);
    }

    public AuthenticationPage clickCreateAccountButton() {
        driver.findElement(createAccountButton).click();
        return new AuthenticationPage(driver);
    }

    public boolean checkValidation() {
        try {
            driver.findElement(validEmailCheck);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void clickRandom() {
        driver.findElement(randomClick).click();
    }
}
