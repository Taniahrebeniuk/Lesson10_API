import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class IssuesPage extends BasicPage {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3)); // wait for up to 3 seconds

    public IssuesPage(WebDriver driver) {
        super(driver);
    }

    public IssuesPage goToIssueTab() {
        WebElement issuesTabElement = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/Taniahrebeniuk/FirstjUnitProject/issues']")));
        issuesTabElement.click();
        return this;
    }

    public void clickOnNewIssueButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement newIssueButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href, '/issues/new')]")));
        newIssueButton.click();
    }

    public boolean isNewIssueFormDisplayed() {
        WebElement titleField = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("issue_title")));
        WebElement descriptionField = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("issue_body")));
        return titleField.isDisplayed() && descriptionField.isDisplayed();
    }

    public void enterTitleAndComment(String title, String comment) {
        WebElement titleField = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("issue_title")));
        WebElement descriptionField = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("issue_body")));
        titleField.sendKeys(title);
        descriptionField.sendKeys(comment);
    }

    public void submitNewIssue() {
        WebElement submitButton = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class=\"btn-primary btn ml-2\"]")));
        submitButton.click();
    }

    public boolean isIssueWithTitleDisplayed(String issueTitle) {
        try {

            WebElement issueLink = driver.findElement(By.xpath("//span[contains(text(),'" + issueTitle + "')]/ancestor::a"));
            return issueLink.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}