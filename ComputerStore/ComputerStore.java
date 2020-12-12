import java.util.Arrays;
import java.util.Scanner;

public class ComputerStore {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int peopleWaiting = Integer.parseInt(scanner.nextLine());
        int[] stateOfLift = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        boolean emptySpots = false;
        for (int i = 0; i < stateOfLift.length; i++) {
            if (peopleWaiting == 0) {
                stateOfLift[i] = 0;
                emptySpots = true;

            }
            if (peopleWaiting >= 4) {
                while (stateOfLift[i] < 4) {
                    stateOfLift[i]++;
                    peopleWaiting--;
                }
                emptySpots = true;
            } else {
                stateOfLift[i] = peopleWaiting;
                peopleWaiting = 0;
                emptySpots = true;
            }
        }
        if (peopleWaiting == 0 && emptySpots) {
            for (int i = 0; i < stateOfLift.length; i++) {
                System.out.print(stateOfLift[i] + " ");
            }
        } else if (peopleWaiting == 0) {
            System.out.println("The lift has empty spots!");
        } else if (peopleWaiting > 4) {
            System.out.printf("There isn't enough space! %d people in a queue!%n", peopleWaiting);
        }
        if (peopleWaiting == 0 && emptySpots) {

        }
        for (int i = 0; i < stateOfLift.length; i++) {
            System.out.print(stateOfLift[i] + " ");
        }

    }
}