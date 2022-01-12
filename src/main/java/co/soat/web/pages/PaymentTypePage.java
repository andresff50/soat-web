package co.soat.web.pages;

import org.openqa.selenium.By;

public class PaymentTypePage {
    By inputCashPayment = By.xpath("//input[contains(@id, 'PagoSoatControl_rblListadoFormasPago_0')]");
    By btnContinue = By.xpath("//input[@value='Continuar']");
    By btnGenerate = By.xpath("//input[@value='Expedir']");

}
