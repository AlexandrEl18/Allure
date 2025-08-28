import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class WebSteps {
    @Step("открываем главную страницу")
    public void openMainPage(){
        open("https://github.com/");
    }

    @Step("Ищем репозиторий: {repo}")
    public void searchForRepository(String repo){
        $(".search-input").click();
        $("#query-builder-test").setValue(repo).pressEnter();

    }
    @Step("проверяем наличие текста: {TEXT}")
    public void checkText(String TEXT){
        $(".Box-sc-g0xbh4-0.jJRiHe").shouldHave(text(TEXT));

    }
    @Attachment(value = "Screenshot",type = "image/png",fileExtension = "png")
    public byte[] takeScreenshot(){
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);

    }
}
