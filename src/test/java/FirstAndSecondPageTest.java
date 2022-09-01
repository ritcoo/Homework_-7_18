import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FirstAndSecondPageTest extends BaseTestClass {


    @Test
    public void FirstPageWithNLogin() throws InterruptedException {
        FirstAndSecondPage page= new FirstAndSecondPage(driver, wait);
        page.NavigateToFirstPage();
        page.EnterName("Asen");
        page.EnterPass("12345");
        Thread.sleep(3000);
        page.ClickLoginCTA();

        WebElement Greetings= driver.findElement(By.xpath("//p[@id='greetings']"));

        String expect= "Hello Asen, let's complete the test form:";
        Thread.sleep(3000);
        String actual= Greetings.getText();

        Assert.assertEquals(expect, actual);


    }

    @Test
    public void SecondPageWithSave() throws InterruptedException {
        FirstAndSecondPage page = new FirstAndSecondPage(driver, wait);
        page.NavigateToFirstPage();
        page.EnterName("Asen");
        page.EnterPass("12345");
        page.ClickLoginCTA();
        page.EnterCountry();
        page.EnterAddress("Sofia, Lozenetz");
        page.EnterEmail("astanevr@abv.bg");
        page.EnterPhone("0886499434");
        Thread.sleep(3000);
        page.SaveCTA();

        WebElement Saved= driver.findElement(By.xpath("//span[@class='tp-saved']"));
        Thread.sleep(3000);

        String ExpectedSave = "Saved";
        String ActualSave= Saved.getText();
        Assert.assertEquals(ExpectedSave, ActualSave);
    }

    @Test
    public void SecondPageWithLogout() throws InterruptedException  {

        FirstAndSecondPage page = new FirstAndSecondPage(driver, wait);
        page.NavigateToFirstPage();
        page.EnterName("Asen");
        page.EnterPass("12345");
        Thread.sleep(3000);
        page.ClickLoginCTA();
        page.EnterCountry();
        page.EnterAddress("Sofia, Lozenetz");
        page.EnterEmail("astanevr@abv.bg");
        page.EnterPhone("0886499434");
        Thread.sleep(3000);
        page.LogoutCTA();

        WebElement LoggedOut = driver.findElement(By.xpath("//button[@id='login']"));
        Thread.sleep(3000);

        String ExpectLogout = "Login";
        String ActualLogout = LoggedOut.getText();
        Assert.assertEquals(ExpectLogout, ActualLogout);
    }

}
