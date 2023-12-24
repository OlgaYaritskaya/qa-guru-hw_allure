package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class AllureExamplePageObj {
    public AllureExamplePageObj verifyIssueExists(String number) {
        String numbValue = String.format("#issue_'%s'_link", number);
        $(numbValue).should(Condition.exist);
        return this;
    }

}
