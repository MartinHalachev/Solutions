import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Obj {
    static class Vehicles {
        public String getType() {
            return type;
        }

        public String getModel() {
            return model;
        }

        public String getColor() {
            return color;
        }

        public double getHorsepower() {
            return horsepower;
        }

        public Vehicles(String type, String model, String color, double horsepower) {
            this.type = type;
            this.model = model;
            this.color = color;
            this.horsepower = horsepower;
        }

        String type;
        String model;
        String color;
        double horsepower;

        @Override
        public String toString() {
            return String.format("Type: %s%n" +
                            "Model: %s%n" +
                            "Color: %s%n" +
                            "Horsepower: %.0f%n",
                    getType().toUpperCase().charAt(0) + getType().substring(1),
                    getModel(),
                    getColor(),
                    getHorsepower());
        }
    }

    public static double averageHp(List<Vehicles> vehicles) {
        if (vehicles.size() == 0) {
            return 0.0;
        }
        return vehicles.stream().mapToDouble(Vehicles::getHorsepower).sum() / vehicles.size();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String addVehicles = scanner.nextLine();
        List<Vehicles> vehicles = new ArrayList<>();

        while (!addVehicles.equals("End")) {
            String[] tokens = addVehicles.split(" ");
            String type = tokens[0];
            String model = tokens[1];
            String color = tokens[2];
            double horsepower = Double.parseDouble(tokens[3]);
            Vehicles vehicle = new Vehicles(type, model, color, horsepower);
            vehicles.add(vehicle);

            addVehicles = scanner.nextLine();
        }
        String checkCar = scanner.nextLine();
        while (!checkCar.equals("Close the Catalogue")) {
            String model = checkCar;
            vehicles.stream()
                    .filter(vehicle -> vehicle.getModel().equals(model))
                    .forEach(vehicle -> System.out.print(vehicle.toString()));
            checkCar = scanner.nextLine();
        }
        List<Vehicles> car = vehicles.stream().filter(vehicle -> vehicle.getType().equals("car")).collect(Collectors.toList());
        List<Vehicles> truck = vehicles.stream().filter(vehicle -> vehicle.getType().equals("truck")).collect(Collectors.toList());
        System.out.printf("Cars have average horsepower of: %.2f.%n",averageHp(car));
        System.out.printf("Trucks have average horsepower of: %.2f.",averageHp(truck));
    }
}
