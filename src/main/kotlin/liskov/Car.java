package liskov;

class Vehicle {
    public void start() {
        System.out.println("Vehicle is starting.");
    }
}

class Car extends Vehicle {

    @Override
    public void start() {
        System.out.println("Car is starting.");
    }

    public void drive() {
        System.out.println("Car is driving.");
    }
}
