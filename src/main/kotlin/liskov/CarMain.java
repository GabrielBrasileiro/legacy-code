package liskov;

public class CarMain {
    public static void main(String[] args) {
        Vehicle vehicle = new Car();
        Car car = (Car) vehicle;
        car.drive();
    }
}
