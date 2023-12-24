package pageObjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPageObj {
    private final SelenideElement SEARCH_FIELD = $(".header-search-button");
    private final SelenideElement SEARCH_INPUT = $("#query-builder-test");

public MainPageObj openMainPage(){
    open();
    return this;
}
    public SearchResultsPageObj setSearchQuery(String query) {
        SEARCH_FIELD.click();
        SEARCH_INPUT.setValue(query).pressEnter();
        return new SearchResultsPageObj();
    }
}
