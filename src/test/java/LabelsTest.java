
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LabelsTest {

    @Test
    @Feature("Текст в репозитории")
    @Story("Создание текста")
    @Owner("eroshenkoam")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value="GitHub",url="https://github.com/")
    @DisplayName("Создание текста для авторизованного пользователя ")
    public void testStaticLabels() {

}

@Test
    public void testDynamicLabels(){
    Allure.feature("Текст в репозитории");
    Allure.story("Создание текста");
    Allure.label("Owner", "eroshenkoam");
    Allure.label("Severity", SeverityLevel.CRITICAL.value());
    Allure.label("Testing", "https://github.com/");
}
}