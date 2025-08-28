import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Allure;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.logevents.SelenideLogger.step;

public class AnttachmentsTest {
    private static final String REPOSITORY="eroshenkoam/allure-axample";
    private static final String TEXT="0 results";

    @Test
    public void testLambdaAttachments() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("открываем главную страницу", () -> {
            open("https://github.com/");
            Allure.addAttachment("Sourse",webdriver().driver().source());
        });
    }
@Test
    public void testAnnotatedAttachments(){
    SelenideLogger.addListener("allure",new AllureSelenide());
        WebSteps steps=new WebSteps();

        steps.openMainPage();
        steps.takeScreenshot();

}
}