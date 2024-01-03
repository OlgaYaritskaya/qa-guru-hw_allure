package pageObjects;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;

public class AllureExamplePageObj {
    public AllureExamplePageObj verifyIssueExists(String number) {
        String numbValue = String.format("#issue_%s_link", number);
        $(numbValue).should(Condition.exist);
        return this;
    }
}