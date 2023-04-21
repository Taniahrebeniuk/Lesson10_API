import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTest {

    @Test
    public void LoginTest() {

        HomePage homePage = new HomePage(driver);
        homePage.goToLoginPage();
        LoginPage loginPage = new LoginPage(driver);
        Assertions.assertTrue(loginPage.getLogo().isDisplayed());
        loginPage.successfullLogin("test9874@ukr.net", "test9874@ukr.net");

    }

    @Test
    public void negativeLoginTest() {
        HomePage homePage = new HomePage(driver);
        homePage.goToLoginPage();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.negativeLogin("", "");
        loginPage.validateErrorMessage("Incorrect username or password.");


    }

}

