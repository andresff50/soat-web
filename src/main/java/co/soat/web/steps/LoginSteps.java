package co.soat.web.steps;

import co.soat.web.pages.IssuePolicyPage;
import co.soat.web.pages.LoginPage;
import co.soat.web.utils.CommonFunction;
import co.soat.web.utils.IssuePolicyData;
import net.thucydides.core.annotations.Step;

public class LoginSteps {
    LoginPage loginPage = new LoginPage();
    IssuePolicyPage issuePolicyPage = new IssuePolicyPage();

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
        issuePolicyPage.btnIssuePolicy.click();
        IssuePolicyData.getIssuePolicyData("data.xlsx", sheet, column);
        CommonFunction.clearAndEnterValue(issuePolicyPage.inputLicensePlate, IssuePolicyData.getLicensePlate());
        issuePolicyPage.btnConsultVehiclePlate.click();
        loginPage.lblOverlay.waitUntilNotVisible();
        CommonFunction.clearAndEnterValue(issuePolicyPage.inputAddress, IssuePolicyData.getAddress());
        CommonFunction.selectDropdownValue(issuePolicyPage.cbxPhoneType, IssuePolicyData.getPhoneType());
        CommonFunction.clearAndEnterValue(issuePolicyPage.inputPhoneNumber, IssuePolicyData.getPhoneNumber());
        CommonFunction.clearAndEnterValue(issuePolicyPage.inputEmail, IssuePolicyData.getEmail());
        CommonFunction.clearAndEnterValue(issuePolicyPage.inputCellPhone, IssuePolicyData.getCellPhone());
        issuePolicyPage.btnCalculate.click();
        String valueTest = issuePolicyPage.lblTextConfirmationBeneficiary.getText();
        issuePolicyPage.btnAccept.click();
        issuePolicyPage.btnGenerateIssuePolicy.click();
        issuePolicyPage.btnAccept.click();
    }
}
