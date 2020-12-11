import com.sun.source.tree.Tree;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String visit = scanner.nextLine();

        TreeMap<String, List<Integer>> cities = new TreeMap<>();

        getInfoForCities(scanner, visit, cities);

        String startSailing = scanner.nextLine();

        whileSailing(scanner, cities, startSailing);

        if (cities.size() == 0) {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        } else {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", cities.size());
            cities.entrySet()
                    .stream()
                    .sorted((a, b) -> b.getValue().get(1) - a.getValue().get(1))
                    .forEach(e -> System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n",
                            e.getKey(),
                            e.getValue().get(0),
                            e.getValue().get(1)));
        }

    }

    private static void whileSailing(Scanner scanner, TreeMap<String, List<Integer>> cities, String startSailing) {
        while (!startSailing.equals("End")) {
            String[] split = startSailing.split("=>");
            String token = split[0];
            if (token.equals("Plunder")) {
                String city = split[1];
                int people = Integer.parseInt(split[2]);
                int gold = Integer.parseInt(split[3]);
                int afterAttackPeople = cities.get(city).get(0) - people;
                int afterAttackGold = cities.get(city).get(1) - gold;
                System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", city, gold, people);
                if (afterAttackGold <= 0 || afterAttackPeople <= 0) {
                    System.out.printf("%s has been wiped off the map!%n", city);
                    cities.remove(city);
                } else {
                    cities.get(city).set(0, cities.get(city).get(0) - people);
                    cities.get(city).set(1, cities.get(city).get(1) - gold);
                }
            } else if (token.equals("Prosper")) {
                String city = split[1];
                int gold = Integer.parseInt(split[2]);
                if (gold < 0) {
                    System.out.println("Gold added cannot be a negative number!");
                } else {
                    cities.get(city).set(1, cities.get(city).get(1) + gold);
                    System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n", gold, city, cities.get(city).get(1));
                }
            }
            if (cities.size() == 0) {
                break;
            }
            startSailing = scanner.nextLine();
        }
    }

    private static void getInfoForCities(Scanner scanner, String visit, TreeMap<String, List<Integer>> cities) {
        while (!visit.equals("Sail")) {
            String[] split = visit.split("\\|\\|");
            String city = split[0];
            Integer population = Integer.parseInt(split[1]);
            Integer gold = Integer.parseInt(split[2]);
            if (!cities.containsKey(city)) {
                cities.put(city, new ArrayList<>());
                cities.get(city).add(population);
                cities.get(city).add(gold);
            } else {
                cities.get(city).set(0, cities.get(city).get(0) + population);
                cities.get(city).set(1, cities.get(city).get(1) + gold);
                break;
            }
            visit = scanner.nextLine();
        }
    }
}
