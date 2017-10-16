package tasks10.garage;

import java.util.HashMap;
import java.util.Map;

public class Garage {

    private Map<Car, Integer> garage;

    public static void main(String[] args) {
        Garage garage = new Garage();
        Car car1 = new Minivan("bmv","320",2000, 3.2, Transmission.AUTOMATIC, 5);
        Car car2 = new Minivan("bmv","320",2010, 3.2, Transmission.AUTOMATIC, 5);
        Car car3 = new Sedan("bmv","320",2000, 3.2, Transmission.AUTOMATIC, 5);
        Car car4 = new Sedan("bmv","300",2010, 3.2, Transmission.AUTOMATIC, 3);
        Car car5 = new Hatchback("bmv","320",2010, 3.2, Transmission.AUTOMATIC, 100);
        Car car6 = new Hatchback("bmv","320",2010, 3.2, Transmission.MANUAL, 100);
        Car car7 = new Pickup("bmv","320",2010, 3.2, Transmission.AUTOMATIC, 5);
        Car car8 = new Pickup("audi","320",2010, 3.2, Transmission.AUTOMATIC, 100);
        Car car9 = new Pickup("audi","320",2010, 3.2, Transmission.AUTOMATIC, 100);
        garage.parkCar(car1);
        garage.parkCar(car2);
        garage.parkCar(car3);
        garage.parkCar(car4);
        garage.parkCar(car5);
        garage.parkCar(car6);
        garage.parkCar(car7);
        garage.parkCar(car8);
        garage.parkCar(car9);
        garage.carCount(car8);
        garage.carCount(car2);
        garage.takeCar(car2);
        garage.takeCar(car2);
        garage.carCount(car2);
    }

    public Garage() {
        garage = new HashMap<>();
    }

    public void parkCar(Car car) {
        if (garage.containsKey(car)) {
            garage.put(car, garage.get(car) + 1);
            return;
        }
        garage.put(car, 1);
    }

    public void takeCar(Car car) {
        if (garage.containsKey(car) && garage.get(car) == 1) {
            garage.remove(car);
        } else if (garage.containsKey(car)) {
            garage.put(car, garage.get(car) - 1);
        } else {
            System.out.println("Нет такого автомобиля");
        }
    }

    public void carCount(Car car) {
        if (garage.containsKey(car)) {
            System.out.println("Количество автомобилей " + car + " => " + garage.get(car));
        } else {
            System.out.println("В гараже нет таких автомобилей: " + car);
        }
    }
}