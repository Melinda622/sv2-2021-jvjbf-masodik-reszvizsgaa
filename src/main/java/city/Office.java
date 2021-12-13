package city;

public class Office extends Building {

    private String company;
    private int numberOfTablesPerLevel;

    public Office(int area, int levels, Address address, String company, int numberOfTablesPerLevel) {
        super(area, levels, address);
        this.company = company;
        this.numberOfTablesPerLevel = numberOfTablesPerLevel;
        if (!isNotTooManyTables()) {
            throw new IllegalArgumentException("The area per table must be between 2 and 5!");
        }
    }

    private boolean isNotTooManyTables() {
        int areaPerTable = getArea() / getNumberOfTablesPerLevel();
        return (areaPerTable >= 2 && areaPerTable <= 5);
    }

    @Override
    public int calculateNumberOfPeopleCanFit() {
        return getNumberOfTablesPerLevel() * (getLevels() - 1);
    }

    public Office(int area, Address address) {
        super(area, address);
    }

    public String getCompany() {
        return company;
    }

    public int getNumberOfTablesPerLevel() {
        return numberOfTablesPerLevel;
    }
}
