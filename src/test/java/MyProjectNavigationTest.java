import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.Assertions;

public class MyProjectNavigationTest extends BasicTest {

    @Test
    public void testGoToMyProjectPage() {
        HomePage homePage = new HomePage(driver);
        homePage.goToLoginPage();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successfullLogin("taniahrebeniuk@gmail.com", "grebeniuk1993");
        MyProjectPage myProjectPage = new MyProjectPage(driver);
        myProjectPage.goToMyProjectPage();
    }
}