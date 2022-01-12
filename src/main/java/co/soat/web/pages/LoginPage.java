package co.soat.web.pages;


import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://10.158.85.123:32523/login.aspx")
public class LoginPage extends PageObject {
    @FindBy(xpath = "//input[contains(@id, 'txtUsuario')]")
    public WebElementFacade inputUser;

    @FindBy(xpath = "//input[contains(@id, 'txtClave')]")
    public WebElementFacade inputPassword;

    @FindBy(xpath = "//input[contains(@id, 'btnIngresar')]")
    public WebElementFacade btnLogin;

    @FindBy(xpath = "//div[contains(@class, 'overlay_fontawesome')]")
    public WebElementFacade lblOverlay;

}
