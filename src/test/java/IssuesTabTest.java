import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IssuesTabTest extends BasicTest {

    @Test
    public void GoToIssuesPage() {
        HomePage homePage = new HomePage(driver);
        homePage.goToLoginPage();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successfullLogin("taniahrebeniuk@gmail.com", "taniahrebeniuk@gmail.com");
        MyProjectPage myProjectPage = new MyProjectPage(driver);
        myProjectPage.goToMyProjectPage();
        IssuesPage issuesPage = new IssuesPage(driver);
        issuesPage.goToIssueTab();
        issuesPage.clickOnNewIssueButton();
        assertTrue(issuesPage.isNewIssueFormDisplayed());
        issuesPage.enterTitleAndComment("Some title", "Some comment");
        issuesPage.submitNewIssue();
        issuesPage.isIssueWithTitleDisplayed("Some title");
    }
}