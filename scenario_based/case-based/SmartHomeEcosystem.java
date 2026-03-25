abstract class Device {
    protected String brand;

    public Device(String brand) {
        this.brand = brand;
    }

    abstract void turnOn();
}

interface RemoteControllable {
    String WIFI_NETWORK = "Home_5G";

    void connectToWifi();
}

interface PowerSaving {
    String getEnergyRating();
}

class SmartTV extends Device implements RemoteControllable, PowerSaving {

    public SmartTV(String brand) {
        super(brand);
    }

    @Override
    void turnOn() {
        System.out.println(brand + " TV is booting up...");
    }

    @Override
    public void connectToWifi() {
        System.out.println("Connecting to " + WIFI_NETWORK + "...");
    }

    @Override
    public String getEnergyRating() {
        return "A++";
    }
}

class ElectricKettle extends Device {

    public ElectricKettle(String brand) {
        super(brand);
    }

    @Override
    void turnOn() {
        System.out.println(brand + " kettle is heating water...");
    }
}

public class SmartHomeEcosystem {
    public static void main(String[] args) {
        // TC 1: Upcasting to parent class
        Device d = new SmartTV("Sony");
        d.turnOn();

        // TC 2: Interface polymorphism
        RemoteControllable r = new SmartTV("LG");
        r.connectToWifi();

        // TC 3: Uncommenting the line below gives compile-time error
        // r.turnOn();

        // Extra demo for second interface
        PowerSaving p = new SmartTV("Samsung");
        System.out.println("Energy Rating: " + p.getEnergyRating());

        // Standard device that only extends Device
        Device kettle = new ElectricKettle("Philips");
        kettle.turnOn();
    }
}
