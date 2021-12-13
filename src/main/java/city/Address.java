package city;

public class Address {

    private String Street;
    private int buildingNumber;

    public Address(String street, int buildingNumber) {
        Street = street;
        this.buildingNumber = buildingNumber;
    }

    public String getStreet() {
        return Street;
    }

    public int getBuildingNumber() {
        return buildingNumber;
    }
}
