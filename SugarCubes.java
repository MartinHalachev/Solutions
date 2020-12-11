import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SugarCubes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> cubes = parseLineOfNumbers(scanner);
        String[] command = scanner.nextLine().split(" ");
        while (!command[0].equals("Mort")) {
            String token = command[0];
            if (token.equals("Add")) {
                int value = Integer.parseInt(command[1]);
                cubes.add(value);
            } else if (token.equals("Remove")) {
                int value = Integer.parseInt(command[1]);
                if (cubes.contains(value)) {
                    cubes.remove((Integer) value);
                }
            } else if (token.equals("Replace")) {
                int value = Integer.parseInt(command[1]);
                int replacement = Integer.parseInt(command[2]);
                if (cubes.contains(value)) {
                    cubes.set(cubes.indexOf(value), replacement);
                }
            } else if (token.equals("Collapse")) {
                int value = Integer.parseInt(command[1]);
                for (int i = cubes.size() - 1; i >= 0; i--) {
                    if (cubes.get(i) < value) {
                        cubes.remove(i);
                    }
                }
            }
            command = scanner.nextLine().split(" ");
        }
        for (Integer cube : cubes) {
            System.out.print(cube + " ");
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
