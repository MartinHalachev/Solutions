import java.util.Scanner;

public class CookingMasterclass {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());
        double priceForFlour = Double.parseDouble(scanner.nextLine());
        double priceForEgg = Double.parseDouble(scanner.nextLine());
        double priceForApron = Double.parseDouble(scanner.nextLine());

        double total = priceForApron*(students + Math.ceil(students * 0.2)) + ((priceForEgg * 10) * students) + priceForFlour * (students);

        for (int i = 1; i <= students ; i++) {
            if (i % 5 == 0) {
                total -= priceForFlour;
            }
        }
            if (budget >= total) {
                System.out.printf("Items purchased for %.2f$.", total);
            } else if (total > budget) {
                System.out.printf("%.2f$ more needed.", total - budget);
            }
    }
}
