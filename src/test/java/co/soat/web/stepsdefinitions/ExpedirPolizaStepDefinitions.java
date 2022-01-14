package co.soat.web.stepsdefinitions;

import co.soat.web.steps.IssuePolicySteps;
import co.soat.web.utils.IssuePolicyData;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.thucydides.core.annotations.Steps;

public class ExpedirPolizaStepDefinitions {

    @Steps
    IssuePolicySteps issuePolicySteps;

    @Dado("que yo quiero iniciar sesion en SOAT web para expedir una poliza con usuario {string} y password {string}")
    public void queQuieroIniciarSesionEnSOATWebParaExpedirUnaPoliza(String user, String password) {
        issuePolicySteps.openSoatWebPage();
        issuePolicySteps.doLogin(user, password);
    }

    @Cuando("yo completo el formulario con la informacion de la hoja {int} y columna {int}")
    public void completoElFormularioConLaInformacionDeLaHojaYColumna(Integer sheet, Integer column) {
        IssuePolicyData.getIssuePolicyData("data.xlsx", sheet, column);
        issuePolicySteps.goToIssuePolicy();
        issuePolicySteps.searchVehiclePlate();
        issuePolicySteps.fillVehicleDataForm();
        issuePolicySteps.fillDataFromTomador();
        issuePolicySteps.selectPayment();
        issuePolicySteps.generateIssuePolicy();
    }

    @Entonces("yo deberia ver el mensaje que la poliza se creo correctamente")
    public void deberiaVerElMensajeQueLaPolizaSeCreoCorrectamente() {
        issuePolicySteps.validateSuccessfulPolicyCreation();
    }

}
