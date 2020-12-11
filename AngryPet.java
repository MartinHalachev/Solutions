import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AngryPet {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> priceRating = parseLineOfNumbers(scanner);
        int entryPoint = Integer.parseInt(scanner.nextLine());
        String items = scanner.nextLine();
        String ratings = scanner.nextLine();

        String firstPosition = "Left";
        int leftSum = 0;

        String secondPosition = "";
        int rightSum = 0;
        for (int i = 0; i < entryPoint; i++) {
            if (items.equals("cheap")) {
                if (priceRating.get((Integer) i) < priceRating.get((Integer) entryPoint)) {
                    if (ratings.equals("positive") && priceRating.get((Integer) i) > 0) {
                        leftSum += priceRating.get(i);
                    } else if (ratings.equals("negative") && priceRating.get((Integer) i) < 0) {
                        leftSum += priceRating.get(i);
                    } else if (ratings.equals("all")) {
                        leftSum += priceRating.get(i);
                    }

                }
            } else if (items.equals("expensive")) {
                if (priceRating.get((Integer) i) > priceRating.get((Integer) entryPoint)) {
                    if (ratings.equals("positive") && priceRating.get((Integer) i) > 0) {
                        leftSum += priceRating.get(i);
                    } else if (ratings.equals("negative") && priceRating.get((Integer) i) < 0) {
                        leftSum += priceRating.get(i);
                    } else if (ratings.equals("all")) {
                        leftSum += priceRating.get(i);
                    }

                }
            }
        }
        for (int i = entryPoint; i < priceRating.size(); i++) {
            if (items.equals("cheap")) {
                if (priceRating.get((Integer) i) < priceRating.get((Integer) entryPoint)) {
                    if (ratings.equals("positive") && priceRating.get((Integer) i) > 0) {
                        rightSum += priceRating.get(i);
                    } else if (ratings.equals("negative") && priceRating.get((Integer) i) < 0) {
                        rightSum += priceRating.get(i);
                    } else if (ratings.equals("all")) {
                        rightSum += priceRating.get(i);
                    }

                }
            } else if (items.equals("expensive")) {
                if (priceRating.get((Integer) i) > priceRating.get((Integer) entryPoint)) {
                    if (ratings.equals("positive") && priceRating.get((Integer) i) > 0) {
                        rightSum += priceRating.get(i);
                    } else if (ratings.equals("negative") && priceRating.get((Integer) i) < 0) {
                        rightSum += priceRating.get(i);
                    } else if (ratings.equals("all")) {
                        rightSum += priceRating.get(i);
                    }

                }
            }
        }
        if (leftSum >= rightSum) {
            System.out.printf("Left - %d", leftSum);
        } else {
            System.out.printf("Right - %d", rightSum);
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
