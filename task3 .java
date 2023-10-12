class Engine {
    private String type;

    public Engine(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

class CombustionEngine extends Engine {
    private String fuelType;

    public CombustionEngine(String fuelType) {
        super("Combustion");
        this.fuelType = fuelType;
    }

    public String getFuelType() {
        return fuelType;
    }
}

class ElectricEngine extends Engine {
    private String batteryType;

    public ElectricEngine(String batteryType) {
        super("Electric");
        this.batteryType = batteryType;
    }

    public String getBatteryType() {
        return batteryType;
    }
}

class HybridEngine extends Engine {
    private String fuelType;
    private String batteryType;

    public HybridEngine(String fuelType, String batteryType) {
        super("Hybrid");
        this.fuelType = fuelType;
        this.batteryType = batteryType;
    }

    public String getFuelType() {
        return fuelType;
    }

    public String getBatteryType() {
        return batteryType;
    }
}

class Manufacture {
    private String name;
    private String location;

    public Manufacture(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }
}

abstract class Vehicle {
    protected String make;
    protected String model;
    protected int year;
    protected Manufacture manufacture;
    protected Engine engine;

    public Vehicle(String make, String model, int year, Manufacture manufacture, Engine engine) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.manufacture = manufacture;
        this.engine = engine;
    }

    public abstract void showCharacteristics();
}

class ICEV extends Vehicle {
    public ICEV(String make, String model, int year, Manufacture manufacture, CombustionEngine engine) {
        super(make, model, year, manufacture, engine);
    }

    @Override
    public void showCharacteristics() {
        System.out.println("Internal Combustion Engine Vehicle:");
        System.out.println("Make: " + make);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Manufacture: " + manufacture.getName() + ", Location: " + manufacture.getLocation());
        System.out.println("Engine Type: " + engine.getType());
        System.out.println("Fuel Type: " + ((CombustionEngine) engine).getFuelType());
    }
}

class BEV extends Vehicle {
    public BEV(String make, String model, int year, Manufacture manufacture, ElectricEngine engine) {
        super(make, model, year, manufacture, engine);
    }

    @Override
    public void showCharacteristics() {
        System.out.println("Battery Electric Vehicle:");
        System.out.println("Make: " + make);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Manufacture: " + manufacture.getName() + ", Location: " + manufacture.getLocation());
        System.out.println("Engine Type: " + engine.getType());
        System.out.println("Battery Type: " + ((ElectricEngine) engine).getBatteryType());
    }
}

class HybridV extends Vehicle {
    public HybridV(String make, String model, int year, Manufacture manufacture, HybridEngine engine) {
        super(make, model, year, manufacture, engine);
    }

    @Override
    public void showCharacteristics() {
        System.out.println("Hybrid Vehicle:");
        System.out.println("Make: " + make);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Manufacture: " + manufacture.getName() + ", Location: " + manufacture.getLocation());
        System.out.println("Engine Type: " + engine.getType());
        System.out.println("Fuel Type: " + ((HybridEngine) engine).getFuelType());
        System.out.println("Battery Type: " + ((HybridEngine) engine).getBatteryType());
    }
}

public class Main {
    public static void main(String[] args) {
        Manufacture manufacture1 = new Manufacture("Manufacturer A", "Location A");
        Manufacture manufacture2 = new Manufacture("Manufacturer B", "Location B");

        CombustionEngine engine1 = new CombustionEngine("Gasoline");
        ElectricEngine engine2 = new ElectricEngine("Lithium-ion");
        HybridEngine engine3 = new HybridEngine("Diesel", "Nickel-Metal Hydride");

        ICEV vehicle1 = new ICEV("Benz", "C300", 2023, manufacture1, engine1);
        BEV vehicle2 = new BEV("Bmw", "520i", 2023, manufacture2, engine2);
        HybridV vehicle3 = new HybridV("Ferrari", "F60", 2023, manufacture1, engine3);

        Vehicle[] vehicles = {vehicle1, vehicle2, vehicle3};

        for (Vehicle vehicle : vehicles) {
            vehicle.showCharacteristics();
            System.out.println();
        }
    }
}




