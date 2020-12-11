import java.util.Scanner;

class Datatype {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int adventureDays = Integer.parseInt(scanner.nextLine());
        int playersCount = Integer.parseInt(scanner.nextLine());
        double groupEnergy = Double.parseDouble(scanner.nextLine());
        double waterPerDay = Double.parseDouble(scanner.nextLine());
        double foodPerDay = Double.parseDouble(scanner.nextLine());

        double waterNeeded = adventureDays * playersCount * waterPerDay;
        double foodNeeded = adventureDays * playersCount * foodPerDay;

        boolean ready = true;
        for (int i = 1; i <= adventureDays; i++) {
            double energyLost = Double.parseDouble(scanner.nextLine());
            groupEnergy -= energyLost;
            if (groupEnergy<=0){
                ready = false;
                break;
            }
            if (i % 2 == 0) {
                waterNeeded -= waterNeeded * 0.30;
                groupEnergy += groupEnergy * 0.05;
            }
            if (i % 3 == 0) {
                foodNeeded -= foodNeeded / playersCount;
                groupEnergy += groupEnergy * 0.1;
            }

        }
        if (ready) {
            System.out.printf("You are ready for the quest. You will be left with - %.2f energy%n!", groupEnergy);
        }else{
            System.out.printf("You will run out of energy. You will be left with %.2f food and %.2f water.",foodNeeded,waterNeeded);
        }
    }
}