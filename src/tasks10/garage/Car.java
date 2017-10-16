package tasks10.garage;

public abstract class Car {

    private String mark;
    private String model;
    private int yearOfIssue;
    private double engineCapacity;
    private Transmission transmission;

    public Car(String mark, String model, int yearOfIssue, double engineCapacity, Transmission transmission) {
        this.mark = mark;
        this.model = model;
        this.yearOfIssue = yearOfIssue;
        this.engineCapacity = engineCapacity;
        this.transmission = transmission;
    }

    public String getMark() {
        return mark;
    }

    public String getModel() {
        return model;
    }

    public int getYearOfIssue() {
        return yearOfIssue;
    }

    public double getEngineCapacity() {
        return engineCapacity;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (getYearOfIssue() != car.getYearOfIssue()) return false;
        if (getEngineCapacity() != car.getEngineCapacity()) return false;
        if (!getMark().equals(car.getMark())) return false;
        if (!getModel().equals(car.getModel())) return false;
        return getTransmission() == car.getTransmission();
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getMark().hashCode();
        result = 31 * result + getModel().hashCode();
        result = 31 * result + getYearOfIssue();
        temp = Double.doubleToLongBits(getEngineCapacity());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + getTransmission().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Машина " +
                "марки" + mark +
                ", модель: " + model +
                ", год выпуска: " + yearOfIssue +
                ", объем двигателя: " + engineCapacity +
                ", коробка передач: " + transmission;
    }
}
