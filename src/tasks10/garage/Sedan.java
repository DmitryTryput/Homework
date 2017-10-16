package tasks10.garage;

public class Sedan extends Car {

    private int numberOfDoors;

    public Sedan(String mark, String model, int yearOfIssue, double engineCapacity, Transmission transmission, int numberOfDoors) {
        super(mark, model, yearOfIssue, engineCapacity, transmission);
        this.numberOfDoors = numberOfDoors;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    @Override
    public String toString() {
        return " седан " +
                "марки " + getMark() +
                ", модель: " + getModel() +
                ", год выпуска: " + getYearOfIssue() +
                ", объем двигателя: " + getEngineCapacity() +
                ", коробка передач: " + getTransmission() +
                ", количество дверей: " + getNumberOfDoors();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Sedan sedan = (Sedan) o;

        return getNumberOfDoors() == sedan.getNumberOfDoors();
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getNumberOfDoors();
        return result;
    }
}
