package city;

import java.util.ArrayList;
import java.util.List;

public class City {

    private String name;
    private long fullArea;
    private List<Building> buildings = new ArrayList<>();

    public City(String name, long fullArea) {
        this.name = name;
        this.fullArea = fullArea;
    }

    public void addBuilding(Building building) {
        if (isAreaValid(building)) {
            buildings.add(building);
        } else {
            throw new IllegalArgumentException("City can't be larger than 500");
        }
    }

    private boolean isAreaValid(Building building) {
        int sum = 0;
        for (Building i : buildings) {
            sum += i.getArea();
        }
        return (sum + building.getArea()) <= fullArea;

    }

    public Building findHighestBuilding() {
        Building highest = buildings.get(0);
        int highestLevels = buildings.get(0).getLevels();

        for (Building b : buildings) {
            if (b.getLevels() > highestLevels) {
                highestLevels = b.getLevels();
                highest = b;
            }
        }
        return highest;
    }

    public List<Building> findBuildingsByStreet(String street) {
        List<Building> result = new ArrayList<>();

        for (Building b : buildings) {
            if (b.getAddress().getStreet().equalsIgnoreCase(street)) {
                result.add(b);
            }
        }
        return result;
    }

    public boolean isThereBuildingWithMorePeopleThan(int numberOfPeople) {

        for (Building b : buildings) {
            if (b.calculateNumberOfPeopleCanFit() > numberOfPeople) {
                return true;
            }
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public long getFullArea() {
        return fullArea;
    }

    public List<Building> getBuildings() {
        return buildings;
    }
}
