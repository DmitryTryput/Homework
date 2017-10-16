package tasks10.garage;

public class Minivan extends Car {

    private int seatCount;

    public Minivan(String mark, String model, int yearOfIssue, double engineCapacity, Transmission transmission, int seatCount) {
        super(mark, model, yearOfIssue, engineCapacity, transmission);
        this.seatCount = seatCount;
    }

    public int getSeatCount() {
        return seatCount;
    }

    @Override
    public String toString() {
        return " минивэн " +
                "марки " + getMark() +
                ", модель: " + getModel() +
                ", год выпуска: " + getYearOfIssue() +
                ", объем двигателя: " + getEngineCapacity() +
                ", коробка передач: " + getTransmission() +
                ", количество сиденей: " + getSeatCount();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Minivan minivan = (Minivan) o;

        return getSeatCount() == minivan.getSeatCount();
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 311 * result + getSeatCount();
        return result;
    }
}
