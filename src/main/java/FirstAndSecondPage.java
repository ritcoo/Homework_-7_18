import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FirstAndSecondPage extends BaseClass {


    public FirstAndSecondPage(WebDriver driver, WebDriverWait wait) {
        super(driver, new WebDriverWait(driver, Duration.ofSeconds(10)));
    }

    public void NavigateToFirstPage() {
        driver.navigate().to("https://example.testproject.io/web/");
    }

    By fullName = By.xpath("//input[@id='name']");
    By pass = By.xpath("//input[@id='password']");
    By loginCTA = By.xpath("//button[@id='login']");


    public void EnterName(String enterName) {
        Wait().until(ExpectedConditions.presenceOfElementLocated(fullName)).sendKeys(enterName);
    }

    public void EnterPass(String enterPass) {
        Wait().until(ExpectedConditions.presenceOfElementLocated(pass)).sendKeys(enterPass);
    }

    public void ClickLoginCTA() {
        Wait().until(ExpectedConditions.presenceOfElementLocated(loginCTA)).click();
    }

    //Below is info for second page
    By address = By.xpath("//input[@id='address']");
    By email = By.xpath("//input[@id='email']");
    By phone = By.xpath("//input[@id='phone']");
    By saveCTA = By.xpath("//button[@id='save']");
    By logoutCTA = By.xpath("//button[@id='logout']");

    public void EnterCountry() {
        Select se = new Select(driver.findElement(By.xpath("//select[@id='country']")));
        se.selectByValue("BG");
    }

    public void EnterAddress(String enterAddress) {
        Wait().until(ExpectedConditions.presenceOfElementLocated(address)).sendKeys(enterAddress);
    }

    public void EnterEmail(String enterEmail) {
        Wait().until(ExpectedConditions.presenceOfElementLocated(email)).sendKeys(enterEmail);
    }

    public void EnterPhone(String enterPhone) {
        Wait().until(ExpectedConditions.presenceOfElementLocated(phone)).sendKeys(enterPhone);

    }

    public void SaveCTA() {
        driver.findElement(saveCTA).click();
    }

    public void LogoutCTA() {
        driver.findElement(logoutCTA).click();
    }
}


