package tasks10.garage;

public class Pickup extends Car{

    private int trunkSize;

    public Pickup(String mark, String model, int yearOfIssue, double engineCapacity, Transmission transmission, int trunkSize) {
        super(mark, model, yearOfIssue, engineCapacity, transmission);
        this.trunkSize = trunkSize;
    }

    public int getTrunkSize() {
        return trunkSize;
    }

    @Override
    public String toString() {
        return " пикап " +
                "марки " + getMark() +
                ", модель: " + getModel() +
                ", год выпуска: " + getYearOfIssue() +
                ", объем двигателя: " + getEngineCapacity() +
                ", коробка передач: " + getTransmission() +
                ", размер багажника: " + getTrunkSize();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Pickup pickup = (Pickup) o;

        return getTrunkSize() == pickup.getTrunkSize();
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getTrunkSize();
        return result;
    }
}
