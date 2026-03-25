abstract class Robot {
    private final String batteryId;
    protected double chargeLevel;

    Robot(String batteryId, double chargeLevel) {
        this.batteryId = batteryId;
        this.chargeLevel = Math.max(0.0, chargeLevel);
    }

    public String getBatteryId() {
        return batteryId;
    }

    public double getChargeLevel() {
        return chargeLevel;
    }

    protected boolean work(double requiredCharge) {
        if (chargeLevel < requiredCharge) {
            System.out.println("Low battery!");
            return false;
        }
        chargeLevel -= requiredCharge;
        return true;
    }

    public void reportStatus() {
        System.out.println("Robot " + batteryId + " | Charge: " + String.format("%.1f", chargeLevel) + "%");
    }

    abstract void performTask();
}

class DroneRobot extends Robot {
    private final double speedMultiplier;

    DroneRobot(String batteryId, double chargeLevel) {
        super(batteryId, chargeLevel);
        this.speedMultiplier = 2.0;
    }

    @Override
    void performTask() {
        if (work(15.0)) {
            System.out.println("Drone " + getBatteryId() + " moved inventory at " + speedMultiplier + "x speed.");
            reportStatus();
        }
    }
}

class GroundRobot extends Robot {
    GroundRobot(String batteryId, double chargeLevel) {
        super(batteryId, chargeLevel);
    }

    private boolean surfaceCheck() {
        System.out.println("Ground robot " + getBatteryId() + " surface check complete.");
        return true;
    }

    @Override
    void performTask() {
        if (surfaceCheck() && work(5.0)) {
            System.out.println("Ground robot " + getBatteryId() + " moved inventory.");
            reportStatus();
        }
    }
}

class warehouse {
    public static void main(String[] args) {
        System.out.println("TC 1:");
        Robot tc1 = new DroneRobot("D-1", 20.0);
        tc1.performTask();

        System.out.println("TC 2:");
        Robot tc2 = new GroundRobot("G-5", 10.0);
        tc2.performTask();

        System.out.println("TC 3:");
        Robot tc3 = new DroneRobot("D-2", 10.0);
        tc3.performTask();

        System.out.println("Fleet Demo:");
        Robot[] fleet = { new DroneRobot("D1", 50.0), new GroundRobot("G1", 50.0) };
        for (Robot r : fleet) {
            r.performTask();
        }
    }
}




