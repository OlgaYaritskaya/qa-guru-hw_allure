package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {
    private final SelenideElement SEARCH_FIELD = $(".header-search-button");
    private final SelenideElement SEARCH_INPUT = $("#query-builder-test");

    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("https://www.github.com");
    }

    @Step("Вводим поисковый запрос {query}")
    public void searchForRepository(String query) {
        SEARCH_FIELD.click();
        SEARCH_INPUT.setValue(query).pressEnter();
    }

    @Step("Клик на репозиторий {repo}")
    public void clickOnRepository(SelenideElement repo) {
        repo.click();
    }

    @Step("Открыть таб {tabName}")
    public void openTab(SelenideElement tabName) {
        tabName.click();
    }

    @Step("Проверяем, что присутствет Issue с номером {issue}")
    public void shouldContainIssueWithNumber(int issue) {
        String numbValue = String.format("#issue_%s_link", issue);
        $(numbValue).should(Condition.exist);
    }

    @Attachment(value = "screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenShot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}

