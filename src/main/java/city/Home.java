package city;

public class Home extends Building {

    protected static final int SQUARE_METERS_NEED_PER_PERSON = 20;

    public Home(int area, int levels, Address address) {
        super(area, levels, address);
        if (!isLevelsValid()) {
            throw new IllegalArgumentException("The number of levels cannot be higher than 3");
        }
    }

    public Home(int area, Address address) {
        super(area, address);
        setLevels(1);
    }

    private boolean isLevelsValid() {
        return getLevels() <= 3;
    }

    @Override
    public int calculateNumberOfPeopleCanFit() {
        return getFullArea() / 20;
    }
}
