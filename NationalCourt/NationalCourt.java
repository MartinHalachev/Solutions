import java.util.Scanner;

public class NationalCourt {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int firstEmployee = Integer.parseInt(scanner.nextLine());
        int secondEmployee = Integer.parseInt(scanner.nextLine());
        int thirdEmployee = Integer.parseInt(scanner.nextLine());
        int peopleCount = Integer.parseInt(scanner.nextLine());

        double answerPerHour = firstEmployee + secondEmployee + thirdEmployee;

        double total = Math.ceil(peopleCount / answerPerHour);
        int hours = (int)total;
        for (int i = 1; i <= total; i++) {
            if (i % 3 == 0) {
                hours++;
            }
        }
        System.out.printf("Time needed: %dh.",hours);
    }
}
