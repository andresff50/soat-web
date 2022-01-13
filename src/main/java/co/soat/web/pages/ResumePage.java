package co.soat.web.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class ResumePage extends PageObject {
    @FindBy(xpath = "//*[@id='ctl00_ContentPlaceHolder1_panelMensaje']")
    public WebElementFacade lblSuccessfulSoatGenerate;

    @FindBy(xpath = "//*[@id='ctl00_ContentPlaceHolder1_panelMensajeNotif']")
    public WebElementFacade lblEmailNotification;
}
