import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayManipulator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        double sum = 0;
        boolean price = true;
        while (!command.equals("special") && !command.equals("regular")) {
            double number = Double.parseDouble(command);
            if (number >= 0) {
                sum += number;
            } else {
                System.out.println("Invalid price!");
            }
            command = scanner.nextLine();
        }
        if (sum == 0) {
            price = false;
        }
        double taxes = sum * 0.2;
        if (price) {
            System.out.println("Congratulations you've just bought a new computer!");
            System.out.printf("Price without taxes: %.2f$%n", sum);
            System.out.printf("Taxes: %.2f$%n", taxes);
            System.out.println("-----------");
            if (command.equals("special")) {
                System.out.printf("Total price: %.2f$", (sum + taxes) - (sum + taxes) * 0.1);
            }
            if (command.equals("regular")) {
                System.out.printf("Total price: %.2f$", sum + taxes);
            }
        } else {
            System.out.println("Invalid order!");
        }
    }

    private static List parseLineOfNumbers(Scanner scanner) {
        List<Integer> numbers = new ArrayList<>();
        String input = scanner.nextLine();
        String[] numbersAsString = input.split(" ");
        for (int i = 0; i < numbersAsString.length; i++) {
            numbers.add(Integer.parseInt(numbersAsString[i]));
        }
        return numbers;
    }
}
