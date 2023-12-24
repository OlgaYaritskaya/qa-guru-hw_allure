package pageObjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class SearchResultsPageObj {


    public AllureExamplePageObj navigateToTab(SelenideElement tabName){
        tabName.click();
        return new AllureExamplePageObj();
    }
}
