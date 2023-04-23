import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasicPage {
    private WebElement sighInButton = driver.findElement(By.xpath("//a[contains(text(),'Sign in')]"));

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public LoginPage goToLoginPage() {
        sighInButton.click();
        return new LoginPage(driver);
    }
}