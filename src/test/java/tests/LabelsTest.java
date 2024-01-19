package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.Test;

public class LabelsTest {
    @Test
    @Feature("Issue in repository")
    @Story("Creating Issue in Repository")
    @Owner("yaritskayao")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "gitHub", url = "https://testing.github.com")
    public void testStaticLabels() {

    }

    @Test
    public void testDynamicLabels() {
        Allure.getLifecycle().updateTestCase(
                t -> t.setName(""));
        Allure.feature("");
        Allure.story("");
        Allure.label("owner", "yaritskayao");
        Allure.label("severity", SeverityLevel.CRITICAL.value());
        Allure.link("https://staging.github.com");
    }
}
