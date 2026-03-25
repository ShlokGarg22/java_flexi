import java.util.*;

abstract class Transport {
    protected String trackingId;
    protected String destination;

    public Transport(String trackingId, String destination) {
        this.trackingId = trackingId;
        this.destination = destination;
    }

    abstract void dispatch();

    public static void main(String[] args) {

        Transport t = new DeliveryDrone("D101");
        t.dispatch();

        GPS g = new DeliveryDrone("D101");
        System.out.println(g.getCoordinates());

        if (t instanceof GPS) {
            System.out.println("t is GPS enabled");
        } else {
            System.out.println("t is NOT GPS enabled");
        }

        // ----------- List<Transport> Demo -----------
        List<Transport> transports = new ArrayList<>();
        transports.add(new Truck("T1", "Delhi"));
        transports.add(new DeliveryDrone("D2", "Mumbai"));
        transports.add(new CargoShip("C1", "Dubai"));

        for (Transport transport : transports) {
            transport.dispatch();

            // Safe interface usage
            if (transport instanceof GPS) {
                GPS gpsDevice = (GPS) transport;
                System.out.println("Coordinates: " + gpsDevice.getCoordinates());
            }

            if (transport instanceof Autonomous) {
                Autonomous auto = (Autonomous) transport;
                auto.selfNavigate();
            }

            System.out.println("----------------------");
        }
    }
}

interface GPS {
    String getCoordinates();
}

interface Autonomous {
    void selfNavigate();
}

class Truck extends Transport {

    public Truck(String trackingId, String destination) {
        super(trackingId, destination);
    }

    @Override
    void dispatch() {
        System.out.println("Truck " + trackingId + " leaving via highway...");
    }
}

class CargoShip extends Transport implements GPS {

    public CargoShip(String trackingId, String destination) {
        super(trackingId, destination);
    }

    @Override
    void dispatch() {
        System.out.println("Cargo Ship " + trackingId + " sailing...");
    }

    @Override
    public String getCoordinates() {
        return "25.276987° N, 55.296249° E";
    }
}

class DeliveryDrone extends Transport implements GPS, Autonomous {

    public DeliveryDrone(String trackingId, String destination) {
        super(trackingId, destination);
    }

    // Constructor for test case (only ID)
    public DeliveryDrone(String trackingId) {
        super(trackingId, "Unknown");
    }

    @Override
    void dispatch() {
        System.out.println("Drone " + trackingId + " taking off...");
    }

    @Override
    public String getCoordinates() {
        return "40.7128° N, 74.0060° W";
    }

    @Override
    public void selfNavigate() {
        System.out.println("Drone " + trackingId + " navigating autonomously...");
    }
}