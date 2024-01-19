package tests;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import pageObjects.MainPageObj;

import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class LambdaTest {
    private final String searchQuery = "eroshenkoam/allure-example";
    private final SelenideElement REPOSITORY = $("div [href='/eroshenkoam/allure-example']");
    private final SelenideElement ISSUES_TAB = $("#issues-tab");
    private final String ISSUE = "80";

    @Test
    public void lambdaStepsTest() {
        MainPageObj mainPage = new MainPageObj();

        var searchResultsPage = step("Вводим поисковый запрос" + searchQuery, () ->
                mainPage.openMainPage()
                        .setSearchQuery(searchQuery)
        );

        var allureExamplePage = step("Переходим по ссылке репозитория" + REPOSITORY, () ->
                searchResultsPage.clickLink(REPOSITORY)
                        .navigateToTab(ISSUES_TAB)
        );

        step("Проверяем наличие Issue с номером " + ISSUE, () ->
                allureExamplePage.verifyIssueExists(ISSUE)
        );
    }
}