package co.soat.web.utils;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.logging.Logger;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CommonFunction {
    private static final Logger LOGGER = Logger.getLogger(CommonFunction.class.getName());

    public static void clearAndEnterValue(WebElement element, String value) {
        try {
            if (!value.equals("NA")) {
                element.clear();
                element.sendKeys(value);
            }
        } catch (Exception e) {
            LOGGER.info("Elemento no encontrado o deshabilitado");
        }
    }

    public static void selectDropdownValue(WebElementFacade element, String value) {
        try {
            if (!value.equals("NA")) {
                element.selectByVisibleText(value);
                assertThat(element.getSelectedVisibleTextValue(), is(value));
            }
        } catch (Exception e) {
            LOGGER.info("Elemento no encontrado o deshabilitado");
        }
    }

    public static void waitOverlayToDisappear(WebElementFacade element, long seconds) {
        boolean overlayIsPresent = true;
        while (overlayIsPresent == true) {
            if (!element.isPresent()) {
                overlayIsPresent = false;
            }else {
                try {
                    Thread.sleep(seconds);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
