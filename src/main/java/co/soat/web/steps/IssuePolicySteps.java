package co.soat.web.steps;

import co.soat.web.pages.IssuePolicyPage;
import co.soat.web.pages.LoginPage;
import co.soat.web.pages.PaymentTypePage;
import co.soat.web.pages.ResumePage;
import co.soat.web.utils.CommonFunction;
import co.soat.web.utils.IssuePolicyData;
import net.thucydides.core.annotations.Step;
import org.hamcrest.Matchers;
import static org.hamcrest.Matchers.is;

import static org.hamcrest.MatcherAssert.assertThat;

public class IssuePolicySteps {
    LoginPage loginPage = new LoginPage();
    IssuePolicyPage issuePolicyPage = new IssuePolicyPage();
    PaymentTypePage paymentTypePage = new PaymentTypePage();
    ResumePage resumePage = new ResumePage();
    private final String messageIssueGenerate = "Poliza SOAT generada exitosamente";
    private final String messageEmailNotification = "Correo de notificación enviado correctamente";
    private final long timeOverlay = 10;

    @Step
    public void openSoatWebPage() {
        loginPage.open();
    }

    @Step
    public void doLogin(String userId, String password) {
        CommonFunction.clearAndEnterValue(loginPage.inputUser, userId);
        CommonFunction.clearAndEnterValue(loginPage.inputPassword, password);
        loginPage.btnLogin.click();
    }

    @Step
    public void fillForm(Integer sheet, Integer column) {
        IssuePolicyData.getIssuePolicyData("data.xlsx", sheet, column);
        issuePolicyPage.btnIssuePolicy.click();
        CommonFunction.clearAndEnterValue(issuePolicyPage.inputLicensePlate, IssuePolicyData.getLicensePlate());
        issuePolicyPage.btnConsultVehiclePlate.click();
        CommonFunction.waitOverlayToDisappear(loginPage.lblOverlay, timeOverlay);
        validateDisableElements();
        fillVehicleDataForm();
        fillDataFromTomador();
        issuePolicyPage.btnCalculate.click();
        issuePolicyPage.btnAccept.click();
        CommonFunction.waitOverlayToDisappear(loginPage.lblOverlay, timeOverlay);
        issuePolicyPage.btnGenerateIssuePolicy.click();
        issuePolicyPage.btnAccept.click();
        CommonFunction.waitOverlayToDisappear(loginPage.lblOverlay, timeOverlay);
        paymentTypePage.inputCashPayment.click();
        paymentTypePage.btnContinue.click();
        CommonFunction.waitOverlayToDisappear(loginPage.lblOverlay, 10);
        paymentTypePage.btnGenerate.click();
        CommonFunction.waitOverlayToDisappear(loginPage.lblOverlay, 10);
    }

    private void fillVehicleDataForm() {
        CommonFunction.clearAndEnterValue(issuePolicyPage.inputObservations, "Ninguna");
    }

    private void fillDataFromTomador() {
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
    }

    private void validateDisableElements() {
        assertThat(issuePolicyPage.cbxDisableClass.isDisabled(), is(true));
        assertThat(issuePolicyPage.cbxDisableBrand.isDisabled(), is(true));
        assertThat(issuePolicyPage.cbxDisableLine.isDisabled(), is(true));
        assertThat(issuePolicyPage.cbxDisableService.isDisabled(), is(true));
        assertThat(issuePolicyPage.inputDisableBrandDescription.isDisabled(), is(true));
        assertThat(issuePolicyPage.inputDisableLineDescription.isDisabled(), is(true));
        assertThat(issuePolicyPage.inputDisableModel.isDisabled(), is(true));
        assertThat(issuePolicyPage.inputDisableEngineDisplacement.isDisabled(), is(true));
        assertThat(issuePolicyPage.inputDisablePassengers.isDisabled(), is(true));
    }

    public void validateSuccessfulPolicyCreation() {
        assertThat(resumePage.lblSuccessfulSoatGenerate.getText(), Matchers.containsString(messageIssueGenerate));
        assertThat(resumePage.lblEmailNotification.getText(), Matchers.containsString(messageEmailNotification));
    }


}
