import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;


public class LoginTests extends BaseTest {
    @Test (enabled = true, priority = 1, description = "Login with valid email and valid password")
    public void loginValidEmailValidPass() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginWithValidCredentials();
        Assert.assertTrue(loginPage.getAvatarIcon().isDisplayed());
    }

}