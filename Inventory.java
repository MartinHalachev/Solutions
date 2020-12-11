import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inventory {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int firstEmploy = Integer.parseInt(scanner.nextLine());
        int secondEmploy = Integer.parseInt(scanner.nextLine());
        int thirdEmploy = Integer.parseInt(scanner.nextLine());
        int people = Integer.parseInt(scanner.nextLine());
        int peoplePerHour = firstEmploy + secondEmploy + thirdEmploy;
        int hours = 0;
        int rest = 0;
        while (people >= 0) {
            if (people > 0) {
                people -= peoplePerHour;
                hours++;
            } else {
                break;
            }
            if (hours % 3 == 0) {
                rest++;
            }
        }
        System.out.println("Time needed: " + (hours + rest) + "h.");

    }
}
