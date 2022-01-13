package co.soat.web.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class PaymentTypePage extends PageObject {
    @FindBy(xpath = "//input[contains(@id, 'PagoSoatControl_rblListadoFormasPago_0')]")
    public WebElementFacade inputCashPayment;

    @FindBy(xpath = "//input[@value='Continuar']")
    public WebElementFacade btnContinue;

    @FindBy(xpath = "//input[@value='Expedir']")
    public WebElementFacade btnGenerate;

}
