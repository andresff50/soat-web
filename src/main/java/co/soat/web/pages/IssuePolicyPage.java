package co.soat.web.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class IssuePolicyPage extends PageObject {
    @FindBy(xpath = "//td[contains(text(), 'Expedir Poliza')]/parent::tr")
    public WebElementFacade btnIssuePolicy;

    @FindBy(xpath = "//input[contains(@id, 'txtPlaca')]")
    public WebElementFacade inputLicensePlate;

    @FindBy(xpath = "//input[contains(@value, 'Consultar Runt')]")
    public WebElementFacade btnConsultVehiclePlate;

    @FindBy(xpath = "//select[contains(@id, 'txtClase')]")
    public WebElementFacade cbxDisableClass;

    @FindBy(xpath = "//select[contains(@id, 'txtMarca')]")
    public WebElementFacade cbxDisableBrand;

    @FindBy(xpath = "//select[contains(@id, 'txtLinea')]")
    public WebElementFacade cbxDisableLine;

    @FindBy(xpath = "//select[contains(@id, 'txtServicio')]")
    public WebElementFacade cbxDisableService;

    @FindBy(xpath = "//input[contains(@id, 'txtDesMarca')]")
    public WebElementFacade inputDisableBrandDescription;

    @FindBy(xpath = "//input[contains(@id, 'txtDesLinea')]")
    public WebElementFacade inputDisableLineDescription;

    @FindBy(xpath = "//input[contains(@id, 'txtModelo')]")
    public WebElementFacade inputDisableModel;

    @FindBy(xpath = "//input[contains(@id, 'txtCilindraje')]")
    public WebElementFacade inputDisableEngineDisplacement;

    @FindBy(xpath = "//input[contains(@id, 'txtPasajeros')]")
    public WebElementFacade inputDisablePassengers;

    @FindBy(xpath = "//input[contains(@id, 'txtCapacidad')]")
    public WebElementFacade inputVehicleCapacity;

    @FindBy(xpath = "//input[contains(@id, 'txtMotor')]")
    public WebElementFacade inputVehicleMotor;

    @FindBy(xpath = "//input[contains(@id, 'txtChasis')]")
    public WebElementFacade inputVehicleChassis;

    @FindBy(xpath = "//select[contains(@id, 'txtPais')]")
    public WebElementFacade cbxCountryOfVehicle;

    @FindBy(xpath = "//input[contains(@id, 'txtObservaciones')]")
    public WebElementFacade inputObservations;

    @FindBy(xpath = "//select[contains(@id, 'tipoDocumento_tm')]")
    public WebElementFacade cbxDocumentTypeTm;

    @FindBy(xpath = "//select[contains(@id, 'sexo_tm')]")
    public WebElementFacade cbxGender;

    @FindBy(xpath = "//select[contains(@id, 'tipoPersona_tm')]")
    public WebElementFacade cbxPersonType;

    @FindBy(xpath = "//select[contains(@id, 'tipoEmpresa_tm')]")
    public WebElementFacade cbxCompanyType;

    @FindBy(xpath = "//select[contains(@id, 'ocupacion_tm')]")
    public WebElementFacade cbxOccupationCiiu;

    @FindBy(xpath = "//select[contains(@id, 'tipoDireccion_tm')]")
    public WebElementFacade cbxAddressTypes;

    @FindBy(xpath = "//select[contains(@id, 'tipoTelefono_tm')]")
    public WebElementFacade cbxPhoneType;

    @FindBy(xpath = "//select[contains(@id, 'departamento')]")
    public WebElementFacade cbxDepartment;

    @FindBy(xpath = "//select[contains(@id, 'municipio_tm')]")
    public WebElementFacade cbxMunicipality;

    @FindBy(xpath = "//input[contains(@id, 'txtNroIdentificacion_tm')]")
    public WebElementFacade inputIdNumber;

    @FindBy(xpath = "//input[contains(@id, 'txtDigitoIdentificacion_tm')]")
    public WebElementFacade inputIdDigit;

    @FindBy(xpath = "//input[contains(@id, 'txtApellido1_tm')]")
    public WebElementFacade inputFirstLastName;

    @FindBy(xpath = "//input[contains(@id, 'txtApellido2_tm')]")
    public WebElementFacade inputSecondLastName;

    @FindBy(xpath = "//input[contains(@id, 'txtNombre_tm')]")
    public WebElementFacade inputName;

    @FindBy(xpath = "//input[contains(@id, 'txtDireccion_tm')]")
    public WebElementFacade inputAddress;

    @FindBy(xpath = "//input[contains(@id, 'txtNumeroTelefono_tm')]")
    public WebElementFacade inputPhoneNumber;

    @FindBy(xpath = "//input[contains(@id, 'txtCorreo')]")
    public WebElementFacade inputEmail;

    @FindBy(xpath = "//input[contains(@id, 'txtNumeroCelular')]")
    public WebElementFacade inputCellPhone;

    @FindBy(xpath = "//input[@value='Calcular']")
    public WebElementFacade btnCalculate;

    @FindBy(xpath = "//div[@class='msgBoxContainer']//div[contains(@id, 'Content')]//span")
    public WebElementFacade lblTextConfirmationBeneficiary;

    @FindBy(xpath = "//input[@value='Aceptar']")
    public WebElementFacade btnAccept;

    @FindBy(id = "ctl00_ContentPlaceHolder1_mensaje2")
    public WebElementFacade lblCorrectDataMessage;

    @FindBy(xpath = "//input[contains(@id, 'btnGenerarPoliza')]")
    public WebElementFacade btnGenerateIssuePolicy;

    @FindBy(xpath = "//div[@id='msgBox1641916689844Content']//span")
    public WebElementFacade lblResumeIssuePolicy;

}
