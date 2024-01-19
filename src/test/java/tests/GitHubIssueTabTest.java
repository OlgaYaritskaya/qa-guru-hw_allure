package tests;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import pageObjects.MainPageObj;

import static com.codeborne.selenide.Selenide.$;

public class GitHubIssueTabTest {
    private final String searchQuery = "eroshenkoam/allure-example";
    private final SelenideElement REPOSITORY = $("div [href='/eroshenkoam/allure-example']");
    private final SelenideElement ISSUES_TAB = $("#issues-tab");
    private final int ISSUE = 80;

    @Test
    public void issueTabSearchTest() {
        MainPageObj mainPage = new MainPageObj();

        var searchResultsPage = mainPage
                .openMainPage()
                .setSearchQuery(searchQuery);

        var allureExamplePage = searchResultsPage
                        .clickLink(REPOSITORY)
                        .navigateToTab(ISSUES_TAB);

        allureExamplePage.verifyIssueExists("80");
    }

    @Test
    public void annotatedStepsTest() {
        WebSteps step = new WebSteps();

        step.openMainPage();
        step.searchForRepository(searchQuery);
        step.clickOnRepository(REPOSITORY);
        step.openTab(ISSUES_TAB);
        step.shouldContainIssueWithNumber(ISSUE);
        step.takeScreenShot();


    }
}