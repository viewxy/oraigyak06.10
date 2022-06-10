import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Calendar;
import java.util.Date;

public class AuthenticationPage {
    WebDriver driver;

    public AuthenticationPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By maleRadioButton = By.id("id_gender1");
    private final By femaleRadioButton = By.id("id_gender2");
    private final By firstName = By.xpath("//*[@id=\"customer_firstname\"]");
    private final By lastName = By.xpath("//*[@id=\"customer_lastname\"]");
    private final By password = By.xpath("//*[@id=\"passwd\"]");

    private final By month = By.xpath("//*[@id=\"months\"]");
    private final By year = By.xpath("//*[@id=\"years\"]");
    private final By day = By.xpath("//*[@id=\"days\"]");

    public void chooseGender(Gender gender) {
        if (gender == Gender.FEMALE) {
            driver.findElement(femaleRadioButton).click();
        } else {
            driver.findElement(maleRadioButton).click();
        }
    }

    public void selectDate(Date date) {
        Select daySelect = new Select(driver.findElement(day));
        Select monthSelect = new Select(driver.findElement(month));
        Select yearSelect = new Select(driver.findElement(year));

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);


        daySelect.selectByValue(String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)));


        monthSelect.selectByValue(String.valueOf(calendar.get(Calendar.MONTH)+1));
        yearSelect.selectByValue(String.valueOf(calendar.get(Calendar.YEAR)));
    }

}
