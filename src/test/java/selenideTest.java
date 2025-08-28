import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class selenideTest {
    @Test
    public void testIssueSearch() {
        SelenideLogger.addListener("allure",new AllureSelenide());
        open("https://github.com/");
        $(".search-input").click();
        $("#query-builder-test").setValue("eroshenkoam/allure-axample").pressEnter();
        $(".Box-sc-g0xbh4-0.jJRiHe").shouldHave(text("0 results"));

    }

}