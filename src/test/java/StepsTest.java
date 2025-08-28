import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.step;

public class StepsTest {

    private static final String REPOSITORY="eroshenkoam/allure-axample";
    private static final String TEXT="0 results";

    @Test
    public void testLambdaStep() {
        SelenideLogger.addListener("allure",new AllureSelenide());

        step("открываем главную страницу", () -> {
            open("https://github.com/");
        });

        step("Ищем репозиторий" + REPOSITORY, () -> {
            $(".search-input").click();
            $("#query-builder-test").setValue(REPOSITORY).pressEnter();
        });

        step("проверяем наличие текста"+TEXT,()->{
        $(".Box-sc-g0xbh4-0.jJRiHe").shouldHave(text(TEXT));

    });

}

@Test
    public void testAnnotatedStep(){
    SelenideLogger.addListener("allure",new AllureSelenide());
        WebSteps steps=new WebSteps();

        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.checkText(TEXT);
}
}