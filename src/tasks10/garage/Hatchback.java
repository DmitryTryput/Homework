package tasks10.garage;

public class Hatchback extends Car {

    private int horsepower;

    public Hatchback(String mark, String model, int yearOfIssue, double engineCapacity, Transmission transmission, int horsepower) {
        super(mark, model, yearOfIssue, engineCapacity, transmission);
        this.horsepower = horsepower;
    }

    public int getHorsepower() {
        return horsepower;
    }

    @Override
    public String toString() {
        return " хэчбэк " +
                "марки " + getMark() +
                ", модель: " + getModel() +
                ", год выпуска: " + getYearOfIssue() +
                ", объем двигателя: " + getEngineCapacity() +
                ", коробка передач: " + getTransmission() +
                ", и лошадиных сил: " + getHorsepower();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Hatchback hatchback = (Hatchback) o;

        return getHorsepower() == hatchback.getHorsepower();
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getHorsepower();
        return result;
    }
}
