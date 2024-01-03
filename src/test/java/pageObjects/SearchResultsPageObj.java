package pageObjects;

import com.codeborne.selenide.SelenideElement;

public class SearchResultsPageObj {

    public SearchResultsPageObj clickLink(SelenideElement link) {
        link.click();
        return this;
    }

    public AllureExamplePageObj navigateToTab(SelenideElement tabName) {
        tabName.click();
        return new AllureExamplePageObj();
    }
}
