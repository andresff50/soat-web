package co.soat.web.utils;

import java.util.Map;
import java.util.TreeMap;

public class IssuePolicyData {
    private static Map<Integer, Map<Integer, String>> dataDriver = new TreeMap<>();
    private static String licensePlate;
    private static String vehicleCapacity;
    private static String vehicleMotor;
    private static String vehicleChassis;
    private static String countryOfVehicle;
    private static String documentTypeTm;
    private static String gender;
    private static String personType;
    private static String companyType;
    private static String occupationCiiu;
    private static String addressTypes;
    private static String phoneType;
    private static String department;
    private static String municipality;
    private static String idNumber;
    private static String idDigit;
    private static String firstLastName;
    private static String secondLastName;
    private static String name;
    private static String address;
    private static String phoneNumber;
    private static String email;
    private static String cellPhone;

    public IssuePolicyData() {
        throw new IllegalStateException("DatosExpedirSoat class");
    }

    public static void getIssuePolicyData(String documentName, int sheetNumber, int rowNumber) {
        dataDriver = loadDataDriver(documentName, sheetNumber);
        licensePlate = dataDriver.get(rowNumber).get(0);
        documentTypeTm = dataDriver.get(rowNumber).get(1);
        idNumber = dataDriver.get(rowNumber).get(2);
        idDigit = dataDriver.get(rowNumber).get(3);
        gender = dataDriver.get(rowNumber).get(4);
        personType = dataDriver.get(rowNumber).get(5);
        companyType = dataDriver.get(rowNumber).get(6);
        occupationCiiu = dataDriver.get(rowNumber).get(7);
        firstLastName = dataDriver.get(rowNumber).get(8);
        secondLastName = dataDriver.get(rowNumber).get(9);
        name = dataDriver.get(rowNumber).get(10);
        addressTypes = dataDriver.get(rowNumber).get(11);
        address = dataDriver.get(rowNumber).get(12);
        phoneType = dataDriver.get(rowNumber).get(13);
        phoneNumber = dataDriver.get(rowNumber).get(14);
        department = dataDriver.get(rowNumber).get(15);
        municipality = dataDriver.get(rowNumber).get(16);
        email = dataDriver.get(rowNumber).get(17);
        cellPhone = dataDriver.get(rowNumber).get(18);
    }

    public static Map<Integer, Map<Integer, String>> loadDataDriver(String documentName, int sheetNumber) {
        ExcelDriver document = new ExcelDriver();
        return document.loadDataDrive("data/" + documentName, sheetNumber);
    }

    public static String getLicensePlate() {
        return licensePlate;
    }

    public static String getVehicleCapacity() {
        return vehicleCapacity;
    }

    public static String getVehicleMotor() {
        return vehicleMotor;
    }

    public static String getVehicleChassis() {
        return vehicleChassis;
    }

    public static String getCountryOfVehicle() {
        return countryOfVehicle;
    }

    public static String getDocumentTypeTm() {
        return documentTypeTm;
    }

    public static String getGender() {
        return gender;
    }

    public static String getPersonType() {
        return personType;
    }

    public static String getCompanyType() {
        return companyType;
    }

    public static String getOccupationCiiu() {
        return occupationCiiu;
    }

    public static String getAddressTypes() {
        return addressTypes;
    }

    public static String getPhoneType() {
        return phoneType;
    }

    public static String getDepartment() {
        return department;
    }

    public static String getMunicipality() {
        return municipality;
    }

    public static String getIdNumber() {
        return idNumber;
    }

    public static String getIdDigit() {
        return idDigit;
    }

    public static String getFirstLastName() {
        return firstLastName;
    }

    public static String getSecondLastName() {
        return secondLastName;
    }

    public static String getName() {
        return name;
    }

    public static String getAddress() {
        return address;
    }

    public static String getPhoneNumber() {
        return phoneNumber;
    }

    public static String getEmail() {
        return email;
    }

    public static String getCellPhone() {
        return cellPhone;
    }
}
