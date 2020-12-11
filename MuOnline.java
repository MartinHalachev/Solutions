import java.util.BitSet;
import java.util.Scanner;

public class MuOnline {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int health = 100;
        int bitcoins = 0;
        boolean alive = true;

        String[] input = scanner.nextLine().split("\\|");

        for (int i = 0; i < input.length; i++) {

            String[] tokens = input[i].split(" ");
            String command = tokens[0];
            int number = Integer.parseInt(tokens[1]);

            if (command.equals("potion")){
                if (health + number >= 100){
                    System.out.printf("You healed for %d hp.%n",100 - health);
                    health = 100;
                }else {
                    health += number;
                    System.out.printf("You healed for %d hp.%n", number);
                }
                System.out.printf("Current health: %d hp.%n", health);
            } else if (command.equals("chest")) {
                bitcoins += number;
                System.out.printf("You found %d bitcoins.%n", number);
            }else{
                if (health - number > 0 ){
                    System.out.printf("You slayed %s.%n",command);
                    health -= number;
                }else{
                    System.out.printf("You died! Killed by %s.%n",command);
                    System.out.printf("Best room: %d",i + 1);
                    alive = false;
                    break;
                }
            }

        }
        if (alive){
            System.out.printf("You've made it!%n" +
                    "Bitcoins: %d%n",bitcoins);
            System.out.printf("Health: %d%n",health);
        }

    }
}
