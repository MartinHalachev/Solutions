import java.util.Scanner;

public class CounterStrike {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int initialEnergy = Integer.parseInt(scanner.nextLine());
        int battlesWon = 0;
        String command = scanner.nextLine();
        boolean alive = true;
        while (!command.equals("End of battle")) {

            int distance = Integer.parseInt(command);

            if (battlesWon % 3 == 0) {
                initialEnergy += battlesWon;
            }

            if (distance <= initialEnergy) {
                initialEnergy -= distance;
                battlesWon++;
            } else {
                System.out.printf("Not enough energy! Game ends with %d won battles and %d energy", battlesWon, initialEnergy);
                alive = false;
                break;
            }

            command = scanner.nextLine();
        }
        if (alive) {
            System.out.printf("Won battles: %d. Energy left: %d",battlesWon,initialEnergy);
        }
    }
}

