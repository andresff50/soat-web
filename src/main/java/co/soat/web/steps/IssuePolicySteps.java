package co.soat.web.steps;

import co.soat.web.pages.IssuePolicyPage;
import co.soat.web.pages.LoginPage;
import co.soat.web.pages.PaymentTypePage;
import co.soat.web.pages.ResumePage;
import co.soat.web.utils.CommonFunction;
import co.soat.web.utils.IssuePolicyData;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.actions.Scroll;
import net.thucydides.core.annotations.Step;
import org.hamcrest.Matchers;
import org.openqa.selenium.JavascriptExecutor;
import java.time.Duration;
import java.util.logging.Logger;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class IssuePolicySteps {
    private LoginPage loginPage = new LoginPage();
    private IssuePolicyPage issuePolicyPage = new IssuePolicyPage();
    private PaymentTypePage paymentTypePage = new PaymentTypePage();
    private ResumePage resumePage = new ResumePage();
    private final String messageIssueGenerate = "Poliza SOAT generada exitosamente";
    private final String messageEmailNotification = "Correo de notificación enviado correctamente";
    private final long timeOverlay = 20;
    private final String validateMessage = "DATOS CORRECTOS";
    private static final Logger LOGGER = Logger.getLogger(IssuePolicySteps.class.getName());

    @Step
    public void openSoatWebPage() {
        loginPage.open();
    }

    @Step("Realiza login en la aplicación")
    public void doLogin(String userId, String password) {
        try {
            assertThat(loginPage.inputUser.isPresent(), is(true));
            assertThat(loginPage.inputPassword.isPresent(), is(true));
            CommonFunction.clearAndEnterValue(loginPage.inputUser, userId);
            CommonFunction.clearAndEnterValue(loginPage.inputPassword, password);
            loginPage.btnLogin.click();
            CommonFunction.waitOverlayToDisappear(loginPage.lblOverlay, timeOverlay);
        } catch (Exception e) {
            LOGGER.info("Elemento no encontrado o pagina sin servicio");
        }
    }

    @Step("Se empieza a completar el formulario para expedir poliza SOAT")
    public void fillForm(String file, Integer sheet, Integer column) {
        IssuePolicyData.getIssuePolicyData(file, sheet, column);
        goToIssuePolicy();
        searchVehiclePlate();
        fillVehicleDataForm();
        fillDataFromTomador();
        selectPayment();
        generateIssuePolicy();
    }

    @Step("Realiza click para expedir poliza SOAT")
    public void goToIssuePolicy() {
        JavascriptExecutor js = (JavascriptExecutor) Serenity.getDriver();
        js.executeScript("window.scrollBy(0,500)", "");
        Serenity.takeScreenshot();
        issuePolicyPage.btnIssuePolicy.click();
        CommonFunction.waitOverlayToDisappear(loginPage.lblOverlay, timeOverlay);
    }

    @Step("Realiza la busqueda de la placa del vehiculo")
    public void searchVehiclePlate() {
        Scroll.to(issuePolicyPage.inputLicensePlate);
        CommonFunction.clearAndEnterValue(issuePolicyPage.inputLicensePlate, IssuePolicyData.getLicensePlate());
        issuePolicyPage.btnConsultVehiclePlate.click();
        CommonFunction.waitOverlayToDisappear(loginPage.lblOverlay, timeOverlay);
    }

    @Step("Se completa la información del vehiculo")
    public void fillVehicleDataForm() {
        if (issuePolicyPage.inputObservations.isPresent()) {
            CommonFunction.clearAndEnterValue(issuePolicyPage.inputObservations, "Ninguna");
        }
    }

    @Step("Se completa la informacion del tomador")
    public void fillDataFromTomador() {
        Scroll.to(issuePolicyPage.cbxDocumentTypeTm);
        CommonFunction.selectDropdownValue(issuePolicyPage.cbxDocumentTypeTm, IssuePolicyData.getDocumentTypeTm());
        CommonFunction.clearAndEnterValue(issuePolicyPage.inputIdNumber, IssuePolicyData.getIdNumber());
        CommonFunction.clearAndEnterValue(issuePolicyPage.inputIdDigit, IssuePolicyData.getIdDigit());
        CommonFunction.selectDropdownValue(issuePolicyPage.cbxGender, IssuePolicyData.getGender());
        CommonFunction.selectDropdownValue(issuePolicyPage.cbxPersonType, IssuePolicyData.getPersonType());
        CommonFunction.selectDropdownValue(issuePolicyPage.cbxCompanyType, IssuePolicyData.getCompanyType());
        CommonFunction.selectDropdownValue(issuePolicyPage.cbxOccupationCiiu, IssuePolicyData.getOccupationCiiu());
        CommonFunction.clearAndEnterValue(issuePolicyPage.inputFirstLastName, IssuePolicyData.getFirstLastName());
        CommonFunction.clearAndEnterValue(issuePolicyPage.inputSecondLastName, IssuePolicyData.getSecondLastName());
        CommonFunction.clearAndEnterValue(issuePolicyPage.inputName, IssuePolicyData.getName());
        CommonFunction.selectDropdownValue(issuePolicyPage.cbxAddressTypes, IssuePolicyData.getAddressTypes());
        CommonFunction.clearAndEnterValue(issuePolicyPage.inputAddress, IssuePolicyData.getAddress());
        CommonFunction.selectDropdownValue(issuePolicyPage.cbxPhoneType, IssuePolicyData.getPhoneType());
        CommonFunction.clearAndEnterValue(issuePolicyPage.inputPhoneNumber, IssuePolicyData.getPhoneNumber());
        CommonFunction.selectDropdownValue(issuePolicyPage.cbxDepartment, IssuePolicyData.getDepartment());
        CommonFunction.selectDropdownValue(issuePolicyPage.cbxMunicipality, IssuePolicyData.getMunicipality());
        CommonFunction.clearAndEnterValue(issuePolicyPage.inputEmail, IssuePolicyData.getEmail());
        CommonFunction.clearAndEnterValue(issuePolicyPage.inputCellPhone, IssuePolicyData.getCellPhone());
        Scroll.to(issuePolicyPage.cbxMunicipality);
        issuePolicyPage.btnCalculate.click();
        Scroll.to(issuePolicyPage.btnAccept);
        Serenity.takeScreenshot();
        issuePolicyPage.btnAccept.click();
        CommonFunction.waitOverlayToDisappear(loginPage.lblOverlay, timeOverlay);
        Scroll.to(paymentTypePage.btnGenerate);
        Serenity.takeScreenshot();
        assertThat(issuePolicyPage.lblCorrectDataMessage.getText(), Matchers.containsString(validateMessage));
        paymentTypePage.btnGenerate.click();
        Scroll.to(issuePolicyPage.btnAccept);
        Serenity.takeScreenshot();
        issuePolicyPage.btnAccept.click();
        CommonFunction.waitOverlayToDisappear(loginPage.lblOverlay, timeOverlay);
    }

    @Step("Se selecciona el metodo de pago")
    public void selectPayment() {
        paymentTypePage.inputCashPayment.click();
        Scroll.to(paymentTypePage.btnContinue);
        Serenity.takeScreenshot();
        paymentTypePage.btnContinue.waitUntilEnabled().withTimeoutOf(Duration.ofSeconds(10));
        Serenity.takeScreenshot();
        paymentTypePage.btnContinue.click();
        CommonFunction.waitOverlayToDisappear(loginPage.lblOverlay, timeOverlay);
    }

    @Step("Se genera la expedicion de poliza SOAT")
    public void generateIssuePolicy() {
        Scroll.to(issuePolicyPage.btnAccept);
        Serenity.takeScreenshot();
        CommonFunction.waitOverlayToDisappear(loginPage.lblOverlay, timeOverlay);
        issuePolicyPage.btnGenerateIssuePolicy.click();
        if (issuePolicyPage.btnAccept.isPresent()) {
            issuePolicyPage.btnAccept.click();
        }
        CommonFunction.waitOverlayToDisappear(loginPage.lblOverlay, timeOverlay);
    }

    @Step("Se crea la expedicion de poliza SOAT")
    public void validateSuccessfulPolicyCreation() {
        try {
            JavascriptExecutor js = (JavascriptExecutor) Serenity.getDriver();
            js.executeScript("window.scrollBy(0,250)", "");
            Scroll.to(resumePage.lblEmailNotification);
            Serenity.takeScreenshot();
            assertThat(resumePage.lblSuccessfulSoatGenerate.getText().trim(), is(messageIssueGenerate));
            assertThat(resumePage.lblEmailNotification.getText().trim(), is(messageEmailNotification));
            js.executeScript("window.scrollBy(0,300)", "");
            Serenity.takeScreenshot();
        } catch (Exception e) {
            LOGGER.info("Error en la validacion");
        }
    }


}
