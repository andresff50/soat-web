package co.soat.web.utils;

import java.util.Map;
import java.util.TreeMap;

public class IssuePolicyData {
    private static Map<Integer, Map<Integer, String>> dataDriver = new TreeMap<>();
    private static String licensePlate;
    private static String vehicleCLass;
    private static String vehicleBrand;
    private static String vehicleLine;
    private static String vehicleService;
    private static String model;
    private static String displacement;
    private static String vehiclePassengers;
    private static String capacity;
    private static String motor;
    private static String chassis;
    private static String vin;
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
        vehicleCLass = dataDriver.get(rowNumber).get(1);
        vehicleBrand = dataDriver.get(rowNumber).get(2);
        vehicleLine = dataDriver.get(rowNumber).get(3);
        vehicleService = dataDriver.get(rowNumber).get(4);
        model = dataDriver.get(rowNumber).get(5);
        displacement = dataDriver.get(rowNumber).get(6);
        vehiclePassengers = dataDriver.get(rowNumber).get(7);
        capacity = dataDriver.get(rowNumber).get(8);
        motor = dataDriver.get(rowNumber).get(9);
        chassis = dataDriver.get(rowNumber).get(10);
        vin = dataDriver.get(rowNumber).get(11);
        countryOfVehicle = dataDriver.get(rowNumber).get(12);

        documentTypeTm = dataDriver.get(rowNumber).get(13);
        idNumber = dataDriver.get(rowNumber).get(14);
        idDigit = dataDriver.get(rowNumber).get(15);
        gender = dataDriver.get(rowNumber).get(16);
        personType = dataDriver.get(rowNumber).get(17);
        companyType = dataDriver.get(rowNumber).get(18);
        occupationCiiu = dataDriver.get(rowNumber).get(19);
        firstLastName = dataDriver.get(rowNumber).get(20);
        secondLastName = dataDriver.get(rowNumber).get(21);
        name = dataDriver.get(rowNumber).get(22);
        addressTypes = dataDriver.get(rowNumber).get(23);
        address = dataDriver.get(rowNumber).get(24);
        phoneType = dataDriver.get(rowNumber).get(25);
        phoneNumber = dataDriver.get(rowNumber).get(26);
        department = dataDriver.get(rowNumber).get(27);
        municipality = dataDriver.get(rowNumber).get(28);
        email = dataDriver.get(rowNumber).get(29);
        cellPhone = dataDriver.get(rowNumber).get(30);
    }

    public static Map<Integer, Map<Integer, String>> loadDataDriver(String documentName, int sheetNumber) {
        ExcelDriver document = new ExcelDriver();
        return document.loadDataDrive("data/" + documentName, sheetNumber);
    }

    public static String getLicensePlate() {
        return licensePlate;
    }

    public static String getVehicleCLass() {
        return vehicleCLass;
    }

    public static String getVehicleBrand() {
        return vehicleBrand;
    }

    public static String getVehicleLine() {
        return vehicleLine;
    }

    public static String getVehicleService() {
        return vehicleService;
    }

    public static String getModel() {
        return model;
    }

    public static String getDisplacement() {
        return displacement;
    }

    public static String getVehiclePassengers() {
        return vehiclePassengers;
    }

    public static String getCapacity() {
        return capacity;
    }

    public static String getMotor() {
        return motor;
    }

    public static String getChassis() {
        return chassis;
    }

    public static String getVin() {
        return vin;
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
