
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class TestExample extends BaseTest {

    @Test
    void test() {
        page.navigate("https://www.google.com/");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Zaakceptuj wszystko")).click();
        page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Szukaj")).click();
        page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Szukaj")).fill("selenide");
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Selenide: concise UI tests in")).click();
        assertThat(page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("What is Selenide?")))
                .isVisible();
        assertThat(page.locator("section")).containsText("What is Selenide?");
    }
}