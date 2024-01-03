package tests;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import pageObjects.MainPageObj;

import static com.codeborne.selenide.Selenide.$;

public class GitHubIssueTabTest {
    private final String searchQuery = "eroshenkoam/allure-example";
    private final SelenideElement ALLURE_EXAMPLE_LINK = $("div [href='/eroshenkoam/allure-example']");
    private final SelenideElement ISSUES_TAB = $("#issues-tab");

    @Test
    public void issueTabSearchTest() {
        MainPageObj mainPage = new MainPageObj();

        var searchResultsPage =
                mainPage.openMainPage()
                        .setSearchQuery(searchQuery);

        var allureExamplePage =
                searchResultsPage
                        .clickLink(ALLURE_EXAMPLE_LINK)
                        .navigateToTab(ISSUES_TAB);

        allureExamplePage.verifyIssueExists("80");
    }
}