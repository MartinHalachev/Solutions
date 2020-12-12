import java.util.Scanner;

public class PadawanEqt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double money = Double.parseDouble(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());
        double lightSabersPrice = Double.parseDouble(scanner.nextLine());
        double robesPrice = Double.parseDouble(scanner.nextLine());
        double beltsPrice = Double.parseDouble(scanner.nextLine());

        int freeBelts = 0;

        if (students % 6 == 0) {
            freeBelts = students / 6;
        }
        double cost = lightSabersPrice * (students + Math.ceil(students * 0.1)) + (robesPrice * students) + beltsPrice * (students - freeBelts);

        if (money - cost >= 0) {
            System.out.printf("The money is enough - it would cost %.2flv.", cost);
        } else {
            double moneyNeeded = cost - money;
            System.out.printf("Ivan Cho will need %.2flv more.", moneyNeeded);
        }

    }
}
