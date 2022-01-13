package co.soat.web.utils;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CommonFunction {

    public static void clearAndEnterValue(WebElement element, String value) {
        if (!value.equals("NA")) {
            element.clear();
            element.sendKeys(value);
        }
    }

    public static void selectDropdownValue(WebElementFacade element, String value) {
        if (!value.equals("NA")) {
            element.selectByVisibleText(value);
            assertThat(element.getSelectedVisibleTextValue(), is(value));
        }
    }

    public static void waitOverlayToDisappear(WebElementFacade element, long seconds) {
        element.waitUntilNotVisible().withTimeoutOf(Duration.ofSeconds(seconds));
    }

}