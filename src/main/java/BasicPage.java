import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasicPage {
    protected WebDriver driver;
    protected WebDriverWait webDriverWait;
    public BasicPage(WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, Duration.ofMillis(1000));
    }
}
