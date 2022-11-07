package lecture02;

public class Excercise2_3 {
    public static void main(String[] args) {
        Tire[] tires =new Tire[4];
        for (int i = 0; i <tires.length ; i++) {
            tires[i]=new Tire();
            tires[i].size=65;
        }
        Engine engine =new Engine(4000);
        Car car = new Car(tires,engine);
        GasStation gasStation =new GasStation();
        gasStation.refuel(car);
        car.startEngine();
        car.run();
        car.run();

    }
}
