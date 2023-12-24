package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import pageObjects.MainPageObj;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GitHubIssueTabTest {
    private final String searchQuery = "eroshenkoam/allure-example";

    private final SelenideElement ISSUES_TAB = $("#issues-tab");

    @Test
    public void issueTabSearchTest() {
        MainPageObj mainPage = new MainPageObj();

        var searchResultsPage =
                mainPage.openMainPage()
                        .setSearchQuery(searchQuery);

        var allureExamplePage =
                searchResultsPage.navigateToTab(ISSUES_TAB);

        allureExamplePage.verifyIssueExists("80");
    }
}
