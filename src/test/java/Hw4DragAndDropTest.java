import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class Hw4DragAndDropTest {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void DragAndDropTest(){
        open("https://the-internet.herokuapp.com/drag_and_drop");
        SelenideElement
                a = $x("//div[@id = 'column-a']"),
                b = $x("//div[@id = 'column-b']");
        //a.dragAndDropTo(b);
        actions().clickAndHold(a).moveToElement(b).perform();
        //check
        a.shouldHave(text("B"));
        b.shouldHave(text("A"));
    }
}
