import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyProjectPage extends BasicPage {

    private WebElement myProjectLink = driver.findElement(By.cssSelector("a[href='/Taniahrebeniuk/FirstjUnitProject']"));

    public MyProjectPage(WebDriver driver) {
        super(driver);
    }

    public void goToMyProjectPage() {
        myProjectLink.click();
    }
}